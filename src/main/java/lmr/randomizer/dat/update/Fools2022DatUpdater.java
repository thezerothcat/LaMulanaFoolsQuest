package lmr.randomizer.dat.update;

import lmr.randomizer.Settings;
import lmr.randomizer.Translations;
import lmr.randomizer.dat.DatFileData;
import lmr.randomizer.dat.blocks.*;
import lmr.randomizer.dat.blocks.contents.*;
import lmr.randomizer.dat.blocks.contents.entries.GrailPointEntry;
import lmr.randomizer.randomization.data.CustomBlockEnum;
import lmr.randomizer.randomization.data.ItemPriceCount;
import lmr.randomizer.randomization.data.ShopInventory;
import lmr.randomizer.randomization.data.ShopInventoryData;
import lmr.randomizer.util.*;

import java.util.Arrays;
import java.util.List;

public class Fools2022DatUpdater extends DatUpdater {
    public Fools2022DatUpdater(DatFileData datFileData) {
        super(datFileData);
    }

    @Override
    void updateItemNames(ItemNameBlock itemNameBlock) {
        itemNameBlock.setName(ItemDescriptionBlock.SoftwareCapstar, buildTextEntry(Translations.getText("event.fools2022.capstar.name")));
        itemNameBlock.setName(ItemDescriptionBlock.BookOfTheDead, buildTextEntry(Translations.getText("event.fools2022.bookofthedead.name")));
        itemNameBlock.setName(ItemDescriptionBlock.Diary, buildTextEntry(Translations.getText("event.fools2022.diary.name")));
    }

