package lmr.randomizer.node;

import lmr.randomizer.DataFromFile;
import lmr.randomizer.HolidaySettings;
import lmr.randomizer.randomization.*;
import lmr.randomizer.FileUtils;
import lmr.randomizer.Settings;
import lmr.randomizer.util.LocationCoordinateMapper;

import java.util.*;

/**
 * Created by thezerothcat on 7/11/2017.
 */
public class AccessChecker {

    private Map<String, NodeWithRequirements> mapOfNodeNameToRequirementsObject = new HashMap<>();
    private Map<String, Set<String>> mapOfRequirementsToNodeNameObject = new HashMap<>();

    private Set<String> accessedNodes = new HashSet<>();

    private List<String> queuedUpdates = new ArrayList<>();
    private Set<String> accessibleBossNodes = new HashSet<>();

    private List<String> nodesToDelay;

    private ItemRandomizer itemRandomizer;
    private ShopRandomizer shopRandomizer;
    private BacksideDoorRandomizer backsideDoorRandomizer;
    private TransitionGateRandomizer transitionGateRandomizer;
    private SealRandomizer sealRandomizer;
    private NpcRandomizer npcRandomizer;

    private int numberOfAccessibleAnkhJewels;
    private int numberOfCollectedAnkhJewels;
    private int numberOfAccessibleSacredOrbs;
    private int bossesDefeated;

    public AccessChecker() {
        mapOfNodeNameToRequirementsObject = copyRequirementsMap(DataFromFile.getMapOfNodeNameToRequirementsObject());
        mapOfRequirementsToNodeNameObject = copyNodeNameMap(DataFromFile.getMapOfRequirementsToNodeNameObject());
        nodesToDelay = Settings.isUshumgalluAssist() ? new ArrayList<>(0) : Arrays.asList("Anchor");
    }

    public AccessChecker(AccessChecker accessChecker, boolean copyAll) {
        this.mapOfNodeNameToRequirementsObject = copyRequirementsMap(accessChecker.mapOfNodeNameToRequirementsObject);
        this.mapOfRequirementsToNodeNameObject = copyNodeNameMap(accessChecker.mapOfRequirementsToNodeNameObject);
        this.itemRandomizer = copyAll ? new ItemRandomizer(accessChecker.itemRandomizer) : accessChecker.itemRandomizer;
        this.shopRandomizer = copyAll ? accessChecker.shopRandomizer.copy() : accessChecker.shopRandomizer;
        this.sealRandomizer = accessChecker.sealRandomizer;
        this.npcRandomizer = accessChecker.npcRandomizer;
        this.backsideDoorRandomizer = new BacksideDoorRandomizer(accessChecker.backsideDoorRandomizer);
        this.transitionGateRandomizer = accessChecker.transitionGateRandomizer; // Might need to copy at some point, but currently this only keeps a map/doesn't track state.
        this.accessedNodes = new HashSet<>(accessChecker.accessedNodes);
        this.accessibleBossNodes = new HashSet<>(accessChecker.accessibleBossNodes);
        this.bossesDefeated = accessChecker.bossesDefeated;
        this.numberOfAccessibleAnkhJewels = accessChecker.numberOfAccessibleAnkhJewels;
        this.numberOfCollectedAnkhJewels = accessChecker.numberOfCollectedAnkhJewels;
        this.nodesToDelay = new ArrayList<>(accessChecker.nodesToDelay);
    }

    public void determineCursedChests(Random random) {
        List<String> cursedChests = new ArrayList<>(DataFromFile.getCustomPlacementData().getCursedChests());
        if(cursedChests.isEmpty()) {
            if(Settings.isRandomizeCursedChests()) {
                List<String> possibleChests = new ArrayList<>(DataFromFile.getChestOnlyLocations());
                if (Settings.isRandomizeCoinChests()) {
                    possibleChests.addAll(DataFromFile.getAllCoinChests());
                }
                if (Settings.isRandomizeEscapeChest()) {
                    possibleChests.add(DataFromFile.ESCAPE_CHEST_NAME);
                }
                possibleChests.removeAll(DataFromFile.getNonRandomizedItems());
                String cursedChest;
                for (int i = 0; i < 4; i++) {
                    cursedChest = possibleChests.get(random.nextInt(possibleChests.size()));
                    cursedChests.add(cursedChest);
                    possibleChests.remove(cursedChest);
                }
            }
        }
        if(!cursedChests.isEmpty()) {
            Settings.setCurrentCursedChests(cursedChests);
        }
        for(String chestLocation : Settings.getCurrentCursedChests()) {
            NodeWithRequirements chest = mapOfNodeNameToRequirementsObject.get(chestLocation);
            Set nodeSet = mapOfRequirementsToNodeNameObject.get("Mulana Talisman");
            if(nodeSet == null)
                nodeSet = new HashSet<String>();
            nodeSet.add(chestLocation);
            mapOfRequirementsToNodeNameObject.put("Mulana Talisman", nodeSet);
            for(List<String> requirementSet : chest.getAllRequirements()) {
                requirementSet.add("Mulana Talisman");
            }
        }
    }

    private static Map<String, NodeWithRequirements> copyRequirementsMap(Map<String, NodeWithRequirements> mapToCopy) {
        Map<String, NodeWithRequirements> copyMap = new HashMap<>();
        for(Map.Entry<String, NodeWithRequirements> entry : mapToCopy.entrySet()) {
            copyMap.put(entry.getKey(), new NodeWithRequirements(entry.getValue()));
        }
        return copyMap;
    }

    private static Map<String, Set<String>> copyNodeNameMap(Map<String, Set<String>> mapToCopy) {
        Map<String, Set<String>> copyMap = new HashMap<>();
        for(Map.Entry<String, Set<String>> entry : mapToCopy.entrySet()) {
            copyMap.put(entry.getKey(), new HashSet(entry.getValue()));
        }
        return copyMap;
    }

    public List<String> getQueuedUpdates() {
        return queuedUpdates;
    }

