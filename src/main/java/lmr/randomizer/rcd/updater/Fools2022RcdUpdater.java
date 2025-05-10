package lmr.randomizer.rcd.updater;

import lmr.randomizer.HolidaySettings;
import lmr.randomizer.Settings;
import lmr.randomizer.dat.DatFileData;
import lmr.randomizer.graphics.GraphicsFileData;
import lmr.randomizer.graphics.GraphicsFileEntry;
import lmr.randomizer.randomization.data.CustomBlockEnum;
import lmr.randomizer.rcd.RcdFileData;
import lmr.randomizer.rcd.object.*;
import lmr.randomizer.update.AddObject;
import lmr.randomizer.update.AddToAllScreens;
import lmr.randomizer.update.GraphicsTextureDrawUpdates;
import lmr.randomizer.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fools2022RcdUpdater extends RcdUpdater {
    private static final int SPAULDER_HOLY_NOTHING = MantraConstants.BIRTH; // SPAULDER
    private static final int ORIGIN_REALITY = MantraConstants.DEATH; // REAL SPUD
    private static final int BIRTH_SLAP = MantraConstants.MARDUK; // RUDE SLAP
    private static final int LIFE_QUAKE = MantraConstants.SABBAT; // RAD PULSE
    private static final int DEATH = MantraConstants.MU; // UR LAPSED
    private static final int REBIRTH_WATER = MantraConstants.VIY; // LURED SPA
    private static final int WAR_RAP = MantraConstants.BAHRUN; // RAP DUELS
    private static final int DECEIT = MantraConstants.WEDJET; // RUSED PAL
    private static final int ETERNITY_FIRE = MantraConstants.ABUTO; // PULSARED
    private static final int ASCENSION = MantraConstants.LAMULANA; // LASER'D UP

    private static final int ROLLING_SHURIKEN_ITEM_ARG = ItemConstants.SOFTWARE_DEATHV;
    private static final int ROLLING_SHURIKEN_ITEM_FLAG = FlagConstants.WF_SOFTWARE_DEATHV;

    private static final int TREASURE_OF_THE_FOOL_ITEM = ItemConstants.TREASURES;
    private static final int TREASURE_OF_THE_FOOL_FLAG = FlagConstants.WF_TREASURES;

    private static final int STATUE_OF_THE_GIANT_ITEM = ItemConstants.CRUCIFIX;
    private static final int STATUE_OF_THE_GIANT_FLAG = FlagConstants.WF_CRUCIFIX;

    private static final int SNAPSHOTS_OANNES_ITEM = ItemConstants.SOFTWARE_BOUNCE;
    private static final int SNAPSHOTS_OANNES_FLAG = FlagConstants.WF_SOFTWARE_BOUNCE;

    private static final int SNAPSHOTS_INVOCATION_ITEM = ItemConstants.SOFTWARE_LAMULANA;
    private static final int SNAPSHOTS_INVOCATION_FLAG = FlagConstants.WF_SOFTWARE_LAMULANA;

    private static final int SNAPSHOTS_LIGHT_ITEM = ItemConstants.BOOK_OF_THE_DEAD;
    private static final int SNAPSHOTS_LIGHT_FLAG = FlagConstants.WF_BOOK_OF_THE_DEAD;

    private static final int ISIS_PENDANT_ZONE = ZoneConstants.GUIDANCE;
    private static final int ISIS_PENDANT_ROOM = 3;
    private static final int ISIS_PENDANT_SCREEN = 0;

    private static final int EMUSIC_ZONE = ZoneConstants.TWIN_FRONT;
    private static final int EMUSIC_ROOM = 14;
    private static final int EMUSIC_SCREEN = 0;

    private static final int BEOLAMU_ZONE = ZoneConstants.EXTINCTION;
    private static final int BEOLAMU_ROOM = 6;
    private static final int BEOLAMU_SCREEN = 0;

    private static final int MIRACLE_ZONE = ZoneConstants.SUN;
    private static final int MIRACLE_ROOM = 0;
    private static final int MIRACLE_SCREEN = 1;

    private static final int BOUNCE_ZONE = ZoneConstants.SPRING;
    private static final int BOUNCE_ROOM = 0;
    private static final int BOUNCE_SCREEN = 1;

    private static final short BACKBEARD_HEALTH = 30;
    private static final short TAI_SUI_HEALTH = 10;

    private static final int COINS_PER_CHEST = 2;

//    private static final int MAIL_DELAY_FRAMES = 1;
    private static final int MAIL_DELAY_FRAMES = 3;

    private static final int TIAMAT_HEALTH = 160; // 300
    private static final int TIAMAT_PHASE_1_HEALTH = 80; // 40
    private static final int TIAMAT_PHASE_2_HEALTH = 50; // 160

    private static final int BAPHOMET_HEALTH = 160; // 200
    private static final int BAPHOMET_PHASE_1_HEALTH = 120; // 120

    private static final int TOTAL_MANTRAS = 8;
    private static final int MAX_ARMOR = 7;

    private static final int MOTHER_PHASE_1_HEALTH = 5; // 240
    private static final int MOTHER_PHASE_2_HEALTH = 28; // 32
    private static final int MOTHER_PHASE_3_HEALTH = 24; // 48
    private static final int MOTHER_PHASE_4_HEALTH = 40; // 40
    private static final int MOTHER_PHASE_5_SUBPHASE_HEALTH = 5; // 15, tried 20

    public Fools2022RcdUpdater(RcdFileData rcdFileData, DatFileData datFileData) {
        super(rcdFileData, datFileData);
    }

    @Override
    boolean updatePot(Pot pot) {
        if(DropType.canDropCoinsOrAmmo(pot.getDropType())) {
            pot.setFlagByte(-1);
            pot.setDrops(DropType.WEIGHTS, 1);
        }
        ObjectContainer objectContainer = pot.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.GUIDANCE && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            pot.setX(140);
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 6 && screen.getScreenIndex() == 1) {
            if(pot.hasTest(new TestByteOperation(FlagConstants.SUN_USAS_VI_SHOP_POT_BROKEN, ByteOp.FLAG_EQUALS, 0))) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ENDLESS && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 2) {
            if(pot.getY() > 240) {
                pot.setX(pot.getX() + 80);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.MOONLIGHT) {
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                return false;
            }
            if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ENDLESS && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE && screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.HT_1 && screen.getRoomIndex() == 21 && screen.getScreenIndex() == 0) {
            if(pot.getY() == 400) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateBat(Bat bat) {
        ObjectContainer objectContainer = bat.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 0) {
                if(bat.getX() == 60) {
                    bat.setDamage(ValueConstants.INSTAKILL_WITH_FAIRY_CLOTHES);
                }
            }
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 3) {
                bat.removeUpdate(new WriteByteOperation(FlagConstants.ROOM_FLAG_3B, ByteOp.ADD_FLAG, 1));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 3) {
            bat.removeUpdate(new WriteByteOperation(FlagConstants.ROOM_FLAG_3B, ByteOp.ADD_FLAG, 1));
        }
        if (bat.hasUpdate(new WriteByteOperation(FlagConstants.GUIDANCE_BATS_KILLED_COUNT, ByteOp.ADD_FLAG, 1))) {
            bat.addTests(new TestByteOperation(FlagConstants.GUIDANCE_BATS_KILLED_COUNT, ByteOp.FLAG_LT, 100));
        }
        return true;
    }

    @Override
    boolean updateSkeleton(Skeleton skeleton) {
        ObjectContainer objectContainer = skeleton.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.MOONLIGHT && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateSnouter(GameObject snouter) {
        ObjectContainer objectContainer = snouter.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.GUIDANCE && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateDais(GameObject dais) {
        ObjectContainer objectContainer = dais.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.GUIDANCE && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            for(TestByteOperation testByteOperation : dais.getTestByteOperations()) {
                if(testByteOperation.getIndex() == FlagConstants.GUIDANCE_PUZZLE_MAP_CHEST) {
                    return false;
                }
            }
        }
        updateDaisForGiantsPuzzle(dais, screen);
        if (screen.getZoneIndex() == ZoneConstants.INFERNO && screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.SHRINE_FRONT && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 0) {
            dais.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.FLAG_LTEQ, 1))
                    .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.ASSIGN_FLAG, 2),
                            new WriteByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.ASSIGN_FLAG, 1));
        }
        if (screen.getZoneIndex() == ZoneConstants.MOONLIGHT && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 3) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SKANDA && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            for(TestByteOperation testByteOperation : dais.getTestByteOperations()) {
                if(testByteOperation.getIndex() == FlagConstants.BIRTH_MOVING_PLATFORM_NEAR_SKANDA) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updateDaisForGiantsPuzzle(GameObject dais, Screen screen) {
        if(screen.getZoneIndex() == 2) {
            // Adjust dais for "foot of Futo" puzzle. Zebu handled separately.
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                if(dais.getX() == 140) {
                    if("Migela".equals(Settings.getCurrentGiant())) {
                        dais.getTestByteOperations().clear();
                        dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));

                        dais.getWriteByteOperations().clear();
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                    }
                    else {
                        dais.getArgs().set(1, (short)10); // Falling speed
                    }
                }
                else {
                    // Futo
                    dais.getArgs().set(1, (short)10); // Falling speed

                    dais.getTestByteOperations().clear();
                    dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.SCREEN_FLAG_8, ByteOp.FLAG_EQUALS, 0));

                    dais.getWriteByteOperations().clear();
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_8, ByteOp.ASSIGN_FLAG, 1));
                }
            }
            else if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
                if("Bado".equals(Settings.getCurrentGiant())) {
                    dais.getTestByteOperations().clear();
                    dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));

                    dais.getWriteByteOperations().clear();
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                }
                else {
                    dais.getArgs().set(1, (short)10); // Falling speed
                }
            }
            else if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 2) {
                if(dais.getY() == 340) {
                    // Make sure not to get the Sakit ankh unlock dais
                    if("Ledo".equals(Settings.getCurrentGiant())) {
                        dais.getTestByteOperations().clear();
                        dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));

                        dais.getWriteByteOperations().clear();
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                    }
                    else {
                        dais.getArgs().set(1, (short)10); // Falling speed
                    }
                }
            }
            else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
                if("Abuto".equals(Settings.getCurrentGiant())) {
                    dais.getTestByteOperations().clear();
                    dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));

                    dais.getWriteByteOperations().clear();
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                }
                else {
                    dais.getArgs().set(1, (short)10); // Falling speed
                }
            }
            else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
                if(dais.getX() == 760) {
                    if("Sakit".equals(Settings.getCurrentGiant())) {
                        dais.getTestByteOperations().clear();
                        dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));
                        dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.SAKIT_ANKH_PUZZLE, ByteOp.FLAG_NOT_EQUAL, 1));

                        dais.getWriteByteOperations().clear();
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                    }
                    else {
                        dais.getArgs().set(1, (short)10); // Falling speed
                    }
                }
                else { //if(obj.getX() == 1140) {
                    if("Ji".equals(Settings.getCurrentGiant())) {
                        dais.getTestByteOperations().clear();
                        dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));
                        dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.SAKIT_ANKH_PUZZLE, ByteOp.FLAG_NOT_EQUAL, 1));

                        dais.getWriteByteOperations().clear();
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                        dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                    }
                    else {
                        dais.getArgs().set(1, (short)10); // Falling speed
                    }
                }
            }
            else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 2) {
                if("Ribu".equals(Settings.getCurrentGiant())) {
                    dais.getTestByteOperations().clear();
                    dais.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));

                    dais.getWriteByteOperations().clear();
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
                    dais.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                }
                else {
                    dais.getArgs().set(1, (short)10); // Falling speed
                }
            }
        }
    }

    @Override
    boolean updateFlagTimer(GameObject flagTimer) {
        ObjectContainer objectContainer = flagTimer.getObjectContainer();
        if(objectContainer instanceof Zone) {
            for(WriteByteOperation flagUpdate : flagTimer.getWriteByteOperations()) {
                if(flagUpdate.getIndex() == FlagConstants.EXTINCTION_TEMP_LIGHT) {
                    return false;
                }
            }
        }
        if(objectContainer instanceof Screen) {
            Screen screen = (Screen)objectContainer;
            if ((screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE)
                && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
                return false;
            }
            if (screen.getZoneIndex() == ZoneConstants.GUIDANCE) {
                if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.AMPHISBAENA_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.MAUSOLEUM) {
                if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SAKIT_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.SUN) {
                if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.ASSIGN_FLAG, 0))) {
                        return false;
                    }
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.ASSIGN_FLAG, 5))) {
                        return false;
                    }
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
                if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 2) {
                    if(flagTimer.hasTest(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_EQUALS, 2))) {
                        return false;
                    }
                    if(flagTimer.hasTest(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_EQUALS, 3))) {
                        return false;
                    }
                    if(flagTimer.hasTest(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_EQUALS, 4))) {
                        return false;
                    }
                }
                if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SUN_GEYSER, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.ASSIGN_FLAG, 5))) {
                        return false;
                    }
                }
                if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.SPRING && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
                return false;
            }
            if (screen.getZoneIndex() == ZoneConstants.INFERNO) {
                if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
                    flagTimer.removeUpdate(new WriteByteOperation(FlagConstants.MANTRA_VIY, ByteOp.ASSIGN_FLAG, 2));
                }
                if(screen.getRoomIndex() == 9) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 0))) {
                        return false;
                    }
                    if(screen.getScreenIndex() == 0) {
                        if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.BAPHOMET_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                            return false;
                        }
                    }
                }
            }
//            if (screen.getZoneIndex() == ZoneConstants.EXTINCTION) {
//                if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 1) {
//                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.EXTINCTION_BACKUP_JEWEL, ByteOp.ASSIGN_FLAG, 1))) {
//                        flagTimer.getTestByteOperations().clear();
//                        flagTimer.addTests(new TestByteOperation(FlagConstants.PALENQUE_STATE, ByteOp.FLAG_EQUALS, 2),
//                                new TestByteOperation(FlagConstants.EXTINCTION_BACKUP_JEWEL, ByteOp.FLAG_EQUALS, 0),
//                                new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_LTEQ, 3),
//                                new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_LTEQ, 3));
//                    }
//                }
//            }
            if (screen.getZoneIndex() == ZoneConstants.ILLUSION) {
                if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.AMPHISBAENA_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.GRAVEYARD) {
                if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.SAKIT_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.MOONLIGHT) {
                if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.MOONLIGHT_ANUBIS_FLOOR_STATE, ByteOp.ASSIGN_FLAG, 0))) {
                        return false;
                    }
                }
                if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 2) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
                if(screen.getRoomIndex() == 10 && screen.getScreenIndex() == 0) {
                    if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1))) {
                        return false;
                    }
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                    return false;
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.RUIN && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                return false;
            }
            if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1))) {
                    return false;
                }
            }
            if (screen.getZoneIndex() == ZoneConstants.HT_1 && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateMovingPlatform(GameObject movingPlatform) {
        ObjectContainer objectContainer = movingPlatform.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT && screen.getRoomIndex() == 14 && screen.getScreenIndex() == 0) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateCycleTimer(GameObject cycleTimer) {
        ObjectContainer objectContainer = cycleTimer.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.INFERNO && screen.getRoomIndex() == 9) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateRoomSpawner(GameObject roomSpawner) {
        ObjectContainer objectContainer = roomSpawner.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE) {
            if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.SURFACE_MEKURI_WALL, ByteOp.FLAG_EQUALS, 0))) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SPRING) {
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.SPRING_FLOODED, ByteOp.FLAG_EQUALS, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                    roomSpawner.addTests(new TestByteOperation(FlagConstants.SPRING_BAHAMUT_ROOM_FLOODED, ByteOp.FLAG_EQUALS, 1));
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
                if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.SPRING_FLOODED, ByteOp.FLAG_EQUALS, 1))
                        && roomSpawner.getArgs().get(0) == 14) {
                    roomSpawner.getTestByteOperations().clear();
                    roomSpawner.addTests(new TestByteOperation(FlagConstants.SPRING_BAHAMUT_ROOM_FLOODED, ByteOp.FLAG_EQUALS, 1));
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 4) {
                if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.SPRING_RIGHT_HATCH, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.INFERNO) {
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                return false;
            }
        }
        else if (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    return false;
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 2) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1) {
                    if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                        roomSpawner.getTestByteOperations().clear();
                    }
                }
            }
            if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 2) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    return false;
                }
            }
            if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 2) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 15 && screen.getScreenIndex() == 2) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_SABBAT, ByteOp.FLAG_LTEQ, 3))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 16 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    roomSpawner.getTestByteOperations().clear();
                }
            }
        }
//        if(screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
//            // todo: other tablets, or different flag work
//            if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_BAHRUN, ByteOp.FLAG_GTEQ, 2))) {
//                roomSpawner.removeTest(new TestByteOperation(FlagConstants.MANTRA_BAHRUN, ByteOp.FLAG_GTEQ, 2));
//            }
//        }
        if(screen.getZoneIndex() == ZoneConstants.ENDLESS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
            if(roomSpawner.getTestByteOperations().size() == 1
                    && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_MARDUK, ByteOp.FLAG_LTEQ, 3))) {
                // Mantra recited indicator always hidden
                roomSpawner.getTestByteOperations().clear();
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.ILLUSION) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && (roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_FINAL, ByteOp.FLAG_LTEQ, 3))
                        || roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_LAMULANA, ByteOp.FLAG_LT, 1)))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && (roomSpawner.hasTest(new TestByteOperation(FlagConstants.ILLUSION_LADDER_BIRDS_ROOM, ByteOp.FLAG_EQUALS, 0)))) {
                    roomSpawner.getArgs().set(4, (short)1);
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.GRAVEYARD) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_ABUTO, ByteOp.FLAG_LTEQ, 3))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.MOONLIGHT) {
            if(screen.getRoomIndex() == 10 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_WEDJET, ByteOp.FLAG_LTEQ, 3))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.GODDESS) {
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_BAHRUN, ByteOp.FLAG_LTEQ, 3))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.RUIN) {
            if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_VIY, ByteOp.FLAG_LTEQ, 3))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getTestByteOperations().size() == 1
                        && roomSpawner.hasTest(new TestByteOperation(FlagConstants.MANTRA_MU, ByteOp.FLAG_LTEQ, 3))) {
                    // Mantra recited indicator always hidden
                    roomSpawner.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                if(roomSpawner.getX() == 380 && roomSpawner.getY() == 520) {
                    roomSpawner.getTestByteOperations().clear();
                    roomSpawner.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_WALL, ByteOp.FLAG_EQUALS, 0));
                }
            }
        }
        return true;
    }

    @Override
    boolean updateOneWayDoor(GameObject oneWayDoor) {
        ObjectContainer objectContainer = oneWayDoor.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                return false;
            }
            if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 2) {
                return false;
            }
            if(screen.getRoomIndex() == 15 && screen.getScreenIndex() == 1) {
                flipOneWayDoor(oneWayDoor);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ENDLESS && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateCrusher(GameObject crusher) {
        ObjectContainer objectContainer = crusher.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                return false;
            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                if(crusher.hasTest(new TestByteOperation(FlagConstants.SUN_FLOODED, ByteOp.FLAG_NOT_EQUAL, 0))) {
                    crusher.getTestByteOperations().clear();
                    crusher.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1));
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.RUIN && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
            if(crusher.hasUpdate(new WriteByteOperation(FlagConstants.RUIN_CRUSHER_MEDICINE_STATUE_SCREEN, ByteOp.ASSIGN_FLAG, 0))) {
                crusher.setX(1180);
            }
        }
        return true;
    }

    @Override
    boolean updateHitbox(Hitbox hitbox) {
        ObjectContainer objectContainer = hitbox.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        if(hitbox.getBreakableBy() == Hitbox.FlareGun) {
            hitbox.setBreakableBy(Hitbox.NotBreakable);
//            return false;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE) {
            if(hitbox.hasTest(new TestByteOperation(FlagConstants.SURFACE_MEKURI_WALL, ByteOp.FLAG_EQUALS, 0))) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.GUIDANCE) {
            if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
                hitbox.setBreakableBy(Hitbox.NotBreakable);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SPRING) {
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.INFERNO) {
            if (screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                // bunplus wall
                return false;
            }
            if (screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
                // Breakable snake statue
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.EXTINCTION) {
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
                if(hitbox.hasTest(new TestByteOperation(FlagConstants.EXTINCTION_WALL_PROCEED_THROUGH, ByteOp.FLAG_EQUALS, 0))) {
//                    hitbox.setBreakableBy(Hitbox.NotBreakable);
                    return false;
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    return false;
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 2) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 1) {
                if(hitbox.getTestByteOperations().size() == 1) {
                    if(hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                        hitbox.getTestByteOperations().clear();
                    }
                }
            }
            if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 2) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    return false;
                }
            }
            if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 0) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 1) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 2) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
            if(screen.getRoomIndex() == 16 && screen.getScreenIndex() == 1) {
                if(hitbox.getTestByteOperations().size() == 1
                        && hitbox.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1))) {
                    hitbox.getTestByteOperations().clear();
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ILLUSION) {
            if (screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0) {
                hitbox.setDirection(Hitbox.AnyDirection);
            }
            if (screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                hitbox.setBreakableBy(Hitbox.AnyWeapon);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.RUIN) {
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
//                hitbox.setBreakableBy(Hitbox.NotBreakable);
                return false;
            }
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
                hitbox.setBreakable(Hitbox.AnyDirection, Hitbox.Bomb);
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
            if(hitbox.hasUpdate(new WriteByteOperation(FlagConstants.BIRTH_MURAL_INSIDE_VISIBLE, ByteOp.ASSIGN_FLAG, 1))) {
                hitbox.getTestByteOperations().clear();
                hitbox.getWriteByteOperations().clear();
                hitbox.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_WALL, ByteOp.FLAG_EQUALS, 0));
                hitbox.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_WALL, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SKANDA) {
            if (screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                if(hitbox.hasUpdate(new WriteByteOperation(FlagConstants.BIRTH_ASURA_BEHEADED, ByteOp.ASSIGN_FLAG, 1))) {
                    return false;
                }
            }
            if (screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                if(hitbox.hasUpdate(new WriteByteOperation(FlagConstants.BIRTH_WALL_DIMENSIONAL_KEY, ByteOp.ASSIGN_FLAG, 1))) {
                    hitbox.setDirection(Hitbox.AnyDirection);
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SHRINE_BACK) {
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.RETRO_MAUSOLEUM) {
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateLemezaDetector(GameObject lemezaDetector) {
        ObjectContainer objectContainer = lemezaDetector.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SURFACE) {
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 2) {
                // Night Surface
                return false;
            }
            if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 1) {
                // Open the ruins
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                lemezaDetector.removeTest(new TestByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.FLAG_EQUALS, 0));
                lemezaDetector.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.FLAG_EQUALS, 0));
                lemezaDetector.getWriteByteOperations().clear();
                lemezaDetector.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1));
            }
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SPRING && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
            lemezaDetector.removeUpdate(new WriteByteOperation(FlagConstants.SUN_FLOODED, ByteOp.ASSIGN_FLAG, 1));
        }
        if (screen.getZoneIndex() == ZoneConstants.EXTINCTION && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 0) {
            for(TestByteOperation testByteOperation : lemezaDetector.getTestByteOperations()) {
                if(testByteOperation.getIndex() == FlagConstants.SCREEN_FLAG_0) {
                    testByteOperation.setIndex(FlagConstants.SCREEN_FLAG_1);
                }
            }
            for(WriteByteOperation writeByteOperation : lemezaDetector.getWriteByteOperations()) {
                if(writeByteOperation.getIndex() == FlagConstants.SCREEN_FLAG_0) {
                    writeByteOperation.setIndex(FlagConstants.SCREEN_FLAG_1);
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
            if(lemezaDetector.getX() == 440 && lemezaDetector.getY() == 520) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
            if(lemezaDetector.hasTest(new TestByteOperation(FlagConstants.BIRTH_LEANING_PILLAR, ByteOp.FLAG_EQUALS, 0))
                    && lemezaDetector.hasUpdate(new WriteByteOperation(FlagConstants.BIRTH_LEANING_PILLAR, ByteOp.ASSIGN_FLAG, 1))) {
                lemezaDetector.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VANDALISM, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SKANDA && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
            for(TestByteOperation testByteOperation : lemezaDetector.getTestByteOperations()) {
                if(testByteOperation.getIndex() == FlagConstants.SCREEN_FLAG_0) {
                    testByteOperation.setIndex(FlagConstants.SCREEN_FLAG_1);
                }
            }
            for(WriteByteOperation writeByteOperation : lemezaDetector.getWriteByteOperations()) {
                if(writeByteOperation.getIndex() == FlagConstants.SCREEN_FLAG_0) {
                    writeByteOperation.setIndex(FlagConstants.SCREEN_FLAG_1);
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.DIMENSIONAL && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
            lemezaDetector.setX(lemezaDetector.getX() + 60);
            lemezaDetector.getArgs().set(4, (short)(lemezaDetector.getArgs().get(4) - 3));
        }
        if (screen.getZoneIndex() == ZoneConstants.HT_2 && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateSphinx(GameObject sphinx) {
        return false;
    }

    @Override
    boolean updateChest(GameObject chest) {
        ObjectContainer objectContainer = chest.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
                ((Chest)chest).setUnlockedCheck(new WriteByteOperation(FlagConstants.SURFACE_ARGUS_DEFEATED, ByteOp.ASSIGN_FLAG, 0));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.INFERNO) {
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
                chest.setX(chest.getX() - 120);
                chest.setY(chest.getY() + 240);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SHRINE_FRONT && screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.ILLUSION && screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
            if(chest.getX() < 320) {
                chest.setX(580);
                chest.setY(400);
            }
            else  {
                chest.setX(40);
                chest.setY(160);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SHRINE_BACK && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateAnkh(GameObject ankh) {
        if(ankh.getArgs().get(0) == ValueConstants.ANKH_BOSS_BAPHOMET) {
            ankh.getArgs().set(2, (short)BAPHOMET_HEALTH);
            ankh.getArgs().set(14, (short)(BAPHOMET_HEALTH - BAPHOMET_PHASE_1_HEALTH)); // 2nd phase health threshold
        }
        if(ankh.getArgs().get(0) == ValueConstants.ANKH_BOSS_TIAMAT) {
            ankh.getArgs().set(2, (short)TIAMAT_HEALTH);
            ankh.getArgs().set(16, (short)(TIAMAT_HEALTH - TIAMAT_PHASE_1_HEALTH)); // 2nd phase health threshold
            ankh.getArgs().set(17, (short)(TIAMAT_HEALTH - TIAMAT_PHASE_1_HEALTH - TIAMAT_PHASE_2_HEALTH)); // 2nd phase health threshold
        }
        if(ankh.getArgs().get(0) == ValueConstants.ANKH_BOSS_MOTHER) {
            if(ankh.hasTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_NOT_EQUAL, 2))) {
                return false;
            }
            else {
                ankh.removeTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2));
            }
        }
        return true;
    }

    @Override
    boolean updateFloatingItem(GameObject floatingItem) {
        ObjectContainer objectContainer = floatingItem.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 2) {
                floatingItem.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.INFERNO) {
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ENDLESS) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateSeal(GameObject seal) {
        ObjectContainer objectContainer = seal.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateHippocamp(GameObject hippocamp) {
        ObjectContainer objectContainer = hippocamp.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SPRING && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 4) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateAnubis(GameObject anubis) {
        ObjectContainer objectContainer = anubis.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        if(!anubis.hasTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2))
                && !anubis.hasTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_NOT_EQUAL, 0))) {
            return false;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.MAUSOLEUM) {
//            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) { // Maus entrance
//                return false;
//            }
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) { // Hardmode tablet room
                return false;
            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) { // Grail tablet room
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
//            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) { // Maus entrance
//                return false;
//            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) { // Mulbruk room
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateSkyfish(GameObject skyfish) {
        skyfish.getWriteByteOperations().clear();
        return true;
    }

    @Override
    boolean updateGraphicsTextureDraw(GameObject graphicsTextureDraw) {
        ObjectContainer objectContainer = graphicsTextureDraw.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if ((screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE)
                && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))) {
                // Never draw gate
                return false;
            }
            else {
                // Always draw cover
                graphicsTextureDraw.getTestByteOperations().clear();
            }
        }
        if ((screen.getZoneIndex() == ZoneConstants.GUIDANCE && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0)
                || (screen.getZoneIndex() == ZoneConstants.MAUSOLEUM && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0)
                || (screen.getZoneIndex() == ZoneConstants.SPRING && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.INFERNO && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.EXTINCTION && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 0)
                || (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT && screen.getRoomIndex() == 12 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.ENDLESS && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.ILLUSION && screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0)
                || (screen.getZoneIndex() == ZoneConstants.GRAVEYARD && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0)
                || (screen.getZoneIndex() == ZoneConstants.MOONLIGHT && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0)
                || (screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.RUIN && screen.getRoomIndex() == 5 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1)
                || (screen.getZoneIndex() == ZoneConstants.DIMENSIONAL && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1)) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_EQUALS, 9))) {
                return false;
            }
        }

        if (screen.getZoneIndex() == ZoneConstants.GUIDANCE) {
            if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
                if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.GUIDANCE_ELEVATOR, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN) {
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
            }
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 2) {
                if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_EQUALS, 5))) {
                    return false;
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.TWIN_FRONT) {
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                if(graphicsTextureDraw.getTestByteOperations().size() == 1
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
                if(graphicsTextureDraw.getTestByteOperations().size() == 2
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.WF_TWIN_STATUE, ByteOp.FLAG_EQUALS, 2))) {
                    graphicsTextureDraw.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
                }
            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 1) {
                if(graphicsTextureDraw.getTestByteOperations().size() == 1
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
                if(graphicsTextureDraw.getTestByteOperations().size() == 2
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.WF_TWIN_STATUE, ByteOp.FLAG_EQUALS, 2))) {
                    graphicsTextureDraw.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
                }
            }
            if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 1) {
                if(graphicsTextureDraw.getTestByteOperations().size() == 1
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
                if(graphicsTextureDraw.getTestByteOperations().size() == 2
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.WF_TWIN_STATUE, ByteOp.FLAG_EQUALS, 2))) {
                    graphicsTextureDraw.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
                }
            }
            if(screen.getRoomIndex() == 16 && screen.getScreenIndex() == 1) {
                if(graphicsTextureDraw.getTestByteOperations().size() == 1
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_EQUALS, 0))) {
                    return false;
                }
                if(graphicsTextureDraw.getTestByteOperations().size() == 2
                        && graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.WF_TWIN_STATUE, ByteOp.FLAG_EQUALS, 2))) {
                    graphicsTextureDraw.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.ENDLESS && screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
            if(graphicsTextureDraw.getArgs().get(10) != 0) {
                // Wall/ceiling preventing climbing the ladder after
                return false;
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.SHRINE_FRONT || screen.getZoneIndex() == ZoneConstants.SHRINE_BACK) {
            for(TestByteOperation testByteOperation : graphicsTextureDraw.getTestByteOperations()) {
                if(ByteOp.FLAG_EQUALS.equals(testByteOperation.getOp())) {
                    if(testByteOperation.getValue() == 4) {
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_MARDUK) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_ETERNITY);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_SABBAT) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_REBIRTH);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_MU) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_LIFE);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_VIY) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_NOTHING);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_BAHRUN) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_ASCENSION);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_WEDJET) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_BIRTH);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_ABUTO) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_DEATH);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                    }
                    else if(testByteOperation.getValue() == 1) {
                        if(testByteOperation.getIndex() == FlagConstants.MANTRA_LAMULANA) {
                            testByteOperation.setIndex(FlagConstants.CUSTOM_MANTRAS_DECEIT);
                            testByteOperation.setOp(ByteOp.FLAG_GTEQ);
                            testByteOperation.setValue(1);
                        }
                    }
                }
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.ILLUSION && screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_EQUALS, 9))) {
                return false;
            }
        }