    @Override
    public void updateItemDescriptions(ItemDescriptionBlock itemDescriptionBlock) {
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Shuriken, buildTextEntry(Translations.getText("event.fools2022.shuriken.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.RollingShuriken, buildTextEntry(Translations.getText("event.fools2022.rollingshuriken.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.EarthSpear, buildTextEntry(Translations.getText("event.fools2022.earthspear.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.FlareGun, buildTextEntry(Translations.getText("event.fools2022.flaregun.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Bomb, buildTextEntry(Translations.getText("event.fools2022.bomb.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Chakram, buildTextEntry(Translations.getText("event.fools2022.chakram.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Caltrops, buildTextEntry(Translations.getText("event.fools2022.caltrops.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Pistol, buildTextEntry(Translations.getText("event.fools2022.pistol.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.SerpentStaff, buildTextEntry(Translations.getText("event.fools2022.serpentstaff.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.AnkhJewel, buildTextEntry(Translations.getText("event.fools2022.ankhjewel.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.SoftwareCapstar, buildTextEntry(Translations.getText("event.fools2022.capstar.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.FairyClothes, buildTextEntry(Translations.getText("event.fools2022.fairyclothes.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.LampOfTime, buildTextEntry(Translations.getText("event.fools2022.lamplit.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.LampOfTimeEmpty, buildTextEntry(Translations.getText("event.fools2022.lampempty.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.GreenMedicine, buildTextEntry(Translations.getText("event.fools2022.greenmedicine.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.RedMedicine, buildTextEntry(Translations.getText("event.fools2022.redmedicine.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.YellowMedicine, buildTextEntry(Translations.getText("event.fools2022.yellowmedicine.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.WaterproofCase, buildTextEntry(Translations.getText("event.fools2022.waterproofcase.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.HeatproofCase, buildTextEntry(Translations.getText("event.fools2022.heatproofcase.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Axe, buildTextEntry(Translations.getText("event.fools2022.axe.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Whip, buildTextEntry(Translations.getText("event.fools2022.whip.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.ChainWhip, buildTextEntry(Translations.getText("event.fools2022.chainwhip.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.FlailWhip, buildTextEntry(Translations.getText("event.fools2022.flailwhip.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Knife, buildTextEntry(Translations.getText("event.fools2022.knife.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.KeySword, buildTextEntry(Translations.getText("event.fools2022.keysword.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.EmpoweredKeySword, buildTextEntry(Translations.getText("event.fools2022.keysword.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Katana, buildTextEntry(Translations.getText("event.fools2022.katana.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Treasures, buildTextEntry(Translations.getText("event.fools2022.treasures.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Buckler, buildTextEntry(Translations.getText("event.fools2022.buckler.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Glove, buildTextEntry(Translations.getText("event.fools2022.glove.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Diary, buildTextEntry(Translations.getText("event.fools2022.diary.description")));

        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Perfume, buildTextEntry(Translations.getText("event.fools2022.perfume.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Crucifix, buildTextEntry(Translations.getText("event.fools2022.crucifix.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.DjedPillar, buildTextEntry(Translations.getText("event.fools2022.djedpillar.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.IsisPendant, buildTextEntry(Translations.getText("event.fools2022.isispendant.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.BookOfTheDead, buildTextEntry(Translations.getText("event.fools2022.bookofthedead.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.SoftwareDeathv, buildTextEntry(Translations.getText("event.fools2022.deathv.description")));
        itemDescriptionBlock.setDescription(ItemDescriptionBlock.Ring, buildTextEntry(Translations.getText("event.fools2022.ring.description")));
    }

    @Override
    public void updateGrailPoints(GrailPointBlock grailPointBlock) {
        GrailPointEntry htWarp = grailPointBlock.getGrailPointEntry(grailPointBlock.getBlockContents().size());
        htWarp.setRequireMirai(true);
        htWarp.setFlag(FlagConstants.CUSTOM_FOOLS2022_HT_GRAIL);
        htWarp.setWarpImage(LocationCoordinateMapper.getImageIndex(23, true));
        htWarp.setDestination(ZoneConstants.HT_1, 0, 0, 300, 152);
    }

    @Override
    public void updateMenuData(MenuBlock menuBlock) {
        menuBlock.setMantraName(MantraConstants.BIRTH, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.BIRTH)));
        menuBlock.setMantraName(MantraConstants.DEATH, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.DEATH)));
        menuBlock.setMantraName(MantraConstants.MARDUK, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.MARDUK)));
        menuBlock.setMantraName(MantraConstants.SABBAT, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.SABBAT)));
        menuBlock.setMantraName(MantraConstants.MU, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.MU)));
        menuBlock.setMantraName(MantraConstants.VIY, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.VIY)));
        menuBlock.setMantraName(MantraConstants.BAHRUN, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.BAHRUN)));
        menuBlock.setMantraName(MantraConstants.WEDJET, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.WEDJET)));
        menuBlock.setMantraName(MantraConstants.ABUTO, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.ABUTO)));
        menuBlock.setMantraName(MantraConstants.LAMULANA, buildTextEntry(Translations.getText("event.fools2022.m" + MantraConstants.LAMULANA)));
    }

    @Override
    public void updateSoftwareData(SoftwareBlock softwareBlock) {
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareMantra, 0);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareMantra, buildTextEntry(Translations.getText("event.fools2022.software.free")));
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareBunemon, 0);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareBunemon, buildTextEntry(Translations.getText("event.fools2022.software.free")));
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareBunplus, 0);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareBunplus, buildTextEntry(Translations.getText("event.fools2022.software.free")));
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareXmailer, 0);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareXmailer, buildTextEntry(Translations.getText("event.fools2022.software.free")));
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareReader, 100);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareReader, buildTextEntry(Translations.getText("event.fools2022.software.reader")));
        softwareBlock.setSoftwareCost(SoftwareBlock.SoftwareCapstar, 2000);
        softwareBlock.setSoftwareCostText(SoftwareBlock.SoftwareCapstar, buildTextEntry(Translations.getText("event.fools2022.software.capstar")));
    }

    @Override
    public void updateEmailData(EmailBlock emailBlock) {
//        List<BlockContents> newEmails = new ArrayList<>();
//        List<Integer> mailFlagsKept = Arrays.asList(
//                FlagConstants.MAIL_00,
//                FlagConstants.MAIL_01,
//                FlagConstants.MAIL_02,
//                FlagConstants.MAIL_03,
//                FlagConstants.MAIL_04,
//                FlagConstants.MAIL_05,
//                FlagConstants.MAIL_06,
//                FlagConstants.MAIL_07,
//                FlagConstants.MAIL_08,
//                FlagConstants.MAIL_09,
//                FlagConstants.MAIL_10,
//                FlagConstants.MAIL_11,
//                FlagConstants.MAIL_12,
//                FlagConstants.MAIL_13,
//                FlagConstants.MAIL_14,
//                FlagConstants.MAIL_15,
//                FlagConstants.MAIL_16,
//                FlagConstants.MAIL_17,
//                FlagConstants.MAIL_18,
//                FlagConstants.MAIL_19,
//                FlagConstants.MAIL_20);
//        for(BlockContents oldEmail : emailBlock.getBlockContents()) {
//            EmailEntry emailEntry = (EmailEntry)oldEmail;
//            if(mailFlagsKept.contains(emailEntry.getMailFlag()) ) {
//                newEmails.add(emailEntry);
//            }
//        }
//        emailBlock.getBlockContents().clear();
//        emailBlock.getBlockContents().addAll(newEmails);
        List<Integer> mailFlagsKept = Arrays.asList(
                FlagConstants.MAIL_00,
                FlagConstants.MAIL_01,
                FlagConstants.MAIL_02,
                FlagConstants.MAIL_03,
                FlagConstants.MAIL_04,
                FlagConstants.MAIL_05,
                FlagConstants.MAIL_06,
                FlagConstants.MAIL_07,
                FlagConstants.MAIL_08,
                FlagConstants.MAIL_09,
                FlagConstants.MAIL_10,
                FlagConstants.MAIL_11,
                FlagConstants.MAIL_12,
                FlagConstants.MAIL_13,
                FlagConstants.MAIL_14,
                FlagConstants.MAIL_15,
                FlagConstants.MAIL_16,
                FlagConstants.MAIL_17,
                FlagConstants.MAIL_18,
                FlagConstants.MAIL_19,
                FlagConstants.MAIL_20);
        for(BlockContents oldEmail : emailBlock.getBlockContents()) {
            EmailEntry emailEntry = (EmailEntry)oldEmail;
            if(!mailFlagsKept.contains(emailEntry.getMailFlag()) ) {
                emailEntry.setMailFlag(FlagConstants.MAIL_44);
            }
        }
    }

    @Override
    void updateMapGraphicsBlock(MapGraphicsBlock mapGraphicsBlock) {
        for(MapGraphicsEntry mapGraphicsEntry : mapGraphicsBlock.getMapGraphics()) {
            if(mapGraphicsEntry.getIcon1() == MapGraphicsEntry.Icon_CrossOfLight) {
                mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_Blank);
            }
            if(mapGraphicsEntry.getIcon2() == MapGraphicsEntry.Icon_CrossOfLight) {
                mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_Blank);
            }
            if(mapGraphicsEntry.getBackgroundColor() == MapGraphicsEntry.BackgroundColor_Red) {
                mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_White);
            }

            if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Surface) {
                if(mapGraphicsEntry.getIcon1() == MapGraphicsEntry.Icon_BacksideDoor) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_Blank);
                }
                if(mapGraphicsEntry.getIcon2() == MapGraphicsEntry.Icon_BacksideDoor) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_Blank);
                }
                if(mapGraphicsEntry.getBackgroundColor() == MapGraphicsEntry.BackgroundColor_Green) {
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_White);
                }

                if(mapGraphicsEntry.getX() == 7 && mapGraphicsEntry.getY() == 4) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 9 && mapGraphicsEntry.getY() == 2) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_GateOfGuidance) {
                if(mapGraphicsEntry.getX() == 1 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_BacksideDoor);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 2) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Mausoleum) {
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 1) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Sun) {
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 4) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Spring) {
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 1) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 0) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Inferno) {
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 2) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 6 && mapGraphicsEntry.getY() == 4) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Extinction) {
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 9 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_TwinLabyrinths) {
                if(mapGraphicsEntry.getX() == 2 && mapGraphicsEntry.getY() == 1) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                else if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                else if(mapGraphicsEntry.getX() == 7 && mapGraphicsEntry.getY() == 1) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Endless) {
                if(mapGraphicsEntry.getX() == 1 && mapGraphicsEntry.getY() == 1) {
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 2 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 2 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_DownExit);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Shrine) {
                if(mapGraphicsEntry.getIcon1() == MapGraphicsEntry.Icon_DragonBone) {
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getIcon2() == MapGraphicsEntry.Icon_DragonBone) {
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 4) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Illusion) {
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Graveyard) {
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_BacksideDoor);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Moonlight) {
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Goddess) {
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 8) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_BlueDoor);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_White);
                }
                if(mapGraphicsEntry.getX() == 5 && mapGraphicsEntry.getY() == 0) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Ruin) {
                if(mapGraphicsEntry.getX() == 6 && mapGraphicsEntry.getY() == 4) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                }
            }
            else if((mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Birth_Swords || mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Birth_Skanda)) {
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 2) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_BacksideDoor);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 7 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
            }
            else if(mapGraphicsBlock.getBlockNumber() == BlockConstants.MapGraphics_Dimensional) {
                if(mapGraphicsEntry.getX() == 1 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 1 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 3) {
                    mapGraphicsEntry.setIcon1(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_CrossOfLight);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Red);
                }
                if(mapGraphicsEntry.getX() == 3 && mapGraphicsEntry.getY() == 5) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
                if(mapGraphicsEntry.getX() == 4 && mapGraphicsEntry.getY() == 6) {
                    mapGraphicsEntry.setIcon2(MapGraphicsEntry.Icon_FairyPoint);
                    mapGraphicsEntry.setBackgroundColor(MapGraphicsEntry.BackgroundColor_Blue);
                }
            }
        }
    }

    @Override
    public void updateFootOfFutoScannableBlock(ScannableBlock scannableBlock) {
        String hintText = String.format(Translations.getText("hintText.giants"), Settings.getCurrentGiant(), Settings.getCurrentGiant());
        scannableBlock.setScanText(buildTextEntry(hintText));
    }

    @Override
    void updateTowerOfTheGoddessSnapshotsScanBlock(Block snapshotsScanBlock) {
        List<BlockContents> blockContents = snapshotsScanBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.snapshotsRemoved"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateTowerOfRuinSnapshotsScanBlock(Block snapshotsScanBlock) {
        List<BlockContents> blockContents = snapshotsScanBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.snapshotsRemoved"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateXmailerConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudIntro1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudIntro2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudIntro3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudIntro4"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudIntro5"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.XELPUD_CONVERSATION_INTRO, 1));
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
    }

    @Override
    void updateXelpudHeldItemPepperBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudCurry1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudCurry2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudCurry3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, 7));
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
    }

    @Override
    void updateXelpudMSX2ConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudPepper1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudPepper2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudPepper3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudPepper4"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.XELPUD_CONVERSATION_MSX2, 2));
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
    }