    public boolean isSuccess(Integer attemptNumber) {
        if(isRequireFullAccess()) {
            if(mapOfNodeNameToRequirementsObject.isEmpty()) {
                return true;
            }

            for(String requiredItem : DataFromFile.getWinRequirements()) {
                if(!accessedNodes.contains(requiredItem)) {
                    FileUtils.log("Win requirement not accessible: " + requiredItem + ", accessed nodes = " + accessedNodes.size());
                    if(accessedNodes.size() > 500 || Settings.isDetailedLoggingAttempt(attemptNumber)) {
                        List<String> defeatedBosses = new ArrayList<>();
                        for(String bossDefeat : DataFromFile.GUARDIAN_DEFEATED_EVENTS) {
                            if(accessedNodes.contains(bossDefeat)) {
                                defeatedBosses.add(bossDefeat);
                            }
                        }
                        FileUtils.log("Bosses defeated: " + defeatedBosses.toString());
                        FileUtils.log("Bosses accessible: " + accessibleBossNodes.toString());
                        List<String> logged = new ArrayList<>();
                        if (requiredItem.startsWith("Event:")) {
                            logAccess(requiredItem, logged);
                        }
                    }
                    return false;
                }
            }

            NodeType nodeType;
            for(String nodeName : mapOfNodeNameToRequirementsObject.keySet()) {
                nodeType = mapOfNodeNameToRequirementsObject.get(nodeName).getType();
                if(NodeType.STATE.equals(nodeType) || NodeType.MAP_LOCATION.equals(nodeType)
                        || NodeType.EXIT.equals(nodeType)|| NodeType.SETTING.equals(nodeType) || NodeType.TRANSITION.equals(nodeType) ) {
                    continue;
                }
                else if(NodeType.NPC.equals(nodeType)) {
                    continue;
                }
                else if(NodeType.ITEM_LOCATION.equals(nodeType)) {
                    if(DataFromFile.ESCAPE_CHEST_NAME.equals(nodeName)) {
                        continue;
                    }
                    String item = itemRandomizer.getItem(nodeName);
                    if(item.startsWith("Coin:") || item.startsWith("Trap:") || Settings.getStartingItemsIncludingCustom().contains(item)) {
                        continue;
                    }
                }
                FileUtils.log("Inaccessible node detected: " + nodeName + " containing " + itemRandomizer.getItem(nodeName) + ", accessed nodes = " + accessedNodes.size());
                if(accessedNodes.size() > 500 || Settings.isDetailedLoggingAttempt(attemptNumber)) {
                    List<String> logged = new ArrayList<>();
                    logAccess(nodeName, logged);
                }
                return false;
            }
            if(isEscapeSuccess()) {
                FileUtils.log("Successful resolution found with accessed nodes = " + accessedNodes.size());
                return true;
            }
            else {
                return false;
            }
        }
        for(String requiredItem : DataFromFile.getWinRequirements()) {
            if(!accessedNodes.contains(requiredItem)) {
                FileUtils.log("Win requirement not accessible: " + requiredItem + ", accessed nodes = " + accessedNodes.size());
                if(accessedNodes.size() > 500 || Settings.isDetailedLoggingAttempt(attemptNumber)) {
                    List<String> defeatedBosses = new ArrayList<>();
                    for(String bossDefeat : DataFromFile.GUARDIAN_DEFEATED_EVENTS) {
                        if(accessedNodes.contains(bossDefeat)) {
                            defeatedBosses.add(bossDefeat);
                        }
                    }
                    FileUtils.log("Bosses defeated: " + defeatedBosses.toString());
                    FileUtils.log("Bosses accessible: " + accessibleBossNodes.toString());
                    List<String> logged = new ArrayList<>();
                    if (requiredItem.startsWith("Event:") || requiredItem.startsWith("Location:")) {
                        logAccess(requiredItem, logged);
                    }
                }
                return false;
            }
        }
        if(isEscapeSuccess()) {
            FileUtils.log("Successful resolution found with accessed nodes = " + accessedNodes.size());
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isEscapeSuccess() {
        if(HolidaySettings.isHalloween2019Mode()) {
            if(HolidaySettings.isIncludeHellTempleNPCs()) {
                return true; // Don't have to have a path to Temple of the Sun since the escape ends when you get out.
            }
            else {
                String escapeSuccessNode = getEscapeSuccessNode();
                for(String locationToEscape : getEscapeStartingLocations()) {
                    if(!new EscapeChecker(backsideDoorRandomizer, transitionGateRandomizer, itemRandomizer, shopRandomizer, accessedNodes, locationToEscape, escapeSuccessNode).isSuccess()) {
                        FileUtils.log("Failed escape from " + locationToEscape);
                        return false;
                    }
                }
                return true;
            }
        }
        if(HolidaySettings.isHalloween2021Mode()) {
            String escapeSuccessNode = getEscapeSuccessNode();
            for(String locationToEscape : getEscapeStartingLocations()) {
                if(!new EscapeChecker(backsideDoorRandomizer, transitionGateRandomizer, itemRandomizer, shopRandomizer, accessedNodes, locationToEscape, escapeSuccessNode).isSuccess()) {
                    FileUtils.log("Failed escape from " + locationToEscape);
                    return false;
                }
            }
            return true;
        }
        return (!Settings.isRandomizeTransitionGates() && LocationCoordinateMapper.isSurfaceStart())
                || new EscapeChecker(backsideDoorRandomizer, transitionGateRandomizer, itemRandomizer, shopRandomizer, accessedNodes, "Location: True Shrine of the Mother", getEscapeSuccessNode()).isSuccess();
    }

    private List<String> getEscapeStartingLocations() {
        List<String> locations = new ArrayList<>();
        if(HolidaySettings.isHalloween2019Mode()) {
            locations.addAll(DataFromFile.NPC_LOCATIONS);
        }
        else if(HolidaySettings.isHalloween2021Mode()) {
            for(String itemLocation : itemRandomizer.getItemLocations()) {
                if(itemRandomizer.getNewContents(itemLocation).startsWith("Map")) {
                    locations.add(getLocationFromItemLocation(itemLocation));
                }
            }
        }
        else {
            locations.add("Location: True Shrine of the Mother");
        }
        return locations;
    }

    private String getEscapeSuccessNode() {
        if(Settings.isRandomizeNpcs()) {
            return npcRandomizer.getNpcLocation("Mulbruk");
        }
        return "Event: Escape";
    }

    private String getLocationFromItemLocation(String itemLocation) {
        if("Ankh Jewel (Dimensional Corridor)".equals(itemLocation)) {
            return "Location: Dimensional Corridor [Upper]";
        }
        if("Ankh Jewel (Gate of Guidance)".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Ankh Jewel (Mausoleum of the Giants)".equals(itemLocation)) {
            return "Location: Mausoleum of the Giants";
        }
        if("Ankh Jewel (Spring in the Sky)".equals(itemLocation)) {
            return "Location: Spring in the Sky [Drain]";
        }
        if("Ankh Jewel (Temple of the Sun)".equals(itemLocation)) {
            return "Location: Temple of the Sun [Main]"; // todo: "Location: Temple of the Sun [Lower]"
        }
        if("Ankh Jewel (Tower of Ruin)".equals(itemLocation)) {
            return "Location: Tower of Ruin [Lower]";
        }
        if("Ankh Jewel (Twin Labyrinths)".equals(itemLocation)) {
            return "Location: Twin Labyrinths [Jewel]";
        }
        if("Birth Seal".equals(itemLocation)) {
            return "Location: Surface [Main]";
        }
        if("bounce.exe".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Main]";
        }
        if("Bronze Mirror".equals(itemLocation)) {
            return "Location: Temple of the Sun [East]";
        }
        if("Cog of the Soul".equals(itemLocation)) {
            return "Location: Gate of Illusion [Upper]";
        }
        if("Crucifix".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Crystal Skull".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Main]";
        }
        if("Death Seal".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Seal]";
        }
        if("Diary".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Main]";
        }
        if("Dimensional Key".equals(itemLocation)) {
            return "Location: Chamber of Birth [West]";
        }
        if("Djed Pillar".equals(itemLocation)) {
            return "Location: Tower of Ruin [Top]";
        }
        if("Eye of Truth".equals(itemLocation)) {
            return "Location: Tower of the Goddess [Lower]";
        }
        if("Fairy Clothes".equals(itemLocation)) {
            return "Location: Gate of Illusion [Middle]";
        }
        if("Feather".equals(itemLocation)) {
            return "Location: Surface [Main]";
        }
        if("Fruit of Eden".equals(itemLocation)) {
            return "Location: Temple of Moonlight [Upper]";
        }
        if("Gauntlet".equals(itemLocation)) {
            return "Location: Graveyard of the Giants [West]";
        }
        if("Glove".equals(itemLocation)) {
            return "Location: Spring in the Sky [Upper]";
        }
        if("Grapple Claw".equals(itemLocation)) {
            return "Location: Temple of Moonlight [Grapple]";
        }
        if("Holy Grail".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Ice Cape".equals(itemLocation)) {
            return "Location: Inferno Cavern [Main]";
        }
        if("Isis' Pendant".equals(itemLocation)) {
            return "Location: Temple of the Sun [West]";
        }
        if("Key of Eternity".equals(itemLocation)) {
            return "Location: Gate of Illusion [Grail]";
        }
        if("lamulana.exe".equals(itemLocation)) {
            return "Location: Gate of Time [Surface]";
        }
        if("Life Seal".equals(itemLocation)) {
            return "Location: Chamber of Extinction [Main]";
        }
        if("Magatama Jewel".equals(itemLocation)) {
            return "Location: Dimensional Corridor [Upper]";
        }
        if("Map (Chamber of Birth)".equals(itemLocation)) {
            return "Location: Chamber of Birth [West]";
        }
        if("Map (Chamber of Extinction)".equals(itemLocation)) {
            return "Location: Chamber of Extinction [Map]";
        }
        if("Map (Dimensional Corridor)".equals(itemLocation)) {
            return "Location: Dimensional Corridor [Lower]";
        }
        if("Map (Endless Corridor)".equals(itemLocation)) {
            return "Location: Endless Corridor [1F]";
        }
        if("Map (Gate of Guidance)".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Map (Gate of Illusion)".equals(itemLocation)) {
            return "Location: Gate of Illusion [Lower]";
        }
        if("Map (Graveyard of the Giants)".equals(itemLocation)) {
            return "Location: Graveyard of the Giants [West]";
        }
        if("Map (Inferno Cavern)".equals(itemLocation)) {
            return "Location: Inferno Cavern [Main]";
        }
        if("Map (Mausoleum of the Giants)".equals(itemLocation)) {
            return "Location: Mausoleum of the Giants";
        }
        if("Map (Shrine of the Mother)".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Map]";
        }
        if("Map (Spring in the Sky)".equals(itemLocation)) {
            return "Location: Spring in the Sky [Main]";
        }
        if("Map (Temple of Moonlight)".equals(itemLocation)) {
            return "Location: Temple of Moonlight [Map]";
        }
        if("Map (Temple of the Sun)".equals(itemLocation)) {
            return "Location: Temple of the Sun [Grail]";
        }
        if("Map (Tower of Ruin)".equals(itemLocation)) {
            return "Location: Tower of Ruin [Illusion]";
        }
        if("Map (Tower of the Goddess)".equals(itemLocation)) {
            return "Location: Tower of the Goddess [Lower]";
        }
        if("Map (Twin Labyrinths)".equals(itemLocation)) {
            return "Location: Twin Labyrinths [Poison 1]";
        }
        if("mirai.exe".equals(itemLocation)) {
            return "Location: Graveyard of the Giants [West]";
        }
        if("Origin Seal".equals(itemLocation)) {
            return "Location: Spring in the Sky [Upper]";
        }
        if("Perfume".equals(itemLocation)) {
            return "Location: Chamber of Birth [Northeast]";
        }
        if("Plane Model".equals(itemLocation)) {
            return "Location: Tower of the Goddess [Grail]";
        }
        if("Pochette Key".equals(itemLocation)) {
            return "Location: Chamber of Birth [Skanda]";
        }
        if("Sacred Orb (Gate of Guidance)".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Sacred Orb (Chamber of Extinction)".equals(itemLocation)) {
            return "Location: Chamber of Extinction [Main]";
        }
        if("Sacred Orb (Dimensional Corridor)".equals(itemLocation)) {
            return "Location: Dimensional Corridor [Upper]";
        }
        if("Sacred Orb (Mausoleum of the Giants)".equals(itemLocation)) {
            return "Location: Mausoleum of the Giants";
        }
        if("Sacred Orb (Shrine of the Mother)".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Main]";
        }
        if("Sacred Orb (Spring in the Sky)".equals(itemLocation)) {
            return "Location: Spring in the Sky [Main]";
        }
        if("Sacred Orb (Surface)".equals(itemLocation)) {
            return "Location: Surface [Main]";
        }
        if("Sacred Orb (Temple of the Sun)".equals(itemLocation)) {
            return "Location: Temple of the Sun [Main]"; // todo: "Location: Temple of the Sun [Lower]"
        }
        if("Sacred Orb (Tower of Ruin)".equals(itemLocation)) {
            return "Location: Tower of Ruin [Southeast]";
        }
        if("Sacred Orb (Twin Labyrinths)".equals(itemLocation)) {
            return "Location: Twin Labyrinths [Lower]";
        }
        if("Scalesphere".equals(itemLocation)) {
            return "Location: Spring in the Sky [Upper]";
        }
        if("Serpent Staff".equals(itemLocation)) {
            return "Location: Temple of Moonlight [Southeast]";
        }
        if("Shell Horn".equals(itemLocation)) {
            return "Location: Surface [Main]";
        }
        if("Spaulder".equals(itemLocation)) {
            return "Location: Tower of the Goddess [Grail]";
        }
        if("Treasures".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Twin Statue".equals(itemLocation)) {
            return "Location: Endless Corridor [3F Lower]";
        }
        if("Vessel".equals(itemLocation)) {
            return "Location: Chamber of Birth [Northeast]";
        }
        if("Woman Statue".equals(itemLocation)) {
            return "Location: Chamber of Birth [Southeast]";
        }
        if("yagostr.exe".equals(itemLocation)) {
            return "Location: Gate of Guidance [Door]";
        }
        if("Coin: Surface (Waterfall)".equals(itemLocation)) {
            return "Location: Surface [Main]";
        }
        if("Coin: Surface (Seal)".equals(itemLocation)) {
            return "Location: Surface [Main]";
        }
        if("Coin: Surface (Ruin Path)".equals(itemLocation)) {
            return "Location: Surface [Ruin Path Upper]";
        }
        if("Coin: Guidance (One)".equals(itemLocation)) {
            return "Location: Gate of Guidance [Shuriken]";
        }
        if("Coin: Guidance (Two)".equals(itemLocation)) {
            return "Location: Gate of Guidance [Shuriken]";
        }
        if("Coin: Guidance (Trap)".equals(itemLocation)) {
            return "Location: Gate of Guidance [Main]";
        }
        if("Coin: Mausoleum".equals(itemLocation)) {
            return "Location: Mausoleum of the Giants";
        }
        if("Coin: Sun (Pyramid)".equals(itemLocation)) {
            return "Location: Temple of the Sun [Main]"; // todo: "Location: Temple of the Sun [Lower]"
        }
        if("Coin: Spring".equals(itemLocation)) {
            return "Location: Spring in the Sky [Main]";
        }
        if("Coin: Inferno (Lava)".equals(itemLocation)) {
            return "Location: Inferno Cavern [Main]";
        }
        if("Coin: Inferno (Spikes)".equals(itemLocation)) {
            return "Location: Inferno Cavern [Spikes]";
        }
        if("Coin: Extinction".equals(itemLocation)) {
            return "Location: Chamber of Extinction [Left Main]";
        }
        if("Coin: Twin (Witches)".equals(itemLocation)) {
            return "Location: Twin Labyrinths [Lower]";
        }
        if("Coin: Twin (Lower)".equals(itemLocation)) {
            return "Location: Twin Labyrinths [Lower]";
        }
        if("Coin: Endless".equals(itemLocation)) {
            return "Location: Endless Corridor [3F Upper]";
        }
        if("Coin: Shrine".equals(itemLocation)) {
            return "Location: Shrine of the Mother [Main]";
        }
        if("Coin: Illusion (Katana)".equals(itemLocation)) {
            return "Location: Gate of Illusion [Middle]";
        }
        if("Coin: Illusion (Spikes)".equals(itemLocation)) {
            return "Location: Gate of Illusion [Lower]";
        }
        if("Coin: Graveyard".equals(itemLocation)) {
            return "Location: Graveyard of the Giants [West]";
        }
        if("Coin: Moonlight".equals(itemLocation)) {
            return "Location: Temple of Moonlight [Eden]";
        }
        if("Coin: Goddess (Shield)".equals(itemLocation)) {
            return "Location: Tower of the Goddess [Grail]";
        }
        if("Coin: Goddess (Fairy)".equals(itemLocation)) {
            return "Location: Tower of the Goddess [Lower]";
        }
        if("Coin: Ruin".equals(itemLocation)) {
            return "Location: Tower of Ruin [Spirits]";
        }
        if("Coin: Birth (Ninja)".equals(itemLocation)) {
            return "Location: Chamber of Birth [Northeast]";
        }
        if("Coin: Birth (Dance)".equals(itemLocation)) {
            return "Location: Chamber of Birth [Dance]";
        }
        if("Coin: Birth (Southeast)".equals(itemLocation)) {
            return "Location: Chamber of Birth [Southeast]";
        }
        if("Coin: Dimensional".equals(itemLocation)) {
            return "Location: Dimensional Corridor [Grail]";
        }
        if(DataFromFile.GRAVEYARD_TRAP_CHEST_NAME.equals(itemLocation)) {
            return "Location: Graveyard of the Giants [West]";
        }
        if(DataFromFile.EXPLODING_CHEST_NAME.equals(itemLocation)) {
            return "Location: Gate of Illusion [Dracuet]";
        }