//        if (screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
//            if(ALWAYS_SHOW_MANTRA_TABLETS) {
//                // todo: this is wrong, would need a proper read flag
//                if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.MANTRA_BAHRUN, ByteOp.FLAG_EQUALS, 2))) {
//                    graphicsTextureDraw.removeTest(new TestByteOperation(FlagConstants.MANTRA_BAHRUN, ByteOp.FLAG_EQUALS, 2));
//                }
//            }
//        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.SKANDA_STATE, ByteOp.FLAG_LTEQ, 1))) {
                return false;
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SKANDA) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
                if(graphicsTextureDraw.getX() == 40 && graphicsTextureDraw.getY() == 40) {
                    graphicsTextureDraw.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_GTEQ, 1));
                }
            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
                if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.SKANDA_STATE, ByteOp.FLAG_LTEQ, 1))) {
                    return false;
                }
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.RETRO_MAUSOLEUM && screen.getRoomIndex() == 1 && screen.getScreenIndex() == 2) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.FLAG_EQUALS, 0))) {
                graphicsTextureDraw.getTestByteOperations().clear();
                graphicsTextureDraw.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_EXIT, ByteOp.FLAG_EQUALS, 0));
            }
        }
        return true;
    }

    @Override
    boolean updateCollapsingFloor(GameObject collapsingFloor) {
//        collapsingFloor.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1));
        return true;
    }

    @Override
    boolean updateExtendableSpikes(GameObject extendableSpikes) {
        ObjectContainer objectContainer = extendableSpikes.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if(screen.getZoneIndex() == ZoneConstants.ENDLESS) {
            return false;
        }
        return updateExtendableSpikesForGiantsPuzzle(extendableSpikes, screen);
    }

    private boolean updateExtendableSpikesForGiantsPuzzle(GameObject extendableSpikes, Screen screen) {
        // Adjust spikes for "foot of Futo" puzzle, if using a different giant. Zebu and Futo handled separately.
        if(screen.getZoneIndex() == 2) {
            extendableSpikes.getArgs().set(22, (short)1);
            extendableSpikes.getArgs().set(23, (short)1);
            extendableSpikes.getArgs().set(24, (short)1);

            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                if("Migela".equals(Settings.getCurrentGiant())) {
                    return false;
                }
                else {
                    extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                }
            }
            else if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
                if("Bado".equals(Settings.getCurrentGiant())) {
                    return false;
                }
                else {
                    extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                }
            }
            else if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 2) {
                if("Ledo".equals(Settings.getCurrentGiant())) {
                    return false;
                }
                else {
                    extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                }
            }
            else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
                if("Abuto".equals(Settings.getCurrentGiant())) {
                    return false;
                }
                else {
                    extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                }
            }
            else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
                if(extendableSpikes.getX() == 740) {
                    if("Sakit".equals(Settings.getCurrentGiant())) {
                        return false;
                    }
                    else {
                        extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                    }
                }
                else { //if(obj.getX() == 1120) {
                    if("Ji".equals(Settings.getCurrentGiant())) {
                        return false;
                    }
                    else {
                        extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                    }
                }
            }
            else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 2) {
                if("Ribu".equals(Settings.getCurrentGiant())) {
                    return false;
                }
                else {
                    extendableSpikes.getArgs().set(4, (short)0); // Activation delay
                }
            }
        }
        return true;
    }

    @Override
    boolean updateWarpPortal(GameObject warpPortal) {
        ObjectContainer objectContainer = warpPortal.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
            setWarpPortalDestination(warpPortal, 15, 2, 1, 560, 140);
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
            if(warpPortal.getY() == 520) {
//                setWarpPortalDestination(warpPortal, 15, 2, 1, 560, 140);
                setWarpPortalDestination(warpPortal, 15, 2, 0, 280, 380);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            setWarpPortalDestination(warpPortal, 15, 2, 1, 120, 232);
        }
        return true;
    }

    @Override
    boolean updateWarpDoor(GameObject warpDoor) {
        ObjectContainer objectContainer = warpDoor.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if ((screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE)
                && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
            return false;
        }

        warpDoor.removeTest(new TestByteOperation(FlagConstants.AMPHISBAENA_STATE, ByteOp.FLAG_EQUALS, 3));
        warpDoor.removeTest(new TestByteOperation(FlagConstants.SAKIT_STATE, ByteOp.FLAG_EQUALS, 3));
        warpDoor.removeTest(new TestByteOperation(FlagConstants.ELLMAC_STATE, ByteOp.FLAG_EQUALS, 3));
        warpDoor.removeTest(new TestByteOperation(FlagConstants.BAHAMUT_STATE, ByteOp.FLAG_EQUALS, 3));
        warpDoor.removeTest(new TestByteOperation(FlagConstants.VIY_STATE, ByteOp.FLAG_EQUALS, 3));
        warpDoor.removeTest(new TestByteOperation(FlagConstants.PALENQUE_STATE, ByteOp.FLAG_EQUALS, 3));
        warpDoor.removeTest(new TestByteOperation(FlagConstants.BAPHOMET_STATE, ByteOp.FLAG_EQUALS, 3));
        if (screen.getZoneIndex() == ZoneConstants.EXTINCTION && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
            warpDoor.addTests(new TestByteOperation(FlagConstants.KEY_FAIRY_DOOR_UNLOCKED, ByteOp.FLAG_EQUALS, 1));
        }
        return true;
    }

    @Override
    boolean updateSoundEffect(GameObject soundEffect) {
        ObjectContainer objectContainer = soundEffect.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if ((screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE)
                && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
            if(soundEffect.hasTest(new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1))) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateUseItemDetector(GameObject useItemDetector) {
        useItemDetector.removeTest(new TestByteOperation(FlagConstants.MEDICINE_SOLVED, ByteOp.FLAG_EQUALS, 0));

        for (TestByteOperation flagTest : useItemDetector.getTestByteOperations()) {
            if (flagTest.getIndex() == FlagConstants.MR_SLUSHFUND_CONVERSATION) {
                // Using Pepper to spawn Treasures chest
                flagTest.setIndex(FlagConstants.WF_TREASURES);
                flagTest.setOp(ByteOp.FLAG_LTEQ);
                flagTest.setValue((byte)1);
                break;
            }
            else if(flagTest.getIndex() == FlagConstants.COG_MUDMEN_STATE) {
                if(flagTest.getValue() == 3) {
                    if(ByteOp.FLAG_EQUALS.equals(flagTest.getOp())) {
                        flagTest.setOp(ByteOp.FLAG_LTEQ);
                        useItemDetector.setX(useItemDetector.getX() - 60);
                        break;
                    }
                    if(ByteOp.FLAG_LTEQ.equals(flagTest.getOp())) {
                        flagTest.setValue((byte)4);
                        flagTest.setOp(ByteOp.FLAG_LT);
                        break;
                    }
                }
                else if(flagTest.getValue() != 4) {
                    flagTest.setIndex(FlagConstants.ILLUSION_PUZZLE_COG_CHEST);
                    break;
                }
            }
        }
        return true;
    }

    @Override
    boolean updateScannable(Scannable scannable) {
//        if(scannable.getTextBlock() == BlockConstants.MantraTablet_MARDUK
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_SABBAT
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_MU
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_VIY
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_BAHRUN
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_WEDJET
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_ABUTO
//                || scannable.getTextBlock() == BlockConstants.MantraTablet_LAMULANA) {
//            if(scannable.getWriteByteOperations().isEmpty()) {
//                scannable.getTestByteOperations().clear();
//            }
//            else {
//                return false;
//            }
//        }
        if(scannable.getTextBlock() == BlockConstants.ResearchMode_CrossOfLight) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateConversationDoor(GameObject conversationDoor) {
        ObjectContainer objectContainer = conversationDoor.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if(screen.getZoneIndex() == ZoneConstants.GUIDANCE && screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateScreenShake(GameObject screenShake) {
        ObjectContainer objectContainer = screenShake.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if(screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
            if(screenShake.hasTest(new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1))) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean updateKeyFairySpot(GameObject keyFairySpot) {
        ObjectContainer objectContainer = keyFairySpot.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if (screen.getZoneIndex() == ZoneConstants.EXTINCTION && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
            return false;
        }
        if (screen.getZoneIndex() == ZoneConstants.ILLUSION && screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
            keyFairySpot.setX(600);
            keyFairySpot.setY(380);
        }
        return true;
    }

    @Override
    boolean updatePushableBlock(GameObject pushableBlock) {
        ObjectContainer objectContainer = pushableBlock.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if(screen.getZoneIndex() == ZoneConstants.MOONLIGHT && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateShawn(GameObject shawn) {
        ObjectContainer objectContainer = shawn.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if(screen.getZoneIndex() == ZoneConstants.SPRING && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
            return false;
        }
        if(screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
            shawn.removeTest(new TestByteOperation(FlagConstants.VIY_STATE, ByteOp.FLAG_EQUALS, 3));
        }
        return true;
    }

    @Override
    boolean updateMantraDetector(GameObject mantraDetector) {
        return false;
    }

    @Override
    boolean updateMotherAnkh(GameObject motherAnkh) {
        if(motherAnkh.hasTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_NOT_EQUAL, 2))) {
            return false;
        }
        else {
            motherAnkh.removeTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2));
        }
        return true;
    }

    @Override
    boolean updateSnapshotsScan(GameObject snapshotsScan) {
        ObjectContainer objectContainer = snapshotsScan.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return false;
        }
        Screen screen = (Screen)objectContainer;
        if(screen.getZoneIndex() == ZoneConstants.GRAVEYARD && screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
            if(snapshotsScan.getWriteByteOperations().isEmpty()) {
                return false;
            }
            ((SnapshotsScan)snapshotsScan).setTextCard(getCustomBlockIndex(CustomBlockEnum.Fools2022_GraveyardSnapshotsScanFail));
            ((SnapshotsScan)snapshotsScan).setInventoryWord(0);
            snapshotsScan.getWriteByteOperations().clear();
            snapshotsScan.removeTest(new TestByteOperation(FlagConstants.WF_SOFTWARE_EMUSIC, ByteOp.FLAG_EQUALS, 0));
            return true;
        }
        return false;
    }

    @Override
    boolean updateCockatrice(GameObject cockatrice) {
        ObjectContainer objectContainer = cockatrice.getObjectContainer();
        if(!(objectContainer instanceof Screen)) {
            return true;
        }
        Screen screen = (Screen)objectContainer;
        if ((screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE)
                && screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            return false;
        }
        return true;
    }

    @Override
    boolean updateMirrorGhosts(GameObject mirrorGhosts) {
        mirrorGhosts.getArgs().set(1, DropType.NOTHING.getValue());
        mirrorGhosts.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ADD_FLAG, 1));
        return true;
    }

    @Override
    boolean updateLavaRock(GameObject lavaRock) {
        lavaRock.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ADD_FLAG, 1));
        return true; // todo: experiment
    }

    @Override
    boolean updateFallingSun(GameObject fallingSun) {
        fallingSun.getArgs().set(0, (short)1); // todo: 0?
        return true;
    }

    @Override
    boolean updateDeathLaserStatue(GameObject deathLaserStatue) {
        deathLaserStatue.setX(320);
        deathLaserStatue.getArgs().set(0, (short)0);
        deathLaserStatue.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ADD_FLAG, 1));
        return true;
    }

    @Override
    void addUntrackedCustomNoPositionObjects(Screen screen, int zoneIndex, int roomIndex, int screenIndex) {
        addLocationBasedTimers(screen, zoneIndex, roomIndex, screenIndex);

        if(zoneIndex == ZoneConstants.SURFACE || zoneIndex == ZoneConstants.NIGHT_SURFACE) {
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.SURFACE_ARGUS_DEFEATED, ByteOp.FLAG_NOT_EQUAL, 0)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));

                addMailTimer(screen, FlagConstants.MAIL_06)
                        .addTests(new TestByteOperation(FlagConstants.SURFACE_ARGUS_DEFEATED, ByteOp.FLAG_NOT_EQUAL, 0),
                                new TestByteOperation(FlagConstants.WF_BIRTH_SEAL, ByteOp.FLAG_EQUALS, 0));

                AddObject.addFramesTimer(screen, 3,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.MAIL_15, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SURFACE_ARGUS_DEFEATED, ByteOp.FLAG_NOT_EQUAL, 0),
                                new TestByteOperation(FlagConstants.WF_BIRTH_SEAL, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.MAIL_15, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
            }
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_EMUSIC, ByteOp.FLAG_GT, 0),
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_BEOLAMU, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_XELPUD_MUSIC_1, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_XELPUD_MUSIC_1, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_BEOLAMU, ByteOp.FLAG_GT, 0),
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_EMUSIC, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_XELPUD_MUSIC_1, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_XELPUD_MUSIC_1, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, WAR_RAP)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));

                CycleTimer cycleTimer = new CycleTimer(screen);
                cycleTimer.setDelayFrames(50);
                cycleTimer.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
                cycleTimer.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ASSIGN_FLAG, 1));
                screen.getObjects().add(0, cycleTimer);

                cycleTimer = new CycleTimer(screen);
                cycleTimer.setDelayFrames(50);
                cycleTimer.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
                cycleTimer.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1));
                screen.getObjects().add(0, cycleTimer);
            }
            if(roomIndex == 11 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, SPAULDER_HOLY_NOTHING)
                        .addTests(new TestByteOperation(FlagConstants.SURFACE_RUINS_FRONT_DOOR_OPEN, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SURFACE_RUINS_FRONT_DOOR_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SURFACE_RUINS_FRONT_DOOR_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
            }
        }
        if(zoneIndex == ZoneConstants.GUIDANCE) {
            if(roomIndex == 0 && screenIndex == 1) {
                addMailTimer(screen, FlagConstants.MAIL_00);
            }
            if(roomIndex == 1 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEAT_CAT_PAUSE, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_BOUNCE, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_FEATHER, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEAT_CAT_PAUSE, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEAT_CAT_PAUSE, ByteOp.FLAG_LT, 2)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEAT_CAT_PAUSE, ByteOp.ASSIGN_FLAG, 2)));
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.GUIDANCE_PUZZLE_MAP_CHEST, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addFramesTimer(screen, 30,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.GUIDANCE_PUZZLE_MAP_CHEST, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 0)));
                AddObject.addFramesTimer(screen, 30,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.GUIDANCE_PUZZLE_MAP_CHEST, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                // todo: mail timer for laser'd up
            }
            if(roomIndex == 5 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_10)
                        .addTests(new TestByteOperation(FlagConstants.AMPHISBAENA_GATE_MIRROR_COVER, ByteOp.FLAG_GTEQ, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.AMPHISBAENA_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);
            }
            if(roomIndex == 9 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if(zoneIndex == ZoneConstants.MAUSOLEUM) {
            addSuccessSoundsForGiantsPuzzle(screen, roomIndex, screenIndex);
            if(roomIndex == 0 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_01);
            }
//            if(roomIndex == 2 && screenIndex == 0) {
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
//                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
//            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.GHOST_LORD_STATE, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GHOSTLORD, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.GHOST_LORD_STATE, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GHOSTLORD, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.ASSIGN_FLAG, 2)));
                addMailTimer(screen, FlagConstants.MAIL_10)
                        .addTests(new TestByteOperation(FlagConstants.SAKIT_GATE_MIRROR_COVER, ByteOp.FLAG_GTEQ, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SAKIT_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);
            }
//            if(roomIndex == 5 && screenIndex == 0) {
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
//                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
//            }
        }
        if(zoneIndex == ZoneConstants.SUN) {
            if(roomIndex == 0 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_01);
            }
            if(roomIndex == 1 && screenIndex == 2) {
                // Cheat detection - Cat Pause for Knife
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.SUN_WEAPON_COVER_KNIFE, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.BUER_STATE, ByteOp.FLAG_GT, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ADD_FLAG, 1)));
            }
            if(roomIndex == 3 && screenIndex == 0) {
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
//                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addMantraDetector(screen, BIRTH_SLAP)
                        .addTests(new TestByteOperation(FlagConstants.MULBRUK_DOOR_UNSEALED, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.MULBRUK_DOOR_UNSEALED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addShellHornFailureSound(screen, true)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1));
            }
            if(roomIndex == 4 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.SUN_PYRAMID_SUN_FALLEN, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SUN_PYRAMID_SUN_FALLEN, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 4 && screenIndex == 2) {
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_EQUALS, 5),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
            }
            if(roomIndex == 4 && screenIndex == 4) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 5 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, REBIRTH_WATER)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SUN_GEYSER, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 6 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_10)
                        .addTests(new TestByteOperation(FlagConstants.ELLMAC_GATE_MIRROR_COVER, ByteOp.FLAG_GTEQ, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);
            }
            if(roomIndex == 6 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 7 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, SPAULDER_HOLY_NOTHING)
                        .addTests(new TestByteOperation(FlagConstants.ROOM_FLAG_33, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SUN_PUZZLE_WEDJET, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SUN_PUZZLE_WEDJET, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if(zoneIndex == ZoneConstants.SPRING) {
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addSnapshotsScan(screen, BlockConstants.SnapshotsScan_Item, SNAPSHOTS_OANNES_ITEM, 140, 60)
                        .addTests(new TestByteOperation(SNAPSHOTS_OANNES_FLAG, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(SNAPSHOTS_OANNES_FLAG, ByteOp.ASSIGN_FLAG, 2));
            }
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, REBIRTH_WATER)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SPRING_LEFT_HATCH, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.WF_WATERPROOF_CASE, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.SPRING_LEFT_HATCH, ByteOp.ASSIGN_FLAG, 0),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SPRING_LEFT_HATCH, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));

                AddObject.addMantraDetector(screen, REBIRTH_WATER)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SPRING_RIGHT_HATCH, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.WF_WATERPROOF_CASE, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.SPRING_RIGHT_HATCH, ByteOp.ASSIGN_FLAG, 0),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addShellHornFailureSound(screen, true)
                        .addTests(new TestByteOperation(FlagConstants.SPRING_RIGHT_HATCH, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.SPRING_FLOODED, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SPRING_BAHAMUT_ROOM_FLOODED, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SPRING_BAHAMUT_ROOM_FLOODED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SPRING_BAHAMUT_ROOM_FLOODED, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
            }
            if(roomIndex == 3 && screenIndex == 4) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if(zoneIndex == ZoneConstants.INFERNO) {
            if(roomIndex == 0 && screenIndex == 0) {
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.INFERNO_VIY_MANTRA_STATUE, ByteOp.FLAG_GTEQ, 2),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.FLAG_EQUALS, 1)));
            }
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                // Cheat detection - Lamp Glitch to Viy
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.BAHAMUT_GATE_OPEN, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 8 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 9 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 10,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 2)));
                AddObject.addFramesTimer(screen, 10,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 3)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0)));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.BAPHOMET_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);

                // Cheat detection for entering backside door path without using backside door
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_DOOR_REACHED, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 9 && screenIndex == 1) {
                // Cheat detection for entering backside door path without using backside door
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_DOOR_REACHED, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
        }
        if(zoneIndex == ZoneConstants.EXTINCTION) {
            if(roomIndex != 8 && roomIndex != 9) {
                // Cheat detection for entering the dark portion of Extinction prior to Origin Seal
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.WF_ORIGIN_SEAL, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }

            if(roomIndex == 0 && screenIndex == 0) {
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);

                // Cheat detection for entering backside door path without using backside door
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_DOOR_REACHED, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 1 && screenIndex == 1) {
                // Cheat detection for entering backside door path without using backside door
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_DOOR_REACHED, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addSnapshotsScan(screen, BlockConstants.SnapshotsScan_Item, SNAPSHOTS_INVOCATION_ITEM, 400, 240)
                        .addTests(new TestByteOperation(SNAPSHOTS_INVOCATION_FLAG, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(SNAPSHOTS_INVOCATION_FLAG, ByteOp.ASSIGN_FLAG, 2));
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 3 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 5 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 5 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 6 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.ASSIGN_FLAG, 3),
                                new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(0x32c, ByteOp.ASSIGN_FLAG, 2));
                AddObject.addSnapshotsScan(screen, BlockConstants.SnapshotsScan_Item, SNAPSHOTS_LIGHT_ITEM, 340, 80)
                        .addTests(new TestByteOperation(SNAPSHOTS_LIGHT_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_GTEQ, 2))
                        .addUpdates(new WriteByteOperation(SNAPSHOTS_LIGHT_FLAG, ByteOp.ASSIGN_FLAG, 2));
            }
            if(roomIndex == 6 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 7 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_10);
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2),
                                new TestByteOperation(FlagConstants.KEY_FAIRY_DOOR_UNLOCKED, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, WAR_RAP)
                        .addTests(new TestByteOperation(FlagConstants.KEY_FAIRY_DOOR_UNLOCKED, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.KEY_FAIRY_DOOR_UNLOCKED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.KEY_FAIRY_DOOR_UNLOCKED_V2, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 7 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
        }
        if(zoneIndex == ZoneConstants.TWIN_FRONT) {
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSecondsTimer(screen, 9,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_GT, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 7 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.TWIN_ANKH_JEWEL_CHEST_PUZZLE, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.TWIN_ANKH_JEWEL_CHEST_PUZZLE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 10 && screenIndex == 1) {
                // Cheat detection - raindropping from Dimensional to Twin Labs?
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_DIMENSIONAL_CHEATS, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DIMENSIONAL_CHEATS, ByteOp.ASSIGN_FLAG, 2),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 15 && screenIndex == 2) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.TWIN_BRING_LIGHT_BURANUN, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.TWIN_BRING_LIGHT_BURANUN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 16 && screenIndex == 0) {
                addMotherMantraObjects(screen, REBIRTH_WATER, FlagConstants.CUSTOM_MANTRAS_REBIRTH, FlagConstants.SCREEN_FLAG_B);
            }
        }
        if(zoneIndex == ZoneConstants.ENDLESS) {
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.TIAMAT_STATE, ByteOp.FLAG_LT, 3)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.ASSIGN_FLAG, 0)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_DIMENSIONAL_CHEATS, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DIMENSIONAL_CHEATS, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 1 && screenIndex == 0) {
                addMotherMantraObjects(screen, ETERNITY_FIRE, FlagConstants.CUSTOM_MANTRAS_ETERNITY, FlagConstants.SCREEN_FLAG_B);
            }
            if(roomIndex == 3 && screenIndex == 3) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 5 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.ENDLESS_5F_BROKEN_FLOOR, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.ENDLESS_5F_BROKEN_FLOOR, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.ENDLESS_5F_BROKEN_FLOOR, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.FLAG_EQUALS, 1)));
            }
            if(roomIndex == 5 && screenIndex == 3) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_NOT_EQUAL, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.ASSIGN_FLAG, 0)));
            }
        }
        if(zoneIndex == ZoneConstants.SHRINE_FRONT) {
            if(roomIndex == 1 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.FLAG_LTEQ, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_37, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.FLAG_EQUALS, 2)));
            }
            if(roomIndex == 5 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 7 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ILLUSION) {
            if(roomIndex == 0 && screenIndex == 1) {
                // Cheat detection - skip breaking wall to stray fairy room
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.ILLUSION_STRAY_FAIRY_WALL, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 1 && screenIndex == 0) {
                addMotherMantraObjects(screen, DECEIT, FlagConstants.CUSTOM_MANTRAS_DECEIT, FlagConstants.SCREEN_FLAG_B);
            }
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.ILLUSION_LADDER_BIRDS_ROOM, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.ILLUSION_LADDER_BIRDS_ROOM, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.AMPHISBAENA_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);
            }
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
                AddObject.addMantraDetector(screen, ORIGIN_REALITY)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
//                AddObject.addMantraDetector(screen, DECEIT)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
//                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
            }
            if(roomIndex == 7 && screenIndex == 2) {
                AddObject.addMantraDetector(screen, ORIGIN_REALITY)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_GTEQ, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_LTEQ, 2),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_GTEQ, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_LTEQ, 2),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addShellHornFailureSound(screen, true)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 8 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ORIGIN_REALITY)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, 3),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, 3),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addShellHornFailureSound(screen, true)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0));
            }
            if(roomIndex == 9 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, ORIGIN_REALITY)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, 4),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, 4),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addShellHornFailureSound(screen, true)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0));
            }
            if(roomIndex == 9 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ORIGIN_REALITY)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, 5),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, 5),
                                new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, ORIGIN_REALITY)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.ASSIGN_FLAG, 1));
//                AddObject.addMantraDetector(screen, DECEIT)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_EQUALS, 0))
//                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addShellHornFailureSound(screen, true)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.MOONLIGHT) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.ASSIGN_FLAG, 2)));
            }
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 0) {
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.FLAG_LTEQ, 1),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_CRYSTAL_SKULL, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.ASSIGN_FLAG, 3),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 2) {
                AddObject.addAnimatedDoorSound(screen);
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                addMotherMantraObjects(screen, BIRTH_SLAP, FlagConstants.CUSTOM_MANTRAS_BIRTH, FlagConstants.SCREEN_FLAG_B);
            }
//            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 2) { // todo: delete anubis
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
//            }
//            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 3) { // todo: delete anubis
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
//            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) { // todo: delete anubis
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
            }
//            if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) { // todo: delete anubis
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
//            }
//            if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) { // todo: delete anubis
//                AddObject.addFramesTimer(screen, 0,
//                        Arrays.asList(new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.MULBRUK_CONVERSATION_BOOK, ByteOp.ASSIGN_FLAG, 1)));
//            }
        }
        if(zoneIndex == ZoneConstants.GODDESS) {
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.GODDESS_LIGHTS_ON, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.GODDESS_LIGHTS_ON, ByteOp.ASSIGN_FLAG, 1));
            }
            else {
                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
                        .addTests(new TestByteOperation(FlagConstants.GODDESS_LIGHTS_ON, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.GODDESS_LIGHTS_ON, ByteOp.ASSIGN_FLAG, 3));
            }

            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, SPAULDER_HOLY_NOTHING)
                        .addTests(new TestByteOperation(FlagConstants.WF_SPAULDER, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, SPAULDER_HOLY_NOTHING)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);
            }
            if(roomIndex == 1 && screenIndex == 0) {
                addMotherMantraObjects(screen, ASCENSION, FlagConstants.CUSTOM_MANTRAS_ASCENSION, FlagConstants.SCREEN_FLAG_9);
            }
            if(roomIndex == 4 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.MAIL_02, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.XELPUD_CONVERSATION_MSX2, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.XELPUD_CONVERSATION_MSX2, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.MAIL_02, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
            }
            if(roomIndex == 7 && screenIndex == 2) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.ASSIGN_FLAG, 6)));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.ASSIGN_FLAG, 3)));
            }
        }
        if(zoneIndex == ZoneConstants.RUIN) {
            if(roomIndex == 0 && screenIndex == 2) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.ASSIGN_FLAG, 5)));
            }
            if(roomIndex == 1 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_PUZZLE_ANKH_JEWEL_CHEST, ByteOp.FLAG_LT, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_PUZZLE_ANKH_JEWEL_CHEST, ByteOp.ASSIGN_FLAG, 2),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.BAHAMUT_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.THUNDERBIRD_STATE, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 5 && screenIndex == 0) {
                addMotherMantraObjects(screen, SPAULDER_HOLY_NOTHING, FlagConstants.CUSTOM_MANTRAS_NOTHING, FlagConstants.SCREEN_FLAG_B);

                addMailTimer(screen, FlagConstants.MAIL_16)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 5 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_ENTRANCE_LEGIT, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_ENTRANCE_LEGIT, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 6 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_SPIRITS_RUSALII, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.RUIN_SPIRITS_YAKSI, ByteOp.FLAG_NOT_EQUAL, 1),
                                new TestByteOperation(FlagConstants.RUIN_SPIRITS_DAKINI, ByteOp.FLAG_NOT_EQUAL, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_SPIRITS_RUSALII, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_SPIRITS_RUSALII, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_SPIRITS_RUSALII, ByteOp.ASSIGN_FLAG, 2),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_UPPER_SHORTCUT, ByteOp.FLAG_EQUALS, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 6 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_SPIRITS_YAKSI, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.RUIN_SPIRITS_RUSALII, ByteOp.FLAG_NOT_EQUAL, 1),
                                new TestByteOperation(FlagConstants.RUIN_SPIRITS_DAKINI, ByteOp.FLAG_NOT_EQUAL, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_SPIRITS_YAKSI, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_SPIRITS_YAKSI, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_SPIRITS_YAKSI, ByteOp.ASSIGN_FLAG, 2),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 7 && screenIndex == 0) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_SPIRITS_DAKINI, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.RUIN_SPIRITS_RUSALII, ByteOp.FLAG_NOT_EQUAL, 1),
                                new TestByteOperation(FlagConstants.RUIN_SPIRITS_YAKSI, ByteOp.FLAG_NOT_EQUAL, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_SPIRITS_DAKINI, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addMantraDetector(screen, DECEIT)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_SPIRITS_DAKINI, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_SPIRITS_DAKINI, ByteOp.ASSIGN_FLAG, 2),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 7 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.RUIN_MEDICINE_STATUE_UNCOVERED, ByteOp.FLAG_LT, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.RUIN_MEDICINE_STATUE_UNCOVERED, ByteOp.ASSIGN_FLAG, 2));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.ASSIGN_FLAG, 4)));
            }
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
                AddObject.addAnimatedDoorSound(screen);

                // Cheat detection setup - marks entry to backside door path as legitimately earned
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_DOOR_REACHED, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_DOOR_REACHED, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.ASSIGN_FLAG, 1)));
            }
