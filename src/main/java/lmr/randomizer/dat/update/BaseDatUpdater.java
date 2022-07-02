package lmr.randomizer.dat.update;

import lmr.randomizer.*;
import lmr.randomizer.dat.DatFileData;
import lmr.randomizer.dat.blocks.*;
import lmr.randomizer.dat.blocks.contents.*;
import lmr.randomizer.dat.blocks.contents.entries.DefaultGrailPointEntry;
import lmr.randomizer.dat.blocks.contents.entries.GrailPointEntry;
import lmr.randomizer.randomization.data.CustomBlockEnum;
import lmr.randomizer.update.AddBlock;
import lmr.randomizer.util.*;

import java.util.ArrayList;
import java.util.List;

public class BaseDatUpdater extends DatUpdater {
    public BaseDatUpdater(DatFileData datFileData) {
        super(datFileData);
    }

    @Override
    public void updateItemDescriptions(ItemDescriptionBlock itemDescriptionBlock) {
        String versionString = " Randomizer version " + FileUtils.VERSION;
        String settingsString = "Settings " + Settings.generateShortString();
        String msxDescription = Translations.getText("items.MobileSuperX") + "：" + versionString + "\n" + settingsString;
        String msx2Description = Translations.getText("items.MobileSuperX2") + "：" + versionString + "\n" + settingsString;

        itemDescriptionBlock.setDescription(ItemDescriptionBlock.MSX1, buildTextEntry(msxDescription));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.MSX2, buildTextEntry(msx2Description));
    }

    @Override
    public void updateSoftwareData(SoftwareBlock softwareBlock) {
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareMirai, 200);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareMirai, buildTextEntry(Translations.getText("software.cost.mirai")));
    }

    @Override
    public void updateGrailPoints(GrailPointBlock grailPointBlock) {
        if(!LocationCoordinateMapper.isSurfaceStart() || Settings.isReducedBossCount() || HolidaySettings.isFools2021Mode() || Settings.getCurrentStartingLocation() == 22) {
            boolean front = LocationCoordinateMapper.isFrontsideStart();

            DefaultGrailPointEntry defaultGrailPointEntry = grailPointBlock.getDefaultGrailPointEntry();
            defaultGrailPointEntry.setWarpImage(LocationCoordinateMapper.getImageIndex(LocationCoordinateMapper.getStartingZone(), front));
            defaultGrailPointEntry.setDestination(LocationCoordinateMapper.getStartingZone(),
                    LocationCoordinateMapper.getStartingRoom(),
                    LocationCoordinateMapper.getStartingScreen(),
                    LocationCoordinateMapper.getGrailX() % 640,
                    LocationCoordinateMapper.getGrailY() % 480);

            List<Short> warpsUpdated = new ArrayList<>();
            warpsUpdated.add((short)LocationCoordinateMapper.getStartingZone());
            short nextWarp = LocationCoordinateMapper.getNextWarpZone(LocationCoordinateMapper.getStartingZone(), front);
            int grailPointIndex = 1;
            while(!warpsUpdated.contains(nextWarp)) {
                GrailPointEntry grailPointEntry = grailPointBlock.getGrailPointEntry(grailPointIndex++);
                grailPointEntry.setRequireMirai(false);
                grailPointEntry.setFlag(LocationCoordinateMapper.getGrailFlag(nextWarp, front));
                grailPointEntry.setWarpImage(LocationCoordinateMapper.getImageIndex(nextWarp, front));
                grailPointEntry.setDestination(nextWarp,
                        LocationCoordinateMapper.getStartingRoom(nextWarp, front),
                        LocationCoordinateMapper.getStartingScreen(nextWarp),
                        LocationCoordinateMapper.getGrailX(nextWarp, front) % 640,
                        LocationCoordinateMapper.getGrailY(nextWarp, front) % 480);

                warpsUpdated.add(nextWarp);
                nextWarp = LocationCoordinateMapper.getNextWarpZone(nextWarp, front);
            }
            front = !front;
            nextWarp = LocationCoordinateMapper.getNextWarpZone(-1, front);
            warpsUpdated.clear(); // Necessary since Twin Labyrinths is on both sides.
            while(!warpsUpdated.contains(nextWarp)) {
                GrailPointEntry grailPointEntry = grailPointBlock.getGrailPointEntry(grailPointIndex++);
                grailPointEntry.setRequireMirai(true);
                grailPointEntry.setFlag(LocationCoordinateMapper.getGrailFlag(nextWarp, front));
                grailPointEntry.setWarpImage(LocationCoordinateMapper.getImageIndex(nextWarp, front));
                grailPointEntry.setDestination(nextWarp,
                        LocationCoordinateMapper.getStartingRoom(nextWarp, front),
                        LocationCoordinateMapper.getStartingScreen(nextWarp),
                        LocationCoordinateMapper.getGrailX(nextWarp, front) % 640,
                        LocationCoordinateMapper.getGrailY(nextWarp, front) % 480);

                warpsUpdated.add(nextWarp);
                nextWarp = LocationCoordinateMapper.getNextWarpZone(nextWarp, front);
            }
        }
    }

    @Override
    void updateMulbrukWakingUpConversationBlock(Block conversationBlock) {
        // Move flag update from ConversationDoor into conversation
        Integer blockContentIndex = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                BlockFlagData blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.MULBRUK_CONVERSATIONS_EARLY) {
                    blockContentIndex = i;
                }
            }
        }
        conversationBlock.getBlockContents().add(blockContentIndex,
                new BlockFlagData(FlagConstants.MULBRUK_CONVERSATION_AWAKE, 1));
    }

    @Override
    public void updateMiniDollConversationBlock(Block conversationBlock) {
        // Remove Mini Doll's becoming small flag from conversation.
        Integer becomingSmallFlagIndex = null;
        BlockContents blockContents;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData && ((BlockFlagData)blockContents).getWorldFlag() == FlagConstants.PROVE_THOU_ART_SMALL) {
                becomingSmallFlagIndex = i;
            }
        }
        if(becomingSmallFlagIndex != null) {
            conversationBlock.getBlockContents().remove((int)becomingSmallFlagIndex);
        }
    }

    @Override
    void updatePepperConversationBlock(Block conversationBlock) {
        // Add custom conversation flag to separate the Pepper and Anchor checks
        Integer blockContentIndex = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                BlockFlagData blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.MR_SLUSHFUND_CONVERSATION) {
                    blockContentIndex = i;
                }
            }
        }
        conversationBlock.getBlockContents().add(blockContentIndex,
                new BlockFlagData(FlagConstants.MR_SLUSHFUND_CONVERSATION_PEPPER, 1));
    }

    @Override
    void updateXmailerConversationBlock(Block conversationBlock) {
        // Note: This may still get overwritten by holiday mode changes (Halloween, Fools2020)
        List<BlockContents> xelpudBlockContents = conversationBlock.getBlockContents();

        // Set value of world flag to 2 instead of 1
        for(int i = 0; i < xelpudBlockContents.size(); i++) {
            BlockContents blockContents = xelpudBlockContents.get(i);
            if(blockContents instanceof BlockFlagData) {
                BlockFlagData blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.WF_SOFTWARE_XMAILER) {
                    blockFlagData.setFlagValue((short)2);
                }
                else if(blockFlagData.getWorldFlag() == FlagConstants.XELPUD_CONVERSATION_GENERAL) {
                    blockFlagData.setWorldFlag((short)FlagConstants.XELPUD_CONVERSATION_INTRO);
                    blockFlagData.setFlagValue((short)1);
                }
            }
        }
    }

    @Override
    void updateXelpudTalismanConversationBlock(Block conversationBlock) {
        // Talisman conversation (allows Diary chest access)
        Integer blockContentIndex = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                BlockFlagData blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.CONVERSATION_CANT_LEAVE) {
                    blockContentIndex = i;
                }
            }
        }
        conversationBlock.getBlockContents().add(blockContentIndex,
                new BlockFlagData((short)FlagConstants.XELPUD_CONVERSATION_TALISMAN_FOUND, (short)2));
        conversationBlock.getBlockContents().add(blockContentIndex, new BlockFlagData((short)807, (short)1));
    }

    @Override
    void updateXelpudPillarConversationBlock(Block conversationBlock) {
        // Diary chest conversation (allows Diary chest access)
        Integer flagIndexToRemove = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                BlockFlagData blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.SHRINE_DIARY_CHEST) {
                    flagIndexToRemove = i;
                }
            }
        }
        // Get rid of Diary puzzle flag.
        if(flagIndexToRemove != null) {
            conversationBlock.getBlockContents().remove((int)flagIndexToRemove);
        }

        Integer blockContentIndex = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                BlockFlagData blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.CONVERSATION_CANT_LEAVE) {
                    blockContentIndex = i;
                }
            }
        }
        conversationBlock.getBlockContents().add(blockContentIndex,
                new BlockFlagData((short)FlagConstants.XELPUD_CONVERSATION_TALISMAN_FOUND, (short)3));
    }

    @Override
    void updateMulanaTalismanConversationBlock(Block conversationBlock) {
        BlockFlagData blockFlagData;

        // Handle Mulana Talisman conversation flag changes.
        Integer flagIndexOfMulanaTalisman = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                blockFlagData = (BlockFlagData) blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.WF_MULANA_TALISMAN) {
                    blockFlagData.setWorldFlag((short)FlagConstants.XELPUD_CONVERSATION_DIARY_FOUND);
                    blockFlagData.setFlagValue((short)2);
                    flagIndexOfMulanaTalisman = i;
                }
            }
        }
        blockFlagData = new BlockFlagData((short)FlagConstants.WF_MULANA_TALISMAN, (short)2);
        conversationBlock.getBlockContents().add(flagIndexOfMulanaTalisman, blockFlagData);

        // Get rid of Diary puzzle flag.
        Integer flagIndexToRemove = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                blockFlagData = (BlockFlagData)blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.SHRINE_PUZZLE_DIARY_CHEST) {
                    flagIndexToRemove = i;
                }
            }
        }
        if(flagIndexToRemove != null) {
            conversationBlock.getBlockContents().remove((int)flagIndexToRemove);
        }
    }

    @Override
    void updateBookOfTheDeadConversationBlock(Block conversationBlock) {
        // Handle Book of the Dead conversation flag changes.
        BlockFlagData blockFlagData;
        Integer flagIndexOfConversationFlagUpdate = null;
        for(int i = 0; i < conversationBlock.getBlockContents().size(); i++) {
            BlockContents blockContents = conversationBlock.getBlockContents().get(i);
            if(blockContents instanceof BlockFlagData) {
                blockFlagData = (BlockFlagData)blockContents;
                if(blockFlagData.getWorldFlag() == FlagConstants.MULBRUK_CONVERSATION_BOOK) {
                    flagIndexOfConversationFlagUpdate = i;
                }
            }
        }
        blockFlagData = new BlockFlagData(FlagConstants.WF_BOOK_OF_THE_DEAD, 2);
        conversationBlock.getBlockContents().add(flagIndexOfConversationFlagUpdate, blockFlagData);
    }

    @Override
    void updateNeburAltShopBlock(ShopBlock shopBlock) {
        BlockStringData oldBlockStringData = shopBlock.getString(6);
        BlockStringData newBlockStringData = new BlockStringData();
        newBlockStringData.getData().addAll(oldBlockStringData.getData().subList(0, oldBlockStringData.getData().size() - 3));
        shopBlock.setString(newBlockStringData, 6);
    }

    @Override
    public void updateXelpudFlagCheckBlock(CheckBlock flagCheckBlock) {
        flagCheckBlock.removeCheckEntryByBlockIndex(BlockConstants.Removed_WindHowlingSwimsuit);
        flagCheckBlock.removeCheckEntryByBlockIndex(BlockConstants.ItemConversationMulanaTalisman);
        flagCheckBlock.removeCheckEntryByBlockIndex(BlockConstants.XelpudPillarConversation); // Remove Xelpud pillar conversation so we can re-build it at the front.
        flagCheckBlock.removeCheckEntryByBlockIndex(BlockConstants.ItemConversationXmailer); // Remove xmailer conversation so we can re-build it at the front.

        BlockListData blockListData = new BlockListData(BlockDataConstants.DataList, (short)4);
        blockListData.getData().add((short)FlagConstants.XELPUD_CONVERSATION_DIARY_FOUND);
        blockListData.getData().add((short)1);
        blockListData.getData().add((short)BlockConstants.ItemConversationMulanaTalisman);
        blockListData.getData().add((short)0); // Disabling repeat for Mulana Talisman in case it's an ankh jewel or something.
        flagCheckBlock.getFlagCheckReferences().add(0, blockListData);

        // Xelpud pillar conversation possible as soon as Talisman conversation
        blockListData = new BlockListData(BlockDataConstants.DataList, (short)4);
        blockListData.getData().add((short)FlagConstants.XELPUD_CONVERSATION_TALISMAN_FOUND);
        blockListData.getData().add((short)2);
        blockListData.getData().add((short)BlockConstants.XelpudPillarConversation);
        blockListData.getData().add((short)0);
        flagCheckBlock.getFlagCheckReferences().add(0, blockListData);

        // Changing Talisman conversation to use a custom flag instead of a held item check
        blockListData = new BlockListData(BlockDataConstants.DataList, (short)4);
        blockListData.getData().add((short)FlagConstants.XELPUD_CONVERSATION_TALISMAN_FOUND);
        blockListData.getData().add((short)1);
        blockListData.getData().add((short)BlockConstants.XelpudTalismanConversation);
        blockListData.getData().add((short)0);
        flagCheckBlock.getFlagCheckReferences().add(0, blockListData);

        // Changing xmailer conversation to use a custom flag
        blockListData = new BlockListData(BlockDataConstants.DataList, (short)4);
        blockListData.getData().add((short)FlagConstants.XELPUD_CONVERSATION_INTRO);
        blockListData.getData().add((short)0);
        blockListData.getData().add((short)BlockConstants.ItemConversationXmailer);
        blockListData.getData().add((short)0);
        flagCheckBlock.getFlagCheckReferences().add(0, blockListData);
    }

    @Override
    public void updateXelpudScoreCheckBlock(CheckBlock scoreCheckBlock) {
        Integer cmdToRemoveIndex = null;
        for(int i = 0; i < scoreCheckBlock.getFlagCheckReferences().size(); i++) {
            BlockListData blockListData = scoreCheckBlock.getFlagCheckReferences().get(i);
            if(blockListData.getData().get(2) == BlockConstants.Removed_XelpudScoreWindHowling) {
                cmdToRemoveIndex = i;
            }
        }
        if(cmdToRemoveIndex != null) {
            scoreCheckBlock.getFlagCheckReferences().remove((int)cmdToRemoveIndex);
        }
    }

    @Override
    public void updateMulbrukFlagCheckBlock(CheckBlock flagCheckBlock) {
        for(BlockListData blockListData : flagCheckBlock.getFlagCheckReferences()) {
            blockListData.getData().remove((int)blockListData.getData().size() - 1); // Remove existing value for conversation repeats
            blockListData.getData().add((short)0); // Disable conversation repeats to reduce annoyance factor
        }

        List<BlockListData> flagChecks = new ArrayList<>(flagCheckBlock.getFlagCheckReferences().size());
        flagChecks.add(flagCheckBlock.getFlagCheckReferences().get(3)); // Book of the Dead conversation
        flagChecks.addAll(flagCheckBlock.getFlagCheckReferences().subList(13, flagCheckBlock.getFlagCheckReferences().size())); // HT conversations

        // Mulbruk waking up conversation
        BlockListData blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.MULBRUK_CONVERSATION_AWAKE);
        blockListData.getData().add((short)0);
        blockListData.getData().add((short)BlockConstants.MulbrukWakingUpConversationBlock);
        blockListData.getData().add((short)0);
        flagChecks.add(blockListData);

        flagChecks.addAll(flagCheckBlock.getFlagCheckReferences().subList(1, 3)); // MULBRUK_CONVERSATIONS_EARLY
        flagChecks.addAll(flagCheckBlock.getFlagCheckReferences().subList(4, 13)); // Misc Mulbruk conversations
        flagCheckBlock.getFlagCheckReferences().clear();
        flagCheckBlock.getFlagCheckReferences().addAll(flagChecks);
    }

    @Override
    void updateEmailBlock(Block emailBlock, int mailNumber) {
        List<BlockContents> blockContents = emailBlock.getBlockContents();
        String baseKey = "Mail" + mailNumber;
        String titleKey = baseKey + ".Title";
        String textKey = baseKey + ".Text";
        if(Translations.hasKey(titleKey) && Translations.hasKey(textKey)) {
            blockContents.clear();
            for(Short singleCharacter : buildRawDataWithCommands(Translations.getText(titleKey))) {
                blockContents.add(new BlockSingleData(singleCharacter));
            }
            blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
            for(Short singleCharacter : buildRawDataWithCommands(Translations.getText(textKey))) {
                blockContents.add(new BlockSingleData(singleCharacter));
            }
        }
    }

    @Override
    void updateScannableBlock(ScannableBlock scannableBlock) {
        String scannableId = MiscConstants.getScannableId(scannableBlock.getBlockNumber());
        String customText = getCustomScanText(scannableId);
        if(customText != null) {
            scannableBlock.setScanText(buildTextEntryWithCommands(customText));
        }
    }

    protected String getCustomScanText(String scannableId) {
        if(scannableId == null) {
            return null;
        }
        return Translations.getText(scannableId + ".Text");
    }

    @Override
    public void addCustomBlocks(DatFileData datFileData) {
        if(!LocationCoordinateMapper.isSurfaceStart() && Settings.getCurrentStartingLocation() != 23 && Settings.getCurrentStartingLocation() != 24) {
            Block block = AddBlock.buildShopBlock();
            datFileData.addCustomBlock(CustomBlockEnum.DefaultShopBlock, block);
            if(!DataFromFile.getMapOfShopNameToShopBlock().containsKey(DataFromFile.CUSTOM_SHOP_NAME)) {
                DataFromFile.getMapOfShopNameToShopBlock().put(DataFromFile.CUSTOM_SHOP_NAME, block.getBlockNumber());
            }
        }

        if(HolidaySettings.isFools2019Mode() || HolidaySettings.isFools2020Mode()) {
            datFileData.addCustomBlock(CustomBlockEnum.CustomXelpudIntro, AddBlock.buildCustomXelpudIntroBlock());
        }
        if(Settings.isSaveFileNeeded()) {
            datFileData.addCustomBlock(CustomBlockEnum.XelpudDoor_LoadSaveFile_ConversationBlock,
                    AddBlock.buildLoadSaveFileConversationBlock());
            datFileData.addCustomBlock(CustomBlockEnum.XelpudDoor_LoadSaveFile_ReferenceBlock,
                    AddBlock.buildLoadSaveFileReferenceBlock(getCustomBlockIndex(CustomBlockEnum.XelpudDoor_LoadSaveFile_ConversationBlock)));
        }
        datFileData.addCustomBlock(CustomBlockEnum.RecordableStoneConversation,
                AddBlock.buildRecordableStoneConversationBlock());
        int recordableStoneConversationBlockIndex = getCustomBlockIndex(CustomBlockEnum.RecordableStoneConversation);
        datFileData.addCustomBlock(CustomBlockEnum.RecordableStonePhilosopherGiltoriyo,
                AddBlock.buildRecordableStoneConversationMasterBlock(CustomBlockEnum.RecordableStonePhilosopherGiltoriyo,
                        recordableStoneConversationBlockIndex));
        datFileData.addCustomBlock(CustomBlockEnum.RecordableStonePhilosopherAlsedana,
                AddBlock.buildRecordableStoneConversationMasterBlock(CustomBlockEnum.RecordableStonePhilosopherAlsedana,
                        recordableStoneConversationBlockIndex));
        datFileData.addCustomBlock(CustomBlockEnum.RecordableStonePhilosopherSamaranta,
                AddBlock.buildRecordableStoneConversationMasterBlock(CustomBlockEnum.RecordableStonePhilosopherSamaranta,
                        recordableStoneConversationBlockIndex));
        datFileData.addCustomBlock(CustomBlockEnum.RecordableStonePhilosopherFobos,
                AddBlock.buildRecordableStoneConversationMasterBlock(CustomBlockEnum.RecordableStonePhilosopherFobos,
                        recordableStoneConversationBlockIndex));
    }
}
