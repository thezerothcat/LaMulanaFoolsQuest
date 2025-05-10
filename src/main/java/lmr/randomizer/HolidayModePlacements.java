package lmr.randomizer;

import lmr.randomizer.node.CustomDoorPlacement;
import lmr.randomizer.randomization.ShopRandomizationEnum;
import lmr.randomizer.util.ZoneConstants;

import java.util.List;

public class HolidayModePlacements {
    public static void applyCustomPlacements() {
        if(HolidaySettings.isFools2022Mode()) {
            addCustomPlacementsFools2022();
        }
    }

    private static void addCustomPlacementsFools2022() {
        DataFromFile.getCustomPlacementData().setAutomaticMantras(false);
        DataFromFile.getCustomPlacementData().setAlternateMotherAnkh(false);
        DataFromFile.getCustomPlacementData().setMedicineColor("Green");
        DataFromFile.getCustomPlacementData().setStartingLocation(ZoneConstants.SURFACE);

        // Silent settings
        Settings.setRemoveSpaulder(false, false);
        Settings.setReplaceMapsWithWeights(false, false);
        Settings.setRandomizeTransitionGates(true, false);
        Settings.setRandomizeOneWayTransitions(true, false);
        Settings.setRandomizeBacksideDoors(true, false);
        Settings.setRandomizeNonBossDoors(true, false);
        Settings.setRandomizeEnemies(false, false);
        Settings.setCoinChestGraphics(false, false);
        Settings.setBossCheckpoints(true, false);
        Settings.setRandomizeDracuetShop(true, false);
        Settings.setHTFullRandom(true, false);
        Settings.setAutomaticHardmode(false, false);
        Settings.setMinRandomRemovedItems(0, false);
        Settings.setMaxRandomRemovedItems(0, false);

        Settings.setRequireFullAccess(false, false);
        Settings.setReducedBossCount(false, false);
        Settings.setAlternateMotherAnkh(true, false);
        Settings.setRandomizeGraphics(false, false); // really only need to notify that item vs coin chest graphics are not random
        Settings.setRequireSoftwareComboForKeyFairy(true, false);
        Settings.setRequireFlaresForExtinction(false, false);
        Settings.setRequireIceCapeForLava(false, false);
        Settings.setAutomaticGrailPoints(false, false);
        Settings.setShopRandomization(ShopRandomizationEnum.EVERYTHING.name(), false);

        // Make sure to warn of these?
        Settings.setAutomaticTranslations(true, false); // todo: do we care?
        Settings.setUshumgalluAssist(true, false); // todo: say something?
        Settings.setRandomizeEscapeChest(true, false);
        Settings.setRandomizeSeals(false, false);
        Settings.setRandomizeNpcs(false, false); // todo: undecided

        Settings.getStartingItems().clear();
        List<String> startingItems = DataFromFile.getCustomPlacementData().getStartingItems();
        startingItems.clear();
        startingItems.add("Holy Grail");
        startingItems.add("bunemon.exe");
        startingItems.add("bunplus.com");

//        Map<String, Short> customShopPrices = DataFromFile.getCustomPlacementData().getCustomShopPrices();
//        customShopPrices.put("Weights", (short)0);
//        Map<String, Short> customShopCounts = DataFromFile.getCustomPlacementData().getCustomShopCounts();
//        customShopCounts.put("Weights", (short)-1);

        List<CustomDoorPlacement> doors = DataFromFile.getCustomPlacementData().getCustomDoorPlacements();
        doors.add(new CustomDoorPlacement("Door: F1", "Door: B1", "Amphisbaena"));
        doors.add(new CustomDoorPlacement("Door: B1", "Door: F1", "Amphisbaena"));
        doors.add(new CustomDoorPlacement("Door: F2", "Door: B2", "Sakit"));
        doors.add(new CustomDoorPlacement("Door: B2", "Door: F2", "Sakit"));
        doors.add(new CustomDoorPlacement("Door: F3", "Door: B3", "Ellmac"));
        doors.add(new CustomDoorPlacement("Door: B3", "Door: F3", "Ellmac"));
        doors.add(new CustomDoorPlacement("Door: F4", "Door: B4", "Bahamut"));
        doors.add(new CustomDoorPlacement("Door: B4", "Door: F4", "Bahamut"));
        doors.add(new CustomDoorPlacement("Door: F5", "Door: B5", "Viy"));
        doors.add(new CustomDoorPlacement("Door: B5", "Door: F5", "Viy"));
        doors.add(new CustomDoorPlacement("Door: F6", "Door: B6", "Palenque"));
        doors.add(new CustomDoorPlacement("Door: B6", "Door: F6", "Palenque"));
        doors.add(new CustomDoorPlacement("Door: F7", "Door: B7", "Baphomet"));
        doors.add(new CustomDoorPlacement("Door: B7", "Door: F7", "Baphomet"));
        doors.add(new CustomDoorPlacement("Door: F8", "Door: B8", "None"));
        doors.add(new CustomDoorPlacement("Door: B8", "Door: F8", "None"));
        doors.add(new CustomDoorPlacement("Door: F9", "Door: B9", "Key Fairy"));
        doors.add(new CustomDoorPlacement("Door: B9", "Door: F9", "None"));
    }
}