//            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
//                AddObject.addMantraDetector(screen, ETERNITY_FIRE)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0),
//                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))
//                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
//            }
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                AddObject.addMantraDetector(screen, ASCENSION)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.ASSIGN_FLAG, 1)));
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.BIRTH_SKANDA) {
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                AddObject.addMantraDetector(screen, LIFE_QUAKE)
                        .addTests(new TestByteOperation(FlagConstants.BIRTH_MOVING_PLATFORM_NEAR_SKANDA, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.BIRTH_MOVING_PLATFORM_NEAR_SKANDA, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
            }
            else if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0) {
                addMotherMantraObjects(screen, LIFE_QUAKE, FlagConstants.CUSTOM_MANTRAS_LIFE, FlagConstants.SCREEN_FLAG_B);
            }
        }
        if(zoneIndex == ZoneConstants.DIMENSIONAL) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_DIMENSIONAL_CHEATS, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DIMENSIONAL_CHEATS, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
                AddObject.addGrailToggle(screen, false,
                        new TestByteOperation(FlagConstants.TIAMAT_STATE, ByteOp.FLAG_NOT_EQUAL, 3));
            }
        }
        if(zoneIndex == ZoneConstants.SHRINE_BACK) {
            if(roomIndex == 3 && screenIndex == 0) {
                addMailTimer(screen, FlagConstants.MAIL_09)
                        .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.FLAG_LT, 7),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MULBRUK_ARMOR, ByteOp.ASSIGN_FLAG, 1));
                addMailTimer(screen, FlagConstants.MAIL_09)
                        .addTests(new TestByteOperation(FlagConstants.WF_PISTOL, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MULBRUK_ARMOR, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 3 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_SPAULDER, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_SPAULDER, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_SPAULDER, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_HELMET, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_HELMET, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_HELMET, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_GAUNTLET, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_GAUNTLET, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_GAUNTLET, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_FAIRY_CLOTHES, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_BOOTS, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_HERMES_BOOTS, ByteOp.FLAG_EQUALS, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_BOOTS, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
            }
            if(roomIndex == 4 && screenIndex == 1) {
                AddObject.addMantraDetector(screen, BIRTH_SLAP)
                        .addTests(new TestByteOperation(FlagConstants.TRUE_SHRINE_TENTACLE, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.TRUE_SHRINE_TENTACLE, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if(zoneIndex == ZoneConstants.RETRO_MAUSOLEUM && roomIndex == 1 && screenIndex == 2) {
            AddObject.addMantraDetector(screen, BIRTH_SLAP)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_EXIT, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.WF_GLOVE, ByteOp.FLAG_EQUALS, 2))
                    .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_EXIT, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
            AddObject.addMantraDetector(screen, BIRTH_SLAP)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_EXIT, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.WF_GLOVE, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.MAIL_11, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(new WriteByteOperation(FlagConstants.MAIL_11, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1));
            AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_EXIT, ByteOp.FLAG_EQUALS, 1),
                    new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1),
                    new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
        }
        if(zoneIndex == ZoneConstants.BURNING_CAVERN) {
            if(roomIndex == 0 && screenIndex == 0) {
                AddObject.addFramesTimer(screen, 2,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.ASSIGN_FLAG, 2)));
            }
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_NOT_EQUAL, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 0 && screenIndex == 2) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_NOT_EQUAL, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 0 && screenIndex == 3) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_NOT_EQUAL, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.ASSIGN_FLAG, 0)));
            }
            if(roomIndex == 0 && screenIndex == 4) {
                AddObject.addFramesTimer(screen, 0,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.ASSIGN_FLAG, 1)));
            }
        }

        if(zoneIndex == ZoneConstants.MAUSOLEUM && roomIndex == 3 && screenIndex == 0) {
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GHOSTLORD, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GHOSTLORD, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GHOSTLORD, ByteOp.FLAG_GT, 0),
                            new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(

                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
        else if(zoneIndex == ZoneConstants.SUN && roomIndex == 4 && screenIndex == 3) {
//            AddObject.addMantraDetector(screen, DEATH)
//                    .addTests(new TestByteOperation(FlagConstants.SUN_CHEST_SACRED_ORB, ByteOp.FLAG_EQUALS, 0))
//                    .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_3B, ByteOp.ASSIGN_FLAG, 2),
//                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1));
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.SUN_CHEST_SACRED_ORB, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_3B, ByteOp.ASSIGN_FLAG, 2));
            AddObject.addMantraDetector(screen, BIRTH_SLAP)
                    .addTests(new TestByteOperation(FlagConstants.SUN_CHEST_SACRED_ORB, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_3B, ByteOp.ASSIGN_FLAG, 2));
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.SUN_CHEST_SACRED_ORB, ByteOp.FLAG_GT, 0),
                            new TestByteOperation(FlagConstants.ROOM_FLAG_3B, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
        else if(zoneIndex == ZoneConstants.SPRING && roomIndex == 0 && screenIndex == 1) {
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_NOT_EQUAL, 0),
                            new TestByteOperation(FlagConstants.WF_WATERPROOF_CASE, ByteOp.FLAG_EQUALS, 2))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_NOT_EQUAL, 0),
                            new TestByteOperation(FlagConstants.WF_WATERPROOF_CASE, ByteOp.FLAG_EQUALS, 2))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
        else if(zoneIndex == ZoneConstants.GRAVEYARD && roomIndex == 1 && screenIndex == 1) {
            addMotherMantraObjects(screen, DEATH, FlagConstants.CUSTOM_MANTRAS_DEATH, FlagConstants.SCREEN_FLAG_B);
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.FLAG_LTEQ, 1))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
        else if(zoneIndex == ZoneConstants.MOONLIGHT && roomIndex == 2 && screenIndex == 1) {
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
//            AddObject.addFramesTimer(screen, 0,
//                    Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1),
//                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1)),
//                    Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1)));
            AddObject.addFramesTimer(screen, 0,
                    Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1),
                            new TestByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.FLAG_EQUALS, 0)),
                    Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1)));
            AddObject.addFramesTimer(screen, 0,
                    Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1),
                            new TestByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.FLAG_EQUALS, 1)),
                    Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.ASSIGN_FLAG, 1)));
            AddObject.addFramesTimer(screen, 0,
                    Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1),
                            new TestByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.FLAG_EQUALS, 1),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.FLAG_LT, 2)),
                    Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.ASSIGN_FLAG, 1)));
        }
        else if(zoneIndex == ZoneConstants.BIRTH_SKANDA && roomIndex == 2 && screenIndex == 0) {
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.BIRTH_ASURA_BEHEADED, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.BIRTH_ASURA_BEHEADED, ByteOp.ASSIGN_FLAG, 1));
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_DEATH, ByteOp.FLAG_GT, 0),
                            new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.BIRTH_ASURA_BEHEADED, ByteOp.FLAG_GT, 0))
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
        else if(zoneIndex == ZoneConstants.DIMENSIONAL) {
            if(roomIndex == 1 && screenIndex == 1) {
                addDimensionalChildScreenObjects(screen, FlagConstants.KULULLU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C,
                        new WriteByteOperation(FlagConstants.DIMENSIONAL_LEFT_SIDE_STATE, ByteOp.ASSIGN_FLAG, 2));
            }
            else if(roomIndex == 2 && screenIndex == 0) {
                addDimensionalChildScreenObjects(screen, FlagConstants.KUUSARIKKU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C,
                        new WriteByteOperation(FlagConstants.DIMENSIONAL_PUZZLE_KUUSARIKKU_FOBOS_DAIS, ByteOp.ASSIGN_FLAG, 1));
            }
            else if(roomIndex == 3 && screenIndex == 0) {
                addDimensionalChildScreenObjects(screen, FlagConstants.USHUM_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C, null);
            }
            else if(roomIndex == 4 && screenIndex == 1) {
                addDimensionalChildScreenObjects(screen, FlagConstants.LAHAMU_STATE, FlagConstants.SCREEN_FLAG_1, FlagConstants.SCREEN_FLAG_C, null);
            }
            else if(roomIndex == 5 && screenIndex == 0) {
                addDimensionalChildScreenObjects(screen, FlagConstants.UGALLU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C,
                        new WriteByteOperation(FlagConstants.ROOM_FLAG_43, ByteOp.ASSIGN_FLAG, 1));
            }
            else if(roomIndex == 7 && screenIndex == 0) {
                addDimensionalChildScreenObjects(screen, FlagConstants.URMAHLULLU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C, null);
            }
            else if(roomIndex == 8 && screenIndex == 1) {
                addDimensionalChildScreenObjects(screen, FlagConstants.MUSHNAHHU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C, null);
            }
            else if(roomIndex == 9 && screenIndex == 1) {
                addDimensionalChildScreenObjects(screen, FlagConstants.UMU_DABRUTU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C,
                        new WriteByteOperation(FlagConstants.DIMENSIONAL_UPPER_STATE, ByteOp.ASSIGN_FLAG, 2));
            }
            else if(roomIndex == 10 && screenIndex == 1) {
                addDimensionalChildScreenObjects(screen, FlagConstants.USHUMGALLU_STATE, FlagConstants.SCREEN_FLAG_0, FlagConstants.SCREEN_FLAG_C, null);
            }
            else {
                AddObject.addMantraDetector(screen, DEATH)
                        .addUpdates(
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        else if(zoneIndex == ZoneConstants.NIGHT_SURFACE && roomIndex == 6 && screenIndex == 0) {
            AddObject.addMantraDetector(screen, DEATH)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_LT, 2))
                    .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
        else {
            AddObject.addMantraDetector(screen, DEATH)
                    .addUpdates(
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1));
        }
    }

    private void addLocationBasedTimers(Screen screen, int zoneIndex, int roomIndex, int screenIndex) {
        if(zoneIndex == ISIS_PENDANT_ZONE && roomIndex == ISIS_PENDANT_ROOM && screenIndex == ISIS_PENDANT_SCREEN) {
            AddObject.addFramesTimer(screen, 0,
                    Arrays.asList(
                            new TestByteOperation(FlagConstants.WF_ISIS_PENDANT, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.FAIRY_POINTS_ACTIVE, ByteOp.FLAG_EQUALS, 0)),
                    Arrays.asList(
                            new WriteByteOperation(FlagConstants.FAIRY_POINTS_ACTIVE, ByteOp.ASSIGN_FLAG, 1)));
        }
        if(zoneIndex == EMUSIC_ZONE && roomIndex == EMUSIC_ROOM && screenIndex == EMUSIC_SCREEN) {
            addMailTimer(screen, FlagConstants.MAIL_03)
                    .addTests(new TestByteOperation(FlagConstants.WF_SOFTWARE_EMUSIC, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.WF_SOFTWARE_BEOLAMU, ByteOp.FLAG_EQUALS, 2));
        }
        if(zoneIndex == BEOLAMU_ZONE && roomIndex == BEOLAMU_ROOM && screenIndex == BEOLAMU_SCREEN) {
            addMailTimer(screen, FlagConstants.MAIL_03)
                    .addTests(new TestByteOperation(FlagConstants.WF_SOFTWARE_EMUSIC, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.WF_SOFTWARE_BEOLAMU, ByteOp.FLAG_EQUALS, 2));
        }
        if(zoneIndex == BOUNCE_ZONE && roomIndex == BOUNCE_ROOM && screenIndex == BOUNCE_SCREEN) {
            addMailTimer(screen, FlagConstants.MAIL_04)
                    .addTests(new TestByteOperation(FlagConstants.WF_SOFTWARE_BOUNCE, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.WF_SOFTWARE_MIRACLE, ByteOp.FLAG_EQUALS, 2));
        }
        if(zoneIndex == MIRACLE_ZONE && roomIndex == MIRACLE_ROOM && screenIndex == MIRACLE_SCREEN) {
            addMailTimer(screen, FlagConstants.MAIL_04)
                    .addTests(new TestByteOperation(FlagConstants.WF_SOFTWARE_BOUNCE, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.WF_SOFTWARE_MIRACLE, ByteOp.FLAG_EQUALS, 2));
        }
    }

    private void addSuccessSoundsForGiantsPuzzle(Screen screen, int roomIndex, int screenIndex) {
        // Add success sound to any screen except Futo/Migela (who already have one) or Zebu (who is addressed separately)
        if(roomIndex == 7 && screenIndex == 1) {
            if("Bado".equals(Settings.getCurrentGiant())) {
                AddObject.addSuccessSound(screen, Arrays.asList(
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
            }
        }
        else if(roomIndex == 7 && screenIndex == 2) {
            if("Ledo".equals(Settings.getCurrentGiant())) {
                AddObject.addSuccessSound(screen, Arrays.asList(
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
            }
        }
        else if(roomIndex == 8 && screenIndex == 0) {
            if("Abuto".equals(Settings.getCurrentGiant())) {
                AddObject.addSuccessSound(screen, Arrays.asList(
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
            }
        }
        else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
            if("Sakit".equals(Settings.getCurrentGiant()) || "Ji".equals(Settings.getCurrentGiant())) {
                AddObject.addSuccessSound(screen, Arrays.asList(
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
            }
        }
        else if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 2) {
            if("Ribu".equals(Settings.getCurrentGiant())) {
                AddObject.addSuccessSound(screen, Arrays.asList(
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
            }
        }
    }

    private void addDimensionalChildScreenObjects(Screen screen, int childStateFlag, int fightTriggeredScreenFlag,
                                                  int fightEndedScreenFlag, WriteByteOperation additionalUpdate) {
        AddObject.addMantraDetector(screen, DEATH)
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));

        // Haven't started the fight, have Dimensional Key
        GameObject successTimer = AddObject.addFramesTimer(screen, 1,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(childStateFlag, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.WF_DIMENSIONAL_KEY, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(fightTriggeredScreenFlag, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 2),
                        new WriteByteOperation(childStateFlag, ByteOp.ASSIGN_FLAG, 1)));
        if(additionalUpdate != null) {
            successTimer.addUpdates(additionalUpdate);
        }

        // Have started the fight.
        AddObject.addFramesTimer(screen, 1,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(childStateFlag, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(fightTriggeredScreenFlag, ByteOp.FLAG_GT, 0)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1)));

        // Already dead.
        AddObject.addFramesTimer(screen, 1,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(childStateFlag, ByteOp.FLAG_EQUALS, 2)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1)));

        // Sound effect for mantra-based skip
        AddObject.addSuccessSound(screen,
                Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));

        // Track violence
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(
                        new TestByteOperation(fightEndedScreenFlag, ByteOp.FLAG_GT, 0)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
    }

    @Override
    void addUntrackedCustomPositionObjects(Screen screen, int zoneIndex, int roomIndex, int screenIndex) {
        if(zoneIndex == ZoneConstants.SURFACE || zoneIndex == ZoneConstants.NIGHT_SURFACE) {
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addItemGive(screen, 0, 0, ItemConstants.SOFTWARE_READER,
                        Arrays.asList(
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_READER, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(
                                new WriteByteOperation(FlagConstants.WF_SOFTWARE_READER, ByteOp.ASSIGN_FLAG, 2)));
            }
            if(roomIndex == 3 && screenIndex == 0) {
                addFairyPoint(screen, 220, 160);
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addSurfacePlatforming(screen);
            }
            if(roomIndex == 5 && screenIndex == 1) {
                addFairyPoint(screen, 320, 880).addTests(
                        new TestByteOperation(FlagConstants.SURFACE_UNDERPATH_VISIBLE, ByteOp.FLAG_GT, 0));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                // Door randomization leaves off the mirror cover graphic when the rest of the door gets deleted, but we need that active.
                AddObject.addMirrorCoverGraphic(screen, null, (short)0, (short)1, (short)900, (short)60, (short)80, (short)80, 180, 280);
            }
        }
        if(zoneIndex == ZoneConstants.GUIDANCE) {
            if(roomIndex == 1 && screenIndex == 0) {
                addFairyPoint(screen, 60, 160);
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addPressurePlate(screen, 140, 280)
                        .addTests(
                                new TestByteOperation(FlagConstants.GUIDANCE_PUZZLE_MAP_CHEST, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 0),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 0));
                AddObject.addPressurePlate(screen, 460, 360, PressurePlate.Detection_All)
                        .addTests(
                                new TestByteOperation(FlagConstants.GUIDANCE_PUZZLE_MAP_CHEST, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addJumpPointObjects(screen, 100, 440, 3, true, FlagConstants.SCREEN_FLAG_2C);
                AddObject.addPot(screen, 300, 400, PotGraphic.GUIDANCE, DropType.NOTHING, 0);
            }
            if(roomIndex == 5 && screenIndex == 0) {
                AddObject.addUseItemDetector(screen, 160, 120, 4, 4, "Serpent Staff")
                        .addTests(new TestByteOperation(FlagConstants.AMPHISBAENA_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.AMPHISBAENA_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                addCrossOfLight(screen, 80, 40, -1);
            }
            if(roomIndex == 8 && screenIndex == 0) {
//                AddObject.addLemezaDetector(screen, 0, 0, 15, 24,
//                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 0)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1)));
//                AddObject.addPot(screen, 40, 0, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 40, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 80, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 120, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 160, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 240, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 280, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
//                AddObject.addPot(screen, 40, 320, PotGraphic.MAUSOLEUM, DropType.NOTHING, 0)
//                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1));
            }
            if(roomIndex == 9 && screenIndex == 1) {
                addJumpPointObjects(screen, 1100, 440, 3, true, FlagConstants.SCREEN_FLAG_2C);
            }
        }
        if(zoneIndex == ZoneConstants.MAUSOLEUM) {
            if(roomIndex == 2 && screenIndex == 0) {
                addCrossOfLight(screen, 280, 100, -1);
            }
            if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addFloatingItem(screen, 300, 400, ROLLING_SHURIKEN_ITEM_ARG, true)
                        .addTests(
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GHOSTLORD, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(ROLLING_SHURIKEN_ITEM_FLAG, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(
                                new WriteByteOperation(ROLLING_SHURIKEN_ITEM_FLAG, ByteOp.ASSIGN_FLAG, 2));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                AddObject.addUseItemDetector(screen, 60, 280, 4, 4, "Mini Doll")
                        .addTests(new TestByteOperation(FlagConstants.SAKIT_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MAUSOLEUM_PROVE_THOU_ART_SMALL, ByteOp.FLAG_EQUALS, 1))
                        .addUpdates(new WriteByteOperation(FlagConstants.SAKIT_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addZebuDais(screen);
            }
            if(roomIndex == 7 && screenIndex == 0) {
                AddObject.addExtendingSpikes(screen, 320, 360, FlagConstants.SCREEN_FLAG_8);
            }
            if(roomIndex == 9 && screenIndex == 0) {
                addFairyPoint(screen, 300, 400);
            }
        }
        if(zoneIndex == ZoneConstants.SUN) {
            if(roomIndex == 4 && screenIndex == 0) {
                addFairyPoint(screen, 260, 160);
            }
            if(roomIndex == 4 && screenIndex == 2) {
                AddObject.addUseItemDetector(screen, 1660, 220, 13, 7, "Mini Doll")
                        .addTests(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_LT, 5))
                        .addUpdates(new WriteByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.ASSIGN_FLAG, 5),
                                new WriteByteOperation(FlagConstants.SPHINX_DESTROYED_V2, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addUseItemDetector(screen, 1660, 220, 13, 7, "Woman Statue")
                        .addTests(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_LT, 5),
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MAIL_07, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.MAIL_07, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1));
                AddObject.addUseItemDetector(screen, 1660, 220, 13, 7, "Maternity Statue")
                        .addTests(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_LT, 5),
                                new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2),
                                new TestByteOperation(FlagConstants.MAIL_07, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.MAIL_07, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1));

                GraphicsTextureDraw graphicsTextureDraw = new GraphicsTextureDraw(screen, 1720, 220);
                graphicsTextureDraw.setLayer(-1);
                graphicsTextureDraw.setImageFile("01effect.png");
                graphicsTextureDraw.setImagePosition(240, 788);
                graphicsTextureDraw.setImageSize(180, 140);
                graphicsTextureDraw.setAnimation(0, 1, 0, 0);
                graphicsTextureDraw.setCollision(HitTile.Solid);
                graphicsTextureDraw.setExitEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
                graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
                graphicsTextureDraw.setArg23(1);
                graphicsTextureDraw.addTests(new TestByteOperation(FlagConstants.SPHINX_DESTROYED, ByteOp.FLAG_LT, 5));
                screen.getObjects().add(graphicsTextureDraw);
            }
            if(roomIndex == 4 && screenIndex == 4) {
                addCrossOfLight(screen, 640, 520, -1);
            }
            if(roomIndex == 6 && screenIndex == 0) {
                AddObject.addUseItemDetector(screen, 440, 120, 4, 4, "Woman Statue")
                        .addTests(new TestByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addUseItemDetector(screen, 440, 120, 4, 4, "Maternity Statue")
                        .addTests(new TestByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 6 && screenIndex == 1) {
                PushableGraphic pushableGraphic = new PushableGraphic(screen, 820, 400);
                pushableGraphic.setImageX(0);
                pushableGraphic.setImageY(820);
                pushableGraphic.setWidth(40);
                pushableGraphic.setHeight(40);
                screen.getObjects().add(pushableGraphic);
            }
        }
        if(zoneIndex == ZoneConstants.SPRING) {
            if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addLemezaDetector(screen, 20, 620, 3, 3,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SPRING_LEFT_HATCH, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addLemezaDetector(screen, 540, 860, 4, 3,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SPRING_RIGHT_HATCH, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addOneWayDoor(screen, 40, 700, OneWayDoor.EXIT_LEFT);
            }
            if(roomIndex == 3 && screenIndex == 0) {
                addCrossOfLight(screen, 280, 180, -1);
            }
            if(roomIndex == 3 && screenIndex == 4) {
                addJumpPointObjects(screen, 380, 2120, 5, true, FlagConstants.SCREEN_FLAG_2C);
            }
        }
        if(zoneIndex == ZoneConstants.INFERNO) {
            if(roomIndex == 0 && screenIndex == 0) {
                AddObject.addFloatingItem(screen, 300, 240, STATUE_OF_THE_GIANT_ITEM, true)
                        .addTests(new TestByteOperation(FlagConstants.INFERNO_VIY_MANTRA_STATUE, ByteOp.FLAG_GTEQ, 2),
                                new TestByteOperation(STATUE_OF_THE_GIANT_FLAG, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(STATUE_OF_THE_GIANT_FLAG, ByteOp.ASSIGN_FLAG, 2));
                Dais dais = new Dais(screen, 300, 420);
                dais.setFallingTime(60);
                dais.setRise(-1);
                dais.setImage(2);
                dais.setImageX(860);
                dais.setImageY(60);
                dais.setFullWidth();
                dais.setArg8(10);
                dais.setRiseSpeed(60);
                dais.addTests(new TestByteOperation(FlagConstants.INFERNO_VIY_MANTRA_STATUE, ByteOp.FLAG_LT, 2),
                        new TestByteOperation(FlagConstants.WF_EYE_OF_TRUTH, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.INFERNO_VIY_MANTRA_STATUE, ByteOp.ASSIGN_FLAG, 3),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1));
                screen.getObjects().add(dais);
            }
            if(roomIndex == 1 && screenIndex == 1) {
                addCrossOfLight(screen, 560, 860, 4);
                AddObject.addLemezaDetector(screen, 540, 780, 5, 3,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addLaserWall(screen, 140, 120, true, 0)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 1));
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addTablet(screen, 60, 320, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught),
                        FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_FLARE_GUN,
                        new TestByteOperation(FlagConstants.INFERNO_PUZZLE_FLARE_GUN, ByteOp.FLAG_GTEQ, 2));
            }
            if(roomIndex == 6 && screenIndex == 0) {
                addFairyPoint(screen, 300, 160);
            }
            if(roomIndex == 9 && screenIndex == 0) {
                addInfernoSpikesPlatformingPuzzleScreen1(screen);
                addKeyholes(screen);
            }
            if(roomIndex == 9 && screenIndex == 1) {
                addInfernoSpikesPlatformingPuzzleScreen2(screen);
            }
        }
        if(zoneIndex == ZoneConstants.EXTINCTION) {
            addDanceDetectors(screen, getCustomBlockIndex(CustomBlockEnum.Fools2022_DanceDetection));
            if(roomIndex == 3 && screenIndex == 1) {
                addCrossOfLight(screen, 920, 80, -1);
            }
            if(roomIndex == 0 && screenIndex == 0) {
                AddObject.addUseItemDetector(screen, 20, 40, 4, 4, "Magatama Jewel")
                        .addTests(new TestByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 8 && screenIndex == 0) {
                AddObject.addLemezaDetector(screen, 20, 380, 27, 5,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addLemezaDetector(screen, 20, 380, 27, 5,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.ASSIGN_FLAG, 2)));

                AddObject.addLemezaDetector(screen, 480, 300, 8, 9,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addLemezaDetector(screen, 480, 300, 8, 9,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BIRTH_MURAL, ByteOp.ASSIGN_FLAG, 2)));
            }
        }
        if(zoneIndex == ZoneConstants.TWIN_FRONT) {
            if(roomIndex == 0 && screenIndex == 1) {
                addJumpPointObjects(screen, 1000, 440, 3, false, FlagConstants.SCREEN_FLAG_2C);
            }
            if(roomIndex == 1 && screenIndex == 0) {
                addCrossOfLight(screen, 280, 100, -1);
            }
            if(roomIndex == 7 && screenIndex == 1) {
                AddObject.addOneWayDoor(screen, 680, 220, OneWayDoor.EXIT_LEFT);
            }
            if(roomIndex == 9 && screenIndex == 1) {
                addCrossOfLight(screen, 660, 40, 4);
            }
            if(roomIndex == 10 && screenIndex == 1) {
                AddObject.addWarp(screen, 640, 0, 32, 11, 7, 12, 0, 480, 392)
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0));
                AddObject.addUseItemDetector(screen, 640, 220, 32, 10, "Crystal Skull")
                        .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 14 && screenIndex == 0) {
                AddObject.addLemezaDetector(screen, 0, 0, 7, 6,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_A, ByteOp.ADD_FLAG, 1)));
                AddObject.addLemezaDetector(screen, 420, 0, 11, 24,
                        Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.ASSIGN_FLAG, 1)));
                GraphicsTextureDraw wall = new GraphicsTextureDraw(screen, 60, 40);
                wall.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_GTEQ, 1));
                wall.setLayer(-14);
                wall.setImageFile(GraphicsTextureDraw.ImageFile_map);
                wall.setImagePosition(0, 520);
                wall.setImageSize(40, 80);
                wall.setAnimation(0, 1, 4, 1);
                wall.setCollision(HitTile.Solid);
                wall.setMaxAlpha(255);
                wall.setArg23(1);
                screen.getObjects().add(wall);
                GraphicsTextureDraw eye = new GraphicsTextureDraw(screen, 60, 40);
                eye.setLayer(-2);
                eye.setImageFile(GraphicsTextureDraw.ImageFile_map);
                eye.setImagePosition(400, 0);
                eye.setImageSize(40, 40);
                eye.setAnimation(0, 1, 4, 1);
                eye.setMaxAlpha(255);
                eye.setArg23(1);
                screen.getObjects().add(eye);

                AddObject.addEyeOfDivineRetribution(screen, 60, 40);
            }
            if(roomIndex == 16 && screenIndex == 0) {
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_REBIRTH, 520, 180, 0);
            }
        }
        if(zoneIndex == ZoneConstants.ENDLESS) {
            if(roomIndex == 1 && screenIndex == 0) {
                addCrossOfLight(screen, 20, 40, -1);
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_ETERNITY, 560, 40, 0);
            }
            if(roomIndex == 2 && screenIndex == 1) {
                addTablet(screen, 980, 320, -1,
                        getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught),
                        FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_KEY_SWORD,
                        new TestByteOperation(FlagConstants.ENDLESS_PUZZLE_WEAPON_COVER, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 3 && screenIndex == 3) {
                addJumpPointObjects(screen, 2100, 360, 3, true, FlagConstants.SCREEN_FLAG_2C);
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addTablet(screen, 580, 320, -1, BlockConstants.Tablet_Endless_EndureTrials, FlagConstants.TABLET_GLOW_ENDLESS_ENDURE_TRIALS, null);
                addDeathField(screen, 80, 300, -1, 480, 60);
            }
            if(roomIndex == 4 && screenIndex == 2) {
                addTablet(screen, 1280, 320, -1, BlockConstants.Tablet_Endless_EndureTrials, FlagConstants.TABLET_GLOW_ENDLESS_ENDURE_TRIALS, null);
                addDeathField(screen, 1360, 300, -1, 240, 60);
            }
            if(roomIndex == 5 && screenIndex == 3) {
                addFairyPoint(screen, 2500, 240);
            }
        }
        if(zoneIndex == ZoneConstants.SHRINE_FRONT) {
            if(roomIndex == 0 && screenIndex == 0) {
                removeCeilingForEntry(screen);
                addTrueShrineDoor(screen);
            }
            if(roomIndex == 1 && screenIndex == 0) {
                AddObject.addDynamicWall(screen, 560, 380, 3)
                        .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_37, ByteOp.ASSIGN_FLAG, 1));
            }
            if(roomIndex == 5 && screenIndex == 1) {
                addJumpPointObjects(screen, 940, 200, 2, true, FlagConstants.SCREEN_FLAG_2C);
            }
            if(roomIndex == 7 && screenIndex == 0) {
                addJumpPointObjects(screen, 560, 440, 1, false, FlagConstants.SCREEN_FLAG_2C);

                GraphicsTextureDraw platform = new GraphicsTextureDraw(screen, 560, 120);

                platform.setLayer(0);
                platform.setImageFile("map*_1.png");
                platform.setImageX(220);
                platform.setImageY(40);
                platform.setImageWidth(40);
                platform.setImageHeight(20);
                platform.setAnimation(0, 1, 0, 0);
                platform.setCollision(HitTile.Solid);
                platform.setRGBAMax(0, 0, 0, 255);
                platform.setArg23(1);

                screen.getObjects().add(platform);
            }
            if(roomIndex == 8 && screenIndex == 0) {
                addJumpPointObjects(screen, 580, 280, 2, true, FlagConstants.SCREEN_FLAG_2C);
            }
            if(roomIndex == 8 && screenIndex == 1) {
                addFairyPoint(screen, 580, 560);
            }
        }
        if (screen.getZoneIndex() == ZoneConstants.ILLUSION) {
            if(roomIndex == 1 && screenIndex == 0) {
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_DECEIT, 300, 60, 0);
            }
            if(roomIndex == 6 && screenIndex == 0) {
                addTablet(screen, 480, 400, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught),
                        FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_ILLUSION,
                        new TestByteOperation(FlagConstants.ILLUSION_PUZZLE_FAIRY_CLOTHES_CHEST, ByteOp.FLAG_GTEQ, 1));
            }
            if(roomIndex == 7 && screenIndex == 2) {
                addCrossOfLight(screen, 1320, 40, -1);

                addIllusionFloatingItem(screen, 1440, 160, ItemConstants.KNIFE, 0, 1);
                addIllusionFloatingItem(screen, 1560, 240, ItemConstants.ANGEL_SHIELD, 1, 2);
                addIllusionFloatingItem(screen, 1720, 160, ItemConstants.SPAULDER, 2, 3);

                addFairyPoint(screen, 1420, 80);
            }
            if(roomIndex == 8 && screenIndex == 0) {
                AddObject.addLemezaDetector(screen, 20, 300, 21, 8,
                        Arrays.asList(new TestByteOperation(FlagConstants.WF_ANCHOR, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 8 && screenIndex == 1) {
                addIllusionFloatingItem(screen, 380, 880, ItemConstants.PISTOL, 3, 4);
            }
            if(roomIndex == 9 && screenIndex == 0) {
                addIllusionFloatingItem(screen, 460, 80, ItemConstants.DIMENSIONAL_KEY, 4, 5);
            }
            if(roomIndex == 9 && screenIndex == 1) {
                addIllusionFloatingItem(screen, 1080, 320, ItemConstants.FLAIL_WHIP, 5, 0);
            }
        }
        if(zoneIndex == ZoneConstants.GRAVEYARD) {
            addGraveyardWarps(screen, zoneIndex, roomIndex, screenIndex);
            if(roomIndex == 1 && screenIndex == 1) {
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_DEATH, 1020, 20, 3);
            }
            if(roomIndex == 2 && screenIndex == 1) {
                addFairyPoint(screen, 980, 240);
            }
        }
        if(zoneIndex == ZoneConstants.MOONLIGHT) {
            if(roomIndex == 1 && screenIndex == 0) {
                AddObject.addLemezaDetector(screen, 0, 0, 24, 24,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.FLAG_LTEQ, 1),
                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CRYSTAL_SKULL_SECRET, ByteOp.ASSIGN_FLAG, 3),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 4 && screenIndex == 2) {
                AddObject.addUseItemDetector(screen, 180, 1080, 4, 4, "Woman Statue")
                        .addTests(new TestByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                AddObject.addUseItemDetector(screen, 180, 1080, 4, 4, "Maternity Statue")
                        .addTests(new TestByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.ELLMAC_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_BIRTH, 380, 1260, 0);
            }
            if(roomIndex == 4 && screenIndex == 3) {
                GraphicsTextureDraw graphicsTextureDraw = new GraphicsTextureDraw(screen, 300, 1860);

                graphicsTextureDraw.setLayer(-1);
                graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_eveg);

                graphicsTextureDraw.setImageX(860);
                graphicsTextureDraw.setImageY(60);
                graphicsTextureDraw.setImageWidth(40);
                graphicsTextureDraw.setImageHeight(20);

                graphicsTextureDraw.setAnimation(0, 1, 0, 0);
                graphicsTextureDraw.setCollision(HitTile.Air);
                graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
                graphicsTextureDraw.setArg23(1);
                screen.getObjects().add(graphicsTextureDraw);

                WarpDoor warpDoor = new WarpDoor(screen, 300, 1840);
                warpDoor.setPressDown();
                warpDoor.setDestination(12, 5, 1, 300, 312);
                screen.getObjects().add(warpDoor);
            }
            if(roomIndex == 5 && screenIndex == 0) {
                addCrossOfLight(screen, 280, 380, -1);
            }
            if(roomIndex == 7 && screenIndex == 0) {
                addMoonlightShopPuzzle(screen);
            }
            if(roomIndex == 9 && screenIndex == 0) {
                AddObject.addOneWayDoor(screen, 620, 220, OneWayDoor.EXIT_LEFT);
            }
            if(roomIndex == 9 && screenIndex == 1) {
                addFairyPoint(screen, 640, 80);
            }
        }
        if(zoneIndex == ZoneConstants.GODDESS) {
            if(roomIndex == 0 && screenIndex == 1) {
                ConversationDoor mulbrukEscapeRegular = new ConversationDoor(screen, 300, 880);
                mulbrukEscapeRegular.setDoorType(ConversationDoor.SingleConversation);
                mulbrukEscapeRegular.setBlockNumber(BlockConstants.Master_MulbrukEscapeRegular);
                mulbrukEscapeRegular.setDisallowMusicChange(true);
                mulbrukEscapeRegular.getTestByteOperations().add(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1));
                mulbrukEscapeRegular.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2));
                mulbrukEscapeRegular.getTestByteOperations().add(new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 1));
                mulbrukEscapeRegular.getTestByteOperations().add(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_EQUALS, 0));
                screen.getObjects().add(mulbrukEscapeRegular);

                ConversationDoor mulbrukEscapeSwimsuit = new ConversationDoor(screen, 300, 880);
                mulbrukEscapeSwimsuit.setDoorType(ConversationDoor.SingleConversation);
                mulbrukEscapeSwimsuit.setBlockNumber(BlockConstants.Master_MulbrukEscapeSwimsuit);
                mulbrukEscapeSwimsuit.setDisallowMusicChange(true);