//    @Override
//    void updateBookOfTheDeadConversationBlock(Block conversationBlock) {
//        replaceText(conversationBlock.getBlockContents(), Translations.getText("items.BookoftheDead"), Translations.getText("event.fools2022.diary.name"));
//        replaceText(conversationBlock.getBlockContents(), Translations.getText("items.BookoftheDead"), Translations.getText("event.fools2022.diary.name"));
//    }
//
//    @Override
//    void updateBookOfTheDeadRepeatConversationBlock(Block conversationBlock) {
//        replaceText(conversationBlock.getBlockContents(), Translations.getText("items.BookoftheDead"), Translations.getText("event.fools2022.diary.name"));
//        replaceText(conversationBlock.getBlockContents(), Translations.getText("items.BookoftheDead"), Translations.getText("event.fools2022.diary.name"));
//    }

    @Override
    void updateProvocativeBathingSuitConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.DracuetSwimsuit"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
    }

    @Override
    void updateMulbrukHTConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukHT1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukHTRepeatPrompt"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        blockContents.add(new BlockCmdSingle(BlockConstants.MulbrukHTConversationBlock));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukHTRepeatYes"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukHTRepeatNo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukHTFinished"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateMulbrukFatherLocationConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukFather"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukFatherRepeatPrompt"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        blockContents.add(new BlockCmdSingle(BlockConstants.MulbrukFatherLocationConversationBlock));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukFatherRepeatYes"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukFatherRepeatNo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukFatherFinished"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateMulbrukSwimsuitReactionConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukGun"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateHinerConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Hiner"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateMogerConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Moger"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestZarnacConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Zarnac"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestXanadoConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Xanado"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestHidlydaConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Hidlyda"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestMadomonoConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Madomono"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestGailiousConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Gailious1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Gailious2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Gailious3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestRomancisConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Romancis"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestAramoConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Aramo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestTritonConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Triton"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestJaguarfivConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Jaguarfiv"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestLaydocConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Laydoc"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePriestAshgineConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Ashgine"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateGiantThexdeConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Thexde"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void update8BitElderConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.8BitElder"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updateNightSurfaceXelpudConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudMother"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePhilosopherGiltoriyoConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Giltoriyo1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Giltoriyo2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Giltoriyo3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Giltoriyo4"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Giltoriyo5"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.GiltoriyoRepeatPrompt"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        blockContents.add(new BlockCmdSingle(BlockConstants.NpcConversation_PhilosopherGiltoriyo));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.GiltoriyoRepeatYes"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.GiltoriyoRepeatNo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.GiltoriyoFinished"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