//        if(DataFromFile.ESCAPE_CHEST_NAME.equals(itemLocation)) {
//            return "Location: Twin Labyrinths [Upper Left]";
//        }
        throw new RuntimeException("Unable to find location for chest " + itemLocation);
    }

    private void logAccess(String requiredNode, List<String> loggedRequirements) {
        if(loggedRequirements.contains(requiredNode)) {
            return;
        }

        NodeWithRequirements remainingRequirements = mapOfNodeNameToRequirementsObject.get(requiredNode);
        if(remainingRequirements == null) {
            return;
        }

        loggedRequirements.add(requiredNode);
        for (List<String> requirementSet : remainingRequirements.getAllRequirements()) {
            FileUtils.log("Missing requirements for " + requiredNode + " from set: " + requirementSet);
            for (String requirement : requirementSet) {
                if(!requirement.contains(": ")) {
                    continue;
                }
                if(requirement.startsWith("Transition:")) {
                    FileUtils.log("Missing requirements for " + requirement + ": " + transitionGateRandomizer.getTransitionReverse(requirement));
                    logAccess(transitionGateRandomizer.getTransitionReverse(requirement), loggedRequirements);
                }

                if(requirement.startsWith("Door:")) {
                    FileUtils.log("Missing requirements for " + requirement + ": " + backsideDoorRandomizer.getMissingRequirements(requirement));
                    for (String requirementInner : backsideDoorRandomizer.getMissingRequirements(requirement)) {
                        if (requirementInner.startsWith("Door:")) {
                            List<String> missingRequirements = backsideDoorRandomizer.getMissingRequirements(requirementInner);
                            for(String doorRequirement : missingRequirements) {
                                logAccess(doorRequirement, loggedRequirements);
                            }
                        }
                        else if (requirementInner.startsWith("Transition:")) {
                            FileUtils.log("Unable to access " + transitionGateRandomizer.getTransitionReverse(requirementInner));
                            logAccess(transitionGateRandomizer.getTransitionReverse(requirementInner), loggedRequirements);
                        }
                        else if (requirementInner.startsWith("Event:") || requirementInner.startsWith("State:") || requirementInner.startsWith("Location:")) {
                            logAccess(requirementInner, loggedRequirements);
                        }
                    }
                    continue;
                }
                if(requirement.equals("Ankh Jewel: 9")) {
                    FileUtils.log("Total number of ankh jewels found: " + numberOfCollectedAnkhJewels);
                }

                remainingRequirements = mapOfNodeNameToRequirementsObject.get(requirement);
                if(remainingRequirements != null) {
                    for (List<String> requirementsForRequirement : remainingRequirements.getAllRequirements()) {
                        FileUtils.log("Missing requirements for " + requirement + ": " + requirementsForRequirement);
                        for (String requirementInner : requirementsForRequirement) {
                            if (requirementInner.startsWith("Door:")) {
                                List<String> missingRequirements = backsideDoorRandomizer.getMissingRequirements(requirementInner);
                                for(String doorRequirement : missingRequirements) {
                                    logAccess(doorRequirement, loggedRequirements);
                                }
                            }
                            else if (requirementInner.startsWith("Transition:")) {
                                FileUtils.log("Unable to access " + transitionGateRandomizer.getTransitionReverse(requirementInner));
                                logAccess(transitionGateRandomizer.getTransitionReverse(requirementInner), loggedRequirements);
                            }
                            else if (requirementInner.startsWith("Event:") || requirementInner.startsWith("State:") || requirementInner.startsWith("Location:")) {
                                logAccess(requirementInner, loggedRequirements);
                            }
                        }
                    }
                }
            }
        }

    }

    private boolean isRequireFullAccess() {
        if(!Settings.isRequireFullAccess()) {
            return false;
        }
        if(Settings.getCurrentRemovedItems().size() == 1) {
            String removedItem = Settings.getCurrentRemovedItems().iterator().next();
            if("Whip".equals(removedItem) || "Spaulder".equals(removedItem)) {
                return true;
            }
        }
        if(Settings.getCurrentRemovedItems().size() == 2
                && Settings.getCurrentRemovedItems().contains("Whip") && Settings.getCurrentRemovedItems().contains("Spaulder")) {
            return true;
        }
        return Settings.getRemovedItems().isEmpty() && Settings.getCurrentRemovedItems().isEmpty();
    }

    public void computeStartingLocationAccess(boolean fullValidation, Integer attemptNumber) {
        String startingLocation = LocationCoordinateMapper.getStartingLocation();
        String startingExit = startingLocation.replace("Location:", "Exit:");
        computeAccessibleNodes(startingLocation, fullValidation, attemptNumber);
        computeAccessibleNodes(startingExit, fullValidation, attemptNumber);
        queuedUpdates.addAll(transitionGateRandomizer.getTransitionExits(startingExit, attemptNumber));
        if(fullValidation) {
            queuedUpdates.addAll(backsideDoorRandomizer.getAvailableNodes(startingLocation, attemptNumber));
            queuedUpdates.addAll(backsideDoorRandomizer.getAvailableNodes(startingExit, attemptNumber));
        }
    }

    public void computeAccessibleNodes(String newState, Integer attemptNumber) {
        computeAccessibleNodes(newState, true, attemptNumber);
    }

    public void computeAccessibleNodes(String newState, boolean fullValidation, Integer attemptNumber) {
        String stateToUpdate = newState;
        if(fullValidation) {
            FileUtils.logDetail("Checking progress for node " + newState, attemptNumber);
            FileUtils.flush();
            stateToUpdate = checkState(stateToUpdate);
            if(stateToUpdate == null) {
                return;
            }
        }
        accessedNodes.add(newState);
        accessedNodes.add(stateToUpdate);

        NodeWithRequirements node;
        Set<String> nodesToRemove = new HashSet<>();

        // If nothing requires this state, don't bother checking for newly opened nodes since there will be none.
        // Only use this shortcut during full validation, or you lose some initial nodes which cause different output to previous rando version.
        if (fullValidation) {
            if("Bronze Mirror".equals(stateToUpdate)) {
                queuedUpdates.addAll(backsideDoorRandomizer.getAvailableNodes(stateToUpdate, attemptNumber));
            }
            if("Origin Seal".equals(stateToUpdate) || "Birth Seal".equals(stateToUpdate) || "Life Seal".equals(stateToUpdate) || "Death Seal".equals(stateToUpdate)) {
                queuedUpdates.addAll(sealRandomizer.getNodesForSeal(stateToUpdate));
            }
            if(mapOfRequirementsToNodeNameObject.containsKey(stateToUpdate)) {
                for(String nodeName : mapOfRequirementsToNodeNameObject.get(stateToUpdate)) {
                    node = mapOfNodeNameToRequirementsObject.get(nodeName);
                    if(node != null && node.updateRequirements(stateToUpdate)) {
                        FileUtils.logDetail("Gained access to node " + nodeName + " after acquiring " + stateToUpdate, attemptNumber);
                        handleNodeAccess(nodeName, node.getType(), fullValidation, attemptNumber);
                        nodesToRemove.add(nodeName);
                    }
                }
            }
        }
        else { // When not doing full validation, just use old version of this check.  It's slower but this doesn't happen many times per loop so not a big deal
            if("Origin Seal".equals(stateToUpdate) || "Birth Seal".equals(stateToUpdate) || "Life Seal".equals(stateToUpdate) || "Death Seal".equals(stateToUpdate)) {
                // Included for non-full validation on the off chance that someone starts with one or more seals via custom placements/plando.
                queuedUpdates.addAll(sealRandomizer.getNodesForSeal(stateToUpdate));
            }
            for(String nodeName : mapOfNodeNameToRequirementsObject.keySet()) {
                node = mapOfNodeNameToRequirementsObject.get(nodeName);
                if(node.updateRequirements(stateToUpdate)) {
                    FileUtils.logDetail("Gained access to node " + nodeName + " after acquiring " + stateToUpdate, attemptNumber);
                    handleNodeAccess(nodeName, node.getType(), fullValidation, attemptNumber);
                    nodesToRemove.add(nodeName);
                }
            }
        }

        for(String nodeToRemove : nodesToRemove) {
            mapOfNodeNameToRequirementsObject.remove(nodeToRemove);
        }

        queuedUpdates.remove(newState);
    }

    private String checkState(String stateToUpdate) {
        if(stateToUpdate.contains("Amphisbaena Accessible") || stateToUpdate.contains("Sakit Accessible")
                || stateToUpdate.contains("Ellmac Accessible") || stateToUpdate.contains("Bahamut Accessible")
                || stateToUpdate.contains("Viy Accessible") || stateToUpdate.contains("Baphomet Accessible")
                || stateToUpdate.contains("Palenque Accessible") || stateToUpdate.contains("Tiamat Accessible")) {
            if(Settings.isBossSpecificAnkhJewels()) {
                return stateToUpdate;
            }
            accessibleBossNodes.add(stateToUpdate);
            mapOfNodeNameToRequirementsObject.remove(stateToUpdate);
            queuedUpdates.remove(stateToUpdate);
            return null;
        }
        if(stateToUpdate.startsWith("Coin:")) {
            accessedNodes.add(stateToUpdate);
            mapOfNodeNameToRequirementsObject.remove(stateToUpdate);
            queuedUpdates.remove(stateToUpdate);
            return null;
        }
        if(nodesToDelay.contains(stateToUpdate) && queuedUpdates.size() > 1) {
            // Re-add this update to the end of the queue.
            queuedUpdates.remove(stateToUpdate);
            queuedUpdates.add(stateToUpdate);
            return null;
        }
        if(stateToUpdate.contains("Ankh Jewel") && !stateToUpdate.equals("Ankh Jewel: 9")) {
            if(Settings.isBossSpecificAnkhJewels()) {
                return stateToUpdate;
            }
            numberOfAccessibleAnkhJewels += 1;
            numberOfCollectedAnkhJewels += 1;
            if(numberOfCollectedAnkhJewels == 9) {
                // Alternate Mother Ankh
                queuedUpdates.add("Ankh Jewel: 9");
            }
            return "Ankh Jewel";
        }
        if(stateToUpdate.contains("Sacred Orb (")) {
            numberOfAccessibleSacredOrbs += 1;
            queuedUpdates.add("Sacred Orb: " + numberOfAccessibleSacredOrbs);
            return "Sacred Orb";
        }
        if(!"Whip".equals(Settings.getCurrentStartingWeapon()) && "Whip".equals(stateToUpdate)) {
            return null; // Whip is a removed item.
        }
        if(stateToUpdate.equals("Vessel")) {
            if(Settings.getMedicineColor() != null) {
                return String.format("Medicine of the Mind (%s)", Settings.getMedicineColor());
            }
        }
        if(stateToUpdate.contains("Amphisbaena Defeated") || stateToUpdate.contains("Sakit Defeated")
                || stateToUpdate.contains("Ellmac Defeated") || stateToUpdate.contains("Bahamut Defeated")
                || stateToUpdate.contains("Viy Defeated") || stateToUpdate.contains("Baphomet Defeated")
                || stateToUpdate.contains("Palenque Defeated") || stateToUpdate.contains("Tiamat Defeated")) {
            bossesDefeated += 1;
            queuedUpdates.add("Bosses Defeated: " + bossesDefeated);
        }
        return stateToUpdate;
    }

    public void markBossAccessed(String bossEventNodeName) {
        accessedNodes.add(bossEventNodeName);
        accessibleBossNodes.remove(bossEventNodeName);
        numberOfAccessibleAnkhJewels -= 1;
        NodeWithRequirements node;
        Set<String> nodesToRemove = new HashSet<>();
        for(String nodeName : mapOfRequirementsToNodeNameObject.get(bossEventNodeName)) {
            node = mapOfNodeNameToRequirementsObject.get(nodeName);
            if(node != null && node.updateRequirements(bossEventNodeName)) {
                handleNodeAccess(nodeName, node.getType(), true, null);
                nodesToRemove.add(nodeName);
            }
        }
        for(String nodeToRemove : nodesToRemove) {
            mapOfNodeNameToRequirementsObject.remove(nodeToRemove);
        }
    }

    public void markBossDefeated(String bossEventNodeName) {
        if(!accessibleBossNodes.contains(bossEventNodeName)) {
            return;
        }
        markBossAccessed(bossEventNodeName);

        bossesDefeated += 1;
        String bossDefeatedNodeName = bossEventNodeName.replace("Accessible", "Defeated");
        mapOfNodeNameToRequirementsObject.remove(bossDefeatedNodeName);

        accessedNodes.add(bossDefeatedNodeName);
        NodeWithRequirements node;
        Set<String> nodesToRemove = new HashSet<>();
        for(String nodeName : mapOfRequirementsToNodeNameObject.get(bossDefeatedNodeName)) {
            node = mapOfNodeNameToRequirementsObject.get(nodeName);
            if(node != null && node.updateRequirements(bossDefeatedNodeName)) {
                handleNodeAccess(nodeName, node.getType(), true, null);
                nodesToRemove.add(nodeName);
            }
        }
        for(String nodeToRemove : nodesToRemove) {
            mapOfNodeNameToRequirementsObject.remove(nodeToRemove);
        }
    }

    private void handleNodeAccess(String nodeName, NodeType nodeType, boolean fullValidation, Integer attemptNumber) {
        switch (nodeType) {
            case ITEM_LOCATION:
                if(nodeName.startsWith("Coin:") && !Settings.isRandomizeCoinChests()) {
                    break;
                }
                if(nodeName.startsWith("Trap:") && !Settings.isRandomizeTrapItems()) {
                    break;
                }
                if(fullValidation) {
                    String item = itemRandomizer.getItem(nodeName);
                    if (item == null) {
                        throw new RuntimeException("Unable to find item at " + nodeName + " location of type " + nodeType.toString());
                    }
                    if (!Settings.getCurrentRemovedItems().contains(item) && !Settings.getRemovedItems().contains(item)) {
                        FileUtils.logDetail("Found item " + item, attemptNumber);
                        if(HolidaySettings.isFools2020Mode()) {
                            if("Fake Silver Shield".equals(item)) {
                                queuedUpdates.add("Angel Shield");
                            }
                            else if(!"Silver Shield".equals(item) && !"Angel Shield".equals(item)) {
                                queuedUpdates.add(item);
                            }
                        }
                        else {
                            queuedUpdates.add(item);
                        }
                    }
                }
                else {
                    DataFromFile.getInitialNonShopItemLocations().add(nodeName);
                }
                break;
            case NPC:
                FileUtils.logDetail("Gained access to node " + nodeName, attemptNumber);
                queuedUpdates.add(nodeName);
                break;
            case NPC_LOCATION:
                queuedUpdates.add(nodeName);
                queuedUpdates.add(npcRandomizer.getNpc(nodeName));
                break;
            case MAP_LOCATION:
                queuedUpdates.add(nodeName);
                queuedUpdates.addAll(backsideDoorRandomizer.getAvailableNodes(nodeName, attemptNumber));
                break;
            case STATE:
            case SETTING:
                if(fullValidation) {
                    queuedUpdates.add(nodeName);
                    if(DataFromFile.GUARDIAN_DEFEATED_EVENTS.contains(nodeName) || nodeName.startsWith("Fairy:")) {
                        queuedUpdates.addAll(backsideDoorRandomizer.getAvailableNodes(nodeName, attemptNumber));
                    }
                    if("Event: Skanda Block Removed".equals(nodeName) || "Event: Illusion Unlocked".equals(nodeName)) {
                        if(transitionGateRandomizer.isEndlessL1Open(nodeName)) {
                            queuedUpdates.add("State: Endless L1 Open");
                        }
                    }
                }
                else if(!DataFromFile.GUARDIAN_DEFEATED_EVENTS.contains(nodeName)) {
                    queuedUpdates.add(nodeName);
                    if("Event: Skanda Block Removed".equals(nodeName) || "Event: Illusion Unlocked".equals(nodeName)) {
                        if(transitionGateRandomizer.isEndlessL1Open(nodeName)) {
                            queuedUpdates.add("State: Endless L1 Open");
                        }
                    }
                }
                break;
            case EXIT:
                queuedUpdates.add(nodeName);
                queuedUpdates.addAll(backsideDoorRandomizer.getAvailableNodes(nodeName, attemptNumber));
                queuedUpdates.addAll(transitionGateRandomizer.getTransitionExits(nodeName, attemptNumber));
                break;
            case SHOP:
                if(fullValidation) {
                    for (String shopItem : shopRandomizer.getShopItems(nodeName)) {
                        if (shopItem == null) {
                            throw new RuntimeException("Unable to find item at " + nodeName + " location of type " + nodeType.toString());
                        }
                        if (!accessedNodes.contains(shopItem) && !queuedUpdates.contains(shopItem)
                                && !Settings.getRemovedItems().contains(shopItem)
                                && !Settings.getCurrentRemovedItems().contains(shopItem)) {
                            FileUtils.logDetail("Found item " + shopItem, attemptNumber);
                            if(HolidaySettings.isFools2020Mode()) {
                                if("Fake Silver Shield".equals(shopItem)) {
                                    queuedUpdates.add("Angel Shield");
                                }
                                else if(!"Silver Shield".equals(shopItem)
                                        && !"Angel Shield".equals(shopItem)
                                        && !"Lamp of Time".equals(shopItem)) {
                                    queuedUpdates.add(shopItem);
                                }
                            }
                            else {
                                queuedUpdates.add(shopItem);
                            }
                        }
                    }
                }
                else {
                    DataFromFile.getInitialShops().add(nodeName);
                }
                break;
            case TRANSITION:
                queuedUpdates.add(nodeName);
                String reverseTransition = transitionGateRandomizer.getTransitionReverse(nodeName);
                if(!accessedNodes.contains(reverseTransition) && !queuedUpdates.contains(reverseTransition)) {
                    FileUtils.logDetail("Gained access to node " + reverseTransition + " through reverse transition " + nodeName, attemptNumber);
                    queuedUpdates.add(reverseTransition);
                    if("Transition: Goddess L2".equals(reverseTransition) ) {
                        queuedUpdates.add("Event: Special Statue Removal");
                    }
                }
                break;
        }
    }

    public boolean validRequirements(String item, String location) {
        String logicalItem = item;
        if(DataFromFile.ESCAPE_CHEST_NAME.equals(location)) {
            // Must be something not strictly required for the seed.
            // This doesn't prevent some conditionally required items from getting placed here, but it should mostly be optional stuff.
            return DataFromFile.getRandomRemovableItems().contains(item);
        }
        if(location.contains("Shop")) {
            location = location.substring(0, location.indexOf(")") + 1);
        }

        if(item.equals("Dimensional Key")) {
            if(isDimensionalCorridorLocation(location)) {
                return false;
            }
        }
        else if(item.contains("Ankh Jewel")) {
            logicalItem = "Ankh Jewel";
            if(isSnapshotsScanLocation(location)) {
                return false;
            }
        }
        else if(item.contains("Sacred Orb")) { // todo: should probably not do this check if it's a removed item
            logicalItem = "Sacred Orb";
            if(isSnapshotsScanLocation(location)) {
                return false;
            }
            if(location.contains("Shop")) {
                if(shopRandomizer.shopHasTransformation(location)) {
                    if(!itemRandomizer.isRemovedItem(item)) {
                        return false;
                    }
                }
                if(HolidaySettings.isFools2021Mode()
                        && ("Shop 12 (Spring)".equals(location) || "Shop 12 Alt (Spring)".equals(location)
                        || "Shop 18 (Lil Bro)".equals(location) || "Shop 20 (Twin Labs)".equals(location)
                        || "Shop 21 (Unsolvable)".equals(location))) {
                    // Avoid dealing with shop transformations.
                    return false;
                }
            }
        }
        else if(item.startsWith("Map")) {
            // Don't put maps in conversations or torude scans, because the item-give dialog won't behave normally.
            if(isSnapshotsScanLocation(location)) {
                return false;
            }
            if(DataFromFile.LOCATIONS_RELATED_TO_BLOCKS.contains(location) && !"Map (Surface)".equals(location)) {
                if(!itemRandomizer.isRemovedItem(item)) {
                    // Conversations can have removed items, but not maps.
                    return false;
                }
            }
            if(HolidaySettings.isHalloween2021Mode() && !itemRandomizer.isChestLocation(location)) {
                return false;
            }
        }
        else if(item.startsWith("Trap:")) {
            // Shop, NPC, torude scan can't give traps.
            if(location.contains("Shop")) {
                return false;
            }
            if(DataFromFile.LOCATIONS_RELATED_TO_BLOCKS.contains(location)) {
                return false;
            }
            if(isSnapshotsScanLocation(location)) {
                return false;
            }
            if(DataFromFile.getBannedTrapLocations().contains(location)) {
                // Don't put a trap here, because we don't have handling for separate screen flags, and it'll
                // look bad if opening one chest procs both traps.
                return false;
            }
            if(DataFromFile.EXPLODING_CHEST_NAME.equals(item)) {
                if(isFloatingItemLocation(location)) {
                    return false;
                }
            }
            if(HolidaySettings.isHalloween2021Mode()) {
                // Maintain trap types
                if(isFloatingItemLocation(location)) {
                    if(DataFromFile.GRAVEYARD_TRAP_CHEST_NAME.equals(item)) {
                        // Force Graveyard trap chest into a chest
                        return false;
                    }
                }
                else if(itemRandomizer.isChestLocation(location)) {
                    if(DataFromFile.FAKE_ANKH_TRAP_NAME.equals(item)) {
                        return false;
                    }
                    if(DataFromFile.FAKE_ORB_TRAP_NAME.equals(item)) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        else if(item.startsWith("Coin:")) {
            // Shop, floating item, torude scan, item give can't give coins.
            if(location.contains("Shop")) {
                return false;
            }
            if(isFloatingItemLocation(location)) {
                return false;
            }
            if(isSnapshotsScanLocation(location)) {
                return false;
            }
            if("Map (Surface)".equals(location)) {
                return false;
            }
            if(HolidaySettings.isHalloween2021Mode()) {
                // Coins allowed in chests only
                if(DataFromFile.LOCATIONS_RELATED_TO_BLOCKS.contains(location)) {
                    return false;
                }
            }
        }
        else if(item.equals("Whip") || item.equals("Chain Whip") || item.equals("Buckler") || item.contains("Silver Shield")) {
            if(isSnapshotsScanLocation(location)) {
                return false;
            }
            if("Shop 2 Alt (Surface)".equals(location)) {
                // Don't put low/mid tier shield/whip in the shop; you can't buy it to transform the shop if you have the higher tier version.
                if(!itemRandomizer.isRemovedItem(item)) {
                    return false;
                }
            }
        }

        if(itemRandomizer.isRemovedItem(item)) {
            if("Shop 2 Alt (Surface)".equals(location)) {
                // Don't put removed item in transforming Surface shop.
                return false;
            }
            if(isSnapshotsScanLocation(location)) {
                // Don't put removed item in torude scan spots, for now.
                return false;
            }
        }

        if(Settings.isRandomizeCursedChests() && Settings.getMaxRandomRemovedItems() == 0
                && "Mulana Talisman".equals(item) && itemRandomizer.isCursedChestLocation(location, item)) {
            return false;
        }

        return mapOfNodeNameToRequirementsObject.get(location).canContainItem(logicalItem);
    }

    private boolean isDimensionalCorridorLocation(String location) {
        return "Angel Shield".equals(location) || "beolamu.exe".equals(location) || "Sacred Orb (Dimensional Corridor)".equals(location)
                || "Ankh Jewel (Dimensional Corridor)".equals(location) || "Magatama Jewel".equals(location)
                || "Map (Dimensional Corridor)".equals(location) || "Coin: Dimensional".equals(location)
                || npcRandomizer.isDimensionalCorridor(location);
    }

    private boolean isSnapshotsScanLocation(String location) {
        return DataFromFile.SNAPSHOTS_SCAN_LOCATIONS.contains(location);
    }

    private boolean isFloatingItemLocation(String location) {
        return DataFromFile.FLOATING_ITEM_LOCATIONS.contains(location);
    }

    public boolean isEnoughAnkhJewelsToDefeatAllAccessibleBosses() {
        return numberOfAccessibleAnkhJewels >= accessibleBossNodes.size();
    }

    public void logAnkhJewelLock() {
        FileUtils.log("Accessible bosses: " + accessibleBossNodes.toString());
        FileUtils.logFlush("Total ankh jewels: " + numberOfCollectedAnkhJewels);
    }

    public void setItemRandomizer(ItemRandomizer itemRandomizer) {
        this.itemRandomizer = itemRandomizer;
    }

    public void setShopRandomizer(ShopRandomizer shopRandomizer) {
        this.shopRandomizer = shopRandomizer;
    }

    public void setBacksideDoorRandomizer(BacksideDoorRandomizer backsideDoorRandomizer) {
        this.backsideDoorRandomizer = backsideDoorRandomizer;
    }

    public void setTransitionGateRandomizer(TransitionGateRandomizer transitionGateRandomizer) {
        this.transitionGateRandomizer = transitionGateRandomizer;
    }

    public void setSealRandomizer(SealRandomizer sealRandomizer) {
        this.sealRandomizer = sealRandomizer;
    }

    public void setNpcRandomizer(NpcRandomizer npcRandomizer) {
        this.npcRandomizer = npcRandomizer;
    }

    public boolean updateForBosses() {
        List<Thread> threads = new ArrayList<>(accessibleBossNodes.size());
        List<AnkhJewelLockChecker> ankhJewelLockCheckers = new ArrayList<>();
        for(String bossNode : accessibleBossNodes) {
            AnkhJewelLockChecker ankhJewelLockChecker = new AnkhJewelLockChecker(new AccessChecker(this, false), bossNode);
            ankhJewelLockCheckers.add(ankhJewelLockChecker);
            Thread thread = new Thread(ankhJewelLockChecker);
            threads.add(thread);
            thread.start();
        }

        try {
            for(Thread thread : threads) {
                thread.join();
            }
        }
        catch (InterruptedException ex) {
            FileUtils.log("Error: interrupted thread while checking for ankh jewel locks");
        }

        for(AnkhJewelLockChecker ankhJewelLockChecker : ankhJewelLockCheckers) {
            if(ankhJewelLockChecker.isAnkhJewelLock()) {
                ankhJewelLockChecker.logAnkhJewelLock();
                return false;
            }
        }
        NodeWithRequirements bossNode;
        List<String> copyAccessibleBossNodes = new ArrayList<>(accessibleBossNodes);
        for(String accessibleBoss : copyAccessibleBossNodes) {
            bossNode = mapOfNodeNameToRequirementsObject.get(accessibleBoss.replace("Accessible", "Defeated"));
            if(bossNode != null && !accessedNodes.contains(accessibleBoss)) {
                markBossAccessed(accessibleBoss);
            }
        }
        return true;
    }
}