//                mulbrukEscapeSwimsuit.getTestByteOperations().add(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1));
                mulbrukEscapeSwimsuit.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2));
                mulbrukEscapeSwimsuit.getTestByteOperations().add(new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 1));
                mulbrukEscapeRegular.getTestByteOperations().add(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_EQUALS, 2));
                screen.getObjects().add(mulbrukEscapeSwimsuit);

                ConversationDoor preEscape = new ConversationDoor(screen, 300, 880);
                preEscape.setDoorType(ConversationDoor.SingleConversation);
                preEscape.setBlockNumber(getCustomBlockIndex(CustomBlockEnum.Fools2022_PreEscape));
                preEscape.setDisallowMusicChange(false);
                preEscape.getTestByteOperations().add(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 0));
                preEscape.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2));
                preEscape.getTestByteOperations().add(new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 1));
                preEscape.getTestByteOperations().add(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_EQUALS, 0));
                screen.getObjects().add(preEscape);

                AddObject.addAnimatedDoorCover(mulbrukEscapeRegular, FlagConstants.VIY_GATE_OPEN, false);
                AddObject.addNumberlessBacksideDoorGraphic(preEscape);
            }
            if(roomIndex == 1 && screenIndex == 0) {
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_ASCENSION, 540, 40, -1); // todo: fix layering
            }
//            if(roomIndex == 2 && screenIndex == 0) {
//                AddObject.addLemezaDetector(screen, 180, 40, 23, 22,
//                        Arrays.asList(new TestByteOperation(FlagConstants.MAIL_02, ByteOp.FLAG_EQUALS, 0),
//                                new TestByteOperation(FlagConstants.XELPUD_CONVERSATION_MSX2, ByteOp.FLAG_EQUALS, 0),
//                                new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2)),
//                        Arrays.asList(new WriteByteOperation(FlagConstants.XELPUD_CONVERSATION_MSX2, ByteOp.ASSIGN_FLAG, 1),
//                                new WriteByteOperation(FlagConstants.MAIL_02, ByteOp.ASSIGN_FLAG, 1),
//                                new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
//            }
            if(roomIndex == 7 && screenIndex == 1) {
                addCrossOfLight(screen, 1180, 40, -1);
            }
        }
        if(zoneIndex == ZoneConstants.RUIN) {
            if(roomIndex == 1 && screenIndex == 1) {
                addCrossOfLight(screen, 920, 100, -1);
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addFairyPoint(screen, 300, 160);
            }
            if(roomIndex == 5 && screenIndex == 0) {
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_NOTHING, 60, 280, 3);

                AddObject.addLemezaDetector(screen, 460, 40, 9, 22,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_ENTRANCE_LEGIT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.RUIN_PUZZLE_ILLUSION_SHORTCUT, ByteOp.FLAG_NOT_EQUAL, 3)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 6 && screenIndex == 0) {
                Dais dais = new Dais(screen, 40, 180);
                dais.setFallingTime(60);
                dais.setRise(-1);
                dais.setImage(2);
                dais.setImageX(860);
                dais.setImageY(60);
                dais.setFullWidth();
                dais.setArg8(10);
                dais.setRiseSpeed(60);
                dais.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_UPPER_SHORTCUT, ByteOp.FLAG_EQUALS, 0))
                        .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_UPPER_SHORTCUT, ByteOp.ASSIGN_FLAG, 1));
                screen.getObjects().add(dais);

                addJumpPointObjects(screen, 200, 440, 3, true, FlagConstants.SCREEN_FLAG_9,
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_UPPER_SHORTCUT, ByteOp.FLAG_EQUALS, 1));

                // Cheat detection - zipping up from grail tablet to medicine area
                AddObject.addLemezaDetector(screen, 0, 380, 20, 5,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_UPPER_SHORTCUT, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addLemezaDetector(screen, 0, 380, 20, 5,
                        Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_RUIN_UPPER_SHORTCUT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
            }
        }
        if(zoneIndex == ZoneConstants.BIRTH_SWORDS) {
//            if(roomIndex == 1 && screenIndex == 1) {
//                Ladder obj = new Ladder(screen, 1240, 380);
//                obj.setExtendDirection(Ladder.FromTop);
//                obj.setHeight(6);
//                obj.setGraphicsFromMapPng();
//                obj.setArg3(0);
//                obj.setImageX(0);
//                obj.setImageY(800);
//                obj.setStandardLadder();
//                obj.setArg7(1);
//                obj.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1));
//                screen.getObjects().add(obj);
//            }
            if(roomIndex == 0 && screenIndex == 1) {
                addFairyPoint(screen, 300, 240);
            }
            if(roomIndex == 2 && screenIndex == 0) {
                GraphicsTextureDraw graphicsTextureDraw = new GraphicsTextureDraw(screen, 220, 360);
                graphicsTextureDraw.setLayer(-1);
                graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_map);
                graphicsTextureDraw.setImagePosition(80, 40);
                graphicsTextureDraw.setImageSize(100, 20);
                graphicsTextureDraw.setAnimation(0, 1, 0, 0);
                graphicsTextureDraw.setCollision(HitTile.Solid);
                graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
                graphicsTextureDraw.setArg23(1);
                screen.getObjects().add(graphicsTextureDraw);
            }
            if(roomIndex == 3 && screenIndex == 0) {
                addJumpPointObjects(screen, 20, 440, 3, true, FlagConstants.SCREEN_FLAG_2C);
                AddObject.addLemezaDetector(screen, 180, 140, 2, 4,
                        Arrays.asList(new TestByteOperation(FlagConstants.BIRTH_MURAL_INSIDE_VISIBLE, ByteOp.FLAG_EQUALS, 0)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.BIRTH_MURAL_INSIDE_VISIBLE, ByteOp.ASSIGN_FLAG, 1)));
            }
            if(roomIndex == 0 && screenIndex == 1) {
                AddObject.addUseItemDetector(screen, 280, 840, 4, 4, "Magatama Jewel")
                        .addTests(new TestByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.WF_BRONZE_MIRROR, ByteOp.FLAG_EQUALS, 2))
                        .addUpdates(new WriteByteOperation(FlagConstants.PALENQUE_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                                new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
            }
        }
        if(zoneIndex == ZoneConstants.BIRTH_SKANDA) {
            if(roomIndex == 2 && screenIndex == 0) {
                addFairyPoint(screen, 120, 240);
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addMantraRecitedIndicator(screen, zoneIndex, FlagConstants.CUSTOM_MANTRAS_LIFE, 280, 120, 0);
            }
            if(roomIndex == 4 && screenIndex == 2) {
                addCrossOfLight(screen, 1280, 80, -1);
            }
        }
        if(zoneIndex == ZoneConstants.DIMENSIONAL) {
            if(roomIndex == 0 && screenIndex == 0) {
                addFairyPoint(screen, 300, 400);
            }
            if(roomIndex == 1 && screenIndex == 0) {
                addFairyPoint(screen, 380, 240);
            }
            if(roomIndex == 4 && screenIndex == 0) {
                addFairyPoint(screen, 260, 80);
            }
            if(roomIndex == 5 && screenIndex == 1) {
                addFairyPoint(screen, 180, 720);
            }
            if(roomIndex == 8 && screenIndex == 0) {
                addFairyPoint(screen, 100, 240);
            }
            if(roomIndex == 9 && screenIndex == 0) {
                addCrossOfLight(screen, 280, 40, -1);
            }
        }
        if(zoneIndex == ZoneConstants.DIMENSIONAL && roomIndex == 9 && screenIndex == 0) {
            addCrossOfLight(screen, 280, 40, -1);
        }
        if(zoneIndex == ZoneConstants.SHRINE_BACK) {
//            if(roomIndex == 3 && screenIndex == 0) {
//                // Mother ankh room
//            }
            if(roomIndex == 8 && screenIndex == 1) {
                addFairyPoint(screen, 580, 560);
            }
        }
        if(zoneIndex == ZoneConstants.RETRO_MAUSOLEUM) {
            if(roomIndex == 1 && screenIndex == 0) {
                addFutoPuzzleObjects(screen, 140, 340, FlagConstants.SCREEN_FLAG_9, "Migera".equals(Settings.getCurrentGiant()));
                addFutoPuzzleObjects(screen, 340, 340, FlagConstants.SCREEN_FLAG_8, "Fut".equals(Settings.getCurrentGiant()));
            }
            if(roomIndex == 1 && screenIndex == 1) {
                addFutoPuzzleObjects(screen, 1040, 340, FlagConstants.SCREEN_FLAG_9, "Bud".equals(Settings.getCurrentGiant()));
            }
            if(roomIndex == 1 && screenIndex == 2) {
                addFutoPuzzleObjects(screen, 1640, 340, FlagConstants.SCREEN_FLAG_9, "Led".equals(Settings.getCurrentGiant()));
            }
            if(roomIndex == 2 && screenIndex == 0) {
                addFutoPuzzleObjects(screen, 360, 420, FlagConstants.SCREEN_FLAG_9, "Zeb".equals(Settings.getCurrentGiant()));
            }
        }
        if(zoneIndex == ZoneConstants.RETRO_GUIDANCE && roomIndex == 4 && screenIndex == 0) {
            addFairyPoint(screen, 160, 320);
        }
        if(zoneIndex == ZoneConstants.HT_2 && roomIndex == 1 && screenIndex == 0) {
            addFairyPoint(screen, 600, 400);
        }
        if(zoneIndex == ZoneConstants.BURNING_CAVERN && roomIndex == 0 && screenIndex == 0) {
            addTablet(screen, 20, 80, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught), FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN, null);

            addTablet(screen, 580, 80, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught), FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_GLOW, new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_BURNING_CAVERN_2_SPAWN, ByteOp.FLAG_EQUALS, 2));
        }
    }

    private void addMoonlightShopPuzzle(Screen screen) {
        GraphicsTextureDraw graphicsTextureDraw = new GraphicsTextureDraw(screen, 160, 360);
        graphicsTextureDraw.setLayer(-1);
        graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_map);
        graphicsTextureDraw.setImagePosition(0, 80);
        graphicsTextureDraw.setImageSize(160, 20);
        graphicsTextureDraw.setAnimation(0, 1, 0, 0);
        graphicsTextureDraw.setCollision(HitTile.Solid);
        graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
        graphicsTextureDraw.setArg23(1);
        screen.getObjects().add(graphicsTextureDraw);
        graphicsTextureDraw = new GraphicsTextureDraw(screen, 320, 360);
        graphicsTextureDraw.setLayer(-1);
        graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_map);
        graphicsTextureDraw.setImagePosition(0, 80);
        graphicsTextureDraw.setImageSize(160, 20);
        graphicsTextureDraw.setAnimation(0, 1, 0, 0);
        graphicsTextureDraw.setCollision(HitTile.Solid);
        graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
        graphicsTextureDraw.setArg23(1);
        screen.getObjects().add(graphicsTextureDraw);
        graphicsTextureDraw = new GraphicsTextureDraw(screen, 480, 360);
        graphicsTextureDraw.setLayer(-1);
        graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_map);
        graphicsTextureDraw.setImagePosition(0, 80);
        graphicsTextureDraw.setImageSize(140, 20);
        graphicsTextureDraw.setAnimation(0, 1, 0, 0);
        graphicsTextureDraw.setCollision(HitTile.Solid);
        graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
        graphicsTextureDraw.setArg23(1);
        screen.getObjects().add(graphicsTextureDraw);

        GameObject sonic = new GameObject(screen);
        sonic.setX(580);
        sonic.setY(400);
        sonic.setId(ObjectIdConstants.Enemy_Sonic);
        sonic.getArgs().add((short)0);
        sonic.getArgs().add((short)3);
        sonic.getArgs().add((short)0);
        sonic.getArgs().add((short)1);
        sonic.getArgs().add((short)0);
        sonic.getArgs().add((short)0);
        sonic.getArgs().add((short)0);
        screen.getObjects().add(sonic);

        PressurePlate pressurePlate = AddObject.addPressurePlate(screen, 160, 440);
        pressurePlate.setDetectionType(PressurePlate.Detection_Enemy);
        pressurePlate.addUpdates(
                new WriteByteOperation(FlagConstants.MOONLIGHT_SHOP_LASER_WALL, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.MOONLIGHT_SHOP_LASER_WALL, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.MOONLIGHT_SHOP_LASER_WALL, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
        screen.getObjects().add(pressurePlate);

        pressurePlate = AddObject.addPressurePlate(screen, 60, 280);
        pressurePlate.addUpdates(
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
        screen.getObjects().add(pressurePlate);

        pressurePlate = AddObject.addPressurePlate(screen, 120, 280);
        pressurePlate.addUpdates(
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(pressurePlate);

        DynamicWall dynamicWall = new DynamicWall(screen, 560, 380);
        dynamicWall.setGraphicsFromZone(screen.getZoneIndex());
        dynamicWall.setHeight(3);
        dynamicWall.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(dynamicWall);

        dynamicWall = new DynamicWall(screen, 480, 380);
        dynamicWall.setGraphicsFromZone(screen.getZoneIndex());
        dynamicWall.setHeight(3);
        dynamicWall.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(dynamicWall);

        dynamicWall = new DynamicWall(screen, 400, 380);
        dynamicWall.setGraphicsFromZone(screen.getZoneIndex());
        dynamicWall.setHeight(3);
        dynamicWall.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(dynamicWall);

        dynamicWall = new DynamicWall(screen, 320, 380);
        dynamicWall.setGraphicsFromZone(screen.getZoneIndex());
        dynamicWall.setHeight(3);
        dynamicWall.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(dynamicWall);

        dynamicWall = new DynamicWall(screen, 240, 380);
        dynamicWall.setGraphicsFromZone(screen.getZoneIndex());
        dynamicWall.setHeight(3);
        dynamicWall.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 0),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(dynamicWall);
    }

    private void addTrueShrineDoor(Screen screen) {
        GraphicsTextureDraw backupShrineDoorGraphic = new GraphicsTextureDraw(screen, 320, 40);

        backupShrineDoorGraphic.setLayer(-1);
        backupShrineDoorGraphic.setImageFile("01effect.png");
        backupShrineDoorGraphic.setImageX(0);
        backupShrineDoorGraphic.setImageY(512);
        backupShrineDoorGraphic.setImageWidth(80);
        backupShrineDoorGraphic.setImageHeight(80);
        backupShrineDoorGraphic.setAnimation(0, 0, 1, 0);
        backupShrineDoorGraphic.setCollision(HitTile.Air);
        backupShrineDoorGraphic.setRGBAMax(0, 0, 0, 255);
        backupShrineDoorGraphic.setArg23(1);
        backupShrineDoorGraphic.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1));

        screen.getObjects().add(backupShrineDoorGraphic);

        GraphicsTextureDraw doorNumberGraphic = new GraphicsTextureDraw(screen, 320, 40);

        doorNumberGraphic.setLayer(0);
        doorNumberGraphic.setImageFile("01effect.png");
        doorNumberGraphic.setImageX(500);
        doorNumberGraphic.setImageY(592);
        doorNumberGraphic.setImageWidth(50);
        doorNumberGraphic.setImageHeight(36);
        doorNumberGraphic.setAnimation(0, 0, 1, 0);
        doorNumberGraphic.setCollision(HitTile.Air);
        doorNumberGraphic.setRGBAMax(0, 0, 0, 255);
//        doorNumberGraphic.setArg23(1);
        doorNumberGraphic.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1));

        screen.getObjects().add(doorNumberGraphic);

        WarpDoor warpDoor = AddObject.addWarpDoor(screen, 340, 80,18, 0, 0, 340, 92,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_GATE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1)));
//        AddObject.addBossNumberGraphicV2(warpDoor, 8, null);

        AddObject.addAnimatedDoorTimerAndSound(screen, new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_EQUALS, TOTAL_MANTRAS), FlagConstants.CUSTOM_FOOLS2022_MOTHER_GATE, false)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1));;
        AddObject.addAnimatedDoorCover(warpDoor, FlagConstants.CUSTOM_FOOLS2022_MOTHER_GATE, false)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1));;
    }

    private void removeCeilingForEntry(Screen screen) {
        GraphicsTextureDraw graphicsTextureDraw = new GraphicsTextureDraw(screen, 240, 0);

        graphicsTextureDraw.setLayer(-1);
        graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_00item);

        graphicsTextureDraw.setImageX(0);
        graphicsTextureDraw.setImageY(800);
        graphicsTextureDraw.setImageWidth(80);
        graphicsTextureDraw.setImageHeight(40);

        graphicsTextureDraw.setAnimation(0, 1, 0, 0);
        graphicsTextureDraw.setCollision(HitTile.Air_ReplacesSolid);
        graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
        graphicsTextureDraw.setArg23(1);
        screen.getObjects().add(graphicsTextureDraw);
    }

    private Crusher addCrusher(Screen screen, int x, int y) { // screen 1, 6, 0 but probably only at night?
        int animateDuration = 300; // 5 seconds * 60 frames per second
        Crusher crusher = new Crusher(screen, x, y);

        crusher.setExtendDirection(Crusher.ExtendDirection_Down);

        crusher.setWidth(6);
        crusher.setExtendedLength(10);
        crusher.setMinLength(0);

        crusher.setExtend(0, 40, 40, 400);
        crusher.setRetract(60, 40, 40, 400);

        crusher.setLayer(-1);
        crusher.setCrusherCollision(Crusher.HitTile_Solid);

        crusher.setImageFile(Crusher.ImageFile_map);
        crusher.setImagePosition(800, 800);
        crusher.setImageSize(120, 200);

        crusher.setUpdate1DelayFrames(0);
        crusher.setUpdate2DelayFrames(0);

        crusher.setExtendSound(SoundEffect.ShellHornSuccess, animateDuration, 127, 400);
        crusher.setRetractSound(SoundEffect.ShellHornSuccess, animateDuration, 127, 0);

        screen.getObjects().add(crusher);
        return crusher;
    }

    private void addWedge(Screen screen, int x, int y, int bossNumber) { // screen 1, 6, 0 but probably only at night?
        GraphicsTextureDraw wedge = new GraphicsTextureDraw(screen, x, y);

        wedge.setLayer(-1);
        wedge.setImageFile(GraphicsTextureDraw.ImageFile_map);

        wedge.setImageX(0 + (bossNumber - 1) * 100);
        wedge.setImageY(800);
        wedge.setImageWidth(100);
        wedge.setImageHeight(100);

        wedge.setAnimation(0, 1, 0, 0);
        wedge.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
        wedge.setEntryEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
        wedge.setCollision(HitTile.Air);
        wedge.setRGBAMax(0, 0, 0, 255);
        wedge.setArg23(1);

        wedge.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_10 + bossNumber - 1, ByteOp.FLAG_EQUALS, 1));
        screen.getObjects().add(wedge);
    }

    private void updateAutosaves() {
        for(GameObject autosave : rcdFileData.getObjectsById(ObjectIdConstants.Autosave)) {
            if(autosave.getTestByteOperations().size() < 4) {
                autosave.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.FLAG_EQUALS, 0));
            }
        }
    }

    private void updateBossCountTimers() {
        for(GameObject flagTimer : rcdFileData.getObjectsById(ObjectIdConstants.FlagTimer)) {
            if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.ADD_FLAG, 1))) {
                for(WriteByteOperation writeByteOperation : flagTimer.getWriteByteOperations()) {
                    if(writeByteOperation.getIndex() == FlagConstants.SCORE) {
                        writeByteOperation.setIndex(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD);
                        writeByteOperation.setOp(ByteOp.ADD_FLAG);
                        writeByteOperation.setValue(1);
                    }
                }
            }
            if(flagTimer.hasUpdate(new WriteByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.ASSIGN_FLAG, 9))) {
                if(flagTimer.getWriteByteOperations().size() > 1) {
                    flagTimer.removeUpdate(new WriteByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.ASSIGN_FLAG, 9));
                }
            }
        }
    }

    private void fixGateOfTimeAndNightSurfaceDoors() {
        // For some reason (timing of backside door randomization?) this doesn't seem to want to cooperate so we'll adjust here
        for(GameObject warpDoor : rcdFileData.getScreen(ZoneConstants.EXTINCTION, 7, 0).getObjectsById(ObjectIdConstants.WarpDoor)) {
            warpDoor.addTests(new TestByteOperation(FlagConstants.KEY_FAIRY_DOOR_UNLOCKED, ByteOp.FLAG_EQUALS, 1));
        }
        for(GameObject graphicsTextureDraw : rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 8, 0).getObjectsById(ObjectIdConstants.GraphicsTextureDraw)) {
            graphicsTextureDraw.getArgs().set(1, (short)GraphicsTextureDraw.ImageFile_map);
            graphicsTextureDraw.getArgs().set(2, (short)0);
            graphicsTextureDraw.getArgs().set(3, (short)900);
        }
    }

    private void updateTransitionGates() {
        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.TransitionGate)) {
            if(gameObject.removeTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_EQUALS, 9))) {
                gameObject.addTests(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_GTEQ, 9));
            }
            if(gameObject.removeTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_NOT_EQUAL, 9))) {
                gameObject.addTests(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_LT, 9));
            }
            // No transitions lead to true shrine except the one in the mother ankh room
            if(gameObject.getArgs().get(0) == ZoneConstants.SHRINE_BACK) {
                Screen screen = (Screen)gameObject.getObjectContainer();
                if(screen.getZoneIndex() != ZoneConstants.SHRINE_BACK) {
                    gameObject.getArgs().set(0, (short)ZoneConstants.SHRINE_FRONT);
                }
            }
        }
    }

    private void updateForHT() {
        Screen mulbrukScreen = rcdFileData.getScreen(ZoneConstants.SUN, 3, 0);
        AddObject.addFramesTimer(mulbrukScreen, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.MULBRUK_CONVERSATION_HT, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_GTEQ, 8),
                        new TestByteOperation(FlagConstants.HT_UNLOCK_PROGRESS_EARLY, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS)),
                Arrays.asList(new WriteByteOperation(FlagConstants.HT_UNLOCK_PROGRESS_EARLY, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addFramesTimer(mulbrukScreen, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.FLAG_GTEQ, 7),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MULBRUK_ARMOR, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MULBRUK_ARMOR, ByteOp.ASSIGN_FLAG, 2)));

        Screen htUnlockScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 1, 0);
        for(GameObject conversationDoor : htUnlockScreen.getObjectsById(ObjectIdConstants.ConversationDoor)) {
            conversationDoor.removeTest(new TestByteOperation(FlagConstants.HT_UNLOCK_CHAIN_PRIMARY, ByteOp.FLAG_EQUALS, 8));
            conversationDoor.addTests(new TestByteOperation(FlagConstants.HT_UNLOCK_PROGRESS_EARLY, ByteOp.FLAG_GTEQ, 2),
                    new TestByteOperation(FlagConstants.HT_UNLOCK_CHAIN_PRIMARY, ByteOp.FLAG_LTEQ, 8));
        }
        addJumpPointObjects(htUnlockScreen, 500, 200, 3, true, FlagConstants.SCREEN_FLAG_12,
                new TestByteOperation(FlagConstants.HT_UNLOCK_PROGRESS_EARLY, ByteOp.FLAG_GTEQ, 2),
                new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_ASCENSION, ByteOp.FLAG_GTEQ, 2),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0));
        AddObject.addMantraDetector(htUnlockScreen, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.HT_UNLOCK_PROGRESS_EARLY, ByteOp.FLAG_GTEQ, 2),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_ASCENSION, ByteOp.FLAG_GTEQ, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));

        Screen h1 = rcdFileData.getScreen(ZoneConstants.HT_1, 3, 0);
        AddObject.addMantraDetector(h1, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.ASSIGN_FLAG, 1));
        Screen h2 = rcdFileData.getScreen(ZoneConstants.HT_1, 7, 0);
        AddObject.addMantraDetector(h2, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.ASSIGN_FLAG, 1));
        Screen h3 = rcdFileData.getScreen(ZoneConstants.HT_1, 11, 0);
        AddObject.addMantraDetector(h3, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.ASSIGN_FLAG, 1));
        Screen h4 = rcdFileData.getScreen(ZoneConstants.HT_1, 16, 0);
        AddObject.addMantraDetector(h4, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.ASSIGN_FLAG, 1));
        Screen h5 = rcdFileData.getScreen(ZoneConstants.HT_1, 17, 0);
        AddObject.addMantraDetector(h5, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.ROOM_FLAG_32, ByteOp.ASSIGN_FLAG, 1));

        Screen htBoss = rcdFileData.getScreen(ZoneConstants.HT_1, 22, 1);
        addFairyPoint(htBoss, 940, 400);
        for(GameObject animation : htBoss.getObjectsById(ObjectIdConstants.Animation)) {
            if(animation.getArgs().get(7) == 100) {
                animation.getArgs().set(7, (short)0);
            }
        }

        Screen htEntrance = rcdFileData.getScreen(ZoneConstants.HT_1, 0, 0);
        htEntrance.getScreenExit(ScreenExit.DOWN).setDestination(-1, -1, -1);
        for(GameObject warpDoor : htEntrance.getObjectsById(ObjectIdConstants.WarpDoor)) {
            if(warpDoor.hasTest(new TestByteOperation(FlagConstants.HT_PHANTOM_TABLET, ByteOp.FLAG_EQUALS, 6))) {
                warpDoor.getTestByteOperations().clear();
                setWarpDoorDestination(warpDoor, 23, 19, 0, 300, 240);
            }
        }
        for(GameObject scannable : htEntrance.getObjectsById(ObjectIdConstants.Scannable)) {
            scannable.getTestByteOperations().clear();
            scannable.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_GRAIL, ByteOp.FLAG_EQUALS, 0));
            scannable.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_GRAIL, ByteOp.ASSIGN_FLAG, 1));
        }
        htEntrance.getObjects().add(new SavePoint(htEntrance, 300, 160).addTests(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 0)));
        AddObject.addAutosave(htEntrance, 300, 160, BlockConstants.MegaTablet_HT_Entrance,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_GRAIL, ByteOp.FLAG_EQUALS, 1)),
                new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_GRAIL, ByteOp.ASSIGN_FLAG, 1));
        addTablet(htEntrance, 140, 400, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_HT_Shortcut1), FlagConstants.CUSTOM_FOOLS2022_HT_GLOW_1,
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_1, ByteOp.FLAG_EQUALS, 1));
        AddObject.addWarpDoor(htEntrance, 140, 400, ZoneConstants.HT_1, 5, 1, 260, 72,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_1, ByteOp.FLAG_EQUALS, 1)));
        addTablet(htEntrance, 300, 400, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_HT_Shortcut2), FlagConstants.CUSTOM_FOOLS2022_HT_GLOW_2,
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_2, ByteOp.FLAG_EQUALS, 1));
        AddObject.addWarpDoor(htEntrance, 300, 400, ZoneConstants.HT_1, 8, 1, 300, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_2, ByteOp.FLAG_EQUALS, 1))).setPressDown();
        addTablet(htEntrance, 460, 400, -1, getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_HT_Shortcut3), FlagConstants.CUSTOM_FOOLS2022_HT_GLOW_3,
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_3, ByteOp.FLAG_EQUALS, 1));
        AddObject.addWarpDoor(htEntrance, 460, 400, ZoneConstants.HT_1, 18, 1, 60, 80,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_3, ByteOp.FLAG_EQUALS, 1)));

        Screen htDarkRoom = rcdFileData.getScreen(ZoneConstants.HT_1, 10, 1);
        AddObject.addMantraDetector(htDarkRoom, ETERNITY_FIRE)
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 2));

        Screen htAmphisRoom = rcdFileData.getScreen(ZoneConstants.HT_1, 4, 1);
        AddObject.addMantraDetector(htAmphisRoom, DECEIT)
                .addTests(new TestByteOperation(FlagConstants.HT_SOLVED_ROOM5, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.HT_SOLVED_ROOM5, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));

        Screen htFistRoom = rcdFileData.getScreen(ZoneConstants.HT_2, 0, 1);
        AddObject.addMantraDetector(htFistRoom, BIRTH_SLAP)
                .addTests(new TestByteOperation(FlagConstants.HT_SOLVED_ROOM12, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.HT_SOLVED_ROOM12, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));

        Screen htBombRoom = rcdFileData.getScreen(ZoneConstants.HT_1, 5, 1);
        AddObject.addFramesTimer(htBombRoom, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_1, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_1, ByteOp.ASSIGN_FLAG, 1)));
        addFairyPoint(htBombRoom, 500, 640);
        AddObject.addWarpDoor(htBombRoom, 260, 560, 23, 0, 0, 140, 400, new ArrayList<>(0));
        addHTDoorGraphic(htBombRoom, 260, 560);

        Screen htShopRoom = rcdFileData.getScreen(ZoneConstants.HT_1, 8, 1);
        AddObject.addFramesTimer(htShopRoom, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_2, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_2, ByteOp.ASSIGN_FLAG, 1)));

        Screen htRoom33 = rcdFileData.getScreen(ZoneConstants.HT_1, 21, 0);
        addJumpPointObjects(htRoom33, 160, 280, 5, true, FlagConstants.SCREEN_FLAG_2C);
        addJumpPointObjects(htRoom33, 440, 280, 5, true, FlagConstants.SCREEN_FLAG_2C);
        AddObject.addMantraDetector(htRoom33, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_2C, ByteOp.ASSIGN_FLAG, 1));
        for(GameObject warpPortal : htRoom33.getObjectsById(ObjectIdConstants.WarpPortal)) {
            warpPortal.getTestByteOperations().clear();
            setWarpPortalDestination(warpPortal, 23, 21, 0, 300, 240);
        }

        Screen htEyeRoom = rcdFileData.getScreen(ZoneConstants.HT_1, 18, 1);
        AddObject.addFramesTimer(htEyeRoom, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_3, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_HT_3, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addWarpDoor(htEyeRoom, 700, 80, 23, 0, 0, 460, 400, new ArrayList<>(0)).setPressDown();
        addHTDoorGraphic(htEyeRoom, 700, 80);

        Screen htTabletRoom = rcdFileData.getScreen(ZoneConstants.HT_1, 19, 0);
        htTabletRoom.getScreenExit(ScreenExit.UP).setDestination(ZoneConstants.HT_1, 0, 0);
    }

    private void addTheftMail(Screen screen) {
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.WF_BIRTH_SEAL, ByteOp.FLAG_EQUALS, 2)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addFramesTimer(screen, MAIL_DELAY_FRAMES,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.MAIL_19, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.WF_BIRTH_SEAL, ByteOp.FLAG_EQUALS, 2)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.MAIL_19, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
    }

    private void updateForTabletFlip() {
        Screen tabletFlipScreen = rcdFileData.getScreen(ZoneConstants.BIRTH_SKANDA, 0, 0);
        for(GameObject scannableObj : tabletFlipScreen.getObjectsById(ObjectIdConstants.Scannable)) {
            Scannable scannable = (Scannable)scannableObj;
            if(scannable.getTextBlock() == BlockConstants.Tablet_Birth_ClayDollsBecomeHuman) {
                scannable.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 0));
                if(HolidaySettings.isPreserveCustomTabletGlow()) {
                    // Re-add the removed flag update.
                    scannable.addUpdates(new WriteByteOperation(FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN, ByteOp.ASSIGN_FLAG, 1));
                }
            }
        }
        for(GameObject graphicsObj : tabletFlipScreen.getObjectsById(ObjectIdConstants.GraphicsTextureDraw)) {
            if(graphicsObj.getX() == 40 && graphicsObj.getY() == 80) {
                if(HolidaySettings.isPreserveCustomTabletGlow()) {
                    graphicsObj.removeTest(new TestByteOperation(FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN, ByteOp.FLAG_EQUALS, 0));
                }
                graphicsObj.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 0));
            }
        }

        Scannable newTablet = new Scannable(tabletFlipScreen, 40, 80);
        newTablet.setTextBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_DimensionalExit_Alt));
        newTablet.setArg1(0);
        newTablet.setArg2(0);
        newTablet.setArg3(1);
        newTablet.setArg4(1);
        newTablet.setArg5(1);
        newTablet.setArg6(1);
        newTablet.setArg7(1);
        newTablet.setArg8(1);
        newTablet.setArg9(0);
        newTablet.setDimensions(40, 40);
        newTablet.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_GT, 1));
        if(!HolidaySettings.isPreserveCustomTabletGlow()) {
            newTablet.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_ALT_TABLET_GLOW, ByteOp.ASSIGN_FLAG, 1));
        }
        tabletFlipScreen.getObjects().add(newTablet);

        GraphicsTextureDraw tabletGlowGraphic = new GraphicsTextureDraw(tabletFlipScreen, 40, 80);
        tabletGlowGraphic.setLayer(0);
        tabletGlowGraphic.setImageFile(GraphicsTextureDraw.ImageFile_00item_alt);

        tabletGlowGraphic.setImageX(820);
        tabletGlowGraphic.setImageY(560);
        tabletGlowGraphic.setImageWidth(40);
        tabletGlowGraphic.setImageHeight(40);

        tabletGlowGraphic.setAnimation(1, 1, 4, 0);
        tabletGlowGraphic.setExitEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
        tabletGlowGraphic.setCycleColors(true);
        tabletGlowGraphic.setCollision(HitTile.Air);
        tabletGlowGraphic.setAlphaPerFrame(0);
        tabletGlowGraphic.setMaxAlpha(255);
        tabletGlowGraphic.setRedPerFrame(20);
        tabletGlowGraphic.setMaxRed(20);
        tabletGlowGraphic.setGreenPerFrame(0);
        tabletGlowGraphic.setMaxGreen(0);
        tabletGlowGraphic.setBluePerFrame(0);
        tabletGlowGraphic.setMaxBlue(0);
        tabletGlowGraphic.setBlendMode(1);
        tabletGlowGraphic.setArg23(0);
        tabletGlowGraphic.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 2));
        tabletGlowGraphic.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ALT_TABLET_GLOW, ByteOp.FLAG_EQUALS, 0));
        tabletFlipScreen.getObjects().add(tabletGlowGraphic);

        GraphicsTextureDraw tabletFlipAnimation = new GraphicsTextureDraw(tabletFlipScreen, 40, 80);
        tabletFlipAnimation.setLayer(-1);
        tabletFlipAnimation.setImageFile(GraphicsTextureDraw.ImageFile_01effect);

        tabletFlipAnimation.setImageX(417);
        tabletFlipAnimation.setImageY(850);
        tabletFlipAnimation.setImageWidth(40);
        tabletFlipAnimation.setImageHeight(40);

        tabletFlipAnimation.setAnimation(1, 6, 6, 1);
        tabletFlipAnimation.setEntryEffect(GraphicsTextureDraw.EntryEffect_Animate);
        tabletFlipAnimation.setCycleColors(false);
        tabletFlipAnimation.setCollision(HitTile.Air);
        tabletFlipAnimation.setAlphaPerFrame(0);
        tabletFlipAnimation.setMaxAlpha(255);
        tabletFlipAnimation.setRedPerFrame(0);
        tabletFlipAnimation.setMaxRed(0);
        tabletFlipAnimation.setGreenPerFrame(0);
        tabletFlipAnimation.setMaxGreen(0);
        tabletFlipAnimation.setBluePerFrame(0);
        tabletFlipAnimation.setMaxBlue(0);
        tabletFlipAnimation.setBlendMode(0);
        tabletFlipAnimation.setArg23(1);
        tabletFlipAnimation.addTests(new TestByteOperation(FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN, ByteOp.FLAG_EQUALS, 1));
        tabletFlipAnimation.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_GT, 0));
        tabletFlipAnimation.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 1));
        tabletFlipAnimation.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.ASSIGN_FLAG, 2));
        tabletFlipScreen.getObjects().add(tabletFlipAnimation);

        SoundEffect tabletFlipSoundEffect = new SoundEffect(tabletFlipScreen);
        tabletFlipSoundEffect.setSoundEffect(41);
        tabletFlipSoundEffect.setVolume(127, 127, 0);
        tabletFlipSoundEffect.setBalance(64, 64, 0);
        tabletFlipSoundEffect.setPitch(0, 30, 0);
        tabletFlipSoundEffect.setPriority(15);
        tabletFlipSoundEffect.setRumbleStrength(10);

        tabletFlipSoundEffect.getTestByteOperations().add(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 1));

        tabletFlipScreen.getObjects().add(0, tabletFlipSoundEffect);

        // Initiate tablet flip
        AddObject.addFramesTimer(tabletFlipScreen, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_GT, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 1)));

        // Skip tablet flip
        AddObject.addFramesTimer(tabletFlipScreen, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_GT, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.ASSIGN_FLAG, 2)));

        // End tablet flip
        AddObject.addFramesTimer(tabletFlipScreen, 6,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TABLET_FLIP, ByteOp.ASSIGN_FLAG, 2)));

    }

    private void updateForPacifistTracking() {
        int wallBreakFlag = FlagConstants.CUSTOM_FOOLS2022_MISC_VANDALISM;
        int potBreakFlag = FlagConstants.CUSTOM_FOOLS2022_MISC_VANDALISM;
        int floorBreakFlag = FlagConstants.CUSTOM_FOOLS2022_FLOOR_BREAK;
        WriteByteOperation pacifistSubBossUpdate = new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1);

        Screen htBoss = rcdFileData.getScreen(ZoneConstants.HT_1, 22, 1);
        AddObject.addFramesTimer(htBoss, 0,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.THE_BOSS_STATE, ByteOp.FLAG_GT, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_GT, 0)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));

        addTheftMail(rcdFileData.getScreen(ZoneConstants.SURFACE, 0, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 0, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 0, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.SURFACE, 2, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 2, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.GUIDANCE, 1, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.MAUSOLEUM, 5, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.SUN, 0, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.SPRING, 6, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.INFERNO, 6, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.EXTINCTION, 6, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.TWIN_FRONT, 0, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.TWIN_FRONT, 15, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.ENDLESS, 1, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.SHRINE_FRONT, 7, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.ILLUSION, 4, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.GRAVEYARD, 2, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.MOONLIGHT, 1, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.GODDESS, 7, 1));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.RUIN, 6, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.BIRTH_SKANDA, 0, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.DIMENSIONAL, 0, 0));
        addTheftMail(rcdFileData.getScreen(ZoneConstants.SHRINE_BACK, 7, 0));

        for(GameObject pot : rcdFileData.getObjectsById(ObjectIdConstants.Pot)) {
            pot.addUpdates(new WriteByteOperation(potBreakFlag, ByteOp.ASSIGN_FLAG, 1));
            addPacifistMailTimers(pot.getObjectContainer(), potBreakFlag, FlagConstants.MAIL_13);
        }
        for(GameObject collapsingFloor : rcdFileData.getObjectsById(ObjectIdConstants.CollapsingFloor)) {
            collapsingFloor.addUpdates(new WriteByteOperation(floorBreakFlag, ByteOp.ASSIGN_FLAG, 1));
            addPacifistMailTimers(collapsingFloor.getObjectContainer(), floorBreakFlag, FlagConstants.MAIL_14);
        }
        for(GameObject hitboxObj : rcdFileData.getObjectsById(ObjectIdConstants.Hitbox)) {
            Hitbox hitbox = (Hitbox)hitboxObj;
            if(hitbox.hasUpdate(new WriteByteOperation(FlagConstants.SCREEN_FLAG_A, ByteOp.ADD_FLAG, 1))) { // todo: special email for retribution
//                hitbox.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1));
                continue;
            }
            if(hitbox.getBreakableBy() == Hitbox.FlareGun) {
                continue;
            }
            if(hitbox.getBreakableBy() == Hitbox.NotBreakable) {
                continue;
            }

            Screen screen = (Screen)hitbox.getObjectContainer();
            if(screen.getZoneIndex() == ZoneConstants.GUIDANCE) {
                if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
                    if(hitbox.getWriteByteOperations().size() < 4) {
                        hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                        addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                    }
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.MAUSOLEUM) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.SUN) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.SPRING) {
                if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
                    continue;
                }
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.INFERNO) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.EXTINCTION) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.TWIN_FRONT) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.ENDLESS) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.SHRINE_FRONT) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.ILLUSION) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.GRAVEYARD) {
                if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.MOONLIGHT) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.GODDESS) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.RUIN) {
                if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
                    continue;
                }
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.BIRTH_SWORDS) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.BIRTH_SKANDA) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.DIMENSIONAL) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.SHRINE_BACK) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.RETRO_MAUSOLEUM) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
            if(screen.getZoneIndex() == ZoneConstants.RETRO_GUIDANCE) {
                // There are a bunch of hitboxes here that don't do anything, it's really weird.
                continue;
            }
            if(screen.getZoneIndex() == ZoneConstants.RETRO_SURFACE) {
                if(hitbox.getWriteByteOperations().size() < 4) {
                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
                    addPacifistMailTimers(hitbox.getObjectContainer(), wallBreakFlag, FlagConstants.MAIL_13);
                }
            }