//        // For some reason there are some trailing end-of-entry indicators here, so we'll keep them
//        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
//        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
    }

    @Override
    void updatePhilosopherAlsedanaConversationBlock(Block conversationBlock) {
        // No change
    }

    @Override
    void updatePhilosopherSamarantaConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Samaranta1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Samaranta2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Samaranta3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.SamarantaRepeatPrompt"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        blockContents.add(new BlockCmdSingle(BlockConstants.NpcConversation_PhilosopherSamaranta));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.SamarantaRepeatYes"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.SamarantaRepeatNo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.SamarantaFinished"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    void updatePhilosopherFobosLadderConversationBlock(Block conversationBlock) {
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.clear();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadder1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadder2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadder3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadder4"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadderRepeatPrompt"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        blockContents.add(new BlockCmdSingle(BlockConstants.NpcConversation_PhilosopherFobos_Ladder));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadderRepeatYes"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadderRepeatNo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FobosLadderFinished"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
    }

    @Override
    public void updateXelpudHeldItemCheckBlock(CheckBlock heldItemCheckBlock) {
        Integer cmdToRemoveIndex = null;
        for(int i = 0; i < heldItemCheckBlock.getFlagCheckReferences().size(); i++) {
            BlockListData blockListData = heldItemCheckBlock.getFlagCheckReferences().get(i);
            if(blockListData.getData().get(2) == BlockConstants.XelpudHeldItemConversation_SerpentStaff) {
                cmdToRemoveIndex = i;
            }
        }
        if(cmdToRemoveIndex != null) {
            heldItemCheckBlock.getFlagCheckReferences().remove((int)cmdToRemoveIndex);
        }
    }

    @Override
    public void updateXelpudFlagCheckBlock(CheckBlock flagCheckBlock) {
        BlockListData blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.CUSTOM_FOOLS2022_XELPUD_MUSIC_1);
        blockListData.getData().add((short)1);
        blockListData.getData().add(getCustomBlockIndex(CustomBlockEnum.Fools2022_Xelpud_Music));
        blockListData.getData().add((short)0);
        flagCheckBlock.getFlagCheckReferences().add(0, blockListData);
    }

    public void updateMulbrukFlagCheckBlock(CheckBlock flagCheckBlock) {
        flagCheckBlock.getFlagCheckReferences().clear();

        BlockListData blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.MULBRUK_CONVERSATION_BOOK);
        blockListData.getData().add((short)1);
        blockListData.getData().add((short)BlockConstants.ItemConversationBookOfTheDead);
        blockListData.getData().add((short)1);
        flagCheckBlock.getFlagCheckReferences().add(blockListData);

        blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.HT_UNLOCK_PROGRESS_EARLY);
        blockListData.getData().add((short)1);
        blockListData.getData().add((short)BlockConstants.MulbrukHTConversationBlock);
        blockListData.getData().add((short)1);
        flagCheckBlock.getFlagCheckReferences().add(blockListData);

        blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.HT_UNLOCK_PROGRESS_EARLY);
        blockListData.getData().add((short)2);
        blockListData.getData().add((short)BlockConstants.MulbrukFatherLocationConversationBlock);
        blockListData.getData().add((short)1);
        flagCheckBlock.getFlagCheckReferences().add(blockListData);

        blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.CUSTOM_FOOLS2022_MULBRUK_PACIFIST_HINT);
        blockListData.getData().add((short)1);
        blockListData.getData().add(getCustomBlockIndex(CustomBlockEnum.Fools2022_Mulbruk_PacifistHint));
        blockListData.getData().add((short)0);
        flagCheckBlock.getFlagCheckReferences().add(blockListData);

        blockListData = new BlockListData((short)4);
        blockListData.getData().add((short)FlagConstants.CUSTOM_FOOLS2022_MULBRUK_ARMOR);
        blockListData.getData().add((short)1);
        blockListData.getData().add(getCustomBlockIndex(CustomBlockEnum.Fools2022_Mulbruk_Armor));
        blockListData.getData().add((short)0);
        flagCheckBlock.getFlagCheckReferences().add(blockListData);
    }

    @Override
    void updateLaptopScannableBlock(Block scannableBlock) {
        List<BlockContents> blockContents = scannableBlock.getBlockContents();
        blockContents.clear();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Laptop"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        BlockListData tabletLanguageSlate = new BlockListData((short)2);
        tabletLanguageSlate.getData().add((short)0);
        tabletLanguageSlate.getData().add((short)0);
        blockContents.add(tabletLanguageSlate);
    }

    @Override
    public void addCustomBlocks(DatFileData datFileData) {
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_DanceDetection, buildExtinctionDanceBlock());

        ShopBlock yiegahAlt = new ShopBlock(datFileData.getYiegahKungfuShopBlock());
        updateShopBlock(yiegahAlt, buildYiegahShopInventory());
        yiegahAlt.setBunemonIntroText(new BlockStringData(Translations.getText("event.fools2022.medicineIntro")));
        yiegahAlt.setString(new BlockStringData(Translations.getText("event.fools2022.medicineIntro")), 2);
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Yiegah_Alt, yiegahAlt);

        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_MulbrukWaking_ConversationBlock, buildMulbrukWakingConversationBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Mulbruk_Armor, buildMulbrukArmorConversationBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Mulbruk_PacifistHint, buildMulbrukPacifistHintConversationBlock());
//        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Mulbruk_Mother, buildMulbrukMotherConversationBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_NaramuraPacifism, buildNaramuraPacifismConversationBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_NaramuraPacifismMaster, buildNaramuraPacifismReferenceBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_NaramuraPacifism)));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_PreEscape, buildPreEscapeReferenceBlock((short)BlockConstants.EmptyConversation));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_MulbrukSleeping_FlagBlock,
                buildMulbrukSleepingFlagBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_MulbrukWaking_ConversationBlock)));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_MulbrukSleeping_HeldItemBlock, buildMulbrukSleepingHeldItemBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_MulbrukSleeping_ScoreBlock, buildMulbrukSleepingScoreBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_MulbrukSleeping_RandomBlock, buildMulbrukSleepingRandomBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_MulbrukSleeping_ReferenceBlock,
                buildMulbrukSleepingReferenceBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_MulbrukSleeping_FlagBlock),
                        getCustomBlockIndex(CustomBlockEnum.Fools2022_MulbrukSleeping_HeldItemBlock),
                        getCustomBlockIndex(CustomBlockEnum.Fools2022_MulbrukSleeping_ScoreBlock),
                        getCustomBlockIndex(CustomBlockEnum.Fools2022_MulbrukSleeping_RandomBlock)));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught, buildTabletBlock("event.fools2022.toilsForNaught", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_HolyBlessingColorized, buildTabletBlock("event.fools2022.holyBlessing", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_HT_Shortcut1, buildTabletBlock("event.fools2022.htShortcut1", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_HT_Shortcut2, buildTabletBlock("event.fools2022.htShortcut2", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_HT_Shortcut3, buildTabletBlock("event.fools2022.htShortcut3", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_Pacifist_SplitGate, buildTabletBlock("event.fools2022.SplitGate", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_Pacifist_Hint, buildTabletBlock("event.fools2022.PacifistHint", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_Babel, buildTabletBlock("event.fools2022.TowerOfBabel", false));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_GraveyardSnapshotsScan, buildSnapshotsScanBlock("event.fools2022.snapshotsGraveyard"));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_GraveyardSnapshotsScanFail, buildSnapshotsScanBlock("event.fools2022.snapshotsGraveyardFail"));
//        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_FairyQueenSlap_ConversationBlock, buildFairyQueenSlapConversationBlock());
//        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_FairyQueenSlap_ReferenceBlock,
//                buildFairyQueenSlapReferenceBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_FairyQueenSlap_ConversationBlock)));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_XelpudNight_ConversationBlock, buildXelpudNightConversationBlock());
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_XelpudNight_ReferenceBlock, buildXelpudNightReferenceBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_XelpudNight_ConversationBlock)));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Tablet_DimensionalExit_Alt, buildTabletBlock("Tablet_Birth_ClayDollsBecomeHuman.AltText", true));
        datFileData.addCustomBlock(CustomBlockEnum.Fools2022_Xelpud_Music, buildXelpudMusicConversationBlock());
    }

    private static Block buildSnapshotsScanBlock(String textKeyPrefix) {
        Block snapshotsScanBlock = new Block();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText(textKeyPrefix + "1"))) {
            snapshotsScanBlock.getBlockContents().add(new BlockSingleData(rawDataEntry));
        }
        snapshotsScanBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText(textKeyPrefix + "2"))) {
            snapshotsScanBlock.getBlockContents().add(new BlockSingleData(rawDataEntry));
        }
        return snapshotsScanBlock;
    }

    private static Block buildExtinctionDanceBlock() {
        Block danceBlock = new Block();
        BlockListData danceMove = new BlockListData((short)1);
        danceMove.getData().add((short)1); // Jump
        danceBlock.getBlockContents().add(danceMove);

        return danceBlock;
    }

    private static Block buildTabletBlock(String tabletTextKey, boolean laMulanese) {
        Block tabletBlock = new Block();
        List<BlockContents> blockContents = tabletBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText(tabletTextKey))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        BlockListData tabletLanguageSlate = new BlockListData((short)2);
        tabletLanguageSlate.getData().add((short)(laMulanese ? 1 : 2));
        tabletLanguageSlate.getData().add((short)0);
        tabletBlock.getBlockContents().add(tabletLanguageSlate);
        return tabletBlock;
    }

    private static Block buildMulbrukWakingConversationBlock() {
        Block conversationBlock = new Block();

        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukWake1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukWake2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukWake3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.MULBRUK_DOOR_UNSEALED, 2));
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));

        return conversationBlock;
    }

    private static Block buildXelpudMusicConversationBlock() {
        Block conversationBlock = new Block();

        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudMusic1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.Cls));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudMusic2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.CUSTOM_FOOLS2022_XELPUD_MUSIC_1, 2));

        return conversationBlock;
    }

    private static Block buildMulbrukArmorConversationBlock() {
        Block conversationBlock = new Block();
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukArmor"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        return conversationBlock;
    }

    private static Block buildMulbrukPacifistHintConversationBlock() {
        Block conversationBlock = new Block();
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukPacifistHint"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        return conversationBlock;
    }