//            if(screen.getZoneIndex() == ZoneConstants.HT_1 || screen.getZoneIndex() == ZoneConstants.HT_2) {
//                if(hitbox.getWriteByteOperations().size() < 4) {
//                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
//                }
//            }
//            if(screen.getZoneIndex() == ZoneConstants.BURNING_CAVERN) {
//                if(hitbox.getWriteByteOperations().size() < 4) {
//                    hitbox.addUpdates(new WriteByteOperation(wallBreakFlag, ByteOp.ASSIGN_FLAG, 1));
//                }
//            }
        }
        Screen nuckelaveeScreen = rcdFileData.getScreen(ZoneConstants.SPRING, 5, 1);
        AddObject.addFramesTimer(nuckelaveeScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.NUCKELAVEE_STATE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(pacifistSubBossUpdate)));
        Screen oxHeadHorseFaceScreen = rcdFileData.getScreen(ZoneConstants.EXTINCTION, 1, 0);
        AddObject.addFramesTimer(oxHeadHorseFaceScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.OX_HEAD_HORSE_FACE_STATE, ByteOp.FLAG_GTEQ, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(pacifistSubBossUpdate)));
        Screen kamaitachiScreen = rcdFileData.getScreen(ZoneConstants.GRAVEYARD, 6, 0);
        AddObject.addFramesTimer(kamaitachiScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.KAMAITACHI_STATE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_C, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(pacifistSubBossUpdate)));
    }

    private void addPacifistMailTimers(ObjectContainer objectContainer, int wallBreakFlag, int mailFlag) {
        for(GameObject flagTimer : ((Screen)objectContainer).getObjectsById(ObjectIdConstants.FlagTimer)) {
            if(flagTimer.hasTest(new TestByteOperation(wallBreakFlag, ByteOp.FLAG_GTEQ, 1))
                    && flagTimer.hasUpdate(new WriteByteOperation(mailFlag, ByteOp.ASSIGN_FLAG, 1))) {
                return;
            }
        }
        AddObject.addFramesTimer(objectContainer, 0,
                Arrays.asList(new TestByteOperation(wallBreakFlag, ByteOp.FLAG_GTEQ, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
        addMailTimer(objectContainer, mailFlag)
                .addTests(new TestByteOperation(wallBreakFlag, ByteOp.FLAG_GTEQ, 1));
    }

    private void moveDimensionalKeyCurse() {
//        Screen featherCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 0, 0);
//        for(GameObject chest : featherCheck.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest pacifism = new Chest(chest);
//            pacifism.setCursed(true);
//            pacifism.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
//            chest.getObjectContainer().getObjects().add(pacifism);
//            ((Chest)chest).setCursed(false);
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
//        }
//        featherCheck = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 0, 0);
//        for(GameObject chest : featherCheck.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest pacifism = new Chest(chest);
//            pacifism.setCursed(true);
//            pacifism.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
//            chest.getObjectContainer().getObjects().add(pacifism);
//            ((Chest)chest).setCursed(false);
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
//        }

        Screen birthPerfumeChestScreen = rcdFileData.getScreen(ZoneConstants.BIRTH_SWORDS, 2, 0);
        for(GameObject chest : birthPerfumeChestScreen.getObjectsById(ObjectIdConstants.Chest)) {
            Chest pacifism = new Chest(chest);
            pacifism.setCursed(false);
            pacifism.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
            chest.getObjectContainer().getObjects().add(pacifism);
            ((Chest)chest).setCursed(true);
            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
        }
    }

//    private void handleShellHornOcarina_Old() {
//        Screen shellHornCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 4, 1);
//        for(GameObject chest : shellHornCheck.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest ocarina = new Chest(chest);
//            ocarina.setDropType(ItemConstants.PHILOSOPHERS_OCARINA + ValueConstants.CHEST_ITEM_OFFSET);
//            ocarina.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 2));
//            ocarina.setEmptyCheck(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            ocarina.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 1));
//            ocarina.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            chest.getObjectContainer().getObjects().add(ocarina);
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 4));
//        }
//        AddObject.addFramesTimer(shellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//
//        Screen belowShellHornCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 4, 2);
//        AddObject.addFramesTimer(belowShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(belowShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//        AddObject.addFramesTimer(belowShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 4),
//                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 1)));
//
//        Screen rightOfShellHornCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 5, 1);
//        AddObject.addFramesTimer(rightOfShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(rightOfShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//        AddObject.addFramesTimer(rightOfShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 4),
//                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 1)));
//
//        shellHornCheck = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 4, 1);
//        for(GameObject chest : shellHornCheck.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest ocarina = new Chest(chest);
//            ocarina.setDropType(ItemConstants.PHILOSOPHERS_OCARINA + ValueConstants.CHEST_ITEM_OFFSET);
//            ocarina.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2));
//            ocarina.setEmptyCheck(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            ocarina.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 1));
//            ocarina.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            chest.getObjectContainer().getObjects().add(ocarina);
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2));
//        }
//        AddObject.addFramesTimer(shellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//
//        belowShellHornCheck = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 4, 2);
//        AddObject.addFramesTimer(belowShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(belowShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//        AddObject.addFramesTimer(belowShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 4),
//                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 1)));
//
//        rightOfShellHornCheck = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 5, 1);
//        AddObject.addFramesTimer(rightOfShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(rightOfShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//        AddObject.addFramesTimer(rightOfShellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 4),
//                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 1)));
//
//        Screen goddessFairyCoinChestScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 2, 0);
//        for(GameObject chest : goddessFairyCoinChestScreen.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest shellHorn = new Chest(chest);
//            shellHorn.setDropType(ItemConstants.SHELL_HORN + ValueConstants.CHEST_ITEM_OFFSET);
//            shellHorn.setEmptyCheck(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2));
//            shellHorn.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 1));
//            shellHorn.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2));
//            chest.getObjectContainer().getObjects().add(shellHorn);
//
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 2));
//            shellHorn.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2));
//        }
//        AddObject.addFramesTimer(goddessFairyCoinChestScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//
//        Screen goddessLeftOfFairyScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 3, 1);
//        AddObject.addFramesTimer(goddessLeftOfFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(goddessLeftOfFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//        AddObject.addFramesTimer(goddessLeftOfFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 4),
//                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 3)));
//
//        Screen goddessBelowFairyScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 2, 1);
//        AddObject.addFramesTimer(goddessBelowFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_LTEQ, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(goddessBelowFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_EQUALS, 3)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 4)));
//        AddObject.addFramesTimer(goddessBelowFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.FLAG_NOT_EQUAL, 4),
//                        new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SHELL_HORN_LOCATION, ByteOp.ASSIGN_FLAG, 3)));
//    }

    private void handleShellHornOcarina() {
//        Screen shellHornCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 4, 1);
//        for(GameObject chest : shellHornCheck.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest ocarina = new Chest(chest);
//            ocarina.setDropType(ItemConstants.PHILOSOPHERS_OCARINA + ValueConstants.CHEST_ITEM_OFFSET);
//            ocarina.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2));
//            ocarina.setEmptyCheck(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            ocarina.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 1));
//            ocarina.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            chest.getObjectContainer().getObjects().add(ocarina);
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2));
//        }
//        AddObject.addFramesTimer(shellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));
//
//        Screen belowShellHornCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 4, 2);
//        Screen rightOfShellHornCheck = rcdFileData.getScreen(ZoneConstants.SURFACE, 5, 2);
//
//
//        shellHornCheck = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 4, 1);
//        for(GameObject chest : shellHornCheck.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest ocarina = new Chest(chest);
//            ocarina.setDropType(ItemConstants.PHILOSOPHERS_OCARINA + ValueConstants.CHEST_ITEM_OFFSET);
//            ocarina.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2));
//            ocarina.setEmptyCheck(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            ocarina.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 1));
//            ocarina.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2));
//            chest.getObjectContainer().getObjects().add(ocarina);
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2));
//        }
//        AddObject.addFramesTimer(shellHornCheck, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));
//
//        Screen goddessLeftOfFairyScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 3, 1);
//        AddObject.addFramesTimer(goddessLeftOfFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));
//        Screen goddessBelowFairyScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 2, 1);
//        AddObject.addFramesTimer(goddessBelowFairyScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));

//        Screen goddessFairyCoinChestScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 2, 0);
//        for(GameObject chest : goddessFairyCoinChestScreen.getObjectsById(ObjectIdConstants.Chest)) {
//            Chest shellHorn = new Chest(chest);
//            shellHorn.setDropType(ItemConstants.SHELL_HORN + ValueConstants.CHEST_ITEM_OFFSET);
//            shellHorn.setEmptyCheck(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2));
//            shellHorn.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.ASSIGN_FLAG, 1));
//            shellHorn.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2));
//            chest.getObjectContainer().getObjects().add(shellHorn);
//
//            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 2));
//            shellHorn.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_NOT_EQUAL, 2));
//        }
//        AddObject.addFramesTimer(goddessFairyCoinChestScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(goddessFairyCoinChestScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(goddessFairyCoinChestScreen, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 0),
//                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SURFACE_SHELL_HORN, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.ASSIGN_FLAG, 2)));
    }

    private void handleMotherAnkhSendoff() {
        final int pseudoAnimationFrames = 100;

        // todo: avoid the bug with out of order mantras
        Screen nightSurfaceWaterfallPeak = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 6, 0);
//        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, BIRTH_SLAP)
//                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 2))
//                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
//        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 3),
//                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0)));
        Crusher motherAnkhRocket = addCrusher(nightSurfaceWaterfallPeak, 40, 0);
        motherAnkhRocket.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_GTEQ, 2));
        motherAnkhRocket.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.ASSIGN_FLAG, 0));

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, DECEIT)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_DECEIT, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 220, 20, 1);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, DEATH)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_DEATH, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 360, 20, 2);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, BIRTH_SLAP)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_BIRTH, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 500, 20, 3);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, ASCENSION)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_ASCENSION, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 220, 140, 4);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, SPAULDER_HOLY_NOTHING)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_NOTHING, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 360, 140, 5);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, LIFE_QUAKE)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_LIFE, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_15, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_15, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 500, 140, 6);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, REBIRTH_WATER)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_REBIRTH, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_16, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_16, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 220, 260, 7);

        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, ETERNITY_FIRE)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_ETERNITY, ByteOp.FLAG_GTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_17, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_18, ByteOp.ADD_FLAG, 1));
        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_17, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ADD_FLAG, 1)));
        addWedge(nightSurfaceWaterfallPeak, 360, 260, 8);

        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 8)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 12),
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.ASSIGN_FLAG, 1)));

//        AddObject.addMantraDetector(nightSurfaceWaterfallPeak, ORIGIN_REALITY)
//                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 11))
//                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 12),
//                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.ASSIGN_FLAG, 1));
//        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 10),
//                        new TestByteOperation(FlagConstants.SCREEN_FLAG_17, ByteOp.FLAG_EQUALS, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 11),
//                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.ASSIGN_FLAG, 1),
//                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0)));


//        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 9),
//                        new TestByteOperation(FlagConstants.SCREEN_FLAG_16, ByteOp.FLAG_EQUALS, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 10),
//                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0)));

        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, pseudoAnimationFrames,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 12),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 13),
                        new WriteByteOperation(FlagConstants.MAIL_08, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
        AddObject.addSecondsTimer(nightSurfaceWaterfallPeak, 1,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 13),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 14)));

//        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 11),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH_GONE, ByteOp.FLAG_EQUALS, 1)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 12)));
        for(GameObject chest : nightSurfaceWaterfallPeak.getObjectsById(ObjectIdConstants.Chest)) {
            Chest secretTreasureOfLife = new Chest(chest);
            secretTreasureOfLife.setX(60);
            secretTreasureOfLife.setY(160);
            secretTreasureOfLife.setDropType(ItemConstants.SECRET_TREASURE_OF_LIFE + ValueConstants.CHEST_ITEM_OFFSET);
            secretTreasureOfLife.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_GTEQ, 13));
            secretTreasureOfLife.setEmptyCheck(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.ASSIGN_FLAG, 2));
            secretTreasureOfLife.setUnlockedCheck(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 14));
            secretTreasureOfLife.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.ASSIGN_FLAG, 1));
            secretTreasureOfLife.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.ASSIGN_FLAG, 2));
            chest.getObjectContainer().getObjects().add(secretTreasureOfLife);
        }

//        AddObject.addFramesTimer(nightSurfaceWaterfallPeak, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.ESCAPE, ByteOp.ASSIGN_FLAG, 1)));
//        GrailToggle grailToggle = new GrailToggle(nightSurfaceWaterfallPeak, false);
//        grailToggle.addTests(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1));
//        nightSurfaceWaterfallPeak.getObjects().add(0, grailToggle);
    }

    private void handleClosedDoors() {
        for(Zone zone : rcdFileData.getZones()) {
            for(Room room : zone.getRooms()) {
                for(Screen screen : room.getScreens()) {
                    if(screen.getZoneIndex() == ZoneConstants.GODDESS && screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
                        continue;
                    }
                    List<Integer> doorsUpdated = new ArrayList<>();
                    for(GameObject conversationDoor : screen.getObjectsById(ObjectIdConstants.ConversationDoor)) {
                        Integer xy = conversationDoor.getX() * 20 + conversationDoor.getY() / 20;
                        if(!doorsUpdated.contains(xy)) {
                            doorsUpdated.add(xy);
                            GraphicsTextureDrawUpdates.addNpcDoorCover((ConversationDoor)conversationDoor,
                                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_GTEQ, 2));
                        }
                        if(conversationDoor.getTestByteOperations().size() < 4) {
                            conversationDoor.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_LT, 2));
                        }
                    }
                }
            }
        }
    }

    private void updateForPacifist() {
        moveDimensionalKeyCurse();
//        handleShellHornOcarina();
        handleMotherAnkhSendoff();
        handleClosedDoors();

        Screen pepperCheckScreen = rcdFileData.getScreen(ZoneConstants.GUIDANCE, 0, 0);
        for(GameObject chest : pepperCheckScreen.getObjectsById(ObjectIdConstants.Chest)) {
            Chest mirai = new Chest(chest);
            mirai.setDropType(ItemConstants.SOFTWARE_MIRAI + ValueConstants.CHEST_ITEM_OFFSET);
            mirai.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
            mirai.setEmptyCheck(new WriteByteOperation(FlagConstants.WF_SOFTWARE_MIRAI, ByteOp.ASSIGN_FLAG, 2));
            mirai.setUpdateWhenOpened(new WriteByteOperation(FlagConstants.WF_SOFTWARE_MIRAI, ByteOp.ASSIGN_FLAG, 1));
            mirai.setUpdateWhenCollected(new WriteByteOperation(FlagConstants.WF_SOFTWARE_MIRAI, ByteOp.ASSIGN_FLAG, 2));
            chest.getObjectContainer().getObjects().add(mirai);
            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
        }

        Screen surfaceXelpudStatue = rcdFileData.getScreen(ZoneConstants.SURFACE, 4, 2);
        AddObject.addLemezaDetector(surfaceXelpudStatue, 0, 1260, 6, 3,
                new ArrayList<>(0),
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS)),
                Arrays.asList(new WriteByteOperation(FlagConstants.NIGHT_SURFACE_WARP, ByteOp.ASSIGN_FLAG, 1)))
                .setInteractionType(5);
        // todo: consider rad pulse because the words that allow time to move forward. also consider rap duels.

        Screen nightSurfaceXelpud = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 2, 1);

        for(GameObject conversationDoor : nightSurfaceXelpud.getObjectsById(ObjectIdConstants.ConversationDoor)) {
            ConversationDoor beforeTalk = new ConversationDoor(conversationDoor);
            beforeTalk.setBlockNumber(getCustomBlockIndex(CustomBlockEnum.Fools2022_XelpudNight_ReferenceBlock));
            beforeTalk.getTestByteOperations().clear();
            beforeTalk.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.FLAG_LT, 2),
                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_LT, 2),
                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_SHRINE_ENTRANCE, ByteOp.FLAG_GTEQ, 1));
            conversationDoor.getObjectContainer().getObjects().add(beforeTalk);

            conversationDoor.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_GTEQ, 2));
        }
        for(GameObject graphicsTextureDraw : nightSurfaceXelpud.getObjectsById(ObjectIdConstants.GraphicsTextureDraw)) {
            if(graphicsTextureDraw.getX() == 820 && graphicsTextureDraw.getY() == 140) {
                GraphicsTextureDraw alt = new GraphicsTextureDraw(graphicsTextureDraw);
                alt.getTestByteOperations().clear();
                alt.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
                graphicsTextureDraw.getObjectContainer().getObjects().add(alt);

                GraphicsTextureDraw alt2 = new GraphicsTextureDraw(graphicsTextureDraw);
                alt2.getTestByteOperations().clear();
                alt2.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_SHRINE_ENTRANCE, ByteOp.FLAG_EQUALS, 0));
                graphicsTextureDraw.getObjectContainer().getObjects().add(alt2);

                graphicsTextureDraw.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_SHRINE_ENTRANCE, ByteOp.FLAG_GTEQ, 1));
            }
        }

        Screen nightSurfaceRuinsEntrance = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 11, 1);
        Crusher crusher = new Crusher(nightSurfaceRuinsEntrance, 1220, 360);
        crusher.setExtendDirection(Crusher.ExtendDirection_Up);
        crusher.setWidth(3);
        crusher.setExtendedLength(6);
        crusher.setExtend(0, 0, 0, 0);
        crusher.setUpdate1DelayFrames(0);
        crusher.setRetract(0, 0, 10, 200);
        crusher.setUpdate2DelayFrames(0);
        crusher.setImageFile(4); // msd room
        crusher.setRoomNumber(22);
        crusher.setImagePosition(0, 0);
        crusher.setImageSize(60, 120);
        crusher.setCrusherCollision(Crusher.HitTile_Solid);
        crusher.setLayer(2);
        crusher.setMinLength(20);
        crusher.setExtendSound(SoundEffect.CrusherMove, 60, 127, 400);
        crusher.setRetractSound(SoundEffect.CrusherMove, 60, 127, 0);
        crusher.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_GTEQ, 2),
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_LTEQ, 13));
        crusher.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SECRET_TREASURE_OF_LIFE, ByteOp.ASSIGN_FLAG, 0));
        nightSurfaceRuinsEntrance.getObjects().add(crusher);

        AddObject.addLemezaDetector(surfaceXelpudStatue, 0, 1260, 6, 3,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS)),
                Arrays.asList(new WriteByteOperation(FlagConstants.NIGHT_SURFACE_WARP, ByteOp.ASSIGN_FLAG, 1)))
                .setInteractionType(5);

//        Screen surfaceSplitGate = rcdFileData.getScreen(ZoneConstants.SURFACE, 11, 0);
//        AddObject.addWarpDoor(surfaceSplitGate, 220, 360, ZoneConstants.SHRINE_FRONT, 3, 0, 300, 340,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1)));
//        AddObject.addMantraDetector(surfaceSplitGate, ORIGIN_REALITY)
//                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS),
//                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
//                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
//        KeyFairySpot surfaceSplitGateKeyFairySpot = new KeyFairySpot(surfaceSplitGate, 220, 360);
//        surfaceSplitGateKeyFairySpot.setWidth(40);
//        surfaceSplitGateKeyFairySpot.setHeight(40);
//        surfaceSplitGateKeyFairySpot.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS),
//                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1));
//        surfaceSplitGateKeyFairySpot.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
//                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
//        surfaceSplitGate.getObjects().add(surfaceSplitGateKeyFairySpot);
//        AddObject.addSuccessSound(surfaceSplitGate, Arrays.asList(
//                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
//                new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
//        AddObject.addFramesTimer(surfaceSplitGate, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 1),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 0)));
//        addMotherMailTracking(surfaceSplitGate);

        Screen surfaceSplitGate = rcdFileData.getScreen(ZoneConstants.SURFACE, 11, 0);
        AddObject.addWarpDoor(surfaceSplitGate, 220, 360, ZoneConstants.SHRINE_FRONT, 3, 0, 300, 340,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_GTEQ, 1)));
        AddObject.addMantraDetector(surfaceSplitGate, ORIGIN_REALITY)