//    private static Block buildMulbrukMotherConversationBlock() {
//        Block conversationBlock = new Block();
//        List<BlockContents> blockContents = conversationBlock.getBlockContents();
//        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.MulbrukMother"))) {
//            blockContents.add(new BlockSingleData(rawDataEntry));
//        }
//        return conversationBlock;
//    }

    private static Block buildXelpudNightConversationBlock() {
        Block conversationBlock = new Block();
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.XelpudNight"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        return conversationBlock;
    }

    private static Block buildXelpudNightReferenceBlock(Short conversationBlock) {
        return new MasterNpcBlock(conversationBlock, ValueConstants.NPC_BACKGROUND_TENT_CONVERSATION,
                ValueConstants.NPC_SPRITE_NIGHT_XELPUD, ValueConstants.NPC_MUSIC_NIGHT_XELPUD,
                new BlockStringData(Translations.getLocationAndNpc("ElderXelpud")));
    }

    private static Block buildNaramuraPacifismConversationBlock() {
        Block conversationBlock = new Block();
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.NaramuraPacifism"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        return conversationBlock;
    }

    private static Block buildNaramuraPacifismReferenceBlock(Short conversationBlock) {
        return new MasterNpcBlock(conversationBlock, 0x0007,
                0x02ea, 0x0017,
                new BlockStringData(Translations.getLocationAndNpc("Naramura")));
    }

    private static Block buildPreEscapeReferenceBlock(Short conversationBlock) {
        return new MasterNpcBlock(conversationBlock, ValueConstants.NPC_BACKGROUND_GODDESS,
                ValueConstants.NPC_SPRITE_DISABLE_SPEECH, ValueConstants.NPC_MUSIC_GODDESS,
                new BlockStringData(Translations.getText("event.fools2022.Urtharbrunnr")));
    }

    private static Block buildFairyQueenSlapConversationBlock() {
        Block conversationBlock = new Block();
        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.FairyQueenSlap"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        return conversationBlock;
    }

    private static Block buildMulbrukSleepingFlagBlock(Short mulbrukAwakeConversation) {
        Block flagBlock = new Block();

        BlockListData blockListData = new BlockListData(BlockDataConstants.FlagBlockListSize);
        blockListData.getData().add((short)FlagConstants.MULBRUK_DOOR_UNSEALED);
        blockListData.getData().add((short)1);
        blockListData.getData().add(mulbrukAwakeConversation);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        flagBlock.getBlockContents().add(blockListData);

        return flagBlock;
    }

    private static Block buildMulbrukSleepingHeldItemBlock() {
        Block heldItemBlock = new Block();

        BlockListData blockListData = new BlockListData(BlockDataConstants.HeldItemBlockListSize);
        blockListData.getData().add((short)ItemConstants.MEDICINE_OF_THE_MIND_RED);
        blockListData.getData().add((short)FlagConstants.RANDOMIZER_SAVE_LOADED);
        blockListData.getData().add(BlockConstants.MulbrukRandom_DontWake);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        heldItemBlock.getBlockContents().add(blockListData);

        return heldItemBlock;
    }

    private static Block buildMulbrukSleepingScoreBlock() {
        Block scoreBlock = new Block();

        BlockListData blockListData = new BlockListData(BlockDataConstants.ScoreBlockListSize);
        blockListData.getData().add((short)0); // minScore
        blockListData.getData().add((short)1); // maxScore
        blockListData.getData().add(BlockConstants.MulbrukRandom_DontWake);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        scoreBlock.getBlockContents().add(blockListData);

        return scoreBlock;
    }

    private static Block buildMulbrukSleepingRandomBlock() {
        Block randomBlock = new Block();

        BlockListData blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_DontWake);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_DontWake);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Sleep100MoreYears);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Sleep100MoreYears);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Snort);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Dream_PutAStoneOnTopOfMulbruk);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Dream_Hamburger);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Dream_IgnorantFool);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Dream_HappyHaha);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Dream_Continue);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        randomBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData(BlockDataConstants.RandomBlockListSize);
        blockListData.getData().add(BlockConstants.MulbrukRandom_Dream_BowBeforeMulbruk);
        blockListData.getData().add(BlockDataConstants.BlockNoPrompt);
        randomBlock.getBlockContents().add(blockListData);
        return randomBlock;
    }

    private static Block buildMulbrukSleepingReferenceBlock(Short flagBlock, Short heldItemBlock, Short scoreBlock, Short randomBlock) {
        Block referenceBlock = new Block();

        BlockListData blockListData = new BlockListData(BlockDataConstants.ConversationTreeReferenceBlocksListSize);
        blockListData.getData().add(flagBlock);
        blockListData.getData().add(heldItemBlock);
        blockListData.getData().add(scoreBlock);
        blockListData.getData().add(randomBlock);
        referenceBlock.getBlockContents().add(blockListData);
        referenceBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData((short)1);
        blockListData.getData().add(ValueConstants.NPC_BACKGROUND_SUN);
        referenceBlock.getBlockContents().add(blockListData);
        referenceBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData((short)1);
        blockListData.getData().add(ValueConstants.NPC_SPRITE_MULBRUK);
        referenceBlock.getBlockContents().add(blockListData);
        referenceBlock.getBlockContents().add(new BlockSingleData(BlockDataConstants.EndOfEntry));

        blockListData = new BlockListData((short)1);
        blockListData.getData().add(ValueConstants.NPC_MUSIC_MULBRUK);
        referenceBlock.getBlockContents().add(blockListData);

        return referenceBlock;
    }

    private static Block buildFairyQueenSlapReferenceBlock(Short conversationBlock) {
        return new MasterNpcBlock(conversationBlock, ValueConstants.NPC_BACKGROUND_SUN,
                ValueConstants.NPC_SPRITE_FAIRY_QUEEN, ValueConstants.NPC_MUSIC_FAIRY_QUEEN,
                new BlockStringData(Translations.getLocationAndNpc("TheFairyQueen")));
    }

    private static Block buildSamarantaPacifismConversationBlock() {
        Block conversationBlock = new Block();

        List<BlockContents> blockContents = conversationBlock.getBlockContents();
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 1));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Alsedana1"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Alsedana2"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Alsedana3"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Alsedana4"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.Alsedana5"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockFlagData(FlagConstants.CONVERSATION_CANT_LEAVE, 0));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.AlsedanaRepeatPrompt"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        blockContents.add(new BlockCmdSingle(BlockConstants.NpcConversation_PhilosopherAlsedana));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.AlsedanaRepeatYes"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.AlsedanaRepeatNo"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        blockContents.add(new BlockSingleData(BlockDataConstants.EndOfEntry));
        for(Short rawDataEntry : buildRawDataWithCommands(Translations.getText("event.fools2022.AlsedanaFinished"))) {
            blockContents.add(new BlockSingleData(rawDataEntry));
        }
        return conversationBlock;
    }

    private static ShopInventory buildYiegahShopInventory() {
        String npcName = "Yiegah Kungfu";
        ShopInventory shopInventory = new ShopInventory("Shop 18 (Lil Bro)", npcName, "Yiegah Kungfu");

        String shopItem = "Medicine of the Mind (Yellow)";
        ShopInventoryData shopInventoryData = new ShopInventoryData();
        shopInventoryData.setInventoryArg(ShopInventoryData.getInventoryArg(shopItem));
        shopInventoryData.setWorldFlag(ShopInventoryData.getWorldFlag(shopItem));
        shopInventoryData.setItemPriceCount(new ItemPriceCount(1, 1));
        shopInventory.setItem(1, shopInventoryData);

        shopItem = "Medicine of the Mind (Yellow)";
        shopInventoryData = new ShopInventoryData();
        shopInventoryData.setInventoryArg(ShopInventoryData.getInventoryArg(shopItem));
        shopInventoryData.setWorldFlag(ShopInventoryData.getWorldFlag(shopItem));
        shopInventoryData.setItemPriceCount(new ItemPriceCount(0, 0));
        shopInventory.setItem(2, shopInventoryData);

        shopItem = "Medicine of the Mind (Yellow)";
        shopInventoryData = new ShopInventoryData();
        shopInventoryData.setInventoryArg(ShopInventoryData.getInventoryArg(shopItem));
        shopInventoryData.setWorldFlag(ShopInventoryData.getWorldFlag(shopItem));
        shopInventoryData.setItemPriceCount(new ItemPriceCount(0, 0));
        shopInventory.setItem(3, shopInventoryData);

        return shopInventory;
    }
}