//                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
        KeyFairySpot surfaceSplitGateKeyFairySpot = new KeyFairySpot(surfaceSplitGate, 220, 360);
        surfaceSplitGateKeyFairySpot.setWidth(40);
        surfaceSplitGateKeyFairySpot.setHeight(40);
        surfaceSplitGateKeyFairySpot.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1));
        surfaceSplitGateKeyFairySpot.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
        surfaceSplitGate.getObjects().add(surfaceSplitGateKeyFairySpot);
        AddObject.addSuccessSound(surfaceSplitGate, Arrays.asList(
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
        AddObject.addFramesTimer(surfaceSplitGate, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 0)));
        addMotherMailTracking(surfaceSplitGate);

//        surfaceSplitGate = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 11, 0);
//        AddObject.addWarpDoor(surfaceSplitGate, 220, 360, ZoneConstants.SHRINE_FRONT, 3, 0, 300, 340,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1)));
//        AddObject.addMantraDetector(surfaceSplitGate, ORIGIN_REALITY)
////                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
//                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))
//                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
//        surfaceSplitGateKeyFairySpot = new KeyFairySpot(surfaceSplitGate, 220, 360);
//        surfaceSplitGateKeyFairySpot.setWidth(40);
//        surfaceSplitGateKeyFairySpot.setHeight(40);
//        surfaceSplitGateKeyFairySpot.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
//                new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS),
//                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1));
//        surfaceSplitGateKeyFairySpot.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
//                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
//        surfaceSplitGate.getObjects().add(surfaceSplitGateKeyFairySpot);
//        AddObject.addSuccessSound(surfaceSplitGate, Arrays.asList(
//                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
//                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
//                new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
//        AddObject.addFramesTimer(surfaceSplitGate, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 1),
//                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 0)));
//        AddObject.addFramesTimer(surfaceSplitGate, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
//                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_LT, TOTAL_MANTRAS)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.ASSIGN_FLAG, 2)));
//        AddObject.addFramesTimer(surfaceSplitGate, 0,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 2),
//                        new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS)),
//                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.ASSIGN_FLAG, 3),
//                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
//        addMotherMailTracking(surfaceSplitGate);

        surfaceSplitGate = rcdFileData.getScreen(ZoneConstants.NIGHT_SURFACE, 11, 0);
        AddObject.addWarpDoor(surfaceSplitGate, 220, 360, ZoneConstants.SHRINE_BACK, 3, 0, 300, 340,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_GTEQ, 1)));
        AddObject.addMantraDetector(surfaceSplitGate, ORIGIN_REALITY)
//                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0))
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
        surfaceSplitGateKeyFairySpot = new KeyFairySpot(surfaceSplitGate, 220, 360);
        surfaceSplitGateKeyFairySpot.setWidth(40);
        surfaceSplitGateKeyFairySpot.setHeight(40);
        surfaceSplitGateKeyFairySpot.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1));
        surfaceSplitGateKeyFairySpot.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
        surfaceSplitGate.getObjects().add(surfaceSplitGateKeyFairySpot);
        AddObject.addSuccessSound(surfaceSplitGate, Arrays.asList(
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
        AddObject.addFramesTimer(surfaceSplitGate, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 0)));
        addMotherMailTracking(surfaceSplitGate);

        Screen infernoViyScreen = rcdFileData.getScreen(ZoneConstants.INFERNO, 8, 1);
        for(GameObject roomSpawner : infernoViyScreen.getObjectsById(ObjectIdConstants.RoomSpawner)) {
            roomSpawner.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
        }

        Screen shrineEntrance = rcdFileData.getScreen(ZoneConstants.SHRINE_FRONT, 0, 0);
        for(GameObject graphicsTextureDraw : shrineEntrance.getObjectsById(ObjectIdConstants.GraphicsTextureDraw)) {
            if(graphicsTextureDraw.getX() == 320 && graphicsTextureDraw.getY() == 240) {
                graphicsTextureDraw.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
            }
        }
        AddObject.addFramesTimer(shrineEntrance, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_SHRINE_ENTRANCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_SHRINE_ENTRANCE, ByteOp.ASSIGN_FLAG, 1)));
        addTablet(shrineEntrance, 320, 80, -1,
                getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_Pacifist_SplitGate), FlagConstants.CUSTOM_FOOLS2022_PACIFIST_MOTHER_GATE_HINT_GLOW,
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));

        Screen laptopScreen = rcdFileData.getScreen(ZoneConstants.SHRINE_FRONT, 3, 0);
        AddObject.addWarpDoor(laptopScreen, 300, 400, ZoneConstants.SURFACE, 11, 0, 220, 360,
                Arrays.asList(new TestByteOperation(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1))));

        Screen illusionPotWarpScreen = rcdFileData.getScreen(ZoneConstants.ILLUSION, 7, 2);
        AddObject.addWarpDoor(illusionPotWarpScreen, 1640, 40, ZoneConstants.ILLUSION, 7, 2, 360, 140,
//                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))).setPressDown();
                new ArrayList<>(0)).setPressDown();

        Screen graveyardSnapshotsScreen = rcdFileData.getScreen(ZoneConstants.GRAVEYARD, 9, 0);
        AddObject.addMantraDetector(graveyardSnapshotsScreen, ETERNITY_FIRE)
                .addTests(new TestByteOperation(FlagConstants.GRAVEYARD_WALL_SNAPSHOTS_MURAL, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.GRAVEYARD_WALL_SNAPSHOTS_MURAL, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(graveyardSnapshotsScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.MAIL_02, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.XELPUD_CONVERSATION_MSX2, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.XELPUD_CONVERSATION_MSX2, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_02, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
        for(GameObject snapshotsScan : graveyardSnapshotsScreen.getObjectsById(ObjectIdConstants.SnapshotsScan)) {
            SnapshotsScan pacifist = new SnapshotsScan(snapshotsScan);
            pacifist.setTextCard(getCustomBlockIndex(CustomBlockEnum.Fools2022_GraveyardSnapshotsScan));
            pacifist.setInventoryWord(0);
            pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
            snapshotsScan.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1));
            snapshotsScan.getObjectContainer().getObjects().add(0, pacifist);
        }
        AddObject.addFramesTimer(graveyardSnapshotsScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 0)));

        Screen graveyardLampStationScreen = rcdFileData.getScreen(ZoneConstants.GRAVEYARD, 9, 1);
        AddObject.addFramesTimer(graveyardLampStationScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.GODDESS_STATUE_SHIELD_ANIMATION, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 3),
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addFramesTimer(graveyardLampStationScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.GODDESS_STATUE_SHIELD_ANIMATION, ByteOp.FLAG_GTEQ, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 2)));
        addMailTimer(graveyardLampStationScreen, FlagConstants.MAIL_16)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));

        Screen moonlightShortcutScreen = rcdFileData.getScreen(ZoneConstants.MOONLIGHT, 2, 1);
        AddObject.addLemezaDetector(moonlightShortcutScreen, 920, 380, 18, 5,
                Arrays.asList(
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addWarp(moonlightShortcutScreen, 1240, 380, 2, 3, 12, 0, 1, 60, 392)
                .addTests(
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_EQUALS, 1));

        Screen moonlightPyramidMain = rcdFileData.getScreen(ZoneConstants.MOONLIGHT, 5, 0);
        AddObject.addFramesTimer(moonlightPyramidMain, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 0)));
        WarpDoor warpDoor = new WarpDoor(moonlightPyramidMain, 540, 400);
        warpDoor.setPressDown();
        warpDoor.setDestination(12, 5, 1, 540, 0);
        warpDoor.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0));
        moonlightPyramidMain.getObjects().add(warpDoor);

        Screen moonlightPyramidLower = rcdFileData.getScreen(ZoneConstants.MOONLIGHT, 5, 1);
        AddObject.addFramesTimer(moonlightPyramidLower, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 0)));

        Screen moonlightAlsedanaScreen = rcdFileData.getScreen(ZoneConstants.MOONLIGHT, 6, 0);
        AddObject.addFramesTimer(moonlightAlsedanaScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 1)));

        Screen moonlightPyramidTablet = rcdFileData.getScreen(ZoneConstants.MOONLIGHT, 6, 1);
        for(GameObject lemezaDetector : moonlightPyramidTablet.getObjectsById(ObjectIdConstants.LemezaDetector)) {
            GameObject pacifist = new GameObject(lemezaDetector);
            pacifist.getTestByteOperations().clear();
            pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                    new TestByteOperation(FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE, ByteOp.FLAG_EQUALS, 0));
            pacifist.getWriteByteOperations().clear();

            GameObject cheat = new GameObject(pacifist);
            pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 0));
            cheat.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 1));
            cheat.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 2),
                    new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                    new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.ASSIGN_FLAG, 1));
            cheat.getArgs().set(0, (short)0);
            cheat.getArgs().set(1, (short)0);
            moonlightPyramidTablet.getObjects().add(cheat);

            pacifist.addUpdates(new WriteByteOperation(FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE, ByteOp.ASSIGN_FLAG, 2),
                    new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOONLIGHT_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 3),
                    new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 2));
            moonlightPyramidTablet.getObjects().add(pacifist);

            lemezaDetector.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
        }
        addMailTimer(moonlightPyramidTablet, FlagConstants.MAIL_16)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHEATED, ByteOp.FLAG_GTEQ, 1));

        for(GameObject scannable : moonlightPyramidTablet.getObjectsById(ObjectIdConstants.Scannable)) {
            if(scannable.hasTest(new TestByteOperation(FlagConstants.MOONLIGHT_HIDDEN_TABLET_COLLAPSING_FLOOR, ByteOp.FLAG_EQUALS, 2))) {
                GameObject pacifist = new GameObject(scannable);
                pacifist.getTestByteOperations().clear();
                pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE, ByteOp.FLAG_EQUALS, 2));
                pacifist.getWriteByteOperations().clear();
                pacifist.addUpdates(new WriteByteOperation(FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE, ByteOp.ASSIGN_FLAG, 3));
                moonlightPyramidTablet.getObjects().add(pacifist);
            }
        }
        for(GameObject graphicsTextureDraw : moonlightPyramidTablet.getObjectsById(ObjectIdConstants.GraphicsTextureDraw)) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.MOONLIGHT_HIDDEN_TABLET_COLLAPSING_FLOOR, ByteOp.FLAG_EQUALS, 2))) {
                GameObject pacifist = new GameObject(graphicsTextureDraw);
                pacifist.getTestByteOperations().clear();
                pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE, ByteOp.FLAG_EQUALS, 2));
                moonlightPyramidTablet.getObjects().add(pacifist);
            }
        }
        for(GameObject roomSpawner : moonlightPyramidTablet.getObjectsById(ObjectIdConstants.RoomSpawner)) {
            if(roomSpawner.hasTest(new TestByteOperation(FlagConstants.MOONLIGHT_HIDDEN_TABLET_COLLAPSING_FLOOR, ByteOp.FLAG_EQUALS, 2))) {
                GameObject pacifist = new GameObject(roomSpawner);
                pacifist.getTestByteOperations().clear();
                pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE, ByteOp.FLAG_GTEQ, 2));
                moonlightPyramidTablet.getObjects().add(pacifist);
            }
        }

        Screen goddessRuinEntranceScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 2, 2);
        AddObject.addFloatingItem(goddessRuinEntranceScreen, 560, 1120, ItemConstants.BOOK_OF_THE_DEAD, true)
                .addTests(new TestByteOperation(FlagConstants.WF_BOOK_OF_THE_DEAD, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.GODDESS_SHAWN_SEEN, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.WF_BOOK_OF_THE_DEAD, ByteOp.ASSIGN_FLAG, 2));

        Screen spaulderChestScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 7, 0);
        AddObject.addMantraDetector(spaulderChestScreen, ETERNITY_FIRE)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.GODDESS_PUZZLE_KEY_FAIRY, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.GODDESS_PUZZLE_KEY_FAIRY, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_HINT, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));
        for(GameObject chest : spaulderChestScreen.getObjectsById(ObjectIdConstants.Chest)) {
            chest.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_GTEQ, 1));
        }
        addTablet(spaulderChestScreen, 480, 120, -1,
                getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_Pacifist_Hint), FlagConstants.CUSTOM_FOOLS2022_PACIFIST_HINT_GLOW,
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_HINT, ByteOp.FLAG_GTEQ, 2));
        AddObject.addSecondsTimer(spaulderChestScreen, 1,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_HINT, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_HINT, ByteOp.ASSIGN_FLAG, 2)));

        Screen goddessShieldStatueScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 7, 2);
        AddObject.addMantraDetector(goddessShieldStatueScreen, LIFE_QUAKE)
                .addTests(
                        new TestByteOperation(FlagConstants.WF_ANGEL_SHIELD, ByteOp.FLAG_EQUALS, 2))
                .addUpdates(new WriteByteOperation(FlagConstants.GODDESS_STATUE_SHIELD_ANIMATION, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(goddessShieldStatueScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_GODDESS_STATUE_CHEAT_DETECTION, ByteOp.ASSIGN_FLAG, 1)));
        Screen ruinUseEarthSpearScreen = rcdFileData.getScreen(ZoneConstants.RUIN, 2, 0);
        AddObject.addMantraDetector(ruinUseEarthSpearScreen, BIRTH_SLAP)
                .addTests(
                        new TestByteOperation(FlagConstants.RUIN_USED_EARTH_SPEAR, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.RUIN_USED_EARTH_SPEAR, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));

        Screen ruinLowerBacksideDoorScreen = rcdFileData.getScreen(ZoneConstants.RUIN, 2, 1);
        AddObject.addFramesTimer(ruinLowerBacksideDoorScreen, 4,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BABEL_DETECTION, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BABEL_DETECTION, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0)));
        AddObject.addFramesTimer(ruinLowerBacksideDoorScreen, 3,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BABEL_DETECTION, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.BAHAMUT_GATE_OPEN, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_BABEL_DETECTION, ByteOp.ASSIGN_FLAG, 3),
                        new WriteByteOperation(FlagConstants.BAHAMUT_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1)));
        for(GameObject scannable : ruinLowerBacksideDoorScreen.getObjectsById(ObjectIdConstants.Scannable)) {
            if(((Scannable)scannable).getTextBlock() == BlockConstants.Tablet_Ruin_WhiteDiamondRepresentsPurity) {
                Scannable repeatRead = new Scannable(scannable);
                repeatRead.setTextBlock(getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_Babel));
                repeatRead.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BABEL_DETECTION, ByteOp.FLAG_GTEQ, 1));
                repeatRead.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));

                scannable.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BABEL_DETECTION, ByteOp.FLAG_EQUALS, 0));

                scannable.getObjectContainer().getObjects().add(repeatRead);
            }
        }

        Screen birthGrailScreen = rcdFileData.getScreen(ZoneConstants.BIRTH_SKANDA, 0, 0);
        for(GameObject graphicsTextureDraw : birthGrailScreen.getObjectsById(ObjectIdConstants.GraphicsTextureDraw)) {
            if(graphicsTextureDraw.hasTest(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_GTEQ, 1))) {
                GameObject nonPacifist = new GameObject(graphicsTextureDraw);
                nonPacifist.getTestByteOperations().clear();
                nonPacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));
                birthGrailScreen.getObjects().add(nonPacifist);
            }
        }
        AddObject.addMantraDetector(birthGrailScreen, ETERNITY_FIRE)
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
        TransitionGate transitionGate = new TransitionGate(birthGrailScreen, 40, 0);
        transitionGate.setDestination(ZoneConstants.BIRTH_SWORDS, 1, 0, 40, 392);
        transitionGate.setTransitionDirection(TransitionGate.Up);
        birthGrailScreen.getObjects().add(transitionGate);

        Ladder ladder = new Ladder(birthGrailScreen, 40, 0);
        ladder.setExtendDirection(Ladder.FromTop);
        ladder.setHeight(6);
        ladder.setGraphicsFromMapPng();
        ladder.setArg3(0);
        ladder.setImageX(0);
        ladder.setImageY(800);
        ladder.setStandardLadder();
        ladder.setArg7(1);
        ladder.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1));
        birthGrailScreen.getObjects().add(ladder);

        Screen birthPerfumeChestScreen = rcdFileData.getScreen(ZoneConstants.BIRTH_SWORDS, 2, 0);
        Bat bat = AddObject.addBat(birthPerfumeChestScreen, 560, 220);
        bat.setInitiallyFlying(false);
        bat.setFrontsideBat(false);
        bat.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                new TestByteOperation(FlagConstants.WF_DIMENSIONAL_KEY, ByteOp.FLAG_EQUALS, 0),
                new TestByteOperation(FlagConstants.COG_MUDMEN_STATE, ByteOp.FLAG_LT, 4));

        Screen guidanceMural1 = rcdFileData.getScreen(ZoneConstants.GUIDANCE, 6, 1);
        AddObject.addUseItemDetector(guidanceMural1, 960, 180, 5, 6, "Pochette Key")
                .addTests(new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_GTEQ, 1),
                        new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_LT, 3))
                .addUpdates(new WriteByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.ASSIGN_FLAG, 3),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addSuccessSound(guidanceMural1, Arrays.asList(
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_EQUALS, 3),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 1)));

        Screen guidanceMural2 = rcdFileData.getScreen(ZoneConstants.GUIDANCE, 8, 0);
        AddObject.addUseItemDetector(guidanceMural2, 260, 140, 5, 6, "Pochette Key")
                .addTests(new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_GTEQ, 1),
                        new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_LT, 3))
                .addUpdates(new WriteByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.ASSIGN_FLAG, 3),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addSuccessSound(guidanceMural2, Arrays.asList(
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                new TestByteOperation(FlagConstants.PALENQUE_ANKH_PUZZLE, ByteOp.FLAG_EQUALS, 3),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 1)));

        final int totalAnkhJewelsAvailable = 4;
        Screen palenqueAnkhJewelChest = rcdFileData.getScreen(ZoneConstants.EXTINCTION, 9, 0);
        for(GameObject floatingItem : palenqueAnkhJewelChest.getObjectsById(ObjectIdConstants.FloatingItem)) {
            GameObject pacifist = new FloatingItem(floatingItem);
            ((FloatingItem)pacifist).setRealItem(false);
            pacifist.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_PLANE_MODEL, ByteOp.FLAG_LT, totalAnkhJewelsAvailable - 1));
            palenqueAnkhJewelChest.getObjects().add(pacifist);
            GameObject planeModel = new FloatingItem(floatingItem);
            ((FloatingItem)planeModel).setInventoryWord(ItemConstants.PLANE_MODEL);
            planeModel.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                    new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_PLANE_MODEL, ByteOp.FLAG_EQUALS, totalAnkhJewelsAvailable - 1));
            planeModel.addUpdates(new WriteByteOperation(FlagConstants.WF_PLANE_MODEL, ByteOp.ASSIGN_FLAG, 2),
                    new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_PLANE_MODEL, ByteOp.ADD_FLAG, 1));
            palenqueAnkhJewelChest.getObjects().add(planeModel);
            floatingItem.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 1));

            AddObject.addItemGive(pacifist, ItemConstants.WEIGHT)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(FlagConstants.EXTINCTION_BACKUP_JEWEL, ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_PLANE_MODEL, ByteOp.FLAG_NOT_EQUAL, totalAnkhJewelsAvailable - 1))
                    .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_PACIFIST_PLANE_MODEL, ByteOp.ADD_FLAG, 1));
        }

        Screen motherAnkhScreen = rcdFileData.getScreen(ZoneConstants.SHRINE_BACK, 3, 0);
        AddObject.addFramesTimer(motherAnkhScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.MOTHER_ANKH_PUZZLE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.TRUE_SHRINE_MOTHER_ANKH_SEAL_COUNT, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addFramesTimer(motherAnkhScreen, 30,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 2),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_D, ByteOp.ASSIGN_FLAG, 1))); // todo: screen flag D gives screenshake
        AddObject.addMantraDetector(motherAnkhScreen, BIRTH_SLAP)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_LTEQ, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 2),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
        addMotherDefeatedMails(motherAnkhScreen);

        for(GameObject animation : motherAnkhScreen.getObjectsById(ObjectIdConstants.Animation)) {
            if(!animation.hasUpdate(new WriteByteOperation(FlagConstants.SCREEN_FLAG_17, ByteOp.ASSIGN_FLAG, 1))) {
                animation.getTestByteOperations().clear();
                animation.addTests(
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.TRUE_SHRINE_MOTHER_ANKH_SEAL_COUNT, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_LTEQ, 1),
                        new TestByteOperation(FlagConstants.MOTHER_ANKH_PUZZLE, ByteOp.FLAG_EQUALS, 0));
                animation.getWriteByteOperations().clear();
                animation.addUpdates(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
            }
        }

        for(GameObject existingGrailToggle : rcdFileData.getObjectsById(ObjectIdConstants.GrailToggle)) {
            if(existingGrailToggle.getArgs().get(0) == 1) {
                existingGrailToggle.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 0));
            }
        }
        AddObject.addWarpDoor(motherAnkhScreen, 300, 400, ZoneConstants.NIGHT_SURFACE, 11, 0, 220, 360,
                Arrays.asList(new TestByteOperation(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SPLIT_GATE_UNLOCKED, ByteOp.FLAG_EQUALS, 1))));
        GrailToggle grailToggle = new GrailToggle(motherAnkhScreen, false);
        grailToggle.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_GTEQ, 2));
        motherAnkhScreen.getObjects().add(0, grailToggle);

        Screen motherAnkhRightScreen = rcdFileData.getScreen(ZoneConstants.SHRINE_BACK, 3, 1);
        AddObject.addFramesTimer(motherAnkhRightScreen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ANKH, ByteOp.ASSIGN_FLAG, 0)));
        addMotherMailTracking(motherAnkhRightScreen);
        addMotherDefeatedMails(motherAnkhRightScreen);
    }

    private void addMotherMailTracking(Screen screen) {
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VANDALISM, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_FLOOR_BREAK, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.ASSIGN_FLAG, 1)));

        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_LTEQ, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.ASSIGN_FLAG, 2)));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_LTEQ, 2),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_GT, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.ASSIGN_FLAG, 3)));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_LTEQ, 3),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_EQUALS, 8)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.ASSIGN_FLAG, 4)));
    }

    private void addMotherDefeatedMails(Screen screen) {
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_GTEQ, 4),
                        new TestByteOperation(FlagConstants.MOTHER_STATE, ByteOp.FLAG_EQUALS, 3),
                        new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.MAIL_05, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.MAIL_05, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.MOTHER_STATE, ByteOp.FLAG_EQUALS, 3),
                        new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.MAIL_17, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.MAIL_17, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_MAIL_STATE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.MOTHER_STATE, ByteOp.FLAG_EQUALS, 3),
                        new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.MAIL_18, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.MAIL_18, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
    }

    private void addHTDoorGraphic(Screen screen, int x, int y) {
        GraphicsTextureDraw doorMainPart = new GraphicsTextureDraw(screen, x, y);

        doorMainPart.setLayer(-1);
        doorMainPart.setImageFile(GraphicsTextureDraw.ImageFile_map);

        doorMainPart.setImageX(320);
        doorMainPart.setImageY(0);
        doorMainPart.setImageWidth(40);
        doorMainPart.setImageHeight(40);

        doorMainPart.setAnimation(0, 1, 0, 0);
        doorMainPart.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
        doorMainPart.setCollision(HitTile.Air);
        doorMainPart.setRGBAMax(0, 0, 0, 255);
        doorMainPart.setArg23(1);
        screen.getObjects().add(doorMainPart);

        GraphicsTextureDraw doorUpper = new GraphicsTextureDraw(screen, x, y - 20);

        doorUpper.setLayer(-1);
        doorUpper.setImageFile(GraphicsTextureDraw.ImageFile_map);

        doorUpper.setImageX(360);
        doorUpper.setImageY(0);
        doorUpper.setImageWidth(40);
        doorUpper.setImageHeight(20);

        doorUpper.setAnimation(0, 1, 0, 0);
        doorUpper.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
        doorUpper.setCollision(HitTile.Air);
        doorUpper.setRGBAMax(0, 0, 0, 255);
        doorUpper.setArg23(1);
        screen.getObjects().add(doorUpper);
    }

    private void updateDimensionalCorridorExit() {
        Screen screen = rcdFileData.getScreen(ZoneConstants.DIMENSIONAL, 0, 0);
        for(GameObject warpDoor : screen.getObjectsById(ObjectIdConstants.WarpDoor)) {
            AddObject.addBossNumberGraphicV2(warpDoor, 8, null);
            AddObject.addAnimatedDoorCover(warpDoor, FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, false);
            warpDoor.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.FLAG_EQUALS, 1));
        }
        for(GameObject autosave : screen.getObjectsById(ObjectIdConstants.Autosave)) {
            autosave.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.FLAG_EQUALS, 1));
        }
        for(GameObject savePoint : screen.getObjectsById(ObjectIdConstants.SavePoint)) {
            savePoint.addTests(new TestByteOperation(FlagConstants.TABLET_GRAIL_DIMENSIONAL, ByteOp.FLAG_EQUALS, 1));
        }
        for(GameObject scannable : screen.getObjectsById(ObjectIdConstants.Scannable)) {
            if(scannable.hasTest(new TestByteOperation(FlagConstants.TABLET_GRAIL_DIMENSIONAL, ByteOp.FLAG_EQUALS, 0))) {
                Scannable copy = new Scannable(scannable);
                copy.getTestByteOperations().clear();
                copy.addTests(new TestByteOperation(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.FLAG_EQUALS, 0)));
                screen.getObjects().add(copy);
            }
            scannable.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.FLAG_EQUALS, 1));
        }

        AddObject.addMantraDetector(screen, BIRTH_SLAP)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addAnimatedDoorTimerAndSound(screen, FlagConstants.TIAMAT_STATE, FlagConstants.CUSTOM_FOOLS2022_TIAMAT_GATE);
    }

    private void addFutoPuzzleObjects(Screen screen, int x, int y, int screenFlag, boolean correctGiant) {
        GameObject obj = new GameObject(screen);
        obj.setId(ObjectIdConstants.Dais);
        obj.getArgs().add((short)0);
        obj.getArgs().add((short)10); // Falling speed
        obj.getArgs().add((short)-1);
        obj.getArgs().add((short)2);
        obj.getArgs().add((short)0);
        obj.getArgs().add((short)80);
        obj.getArgs().add((short)320);
        obj.getArgs().add((short)1);
        obj.getArgs().add((short)10);
        obj.getArgs().add((short)60);
        obj.setX(x);
        obj.setY(y);
        screen.getObjects().add(obj);

        if(correctGiant) {
            obj.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));
            obj.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.ASSIGN_FLAG, 1));
            obj.getWriteByteOperations().add(new WriteByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.ASSIGN_FLAG, 1));

            AddObject.addSuccessSound(screen, Arrays.asList(
                    new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2),
                    new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 1),
                    new TestByteOperation(FlagConstants.SCREEN_FLAG_B, ByteOp.FLAG_EQUALS, 1)));
        }
        else {
            obj.getTestByteOperations().add(new TestByteOperation(screenFlag, ByteOp.FLAG_EQUALS, 0));
            obj.getTestByteOperations().add(new TestByteOperation(FlagConstants.MAUSOLEUM_PUZZLE_ORB_CHEST, ByteOp.FLAG_EQUALS, 0));
            obj.getWriteByteOperations().add(new WriteByteOperation(screenFlag, ByteOp.ASSIGN_FLAG, 1));

            ExtendableSpikes extendableSpikes = AddObject.addExtendingSpikes(obj.getObjectContainer(), obj.getX() - 20, obj.getY() + 20, screenFlag);
            extendableSpikes.setImageX(0);
            extendableSpikes.setImageY(320);
            extendableSpikes.setFlatDamage(1);
            extendableSpikes.setSideDamage(1);
        }
    }

    @Override
    void addUntrackedCustomNoPositionZoneObjects(Zone zone) {
        AddObject.addFramesTimer(zone, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BOSSES_DEAD, ByteOp.FLAG_GT, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
        if(zone.getZoneIndex() == ZoneConstants.GUIDANCE) {
            addMailTimer(zone, FlagConstants.MAIL_12)
                    .addTests(new TestByteOperation(FlagConstants.GUIDANCE_BATS_KILLED_COUNT, ByteOp.FLAG_GTEQ, 50));
        }
        AddObject.addFramesTimer(zone, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.FLAG_GTEQ, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_CHOSE_VIOLENCE, ByteOp.ASSIGN_FLAG, 1)));
        addMailTimer(zone, FlagConstants.MAIL_13)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.FLAG_GTEQ, 1));
    }

    @Override
    public void doPostShuffleUpdates() {
        updateTwinLabyrinthsWarps();
        updateEndlessCorridorExit();
        updateExtinctionShrineGate();
        updateEnemies();
        updateFairyPoints();
        updateMotherAnkhObjects();
        updateChests();
        removeEscapeDoors();
        updateYiegahScreen();
        updateMulbrukScreen();
        updateGrailTablets();
        updateDimensionalCorridorExit();
        updateAutosaves();
        updateBossCountTimers();
        fixGateOfTimeAndNightSurfaceDoors();
        updateTransitionGates();
        updateForHT();
        updateForTabletFlip();
        updateForPacifistTracking();
        updateForPacifist();
        AddToAllScreens addCrusherGraphic = new AddToAllScreens() {
            @Override
            public void addToScreen(Screen screen, int leftmostX, int topmostY) {
                GraphicsTextureDraw crushTexture = new GraphicsTextureDraw(screen, leftmostX, topmostY);

                crushTexture.setLayer(-1);
                crushTexture.setImageFile(GraphicsTextureDraw.ImageFile_02comenemy);

                crushTexture.setImageX(0);
                crushTexture.setImageY(524);
                crushTexture.setImageWidth(640);
                crushTexture.setImageHeight(480);

                crushTexture.setAnimation(0, 1, 0, 0);
                crushTexture.setCollision(HitTile.CrusherTile_CrushHorizontal);
                crushTexture.setRGBAMax(0, 0, 0, 255);
                crushTexture.setArg23(1);
                crushTexture.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.FLAG_GT, 0));
                screen.getObjects().add(crushTexture);
            }
        };
        AddObject.addFramesTimer(rcdFileData.getRoom(ZoneConstants.TWIN_FRONT, 16), 0,
                Arrays.asList(new TestByteOperation(FlagConstants.LAMP_STATION_UNKNOWN, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.LAMP_STATION_UNKNOWN, ByteOp.ASSIGN_FLAG, 0)));
        for(Zone zone : rcdFileData.getZones()) {
            for(Room room : zone.getRooms()) {
                for(Screen screen : room.getScreens()) {
                    AddObject.addToAllScreens(screen, addCrusherGraphic);
                }
            }
        }
    }

    private void updateGrailTablets() {
        Screen screen = rcdFileData.getScreen(ZoneConstants.SURFACE, 2, 1);
        for(GameObject gameObject : screen.getObjectsById(ObjectIdConstants.Autosave)) {
            gameObject.addTests(new TestByteOperation(FlagConstants.TABLET_GRAIL_SURFACE, ByteOp.FLAG_EQUALS, 1));
        }
        AddObject.addSurfaceGrailTablet(screen);
    }

    private void updateYiegahScreen() {
        Screen yiegahScreen = rcdFileData.getScreen(ZoneConstants.TWIN_FRONT, 3, 2);
        for(GameObject gameObject : yiegahScreen.getObjectsById(ObjectIdConstants.ConversationDoor)) {
            ConversationDoor conversationDoor = new ConversationDoor(gameObject);
            conversationDoor.setBlockNumber(getCustomBlockIndex(CustomBlockEnum.Fools2022_Yiegah_Alt));
            conversationDoor.addTests(new TestByteOperation(FlagConstants.WF_MEDICINE_YELLOW, ByteOp.FLAG_EQUALS, 2));
            gameObject.getObjectContainer().getObjects().add(conversationDoor);

            gameObject.addTests(new TestByteOperation(FlagConstants.WF_MEDICINE_YELLOW, ByteOp.FLAG_EQUALS, 0));

            AddObject.addMedicineStatueTimer(conversationDoor.getObjectContainer(), FlagConstants.WF_MEDICINE_YELLOW);
        }
        for(GameObject gameObject : yiegahScreen.getObjectsById(ObjectIdConstants.FlagTimer)) {
            if(gameObject.hasUpdate(new WriteByteOperation(FlagConstants.WF_MEDICINE_YELLOW, ByteOp.ASSIGN_FLAG, 2))) {
                gameObject.addUpdates(new WriteByteOperation(FlagConstants.WF_MEDICINE_GREEN, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.WF_MEDICINE_RED, ByteOp.ASSIGN_FLAG, 0));
            }
            if(gameObject.hasUpdate(new WriteByteOperation(FlagConstants.WF_MEDICINE_GREEN, ByteOp.ASSIGN_FLAG, 2))) {
                gameObject.addUpdates(new WriteByteOperation(FlagConstants.WF_MEDICINE_YELLOW, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.WF_MEDICINE_RED, ByteOp.ASSIGN_FLAG, 0));
            }
            if(gameObject.hasUpdate(new WriteByteOperation(FlagConstants.WF_MEDICINE_RED, ByteOp.ASSIGN_FLAG, 2))) {
                gameObject.addUpdates(new WriteByteOperation(FlagConstants.WF_MEDICINE_YELLOW, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.WF_MEDICINE_GREEN, ByteOp.ASSIGN_FLAG, 0));
            }
        }
    }

    private void updateMulbrukScreen() {
        Screen screen = rcdFileData.getScreen(ZoneConstants.SUN, 3, 0);
        for(GameObject gameObject : screen.getObjectsById(ObjectIdConstants.Seal)) {
            gameObject.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0));
            gameObject.getWriteByteOperations().clear();
            gameObject.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
        }
        ConversationDoor conversationDoor;
        for(GameObject gameObject : screen.getObjectsById(ObjectIdConstants.ConversationDoor)) {
            conversationDoor = (ConversationDoor)gameObject;
            if (conversationDoor.getBlockNumber() == BlockConstants.Master_Mulbruk_StoneConversation) {
                gameObject.removeTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_GTEQ, 1));
                conversationDoor.setBlockNumber(getCustomBlockIndex(CustomBlockEnum.Fools2022_MulbrukSleeping_ReferenceBlock));
                conversationDoor.setDoorType(ConversationDoor.ConversationTree);
            }
        }
        Scannable scannable;
        for(GameObject gameObject : screen.getObjectsById(ObjectIdConstants.Scannable)) {
            scannable = (Scannable)gameObject;
            if (scannable.getTextBlock() == BlockConstants.Scannable_ResearchScan_StatueOfThoth) {
                Scannable escapeVersion = new Scannable(scannable);
                escapeVersion.setY(scannable.getY() + 100);
                escapeVersion.setHeight(scannable.getHeight() - 100);
                escapeVersion.addTests(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_NOT_EQUAL, 0));
                scannable.addTests(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 0));
                gameObject.getObjectContainer().getObjects().add(escapeVersion);
            }
        }
        addSunEscapeRubble(screen, 440, 260);
        addTablet(screen, 500, 80, -1,
                getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_ToilsForNaught),
                FlagConstants.CUSTOM_FOOLS2022_TOILS_FOR_NAUGHT_MULBRUK,
                new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_NOT_EQUAL, 0));
        addTablet(screen, 540, 80, -1,
                getCustomBlockIndex(CustomBlockEnum.Fools2022_Tablet_HolyBlessingColorized),
                FlagConstants.CUSTOM_FOOLS2022_ESCAPE_TABLET,
                new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_NOT_EQUAL, 0));

        GraphicsTextureDraw graphicsTextureDraw = new GraphicsTextureDraw(screen, 440, 300);
        graphicsTextureDraw.setLayer(-1);
        graphicsTextureDraw.setImageFile(GraphicsTextureDraw.ImageFile_map);
        graphicsTextureDraw.setImagePosition(0, 160);
        graphicsTextureDraw.setImageSize(80, 60);
        graphicsTextureDraw.setAnimation(0, 1, 0, 0);
        graphicsTextureDraw.setCollision(HitTile.Air);
        graphicsTextureDraw.setRGBAMax(0, 0, 0, 255);
        graphicsTextureDraw.setArg23(1);
        screen.getObjects().add(graphicsTextureDraw);
    }

    private void updateChests() {
        Chest chest;
        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.Chest)) {
            chest = (Chest)gameObject;
            if(chest.getDropType() == DropType.COINS.getValue()) {
                chest.setDropQuantity(COINS_PER_CHEST);
            }
        }
    }

    private void updateTwinLabyrinthsWarps() {
        int roomIndex;
        int screenIndex;
        Screen screen;
        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.WarpDoor, ZoneConstants.TWIN_FRONT)) {
            screen = (Screen)gameObject.getObjectContainer();
            roomIndex = screen.getRoomIndex();
            screenIndex = screen.getScreenIndex();

            if(roomIndex == 0 && screenIndex == 0) {
                setWarpDoorDestination(gameObject, 7, 3, 1, 300, 80);
            }
            if(roomIndex == 2 && screenIndex == 0) {
                setWarpDoorDestination(gameObject, 7, 14, 1, 300, 160);
            }
            if(roomIndex == 2 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 11, 1, 320, 80);
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
            }
            if(roomIndex == 3 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 0, 0, 240, 400);
            }
            if(roomIndex == 3 && screenIndex == 2) {
                setWarpDoorDestination(gameObject, 7, 11, 2, 300, 400);
            }
            if(roomIndex == 5 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 16, 1, 60, 400);
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
            }
            if(roomIndex == 6 && screenIndex == 0) {
                setWarpDoorDestination(gameObject, 7, 12, 2, 300, 320);
            }
            if(roomIndex == 9 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 12, 1, 300, 80);
            }
            if(roomIndex == 11 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 2, 1, 280, 80);
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
            }
            if(roomIndex == 11 && screenIndex == 2) {
                setWarpDoorDestination(gameObject, 7, 3, 2, 300, 320);
            }
            if(roomIndex == 12 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 9, 1, 360, 400);
            }
            if(roomIndex == 12 && screenIndex == 2) {
                setWarpDoorDestination(gameObject, 7, 6, 0, 300, 160);
            }
            if(roomIndex == 14 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 2, 0, 300, 400);
            }
            if(roomIndex == 16 && screenIndex == 1) {
                setWarpDoorDestination(gameObject, 7, 5, 1, 200, 320);
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_GTEQ, 2));
            }
        }

        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.TransitionGate, ZoneConstants.TWIN_FRONT)) {
            screen = (Screen)gameObject.getObjectContainer();
            roomIndex = screen.getRoomIndex();
            screenIndex = screen.getScreenIndex();

            if(roomIndex == 3 && screenIndex == 0) {
                if(gameObject.getY() > 240) {
                    // Bottom gate
                    setTransitionGateDestination(gameObject, 7, 12, 1, 480, 20);
                    gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1));
                }
            }
            if(roomIndex == 3 && screenIndex == 1) {
                if(gameObject.getY() < 720) {
                    // Top gate
                    setTransitionGateDestination(gameObject, 7, 3, 0, 120, 392);
                }
                else if(gameObject.getX() < 320) {
                    // Bottom left gate
                    setTransitionGateDestination(gameObject, 7, 12, 1, 480, 20);
                }
                else {
                    // Bottom right gate
                    setTransitionGateDestination(gameObject, 7, 3, 2, 120, 20);
                }
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1));
            }
            if(roomIndex == 3 && screenIndex == 2) {
                if(gameObject.getX() < 320) {
                    // Left gate
                    setTransitionGateDestination(gameObject, 7, 12, 0, 480, 392);
                }
                else {
                    // Right gate
                    setTransitionGateDestination(gameObject, 7, 3, 0, 120, 392);
                }
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1));
            }
            if(roomIndex == 12 && screenIndex == 0) {
                if(gameObject.getX() < 320) {
                    // Top gate
                    setTransitionGateDestination(gameObject, 7, 12, 0, 480, 392);
                }
                else {
                    // Bottom gate
                    setTransitionGateDestination(gameObject, 7, 3, 1, 120, 20);
                }
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1));
            }
            if(roomIndex == 12 && screenIndex == 1) {
                if(gameObject.getY() < 720) {
                    // Top gate
                    setTransitionGateDestination(gameObject, 7, 3, 0, 120, 392);
                }
                else if(gameObject.getX() < 320) {
                    // Bottom left gate
                    setTransitionGateDestination(gameObject, 7, 3, 2, 480, 20);
                }
                else {
                    // Bottom right gate
                    setTransitionGateDestination(gameObject, 7, 3, 1, 120, 20);
                }
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1));
            }
            if(roomIndex == 12 && screenIndex == 2) {
                if(gameObject.getX() < 320) {
                    // Left gate
                    setTransitionGateDestination(gameObject, 7, 12, 1, 480, 392);
                }
                else {
                    // Right gate
                    setTransitionGateDestination(gameObject, 7, 3, 0, 120, 392);
                }
                gameObject.removeTest(new TestByteOperation(FlagConstants.TWINS_RELEASED, ByteOp.FLAG_LTEQ, 1));
            }
        }
        Screen sunBronzeMirrorScreen = rcdFileData.getScreen(3, 5, 0);
        for(GameObject gameObject : sunBronzeMirrorScreen.getObjectsById(ObjectIdConstants.TransitionGate)) {
            gameObject.addTests(new TestByteOperation(FlagConstants.SUN_UNSEALED_EXTINCTION, ByteOp.FLAG_GTEQ, 1));
        }
        Screen illusionToGraveyardScreen = rcdFileData.getScreen(10, 7, 0);
        for(GameObject gameObject : illusionToGraveyardScreen.getObjectsById(ObjectIdConstants.TransitionGate)) {
            gameObject.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_GTEQ, 1));
        }
        Screen illusionToMoonlightScreen = rcdFileData.getScreen(10, 9, 1);
        for(GameObject gameObject : illusionToMoonlightScreen.getObjectsById(ObjectIdConstants.TransitionGate)) {
            gameObject.addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_GTEQ, 1));
        }
    }

    private void updateEndlessCorridorExit() {
        for(GameObject gameObject : rcdFileData.getScreen(ZoneConstants.ENDLESS, 5, 3).getObjectsById(ObjectIdConstants.TransitionGate)) {
            setTransitionGateDestination(gameObject, 25, 0, 0, 540, 0);
        }
        for(GameObject gameObject : rcdFileData.getScreen(ZoneConstants.SHRINE_FRONT, 0, 0).getObjectsById(ObjectIdConstants.TransitionGate)) {
            setTransitionGateDestination(gameObject, 8, 5, 1, gameObject.getArgs().get(3), gameObject.getArgs().get(4));
        }
        for(GameObject gameObject : rcdFileData.getScreen(ZoneConstants.SHRINE_BACK, 0, 0).getObjectsById(ObjectIdConstants.TransitionGate)) {
            setTransitionGateDestination(gameObject, 8, 5, 1, gameObject.getArgs().get(3), gameObject.getArgs().get(4));
        }
    }

    private void updateExtinctionShrineGate() {
        for(GameObject gameObject : rcdFileData.getScreen(ZoneConstants.EXTINCTION, 7, 1).getObjectsById(ObjectIdConstants.TransitionGate)) {
            if(gameObject.hasTest(new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_EQUALS, 9))) {
                setTransitionGateDestination(gameObject, 25, 0, 0, 540, 0);
            }
        }
    }

    private void updateFairyPoints() {
        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.FairyPoint)) {
            ((FairyPoint)gameObject).setFairyType(FairyPoint.HEALTH_FAIRY);
        }
        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.Ankh)) {
            if(!gameObject.hasTest(new TestByteOperation(FlagConstants.HARDMODE, ByteOp.FLAG_EQUALS, 2))) {
                addFairyPoint(gameObject.getObjectContainer(), gameObject.getX(), gameObject.getY()).addTests(
                        new TestByteOperation(gameObject.getWriteByteOperations().get(0).getIndex(), ByteOp.FLAG_GTEQ, 0),
                        new TestByteOperation(gameObject.getWriteByteOperations().get(0).getIndex(), ByteOp.FLAG_LTEQ, 2));
            }
        }
    }

    private void updateMotherAnkhObjects() {
        Screen fourSealsChestScreen = rcdFileData.getScreen(ZoneConstants.SHRINE_FRONT, 1, 1);
        for(GameObject chestObj : fourSealsChestScreen.getObjectsById(ObjectIdConstants.Chest)) {
            Chest chest = (Chest)chestObj;
            chest.setDropType(ItemConstants.SPAULDER + ValueConstants.CHEST_ITEM_OFFSET);
            Screen rightOfMotherAnkh = rcdFileData.getScreen(ZoneConstants.SHRINE_BACK, 3, 1);
            AddObject.addFramesTimer(rightOfMotherAnkh, 0,
                    Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_OTHER_SPAULDER, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(chest.getWriteByteOperations().get(0).getIndex(), ByteOp.FLAG_EQUALS, 2)),
                    Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_OTHER_SPAULDER, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
            Screen goddessScreen = rcdFileData.getScreen(ZoneConstants.GODDESS, 0, 1);
            AddObject.addMantraDetector(goddessScreen, SPAULDER_HOLY_NOTHING)
                    .addTests(new TestByteOperation(chest.getWriteByteOperations().get(0).getIndex(), ByteOp.FLAG_EQUALS, 2),
                            new TestByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.FLAG_EQUALS, 0))
                    .addUpdates(new WriteByteOperation(FlagConstants.VIY_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1));
        }
        Screen dcOrbScreen = rcdFileData.getScreen(ZoneConstants.SURFACE, 8, 1);
        for(GameObject chestObj : dcOrbScreen.getObjectsById(ObjectIdConstants.Chest)) {
            Chest chest = (Chest)chestObj;
            chest.setDropType(ItemConstants.GAUNTLET + ValueConstants.CHEST_ITEM_OFFSET);
            Screen rightOfMotherAnkh = rcdFileData.getScreen(ZoneConstants.SHRINE_BACK, 3, 1);
            AddObject.addFramesTimer(rightOfMotherAnkh, 0,
                    Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_OTHER_GAUNTLET, ByteOp.FLAG_EQUALS, 0),
                            new TestByteOperation(chest.getWriteByteOperations().get(0).getIndex(), ByteOp.FLAG_EQUALS, 2)),
                    Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR_OTHER_GAUNTLET, ByteOp.ASSIGN_FLAG, 1),
                            new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.ADD_FLAG, 1)));
        }

        for(GameObject motherAnkh : rcdFileData.getObjectsById(ObjectIdConstants.Ankh, ZoneConstants.SHRINE_BACK)) {
            if(motherAnkh.getArgs().get(0) == ValueConstants.ANKH_BOSS_MOTHER) {
                motherAnkh.getArgs().set(1, (short)MOTHER_PHASE_1_HEALTH);
                motherAnkh.getArgs().set(5, (short)MOTHER_PHASE_2_HEALTH); // initial part of phase 5 health
                motherAnkh.getArgs().set(8, (short)MOTHER_PHASE_3_HEALTH);
                motherAnkh.getArgs().set(12, (short)MOTHER_PHASE_4_HEALTH);
                motherAnkh.getArgs().set(15, (short)MOTHER_PHASE_5_SUBPHASE_HEALTH);

                for (int i = 0; i < MAX_ARMOR; i++) {
                    GameObject armorAnkh = new GameObject(motherAnkh);
                    armorAnkh.getArgs().set(3, (short)(36 - 4 * i));
                    armorAnkh.getArgs().set(4, (short)(60 - 10 * i)); // Contact damage, Rapid-fire pink&blue triangle damage
                    armorAnkh.getArgs().set(6, (short)(100 - 10 * i));
                    armorAnkh.getArgs().set(7, (short)(64 - 6 * i));
                    armorAnkh.getArgs().set(8, (short)(48 - 4 * i));
                    armorAnkh.getArgs().set(10, (short)(64 - 4 * i));
                    armorAnkh.getArgs().set(11, (short)(80 - 7 * i));
                    armorAnkh.getArgs().set(14, (short)(32 - 3 * i));
                    armorAnkh.getArgs().set(16, (short)(24 - 2 * i));
                    armorAnkh.getArgs().set(17, (short)(24 - 2 * i));
                    armorAnkh.getArgs().set(18, (short)(36 - 3 * i));
                    armorAnkh.getArgs().set(19, (short)(36 - 3 * i));
                    armorAnkh.getArgs().set(20, (short)(100 - 10 * i));
                    armorAnkh.getArgs().set(21, (short)(16 - 2 * i));
                    armorAnkh.getArgs().set(22, (short)(45 - 5 * i));
                    armorAnkh.getArgs().set(23, (short)(24 - 2 * i));
                    armorAnkh.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.FLAG_EQUALS, i));
                    motherAnkh.getObjectContainer().getObjects().add(armorAnkh);
                }
                motherAnkh.getArgs().set(3, (short)(36 - 4 * MAX_ARMOR));
                motherAnkh.getArgs().set(4, (short)0); // Contact damage, Rapid-fire pink&blue triangle damage
                motherAnkh.getArgs().set(6, (short)(100 - 10 * MAX_ARMOR));
                motherAnkh.getArgs().set(7, (short)(64 - 6 * MAX_ARMOR));
                motherAnkh.getArgs().set(8, (short)(48 - 4 * MAX_ARMOR));
                motherAnkh.getArgs().set(10, (short)(64 - 4 * MAX_ARMOR));
                motherAnkh.getArgs().set(11, (short)(80 - 7 * MAX_ARMOR));
                motherAnkh.getArgs().set(14, (short)(32 - 3 * MAX_ARMOR));
                motherAnkh.getArgs().set(16, (short)(24 - 2 * MAX_ARMOR));
                motherAnkh.getArgs().set(17, (short)(24 - 2 * MAX_ARMOR));
                motherAnkh.getArgs().set(18, (short)(36 - 3 * MAX_ARMOR));
                motherAnkh.getArgs().set(19, (short)(36 - 3 * MAX_ARMOR));
                motherAnkh.getArgs().set(20, (short)(100 - 10 * MAX_ARMOR));
                motherAnkh.getArgs().set(21, (short)(16 - 2 * MAX_ARMOR));
                motherAnkh.getArgs().set(22, (short)(45 - 5 * MAX_ARMOR));
                motherAnkh.getArgs().set(23, (short)(24 - 2 * MAX_ARMOR));
                motherAnkh.getArgs().set(4, (short)0); // Contact damage, Rapid-fire pink&blue triangle damage
                motherAnkh.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MOTHER_ARMOR, ByteOp.FLAG_GTEQ, MAX_ARMOR));
            }
        }
    }

    private void removeEscapeDoors() {
        Screen mulbrukScreen = rcdFileData.getScreen(3, 3, 0);
        List<GameObject> removeObjects = new ArrayList<>(2);
        for(GameObject gameObject : mulbrukScreen.getObjectsById(ObjectIdConstants.ConversationDoor)) {
            if(gameObject.hasTest(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1))) {
                removeObjects.add(gameObject);
            }
        }
        mulbrukScreen.getObjects().removeAll(removeObjects);
    }

    private void updateEnemies() {
        WriteByteOperation pacifistRegularEnemyUpdate = new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1);
        WriteByteOperation pacifistSubBossUpdate = new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_MISC_VIOLENCE, ByteOp.ASSIGN_FLAG, 1);

        GameObject copy;
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Antlion)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(3, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Bat)) {
            ((Bat)hasContact).setDropType(DropType.SOUL);
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Skeleton)) {
            ((Skeleton)hasContact).setDropType(DropType.SOUL);
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            Screen screen = (Screen)hasContact.getObjectContainer();
            if(screen.getZoneIndex() == ZoneConstants.GUIDANCE && screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
                ((Skeleton)hasContact).setContactDamage(0);
                hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_PERFUME, ByteOp.FLAG_EQUALS, 2));
            }
            else {
                copy = new Skeleton(hasContact);
                copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_PERFUME, ByteOp.FLAG_EQUALS, 2));
                ((Skeleton)copy).setContactDamage(0);
                hasContact.getObjectContainer().getObjects().add(copy);

                hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_PERFUME, ByteOp.FLAG_NOT_EQUAL, 2));
            }
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.TogSpawner)) {
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Snouter)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_KodamaRat)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Argus)) {
            hasContact.getArgs().set(0, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(3, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Snake)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Cockatrice)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            Screen screen = (Screen)hasContact.getObjectContainer();
            if(screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE) {
                if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
                    hasContact.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_NOT_EQUAL, 1));
                }
            }

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Condor)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_MaskedMan)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Nozuchi)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Fist)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.GhostSpawner)) {
            hasContact.getArgs().set(3, DropType.NOTHING.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_CRUCIFIX, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(0, copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_CRUCIFIX, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.GhostLord)) {
            hasContact.getArgs().set(0, DropType.NOTHING.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_CRUCIFIX, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);

            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_CRUCIFIX, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.RedSkeleton)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_PERFUME, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_PERFUME, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Sonic)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_CatBall)) {
            hasContact.getArgs().set(3, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Bennu)) {
            hasContact.getArgs().set(3, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_PharaohHead)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(3, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Buer)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Gyonin)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.MrGyonin)) {
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(2, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Hippocamp)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Kraken)) {
            hasContact.getArgs().set(0, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(3, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_WaterLeaper)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Nuckelavee)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_ExplodeRock)) {
            hasContact.getArgs().set(0, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(6, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Slime)) {
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Kakoujuu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Pazuzu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Mandrake)) {
            hasContact.getArgs().set(0, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(2, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Naga)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Garuda)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Blob)) {
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Hekatonkheires)) {
            hasContact.getArgs().set(0, (short)0);
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.getArgs().set(2, (short)0);

            if(!replaceScoreUpdate(hasContact, pacifistSubBossUpdate)) {
                hasContact.addUpdates(pacifistSubBossUpdate);
            }

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.OxHeadAndHorseFace)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.getArgs().set(10, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            copy.getArgs().set(13, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Bonnacon)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_FlowerFacedSnouter)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(3, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Monocoli)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_JiangShi)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_RongXuanwangCorpse)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Backbeard)) {
            hasContact.getArgs().set(3, BACKBEARD_HEALTH);
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.TaiSui)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.getArgs().set(3, TAI_SUI_HEALTH);
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Hundun)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Pan)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Hanuman)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Enkidu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Marchosias)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Beelzebub)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistSubBossUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            copy.getArgs().set(8, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Witch)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Siren)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_XingTian)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_ZaoChi)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Leucrotta)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Peryton)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Zu)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_LizardMan)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Asp)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Kui)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Ba)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.ChiYou)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Toujin)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_DiJiang)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_IceWizard)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Keseran)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_BaiZe)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Kamaitachi)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Anubis)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_BOOK_OF_THE_DEAD, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Yowie)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Troll)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Anubis)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.NinjaSpawner)) {
            hasContact.getArgs().set(3, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_ABaoAQu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Andras)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            copy.getArgs().set(9, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.ChonchonSpawner)) {
            hasContact.getArgs().set(4, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(7, (short)0);
            hasContact.getObjectContainer().getObjects().add(0, copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Cyclops)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Vimana)) {
            hasContact.getArgs().set(2, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistSubBossUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(5, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_BlackDog)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Salamander)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Skyfish)) {
            hasContact.getArgs().set(3, DropType.SOUL.getValue());
            hasContact.removeUpdate(new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ADD_FLAG, 1));
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(6, (short)0);
            hasContact.getObjectContainer().getObjects().add(0, copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Thunderbird)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject gameObject : rcdFileData.getObjectsById(ObjectIdConstants.Rusalii)) {
            gameObject.getArgs().set(2, DropType.NOTHING.getValue());
            gameObject.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Yaksi)) {
            hasContact.getArgs().set(1, DropType.NOTHING.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Dakini)) {
            hasContact.getArgs().set(1, DropType.NOTHING.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(3, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Nuwa)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.MudManSpawner)) {
            hasContact.getArgs().set(3, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(6, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_SwordBird)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Elephant)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Skanda)) {
            hasContact.getArgs().set(1, DropType.NOTHING.getValue());
            hasContact.getArgs().set(2, (short)4); // Speed
            hasContact.getArgs().set(3, (short)10); // HP
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0); // Contact damage
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Amon)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Satan)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_Devil)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.UmuDabrutu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Urmahlullu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Ugallu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Kuusarikku)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Girtablilu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistSubBossUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Kulullu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Mushnahhu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Lahamu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Ushumgallu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Ushum)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Mushussu)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            replaceScoreUpdate(hasContact, pacifistSubBossUpdate);

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.Enemy_MiniBoss)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());
            hasContact.addUpdates(new WriteByteOperation(pacifistRegularEnemyUpdate));

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
        for(GameObject hasContact : rcdFileData.getObjectsById(ObjectIdConstants.TheBoss)) {
            hasContact.getArgs().set(1, DropType.SOUL.getValue());

            copy = new GameObject(hasContact);
            copy.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_EQUALS, 2));
            copy.getArgs().set(4, (short)0);
            copy.getArgs().set(10, (short)0);
            hasContact.getObjectContainer().getObjects().add(copy);

            hasContact.getTestByteOperations().add(new TestByteOperation(FlagConstants.WF_FAIRY_CLOTHES, ByteOp.FLAG_NOT_EQUAL, 2));
        }
    }

    private boolean replaceScoreUpdate(GameObject objectToUpdate, WriteByteOperation newUpdate) {
        for(WriteByteOperation update : objectToUpdate.getWriteByteOperations()) {
            if(update.getIndex() == FlagConstants.SCORE) {
                update.setIndex(newUpdate.getIndex());
                update.setOp(newUpdate.getOp());
                update.setValue(newUpdate.getValue());
                return true;
            }
        }
        return false;
    }

    @Override
    void updateScreenExits(Screen screen) {
        if(screen.getZoneIndex() == ZoneConstants.SURFACE || screen.getZoneIndex() == ZoneConstants.NIGHT_SURFACE) {
            if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0) {
                screen.getScreenExit(ScreenExit.LEFT).setDestination(1, 9, 0);
            }
            if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
                screen.getScreenExit(ScreenExit.RIGHT).setDestination(1, 4, 0);
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.SUN && screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getZoneIndex() == ZoneConstants.SPRING && screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.DOWN).setDestination(25, 0, 0);
        }
        if(screen.getZoneIndex() == ZoneConstants.TWIN_FRONT) {
            updateTwinLabyrinths(screen);
        }
        if(screen.getZoneIndex() == ZoneConstants.ENDLESS) {
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 1) {
                screen.getScreenExit(ScreenExit.DOWN).setDestination(9, 0, 0);
            }
            if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 3) {
                screen.getScreenExit(ScreenExit.DOWN).setDestination(25, 0, 0);
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.ILLUSION && screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getZoneIndex() == ZoneConstants.GODDESS) {
            if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
                screen.getScreenExit(ScreenExit.DOWN).setDestination(13, 7, 1);
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.SHRINE_BACK) {
            if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
                screen.getScreenExit(ScreenExit.DOWN).setDestination(ZoneConstants.SHRINE_BACK, 3, 0);
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.RETRO_MAUSOLEUM) {
            if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 2) {
                screen.getScreenExit(ScreenExit.DOWN).setDestination(19, 1, 2);
            }
        }
        if(screen.getZoneIndex() == ZoneConstants.BURNING_CAVERN) {
            if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 4) {
                screen.getScreenExit(ScreenExit.DOWN).setDestination(ZoneConstants.BURNING_CAVERN, 0, 0);
            }
        }
    }

    private void updateTwinLabyrinths(Screen screen) {
        if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 1, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 0, 1);
        }
        if(screen.getRoomIndex() == 0 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 0, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 9, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 1, 1);
        }
        if(screen.getRoomIndex() == 1 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 1, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 0, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 2, 1);
        }
        if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 11, 2);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 2, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 2, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 2, 2);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 1, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 2 && screen.getScreenIndex() == 2) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 2, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 0, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 3 && screen.getScreenIndex() == 2) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 5, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 4, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 4 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 4, 0);
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 5, 1);
        }
        if(screen.getRoomIndex() == 5 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 16, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 16, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 5, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 7, 0);
        }
        if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 14, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 6, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 6 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 6, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 8, 0);
        }
        if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 7, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 5, 1);
        }
        if(screen.getRoomIndex() == 7 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 7, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 8, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 4, 1);
        }
        if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 7, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 8, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 8 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 8, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 15, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 0, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 9, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 9 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 9, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 0, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 11, 0);
        }
        if(screen.getRoomIndex() == 10 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 7, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 10, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 7, 1);
        }
        if(screen.getRoomIndex() == 10 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 10, 0);
        }
        if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 11, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 9, 1);
        }
        if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 11, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 11, 2);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 1, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 11 && screen.getScreenIndex() == 2) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 11, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 2, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 14, 0);
        }
        if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 10, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 12 && screen.getScreenIndex() == 2) {
            screen.getScreenExit(ScreenExit.UP).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
            screen.getScreenExit(ScreenExit.LEFT).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 13 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 13, 1);
        }
        if(screen.getRoomIndex() == 13 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 13, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 16, 2);
        }
        if(screen.getRoomIndex() == 14 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 14, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 15, 1);
        }
        if(screen.getRoomIndex() == 14 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 14, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 6, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 15 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 8, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 15, 1);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 15 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 15, 0);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 15, 2);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 15 && screen.getScreenIndex() == 2) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 15, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 2, 0);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 13, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(
                    LocationCoordinateMapper.getStartingZone(), LocationCoordinateMapper.getStartingRoom(), LocationCoordinateMapper.getStartingScreen());
        }
        if(screen.getRoomIndex() == 16 && screen.getScreenIndex() == 0) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 3, 0);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 7, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 16, 1);
        }
        if(screen.getRoomIndex() == 16 && screen.getScreenIndex() == 1) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 5, 1);
            screen.getScreenExit(ScreenExit.RIGHT).setDestination(7, 5, 1);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 16, 0);
            screen.getScreenExit(ScreenExit.DOWN).setDestination(7, 16, 2);
        }
        if(screen.getRoomIndex() == 16 && screen.getScreenIndex() == 2) {
            screen.getScreenExit(ScreenExit.LEFT).setDestination(7, 3, 0);
            screen.getScreenExit(ScreenExit.UP).setDestination(7, 16, 1);
        }
    }

    private static void addGraveyardWarps(Screen screen, int zoneIndex, int roomIndex, int screenIndex) {
        if(roomIndex == 0 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 10, 7, 0, 60, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 1));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 1));
        }
        if(roomIndex == 0 && screenIndex == 1) {
            AddObject.addWarp(screen, 640, 0, 32, 24, 10, 7, 0, 60, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 1));
            AddObject.addWarp(screen, 640, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 1));
        }
        if(roomIndex == 0 && screenIndex == 2) {
            AddObject.addWarp(screen, 1280, 0, 32, 24, 10, 7, 0, 60, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 1));
            AddObject.addWarp(screen, 1280, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 1));
        }
        if(roomIndex == 1 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 10, 7, 0, 60, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 1));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 1));
        }
        if(roomIndex == 1 && screenIndex == 1) {
            AddObject.addWarp(screen, 640, 0, 32, 24, 10, 7, 0, 60, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 1));
            AddObject.addWarp(screen, 640, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 1));
        }
        if(roomIndex == 2 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 10, 7, 0, 60, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 1));
            AddObject.addWarp(screen, 0, 0, 32, 24, 2, 4, 0, 80, 320)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 2));
            AddObject.addWarp(screen, 0, 0, 32, 24, 13, 8, 0, 20, 232)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 3));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 1),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 2),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 3));
        }
        if(roomIndex == 2 && screenIndex == 1) {
            AddObject.addWarp(screen, 640, 0, 32, 24, 2, 4, 0, 80, 320)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 2));
            AddObject.addWarp(screen, 640, 0, 32, 24, 13, 8, 0, 20, 232)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 3));
            AddObject.addWarp(screen, 640, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 2),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 3));
        }
        if(roomIndex == 3 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 2, 4, 0, 80, 320)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 2));
            AddObject.addWarp(screen, 0, 0, 32, 24, 13, 8, 0, 20, 232)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 3));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 2),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 3));

            addCrossOfLight(screen, 120, 340, -1);
        }
        if(roomIndex == 4 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 2, 4, 0, 80, 320)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 2));
            AddObject.addWarp(screen, 0, 0, 32, 24, 13, 8, 0, 20, 232)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 3));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 2),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 3));
        }
        if(roomIndex == 4 && screenIndex == 1) {
            AddObject.addWarp(screen, 0, 480, 32, 24, 2, 4, 0, 80, 320)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 2));
            AddObject.addWarp(screen, 0, 480, 32, 24, 13, 8, 0, 20, 232)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 3));
            AddObject.addWarp(screen, 0, 480, 32, 24, 15, 0, 0, 500, 20)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 480, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 2),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 3),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4));
        }
        if(roomIndex == 4 && screenIndex == 2) {
            AddObject.addWarp(screen, 0, 960, 32, 24, 15, 0, 0, 500, 20)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 960, 32, 24, 14, 0, 2, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 5));
            AddObject.addWarp(screen, 0, 960, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 5));
        }
        if(roomIndex == 4 && screenIndex == 3) {
            AddObject.addWarp(screen, 0, 1440, 32, 24, 15, 0, 0, 500, 20)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 1440, 32, 24, 14, 0, 2, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 5));
            AddObject.addWarp(screen, 0, 1440, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 5));
        }
        if(roomIndex == 5 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 14, 0, 2, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 5));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 5));
        }
        if(roomIndex == 5 && screenIndex == 1) {
            AddObject.addWarp(screen, 640, 0, 32, 24, 14, 0, 2, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 5));
            AddObject.addWarp(screen, 640, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 5));
        }
        if(roomIndex == 6 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 15, 0, 0, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 0, 32, 24, 13, 7, 2, 540, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 6));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 6));
        }
        if(roomIndex == 7 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 15, 0, 0, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 0, 32, 24, 13, 7, 2, 540, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 6));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 6));
        }
        if(roomIndex == 7 && screenIndex == 1) {
            AddObject.addWarp(screen, 0, 480, 32, 24, 15, 0, 0, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 480, 32, 24, 13, 7, 2, 540, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 6));
            AddObject.addWarp(screen, 0, 480, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 6));
        }
        if(roomIndex == 8 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 15, 0, 0, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 0, 32, 24, 13, 7, 2, 540, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 6));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 6));
        }
        if(roomIndex == 9 && screenIndex == 0) {
            AddObject.addWarp(screen, 0, 0, 32, 24, 15, 0, 0, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 0, 0, 30, 24, 13, 7, 2, 540, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 6));
            AddObject.addWarp(screen, 0, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 6));
        }
        if(roomIndex == 9 && screenIndex == 1) {
            AddObject.addWarp(screen, 640, 0, 32, 24, 15, 0, 0, 580, 152)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 4));
            AddObject.addWarp(screen, 640, 0, 32, 24, 13, 7, 2, 540, 392)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_EQUALS, 6));
            AddObject.addWarp(screen, 640, 0, 32, 24, 1, 2, 1, 300, 72)
                    .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_LT, 7),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 4),
                            new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_BAT_CURRY, ByteOp.FLAG_NOT_EQUAL, 6));
        }
    }

    private static void flipOneWayDoor(GameObject oneWayDoor) {
        oneWayDoor.getArgs().set(0, (short)(oneWayDoor.getArgs().get(0) == 0 ? 1 : 0));
    }

    private static void setWarpPortalDestination(GameObject warpPortal, int zone, int room, int screen, int x, int y) {
        warpPortal.getArgs().set(0, (short)zone);
        warpPortal.getArgs().set(1, (short)room);
        warpPortal.getArgs().set(2, (short)screen);
        warpPortal.getArgs().set(3, (short)x);
        warpPortal.getArgs().set(4, (short)y);
    }

    private static void setWarpDoorDestination(GameObject warpDoor, int zone, int room, int screen, int x, int y) {
        warpDoor.getArgs().set(1, (short)zone);
        warpDoor.getArgs().set(2, (short)room);
        warpDoor.getArgs().set(3, (short)screen);
        warpDoor.getArgs().set(4, (short)x);
        warpDoor.getArgs().set(5, (short)y);
    }

    private static void setTransitionGateDestination(GameObject transitionGate, int zone, int room, int screen, int x, int y) {
        transitionGate.getArgs().set(0, (short)zone);
        transitionGate.getArgs().set(1, (short)room);
        transitionGate.getArgs().set(2, (short)screen);
        transitionGate.getArgs().set(3, (short)x);
        transitionGate.getArgs().set(4, (short)y);
    }

    private static GameObject addJumpPointObjects(Screen screen, int x, int y, int layer, boolean doubleWidth, int screenFlag, TestByteOperation... tests) {
        AddObject.addLaserWall(screen, x, y, true, 0)
                .addTests(new TestByteOperation(screenFlag, ByteOp.FLAG_EQUALS, 1))
                .addTests(tests);
        if(doubleWidth) {
            AddObject.addLaserWall(screen, x + 20, y, true, 0)
                    .addTests(new TestByteOperation(screenFlag, ByteOp.FLAG_EQUALS, 1))
                    .addTests(tests);
        }
        return addJumpPointGraphic(screen, x, y, layer, doubleWidth).addTests(tests);
    }

    private static GraphicsTextureDraw addJumpPointGraphic(Screen screen, int x, int y, int layer, boolean doubleWidth) {
        GraphicsTextureDraw jumpPointGraphic = new GraphicsTextureDraw(screen, doubleWidth ? x : x - 20, y);

        jumpPointGraphic.setLayer(layer);
        jumpPointGraphic.setImageFile("01effect.png");

        jumpPointGraphic.setImageX(doubleWidth ? 770 : 760);
        jumpPointGraphic.setImageY(120);
        jumpPointGraphic.setImageWidth(doubleWidth ? 40 : 50);
        jumpPointGraphic.setImageHeight(18);

        jumpPointGraphic.setAnimation(0, 1, 0, 0);
        jumpPointGraphic.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
        jumpPointGraphic.setCollision(HitTile.Air);
        jumpPointGraphic.setRGBAMax(0, 0, 0, 255);
        jumpPointGraphic.setArg23(1);
        screen.getObjects().add(jumpPointGraphic);
        return jumpPointGraphic;
    }

    private static void addTablet(Screen screen, int x, int y, int layer, int blockNumber, int flagIndex, TestByteOperation additionalTest) {
        GraphicsTextureDraw tabletGraphic = new GraphicsTextureDraw(screen, x, y);

        tabletGraphic.setLayer(layer);
        tabletGraphic.setImageFile(GraphicsTextureDraw.ImageFile_map);

        tabletGraphic.setImageX(0);
        tabletGraphic.setImageY(0);
        tabletGraphic.setImageWidth(40);
        tabletGraphic.setImageHeight(40);

        tabletGraphic.setAnimation(0, 1, 0, 0);
        tabletGraphic.setCollision(HitTile.Air);
        tabletGraphic.setRGBAMax(0, 0, 0, 255);
        tabletGraphic.setArg23(1);

        if(additionalTest != null) {
            tabletGraphic.addTests(additionalTest);
        }

        screen.getObjects().add(tabletGraphic);

        GraphicsTextureDraw tabletGlowGraphic = new GraphicsTextureDraw(screen, x, y);
        tabletGlowGraphic.setLayer(layer + 1);
        tabletGlowGraphic.setImageFile(GraphicsTextureDraw.ImageFile_00item_alt);

        tabletGlowGraphic.setImageX(820);
        tabletGlowGraphic.setImageY(560);
        tabletGlowGraphic.setImageWidth(40);
        tabletGlowGraphic.setImageHeight(40);

        tabletGlowGraphic.setAnimation(1, 1, 4, 0);
        tabletGlowGraphic.setExitEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
        tabletGlowGraphic.setCycleColors(true);
        tabletGlowGraphic.setCollision(HitTile.Air);
        tabletGlowGraphic.setAlphaPerFrame(0);
        tabletGlowGraphic.setMaxAlpha(255);
        tabletGlowGraphic.setRedPerFrame(20);
        tabletGlowGraphic.setMaxRed(20);
        tabletGlowGraphic.setGreenPerFrame(0);
        tabletGlowGraphic.setMaxGreen(0);
        tabletGlowGraphic.setBluePerFrame(0);
        tabletGlowGraphic.setMaxBlue(0);
        tabletGlowGraphic.setBlendMode(1);
        tabletGlowGraphic.setArg23(0);

        tabletGlowGraphic.addTests(new TestByteOperation(flagIndex, ByteOp.FLAG_EQUALS, 0));
        if(additionalTest != null) {
            tabletGlowGraphic.addTests(additionalTest);
        }

        screen.getObjects().add(tabletGlowGraphic);

        Scannable scannable = new Scannable(screen, x, y);
        scannable.setTextBlock(blockNumber);
        scannable.setArg1(0);
        scannable.setArg2(0);
        scannable.setArg3(1);
        scannable.setArg4(1);
        scannable.setArg5(1);
        scannable.setArg6(1);
        scannable.setArg7(1);
        scannable.setArg8(1);
        scannable.setArg9(0);
        scannable.setDimensions(40, 40);

        if(additionalTest != null) {
            scannable.addTests(additionalTest);
        }
        scannable.addUpdates(new WriteByteOperation(flagIndex, ByteOp.ASSIGN_FLAG, 1));

        screen.getObjects().add(scannable);
    }

    private static void addDeathField(Screen screen, int x, int y, int graphicsLayer, int width, int height) {
        GraphicsTextureDraw deathFieldGraphic = new GraphicsTextureDraw(screen, x, y);

        deathFieldGraphic.setLayer(graphicsLayer);
        deathFieldGraphic.setImageFile(GraphicsTextureDraw.ImageFile_00item);

        deathFieldGraphic.setImageX(0);
        deathFieldGraphic.setImageY(600);
        deathFieldGraphic.setImageWidth(width);
        deathFieldGraphic.setImageHeight(height);

        deathFieldGraphic.setAnimation(0, 1, 0, 0);
        deathFieldGraphic.setCollision(HitTile.Air);
        deathFieldGraphic.setRGBAMax(0, 0, 0, 200);
        deathFieldGraphic.setArg23(1);

        screen.getObjects().add(deathFieldGraphic);

        AddObject.addLemezaDetector(screen, x, y, width / 20, height / 20,
                Arrays.asList(new TestByteOperation(FlagConstants.WF_BOOK_OF_THE_DEAD, ByteOp.FLAG_NOT_EQUAL, 2)),
                Arrays.asList(
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_DEAD, ByteOp.ASSIGN_FLAG, 1))); // todo: add sound effect to go with death
    }

    private static void addInfernoSpikesPlatformingPuzzleScreen1(Screen screen) {
        AddObject.addUseItemDetector(screen, 0, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addUseItemDetector(screen, 0, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 2))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 3));
    }

    private static void addInfernoSpikesPlatformingPuzzleScreen2(Screen screen) {
        AddObject.addUseItemDetector(screen, 0, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addUseItemDetector(screen, 0, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.FLAG_EQUALS, 2))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_12, ByteOp.ASSIGN_FLAG, 3));

        AddObject.addUseItemDetector(screen, 640, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addUseItemDetector(screen, 640, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addUseItemDetector(screen, 640, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 2),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 0));
        AddObject.addUseItemDetector(screen, 640, 0, 32, 24, "Cog of the Soul")
                .addTests(new TestByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.FLAG_EQUALS, 2),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_F, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 0),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_11, ByteOp.ASSIGN_FLAG, 0));
    }

    private static void addKeyholes(Screen screen) {
        GraphicsTextureDraw keyhole = new GraphicsTextureDraw(screen, 40, 40);
        keyhole.setLayer(0);
        keyhole.setImageFile("01effect.png");
        keyhole.setImageX(50 * 9 + 10);
        keyhole.setImageY(592);
        keyhole.setImageWidth(40);
        keyhole.setImageHeight(36);
        keyhole.setExitEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
        keyhole.setAnimation(0, 0, 1, 0);
        keyhole.setCollision(HitTile.Air);
        keyhole.setRGBAMax(0, 0, 0, 255);
        keyhole.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_1, ByteOp.FLAG_EQUALS, 0));
        screen.getObjects().add(keyhole);

        keyhole = new GraphicsTextureDraw(screen, 40, 40);
        keyhole.setLayer(0);
        keyhole.setImageFile("01effect.png");
        keyhole.setImageX(50 * 9);
        keyhole.setImageY(592);
        keyhole.setImageWidth(50);
        keyhole.setImageHeight(36);
        keyhole.setExitEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
        keyhole.setAnimation(0, 0, 1, 0);
        keyhole.setCollision(HitTile.Air);
        keyhole.setRGBAMax(0, 0, 0, 255);
        keyhole.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_2, ByteOp.FLAG_EQUALS, 0));
        screen.getObjects().add(keyhole);

        keyhole = new GraphicsTextureDraw(screen, 60, 40);
        keyhole.setLayer(0);
        keyhole.setImageFile("01effect.png");
        keyhole.setImageX(50 * 9 + 10);
        keyhole.setImageY(592);
        keyhole.setImageWidth(40);
        keyhole.setImageHeight(36);
        keyhole.setExitEffect(GraphicsTextureDraw.ExitEffect_FadeOut);
        keyhole.setAnimation(0, 0, 1, 0);
        keyhole.setCollision(HitTile.Air);
        keyhole.setRGBAMax(0, 0, 0, 255);
        keyhole.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_3, ByteOp.FLAG_EQUALS, 0));
        screen.getObjects().add(keyhole);

        AddObject.addUseItemDetector(screen, 40, 40, 4, 4, "Key of Eternity")
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_1, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.BAPHOMET_GATE_MIRROR_COVER, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_1, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addUseItemDetector(screen, 40, 40, 4, 4, "Pochette Key")
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_3, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.BAPHOMET_GATE_MIRROR_COVER, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_3, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_15, ByteOp.ASSIGN_FLAG, 1));

        KeyFairySpot obj = new KeyFairySpot(screen, 60, 80);
        obj.setWidth(40);
        obj.setHeight(40);

        obj.addTests(new TestByteOperation(FlagConstants.BAPHOMET_GATE_MIRROR_COVER, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_2, ByteOp.FLAG_EQUALS, 0));

        obj.addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_2, ByteOp.ASSIGN_FLAG, 1),
                new WriteByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.ASSIGN_FLAG, 1));

        screen.getObjects().add(obj);

        AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_1, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_13, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
        AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_2, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_14, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));
        AddObject.addSuccessSound(screen, Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_3, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.SCREEN_FLAG_15, ByteOp.FLAG_EQUALS, 1),
                new TestByteOperation(FlagConstants.WF_SHELL_HORN, ByteOp.FLAG_EQUALS, 2)));

        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_1, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_2, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_3KEYS_3, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.BAPHOMET_GATE_OPEN, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.BAPHOMET_GATE_OPEN, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_29, ByteOp.ASSIGN_FLAG, 1)));
    }

    private static void addMotherMantraObjects(Screen screen, int mantraNumber, int mantraFlag, int soundEffectFlag) {
        AddObject.addMantraDetector(screen, mantraNumber)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.FLAG_GTEQ, 2),
                        new TestByteOperation(mantraFlag, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(mantraFlag, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(mantraFlag, ByteOp.FLAG_EQUALS, 1)),
                Arrays.asList(new WriteByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.ADD_FLAG, 1),
                        new WriteByteOperation(mantraFlag, ByteOp.ASSIGN_FLAG, 2),
                        new WriteByteOperation(soundEffectFlag, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addFramesTimer(screen, 0,
                Arrays.asList(new TestByteOperation(FlagConstants.CUSTOM_MANTRAS_TOTAL, ByteOp.FLAG_GTEQ, TOTAL_MANTRAS),
                        new TestByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.FLAG_LTEQ, 8)),
                Arrays.asList(new WriteByteOperation(FlagConstants.BOSSES_SHRINE_TRANSFORM, ByteOp.ASSIGN_FLAG, 9)));
        AddObject.addMantraRecitedSound(screen, Arrays.asList(new TestByteOperation(mantraFlag, ByteOp.FLAG_EQUALS, 2),
                new TestByteOperation(soundEffectFlag, ByteOp.FLAG_EQUALS, 1)));
    }

    private static void addMantraRecitedIndicator(Screen screen, int zoneIndex, int mantraFlag, int indicatorX, int indicatorY, int layer) {
        GraphicsTextureDraw mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY);

        mantraRecitedIndicator.setLayer(layer);
        mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
        mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
        mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
        mantraRecitedIndicator.setCollision(HitTile.Air);
        mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
        mantraRecitedIndicator.setArg23(1);
        mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));

        if(zoneIndex == ZoneConstants.TWIN_FRONT) {
            mantraRecitedIndicator.setImageX(320);
            mantraRecitedIndicator.setImageY(480);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(40);
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 40);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(400);
            mantraRecitedIndicator.setImageY(480);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(40);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.ENDLESS) {
            mantraRecitedIndicator.setImageX(620);
            mantraRecitedIndicator.setImageY(540);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(60);
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 60);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(820);
            mantraRecitedIndicator.setImageY(540);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.ILLUSION) {
            mantraRecitedIndicator.setImageX(640);
            mantraRecitedIndicator.setImageY(500);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 20);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(720);
            mantraRecitedIndicator.setImageY(500);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 40);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(800);
            mantraRecitedIndicator.setImageY(480);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(40);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.GRAVEYARD) {
            mantraRecitedIndicator.setImageX(320);
            mantraRecitedIndicator.setImageY(380);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(80);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.MOONLIGHT) {
            mantraRecitedIndicator.setImageX(0);
            mantraRecitedIndicator.setImageY(480);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(40);
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 40);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(80);
            mantraRecitedIndicator.setImageY(480);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(40);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.GODDESS) {
            mantraRecitedIndicator.setImageX(0);
            mantraRecitedIndicator.setImageY(620);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 20);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(80);
            mantraRecitedIndicator.setImageY(620);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 40);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(160);
            mantraRecitedIndicator.setImageY(620);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);

            mantraRecitedIndicator = new GraphicsTextureDraw(screen, indicatorX, indicatorY + 60);
            mantraRecitedIndicator.setLayer(layer);
            mantraRecitedIndicator.setEntryEffect(GraphicsTextureDraw.EntryEffect_FadeIn);
            mantraRecitedIndicator.setImageFile(GraphicsTextureDraw.ImageFile_map);
            mantraRecitedIndicator.setAnimation(0, 1, 0, 0);
            mantraRecitedIndicator.setCollision(HitTile.Air);
            mantraRecitedIndicator.setRGBAMax(0, 0, 0, 255);
            mantraRecitedIndicator.setArg23(1);
            mantraRecitedIndicator.setImageX(240);
            mantraRecitedIndicator.setImageY(620);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(20);
            mantraRecitedIndicator.addTests(new TestByteOperation(mantraFlag, ByteOp.FLAG_GTEQ, 1));
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.RUIN) {
            mantraRecitedIndicator.setImageX(280);
            mantraRecitedIndicator.setImageY(420);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(80);
            screen.getObjects().add(mantraRecitedIndicator);
        }
        else if(zoneIndex == ZoneConstants.BIRTH_SWORDS || zoneIndex == ZoneConstants.BIRTH_SKANDA) {
            mantraRecitedIndicator.setImageX(160);
            mantraRecitedIndicator.setImageY(240);
            mantraRecitedIndicator.setImageWidth(80);
            mantraRecitedIndicator.setImageHeight(80);
            screen.getObjects().add(mantraRecitedIndicator);
        }
    }

    private static void addSurfacePlatforming(Screen screen) {
        ToggleBlock toggleBlock = new ToggleBlock(screen, 400, 400);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(toggleBlock);

        toggleBlock = new ToggleBlock(screen, 180, 400);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1));
        screen.getObjects().add(toggleBlock);

        toggleBlock = new ToggleBlock(screen, 180, 300);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(toggleBlock);

        toggleBlock = new ToggleBlock(screen, 120, 400);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1));
        screen.getObjects().add(toggleBlock);

        toggleBlock = new ToggleBlock(screen, 260, 220);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1));
        screen.getObjects().add(toggleBlock);

        toggleBlock = new ToggleBlock(screen, 260, 140);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_0, ByteOp.ASSIGN_FLAG, 0));
        screen.getObjects().add(toggleBlock);

        toggleBlock = new ToggleBlock(screen, 100, 120);
        toggleBlock.setImagePosition(0, 200);
        toggleBlock.setDamage(0);
        toggleBlock.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1));
        toggleBlock.addUpdates(new WriteByteOperation(FlagConstants.SCREEN_FLAG_1, ByteOp.ASSIGN_FLAG, 1));
        screen.getObjects().add(toggleBlock);

        AddObject.addLemezaDetector(screen, 0, 0, 11, 17,
                Arrays.asList(new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0)),
                Arrays.asList(new WriteByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.ASSIGN_FLAG, 1)));
        AddObject.addPot(screen, 180, 180, PotGraphic.SURFACE, DropType.NOTHING, 0)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1));

        AddObject.addFloatingItem(screen, 40, 40, ItemConstants.PHILOSOPHERS_OCARINA, true)
                .addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.FLAG_EQUALS, 1),
                        new TestByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.WF_PHILOSOPHERS_OCARINA, ByteOp.ASSIGN_FLAG, 2),
                        new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_SOUND_CANYON, ByteOp.ASSIGN_FLAG, 2));
    }

    private FairyPoint addFairyPoint(ObjectContainer screen, int x, int y) {
        FairyPoint fairyPoint = new FairyPoint(screen, x, y);
        fairyPoint.setFairyType(FairyPoint.HEALTH_FAIRY);
        fairyPoint.addTests(new TestByteOperation(new TestByteOperation(FlagConstants.FAIRY_POINTS_ACTIVE, ByteOp.FLAG_EQUALS, 1)));
        screen.getObjects().add(fairyPoint);
        return fairyPoint;
    }

    private static GraphicsTextureDraw addCrossOfLight(Screen screen, int x, int y, int layer) {
        GraphicsTextureDraw crossOfLight = new GraphicsTextureDraw(screen, x, y);

        crossOfLight.setLayer(layer);
        crossOfLight.setImageFile("01effect.png");

        crossOfLight.setImageX(getCrossOfLightX(screen.getZoneIndex()));
        crossOfLight.setImageY(screen.getZoneIndex() < 14 ? 708 : 788);
        crossOfLight.setImageWidth(80);
        crossOfLight.setImageHeight(80);

        crossOfLight.setAnimation(0, 1, 0, 0);
        crossOfLight.setCollision(HitTile.Air);
        crossOfLight.setRGBAMax(0, 0, 0, 255);
        crossOfLight.setArg23(1);
        screen.getObjects().add(crossOfLight);

        GraphicsTextureDraw crossOfLightAnimation = new GraphicsTextureDraw(screen, x + 20, y);
        crossOfLightAnimation.addTests(new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_MANTRAS_ENABLED, ByteOp.FLAG_GTEQ, 2));

        crossOfLightAnimation.setLayer(layer + 1);
        crossOfLightAnimation.setImageFile("01effect.png");

        crossOfLightAnimation.setImageX(480);
        crossOfLightAnimation.setImageY(320);
        crossOfLightAnimation.setImageWidth(40);
        crossOfLightAnimation.setImageHeight(60);

        crossOfLightAnimation.setAnimation(2, 7, 3, 0);
        crossOfLightAnimation.setCollision(HitTile.Air);
        crossOfLightAnimation.setRGBAMax(0, 0, 0, 255);
        crossOfLightAnimation.setBlendMode(GraphicsTextureDraw.BlendMode_Add);
        crossOfLightAnimation.setArg23(1);
        screen.getObjects().add(crossOfLightAnimation);
        return crossOfLightAnimation;
    }

    private static int getCrossOfLightX(int zoneIndex) {
        if(zoneIndex == 0) {
            return 0;
        }
        if(zoneIndex == 2) {
            return 80;
        }
        if(zoneIndex == 3) {
            return 160;
        }
        if(zoneIndex == 4) {
            return 240;
        }
        if(zoneIndex == 5) {
            return 320;
        }
        if(zoneIndex == 6) {
            return 400;
        }
        if(zoneIndex == 7) {
            return 480;
        }
        if(zoneIndex == 8) {
            return 560;
        }
        if(zoneIndex == 10) {
            return 640;
        }
        if(zoneIndex == 11) {
            return 720;
        }
        if(zoneIndex == 12) {
            return 800;
        }
        if(zoneIndex == 13) {
            return 880;
        }
        if(zoneIndex == 14) {
            return 0;
        }
        if(zoneIndex == 15 || zoneIndex == 16) {
            return 80;
        }
        if(zoneIndex == 17) {
            return 160;
        }
        return 0;
    }

    private static void addIllusionFloatingItem(Screen screen, int x, int y, int itemArg, int flagStart, int flagEnd) {
        AddObject.addFloatingItem(screen, x, y, itemArg, false)
                .addTests(new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, flagStart),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 0))
                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.ASSIGN_FLAG, flagEnd),
                        new WriteByteOperation(FlagConstants.SCREEN_FLAG_9, ByteOp.ASSIGN_FLAG, 1));
        AddObject.addFloatingItem(screen, x, y, TREASURE_OF_THE_FOOL_ITEM, true)
                .addTests(new TestByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.FLAG_EQUALS, flagStart),
                        new TestByteOperation(FlagConstants.SCREEN_FLAG_10, ByteOp.FLAG_EQUALS, 1))
                .addUpdates(new WriteByteOperation(FlagConstants.CUSTOM_FOOLS2022_ILLUSION_ITEM, ByteOp.ASSIGN_FLAG, 7),
                        new WriteByteOperation(TREASURE_OF_THE_FOOL_FLAG, ByteOp.ASSIGN_FLAG, 2));
    }

    private static GameObject addMailTimer(ObjectContainer objectContainer, int mailFlagIndex) {
        return AddObject.addFramesTimer(objectContainer, MAIL_DELAY_FRAMES,
                Arrays.asList(
                        new TestByteOperation(mailFlagIndex, ByteOp.FLAG_EQUALS, 0),
                        new TestByteOperation(FlagConstants.WF_SOFTWARE_XMAILER, ByteOp.FLAG_EQUALS, 2)),
                Arrays.asList(
                        new WriteByteOperation(mailFlagIndex, ByteOp.ASSIGN_FLAG, 1),
                        new WriteByteOperation(FlagConstants.MAIL_COUNT, ByteOp.ADD_FLAG, 1)));
    }

    private static void addSunEscapeRubble(Screen screen, int x, int y) {
        GraphicsFileEntry rubble = GraphicsFileData.getEveg03GraphicsFileEntries().get(GraphicsFileData.SUN_RUBBLE_LARGE);

        GraphicsTextureDraw rubbleLeft = new GraphicsTextureDraw(screen, x, y);
        rubbleLeft.setLayer(0);
        rubbleLeft.setImageFile(GraphicsTextureDraw.ImageFile_eveg);
        rubbleLeft.setImagePosition(rubble.getX(), rubble.getY());
        rubbleLeft.setImageSize(40, rubble.getHeight());
        rubbleLeft.setAnimation(0, 1, 0, 0);
        rubbleLeft.setCollision(HitTile.Air);
        rubbleLeft.setRGBAMax(0, 0, 0, 255);
        rubbleLeft.setArg23(1);
        rubbleLeft.addTests(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1));
        screen.getObjects().add(rubbleLeft);

        GraphicsTextureDraw rubbleRight = new GraphicsTextureDraw(screen, x + 40, y);
        rubbleRight.setLayer(0);
        rubbleRight.setImageFile(GraphicsTextureDraw.ImageFile_eveg);
        rubbleRight.setImagePosition(rubble.getX() + rubble.getWidth() - 40, rubble.getY());
        rubbleRight.setImageSize(40, rubble.getHeight());
        rubbleRight.setAnimation(0, 1, 0, 0);
        rubbleRight.setCollision(HitTile.Air);
        rubbleRight.setRGBAMax(0, 0, 0, 255);
        rubbleRight.setArg23(1);
        rubbleRight.addTests(new TestByteOperation(FlagConstants.ESCAPE, ByteOp.FLAG_EQUALS, 1));
        screen.getObjects().add(rubbleRight);
    }

    private static void addDanceDetectors(Screen screen, int danceBlock) {
        int zoneIndex = screen.getZoneIndex();
        int roomIndex = screen.getRoomIndex();
        int screenIndex = screen.getScreenIndex();

        if(zoneIndex == 6) {
            if(roomIndex == 2 && screenIndex == 0) {
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 2 && screenIndex == 1) {
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 3 && screenIndex == 0) {
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 3 && screenIndex == 1) {
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 4 && screenIndex == 0) {
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 4 && screenIndex == 1) {
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 5 && screenIndex == 0) {
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 5 && screenIndex == 1) {
                AddObject.addDanceDetector(screen, 0, 480, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 480, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 6 && screenIndex == 0) {
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 6 && screenIndex == 1) {
                AddObject.addDanceDetector(screen, 0, 480, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 480, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 7 && screenIndex == 0) {
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 0, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
            else if(roomIndex == 7 && screenIndex == 1) {
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 0),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 1)));
                AddObject.addDanceDetector(screen, 640, 0, danceBlock,
                        Arrays.asList(new TestByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.FLAG_EQUALS, 1),
                                new TestByteOperation(FlagConstants.EXTINCTION_PERMA_LIGHT, ByteOp.FLAG_LTEQ, 2)),
                        Arrays.asList(new WriteByteOperation(FlagConstants.EXTINCTION_TEMP_LIGHT, ByteOp.ASSIGN_FLAG, 0)));
            }
        }
    }
}
