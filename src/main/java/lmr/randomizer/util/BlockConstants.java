package lmr.randomizer.util;

import java.util.Arrays;
import java.util.List;

public final class BlockConstants {
    public static final int MapsBlock = 0;
    public static final int ItemNameBlock = 1;
    public static final int ItemDescriptionBlock = 2;
    public static final int MenuBlock = 4;
    public static final int SoftwareBlock = 5;
    public static final int EmailBlock = 6;
    public static final int GrailPointBlock = 7;
    public static final int HTMapNamesLimitedBlock = 28;

    public static final int FootOfFuto = 88;

    public static final int SnapshotsScan_TowerOfTheGoddess = 319;
    public static final int SnapshotsScan_TowerOfRuin = 324;
    public static final int SnapshotsScan_Item = 724; // Extinction (mantra.exe), Graveyard (emusic.exe), Dimensional (beolamu.exe)

    public static final int FairyQueenFirstConversation = 215;
    public static final int FairyQueenWhenTheTimeComesConversation = 218;
    public static final int XelpudTalismanConversation = 369;
    public static final int XelpudPillarConversation = 370;
    public static final int XelpudMSX2Conversation = 377;
    public static final int MulbrukStoneConversationBlock = 392; // 0x188; stays with Mulbruk seal door
    public static final int MulbrukWakingUpConversationBlock = 393; // 0x189; moved to flag check conversations in randomizer
    public static final int MulbrukIntroBlock = 393; // Replaced for Helloween 2019
    public static final int MulbrukHTConversationBlock = 414; // 0x19e; Replaced for Halloween 2021
    public static final int MulbrukFatherLocationConversationBlock = 415; // 0x19f
    public static final int MulbrukSwimsuitReactionConversationBlock = 418; // 0x1a2

    public static final int MapText_GateOfGuidance = 10;
    public static final int MapText_Surface = 11;
    public static final int MapText_Mausoleum = 12;
    public static final int MapText_Sun = 13;
    public static final int MapText_Spring = 14;
    public static final int MapText_Inferno = 15;
    public static final int MapText_Extinction = 16;
    public static final int MapText_TwinLabyrinths = 17;
    public static final int MapText_Endless = 18;
    public static final int MapText_Shrine = 19;
    public static final int MapText_Illusion = 20;
    public static final int MapText_Graveyard = 21;
    public static final int MapText_Moonlight = 22;
    public static final int MapText_Goddess = 23;
    public static final int MapText_Ruin = 24;
    public static final int MapText_Birth_Swords = 25;
    public static final int MapText_Birth_Skanda = 26;
    public static final int MapText_Dimensional = 27;
    public static final int MapText_HT = 28;
    public static final int MapText_GateOfTime1 = 29;
    public static final int MapText_GateOfTime2 = 30;

    public static final int MapGraphics_GateOfGuidance = 497; // 0x1f1
    public static final int MapGraphics_Surface = 498;
    public static final int MapGraphics_Mausoleum = 499;
    public static final int MapGraphics_Sun = 500;
    public static final int MapGraphics_Spring = 501;
    public static final int MapGraphics_Inferno = 502;
    public static final int MapGraphics_Extinction = 503;
    public static final int MapGraphics_TwinLabyrinths = 504;
    public static final int MapGraphics_Endless = 505;
    public static final int MapGraphics_Shrine = 506;
    public static final int MapGraphics_Illusion = 507;
    public static final int MapGraphics_Graveyard = 508;
    public static final int MapGraphics_Moonlight = 509;
    public static final int MapGraphics_Goddess = 510;
    public static final int MapGraphics_Ruin = 511;
    public static final int MapGraphics_Birth_Swords = 512;
    public static final int MapGraphics_Birth_Skanda = 995;
    public static final int MapGraphics_Dimensional = 513;
    public static final int MapGraphics_HT = 1030;

    public static final int ItemConversationMekuri = 37;
    public static final int ItemConversationPepper = 245;
    public static final int ItemConversationAnchor = 247;
    public static final int ItemConversationMiniDoll = 249;
    public static final int ItemConversationXmailer = 364;
    public static final int ItemConversationMulanaTalisman = 371;
    public static final int ItemConversationBookOfTheDead = 397;
    public static final int ItemConversationMapSurface = 716;
    public static final int ItemConversationProvocativeBathingSuit = 1012;

    public static final int XelpudHeldItemConversation_DjedPillar = 378;
    public static final int XelpudHeldItemConversation_MiniDoll = 379;
    public static final int XelpudHeldItemConversation_MagatamaJewel = 380;
    public static final int XelpudHeldItemConversation_CogOfTheSoul = 381;
    public static final int XelpudHeldItemConversation_LampOfTime = 382;
    public static final int XelpudHeldItemConversation_PochetteKey = 383;
    public static final int XelpudHeldItemConversation_DragonBone = 384;
    public static final int XelpudHeldItemConversation_CrystalSkull = 385;
    public static final int XelpudHeldItemConversation_Vessel = 386;
    public static final int XelpudHeldItemConversation_Pepper = 387;
    public static final int XelpudHeldItemConversation_WomanStatue = 388;
    public static final int XelpudHeldItemConversation_MaternityStatue = 389;
    public static final int XelpudHeldItemConversation_KeyOfEternity = 390;
    public static final int XelpudHeldItemConversation_SerpentStaff = 391;
    public static final int XelpudHeldItemConversation_HandScanner = 986;
    public static final int XelpudHeldItemConversation_MulanaTalisman = 987;

    public static final int NpcConversation_Hiner = 33; // Hiner - Surface NPC, 01-00-02
    public static final int NpcConversation_PriestZarnac = 40; // Priest Zarnac - Guidance NPC, 00-04-01
    public static final int NpcConversation_PriestXanado = 73; // Priest Xanado - Mausoleum NPC, 02-02-00
    public static final int NpcConversation_PriestHidlyda = 101; // Priest Hidlyda - Spring NPC, 04-06-01
    public static final int NpcConversation_PhilosopherGiltoriyo = 134; // Philosopher Giltoriyo - Spring NPC, 04-00-01
    public static final int NpcConversation_PriestMadomono = 135; // Priest Madomono - Sun NPC, 03-04-02
    public static final int NpcConversation_PriestGailious = 148; // Priest Gailious - Inferno NPC, 05-02-01
    public static final int NpcConversation_PriestRomancis = 158; // Priest Romancis - Inferno NPC, 05-03-02
    public static final int NpcConversation_PriestAramo = 168; // Priest Aramo - Extinction NPC, 06-06-00
    public static final int NpcConversation_PriestTriton = 169; // Priest Triton - Extinction NPC, 06-09-01
    public static final int NpcConversation_PriestJaguarfiv = 203; // Priest Jaguarfiv - Twin Labs NPC, 07-10-01
    public static final int NpcConversation_GiantThexde = 274; // Giant Thexde - Graveyard NPC, 11-07-00
    public static final int NpcConversation_PhilosopherAlsedana = 289; // Philosopher Alsedana - Moonlight NPC, 12-06-00
    public static final int NpcConversation_PhilosopherSamaranta = 304; // Philosopher Samaranta - Goddess NPC, 13-05-01
    public static final int NpcConversation_PriestLaydoc = 322; // Priest Laydoc - Ruin NPC, 14-00-01
    public static final int NpcConversation_PriestAshgine = 338; // Priest Ashgine - Birth NPC, 16-01-00
    public static final int NpcConversation_PhilosopherFobos_Ladder = 357;
    public static final int NpcConversation_Moger = 472; // Moger - Surface NPC, 01-02-00
    public static final int NpcConversation_PhilosopherFobos_MedicineCheck = 478; // Philosopher Fobos - Dimensional NPC, 17-02-00
    public static final int NpcConversation_8BitElder = 514; // 8bit Elder - Gate of Time NPC, 21-00-00

    public static final int Master_Hiner = 671; // Hiner - Surface NPC, 01-00-02
    public static final int Master_Moger = 672; // Moger - Surface NPC, 01-02-00
    public static final int Master_FormerMekuriMaster_Mekuri = 673; // Former Mekuri Master - Surface NPC, 01-07-00
    public static final int Master_PriestZarnac = 674; // Priest Zarnac - Guidance NPC, 00-04-01
    public static final int Master_PriestXanado = 675; // Priest Xanado - Mausoleum NPC, 02-02-00
    public static final int Master_PhilosopherGiltoriyo = 677; // Philosopher Giltoriyo - Spring NPC, 04-00-01
    public static final int Master_PriestHidlyda = 678; // Priest Hidlyda - Spring NPC, 04-06-01
    public static final int Master_PriestRomancis = 679; // Priest Romancis - Inferno NPC, 05-03-02
    public static final int Master_PriestAramo = 680; // Priest Aramo - Extinction NPC, 06-06-00
    public static final int Master_PriestTriton = 681; // Priest Triton - Extinction NPC, 06-09-01
    public static final int Master_PriestJaguarfiv = 683; // Priest Jaguarfiv - Twin Labs NPC, 07-10-01
    public static final int Master_FairyQueen_RequestPendant = 684; // The Fairy Queen - Endless NPC, 08-01-00
    public static final short Master_FairyQueen_WaitingForPendant = 685; // The Fairy Queen - Endless NPC, 08-01-00
    public static final int Master_FairyQueen_UnlockFairies = 686; // The Fairy Queen - Endless NPC, 08-01-00
    public static final short Master_FairyQueen_WhenTheTimeComes = 687; // The Fairy Queen - Endless NPC, 08-01-00
    public static final short Master_FairyQueen_TrueShrine1 = 688; // The Fairy Queen - Endless NPC, 08-01-00
    public static final int Master_MrSlushfund_Pepper = 689; // Mr. Slushfund - Illusion NPC, 10-08-00 - References ItemConversationPepper
    public static final short Master_MrSlushfund_WaitingForTreasures = 690;
    public static final int Master_MrSlushfund_Anchor = 691; // References ItemConversationAnchor
    public static final int Master_MrSlushfund_NeverComeBack = 692;
    public static final int Master_PriestAlest = 693; // Priest Alest - Illusion NPC, 10-08-01
    public static final int Master_StrayFairy = 694; // Stray fairy - Illusion NPC, 10-00-01
    public static final int Master_GiantThexde = 696; // Giant Thexde - Graveyard NPC, 11-07-00
    public static final int Master_PhilosopherAlsedana = 698; // Philosopher Alsedana - Moonlight NPC, 12-06-00
    public static final int Master_PhilosopherSamaranta = 700; // Philosopher Samaranta - Goddess NPC, 13-05-01
    public static final int Master_PriestLaydoc = 701; // Priest Laydoc - Ruin NPC, 14-00-01
    public static final int Master_PriestAshgine = 702; // Priest Ashgine - Birth NPC, 16-01-00
    public static final int Master_PhilosopherFobos_Ladder = 704;
    public static final int Master_PhilosopherFobos_MedicineCheck = 705; // Philosopher Fobos - Dimensional NPC, 17-02-00
    public static final int Master_8BitElder = 706; // 8bit Elder - Gate of Time NPC, 21-00-00
    public static final int Master_duplex = 707; // duplex - Illusion NPC, 10-02-02
    public static final int Master_Samieru = 708; // Samieru - Moonlight NPC, 12-03-00
    public static final int Master_Naramura = 709; // Naramura - Goddess NPC, 13-06-03
    public static final int Master_8BitFairy = 710; // 8bit Fairy - Gate of Time NPC, 20-00-01
    public static final int Master_PriestMadomono = 718; // Priest Madomono - Sun NPC, 03-04-02
    public static final int Master_PriestGailious = 723; // Priest Gailious - Inferno NPC, 05-02-01
    public static final short Master_Mulbruk_StoneConversation = 912; // 0x390; Mulbruk, Sun NPC, 03-03-00
    public static final short Master_PriestAlest_NoItem = 915;
    public static final int Master_MulbrukEscapeRegular = 924; // 0x39c
    public static final int Master_MulbrukEscapeSwimsuit = 926; // 0x39e
    public static final short Master_FairyQueen_TrueShrine2 = 985; // The Fairy Queen - Endless NPC, 08-01-00
    public static final int Master_Mulbruk_ProvocativeBathingSuitReaction = 1013;

    public static final int EmptyConversation = 471;
    public static final int Master_Naramura_Empty = 921;
    public static final int Master_Philosopher_Stone = 676; // References EmptyConversation / 471
    public static final int Master_Philosopher_Stone_Unused1 = 699; // References EmptyConversation / 471
    public static final int Master_Philosopher_Stone_Unused2 = 703; // References EmptyConversation / 471
    public static final int Master_Xelpud_Missing = 913; // References EmptyConversation / 471
    public static final int Master_duplex_Missing = 919; // References EmptyConversation / 471
    public static final int Master_Unlabeled_Missing = 920; // References EmptyConversation / 471
    public static final int Master_Mulbruk_Empty = 1014; // Conversation after showing Provocative Bathing Suit; removed in randomizer; references EmptyConversation / 471

    public static final int Master_Dracuet_WaitForNightfall = 726; // Tailor Dracuet - Guidance NPC, 00-06-00
    public static final int Master_Dracuet_BackInTime = 991; // Tailor Dracuet - Illusion NPC, 10-07-00
    public static final int Master_Dracuet_HugeCasket = 993; // Tailor Dracuet - Gate of Time NPC, 20-03-01
    public static final int Master_Fairy_NightSurface = 998; // Fairy - Night Surface NPC, 22-07-00
    public static final int Master_Dracuet_HTUnlocked = 1000; // Tailor Dracuet - Goddess NPC, 13-01-00
    public static final int Master_Dracuet_ProvocativeBathingSuit = 1011; // References ItemConversationProvocativeBathingSuit

    public static final int MultiMaster_ElderXelpudRandomSetA = 484; // Elder Xelpud - Surface NPC, 01-02-01
    public static final int MultiMaster_MulbrukRandomSetA = 485; // Mulbruk, Sun NPC, 03-03-00
    public static final int MultiMaster_Mulbruk_Awake = 990; // Mulbruk, Sun NPC, 03-03-00
    public static final int MultiMaster_ElderXelpudRandomSetC_Rug = 1019;
    public static final int MultiMaster_ElderXelpudRandomSetB = 1080;
    public static final int MultiMaster_ElderXelpudRandomSetC_NoRug = 1081;
    public static final int MultiMaster_MulbrukRandomSetB = 1082;
    public static final int MultiMaster_MulbrukRandomSetC = 1083;

    public static final int Sprite_Xelpud = 732; // Includes Xelpud bunemon info
    public static final int Sprite_Mulbruk = 736; // Includes Mulbruk bunemon info

    public static final int ShopBlockNebur = 34;
    public static final int ShopBlockNeburAlt = 490;
    public static final int ShopBlockSidro = 35;
    public static final int ShopBlockModro = 36;
    public static final int ShopBlockPenadventOfGhost = 39;
    public static final int ShopBlockGreedyCharlie = 74;
    public static final int ShopBlockShalomIII = 100;
    public static final int ShopBlockUsasVI = 102;
    public static final int ShopBlockKingvalleyI = 103;
    public static final int ShopBlockMrFishman = 132;
    public static final int ShopBlockMrFishmanAlt = 133;
    public static final int ShopBlockOperatorCombaker = 167;
    public static final int ShopBlockYiegahKungfu = 185;
    public static final int ShopBlockArrogantMetagear = 187;
    public static final int ShopBlockArrogantSturdySnake = 204;
    public static final int ShopBlockYiearKungfu = 205;
    public static final int ShopBlockAffectedKnimare = 220;
    public static final int ShopBlockMoverAthleland = 244;
    public static final int ShopBlockGiantMopiran = 272;
    public static final int ShopBlockGiantMopiranAngelShield = 273;
    public static final int ShopBlockKingvalleyII = 290; // Kingvalley II - Moonlight NPC, 12-07-00
    public static final int ShopBlockEnergeticBelmont = 303;
    public static final int ShopBlockMechanicalEfspi = 321;
    public static final int ShopBlockMudManQubert = 337; // Priest Ashgine - Birth NPC, 16-01-01
    public static final int ShopBlockHotbloodedNemesistwo = 470;
    public static final int ShopBlockTailorDracuet = 1008; // Tailor Dracuet - HT NPC, 23-08-01

    public static final int XelpudFlagCheckBlock = 480;
    public static final int XelpudScoreCheckBlock = 482;
    public static final int MulbrukFlagCheckBlock = 486;
    public static final int MulbrukScoreCheckBlock = 488;
    public static final int MulbrukRandomBlock1 = 489;
    public static final int MulbrukRandomBlock2 = 1078;
    public static final int MulbrukRandomBlock3 = 1079;

    public static final short MulbrukRandom_DontWake = 407;
    public static final short MulbrukRandom_Sleep100MoreYears = 1056;
    public static final short MulbrukRandom_Dream_IgnorantFool = 1066;
    public static final short MulbrukRandom_Dream_PutAStoneOnTopOfMulbruk = 1067;
    public static final short MulbrukRandom_Dream_HappyHaha = 1068;
    public static final short MulbrukRandom_Dream_Hamburger = 1069;
    public static final short MulbrukRandom_Dream_Continue = 1070;
    public static final short MulbrukRandom_Dream_Grr = 1071;
    public static final short MulbrukRandom_Snort = 1072;
    public static final short MulbrukRandom_Dream_BowBeforeMulbruk = 1073;

    public static final int RepeatConversationBookOfTheDead = 643;

    public static final int Conversation_MulbrukEscapeRegular = 925;
    public static final int Conversation_MulbrukEscapeSwimsuit = 927;

    public static final int Removed_XelpudScoreWindHowling = 373;
    public static final int Removed_MulbrukLowScore = 719;
    public static final int Removed_WindHowlingSwimsuit = 1049;

    public static final int Tablet_Guidance_DeathAwaitsThePowerless = 43; // Glow flag = TABLET_GLOW_GUIDANCE_DEATH_AWAITS_THE_POWERLESS
    public static final int Tablet_Guidance_Entrance = 44; // Glow flag = TABLET_GLOW_GUIDANCE_ENTRANCE
    public static final int DamagedTablet_Guidance_Guild = 47; // Glow flag = TABLET_GLOW_GUIDANCE_GUILD_DAMAGED
    public static final int Tablet_Guidance_HolyGround = 48; // Glow flag = TABLET_GLOW_GUIDANCE_HOLY_GROUND
    public static final int Tablet_Guidance_ProveThineCourage = 49; // Glow flag = TABLET_GLOW_GUIDANCE_PROVE_THINE_COURAGE
    public static final int Tablet_Spring_ChildWasBorn = 53; // Glow flag = TABLET_GLOW_SPRING_CHILD_WAS_BORN
    public static final int Tablet_Guidance_Offer3Lights = 55; // Glow flag = TABLET_GLOW_GUIDANCE_OFFER_3_LIGHTS
    public static final int Tablet_Guidance_8Ankhs = 56; // Glow flag = TABLET_GLOW_GUIDANCE_8_ANKHS
    public static final int Tablet_Guidance_GiantsHistory = 57; // Glow flag = TABLET_GLOW_GUIDANCE_GIANTS_HISTORY
    public static final int Tablet_Guidance_ChiYou = 61; // Glow flag = TABLET_GLOW_GUIDANCE_CHI_YOU
    public static final int Tablet_Sun_StatueOfTheGiant = 62; // Glow flag = TABLET_GLOW_SUN_STATUE_OF_THE_GIANT
    public static final int Tablet_Guidance_CrossTheSacredLake = 63; // Glow flag = TABLET_GLOW_GUIDANCE_CROSS_THE_SACRED_LAKE
    public static final int Tablet_Guidance_HolyGrailMemories = 65; // Glow flag = TABLET_GLOW_GUIDANCE_GRAIL_MEMORIES
    public static final int Tablet_Guidance_Watchtower = 67; // Glow flag = TABLET_GLOW_GUIDANCE_WATCHTOWER
    public static final int Tablet_Guidance_ItShallConnect = 71; // Glow flag = TABLET_GLOW_GUIDANCE_IT_SHALL_CONNECT
    public static final int Tablet_Mausoleum_CelestialBodies = 76; // Glow flag = TABLET_GLOW_MAUSOLEUM_CELESTIAL_BODIES
    public static final int Tablet_Mausoleum_Abuto = 79; // Glow flag = TABLET_GLOW_MAUSOLEUM_ABUTO
    public static final int Tablet_Mausoleum_ThouArtTiny = 80; // Glow flag = TABLET_GLOW_MAUSOLEUM_THOU_ART_TINY
    public static final int Tablet_Mausoleum_Ribu = 83; // Glow flag = TABLET_GLOW_MAUSOLEUM_RIBU
    public static final int DamagedTablet_Mausoleum_GhostLord = 85; // Glow flag = TABLET_GLOW_MAUSOLEUM_GHOST_LORD_DAMAGED
    public static final int Tablet_Mausoleum_Migela = 86; // Glow flag = TABLET_GLOW_MAUSOLEUM_MIGELA
    public static final int Tablet_Mausoleum_Ledo = 87; // Glow flag = TABLET_GLOW_MAUSOLEUM_LEDO
    public static final int Tablet_Mausoleum_Ji = 89; // Glow flag = TABLET_GLOW_MAUSOLEUM_JI
    public static final int Tablet_Mausoleum_Bado = 90; // Glow flag = TABLET_GLOW_MAUSOLEUM_BADO
    public static final int Tablet_Mausoleum_MigelaLeftHanded = 91; // Glow flag = TABLET_GLOW_MAUSOLEUM_MIGELA_LEFT_HANDED
    public static final int Tablet_Mausoleum_AbutoJiRibuSakit = 92; // Glow flag = TABLET_GLOW_MAUSOLEUM_ABUTO_JI_RIBU_SAKIT
    public static final int Tablet_Mausoleum_Zebu = 93; // Glow flag = TABLET_GLOW_MAUSOLEUM_ZEBU
    public static final int DamagedTablet_Mausoleum_RedLight = 94; // Glow flag = TABLET_GLOW_MAUSOLEUM_RED_LIGHT_DAMAGED
    public static final int Tablet_Mausoleum_ZebuUnableToMove = 95; // Glow flag = TABLET_GLOW_MAUSOLEUM_ZEBU_UNABLE_TO_MOVE
    public static final int Tablet_Mausoleum_Numbers = 96; // Glow flag = TABLET_GLOW_MAUSOLEUM_NUMBERS
    public static final int Tablet_Mausoleum_BadoMigelaLedoFuto = 97; // Glow flag = TABLET_GLOW_MAUSOLEUM_BADO_MIGELA_LEDO_FUTO
    public static final int Tablet_Mausoleum_NineBrothers = 98; // Glow flag = TABLET_GLOW_MAUSOLEUM_NINE_BROTHERS
    public static final int Tablet_Mausoleum_Sakit = 99; // Glow flag = TABLET_GLOW_MAUSOLEUM_SAKIT
    public static final int Tablet_Sun_JumpIntoTheSun = 106; // Glow flag = TABLET_GLOW_SUN_JUMP_INTO_THE_SUN
    public static final int Tablet_Sun_ChallengeTheInfernoCavern = 107; // Glow flag = TABLET_GLOW_SUN_CHALLENGE_THE_INFERNO_CAVERN
    public static final int Tablet_Sun_CastALight = 109; // Glow flag = TABLET_GLOW_SUN_CAST_A_LIGHT
    public static final int Tablet_Sun_Scalesphere = 111; // Glow flag = TABLET_GLOW_SUN_SCALESPHERE
    public static final int Tablet_Sun_PathThatConnectsTwoPyramids = 112; // Glow flag = TABLET_GLOW_SUN_PATH_THAT_CONNECTS_TWO_PYRAMIDS
    public static final int Tablet_Sun_MoonGazingPit = 113; // Glow flag = TABLET_GLOW_SUN_MOON_GAZING_PIT
    public static final int Tablet_Sun_FirstMantra = 114; // Glow flag = TABLET_GLOW_SUN_FIRST_MANTRA
    public static final int Tablet_Sun_SecondMantra = 116; // Glow flag = TABLET_GLOW_SUN_SECOND_MANTRA
    public static final int Tablet_Sun_ThirdMantra = 117; // Glow flag = TABLET_GLOW_SUN_THIRD_MANTRA
    public static final int Tablet_Sun_MantraOrder = 118; // Glow flag = TABLET_GLOW_SUN_MANTRA_ORDER
    public static final int Tablet_Sun_FourthMantra = 119; // Glow flag = TABLET_GLOW_SUN_FOURTH_MANTRA
    public static final int Tablet_Sun_FifthMantra = 120; // Glow flag = TABLET_GLOW_SUN_FIFTH_MANTRA
    public static final int Tablet_Sun_SeventhMantra = 121; // Glow flag = TABLET_GLOW_SUN_SEVENTH_MANTRA
    public static final int Tablet_Sun_LastMantra = 122; // Glow flag = TABLET_GLOW_SUN_LAST_MANTRA
    public static final int Tablet_Sun_ManWomanWeapon = 123; // Glow flag = TABLET_GLOW_SUN_MAN_WOMAN_WEAPON
    public static final int Tablet_Sun_WomanWithChild = 124; // Glow flag = TABLET_GLOW_SUN_WOMAN_WITH_CHILD
    public static final int DamagedTablet_Sun_FillThisPlaceWithWater = 125; // Glow flag = TABLET_GLOW_SUN_FILL_THIS_PLACE_WITH_WATER_DAMAGED
    public static final int Tablet_Sun_NoLightUpAhead = 126; // Glow flag = TABLET_GLOW_SUN_NO_LIGHT_UP_AHEAD
    public static final int Tablet_Sun_ThoseThatFlyShallBeCastDown = 127; // Glow flag = TABLET_GLOW_SUN_THOSE_THAT_FLY_SHALL_BE_CAST_DOWN
    public static final int Tablet_Sun_MeditateUnderWedjet = 128; // Glow flag = TABLET_GLOW_SUN_MEDITATE_UNDER_WEDJET
    public static final int Tablet_Sun_PowerOfTheTwins = 129; // Glow flag = TABLET_GLOW_SUN_POWER_OF_THE_TWINS
    public static final int Tablet_Sun_SolvedAllPuzzles = 130; // Glow flag = TABLET_GLOW_SUN_SOLVED_ALL_PUZZLES
    public static final int Tablet_Spring_AboveTheSun = 138; // Glow flag = TABLET_GLOW_SPRING_ABOVE_THE_SUN
    public static final int Tablet_Spring_Fairy = 139; // Glow flag = TABLET_GLOW_SPRING_FAIRY
    public static final int Tablet_Spring_OpenTheFloodgate = 140; // Glow flag = TABLET_GLOW_SPRING_OPEN_THE_FLOODGATE
    public static final int Tablet_Spring_OannesFormOfAFish = 142; // Glow flag = TABLET_GLOW_SPRING_OANNES_FISH
    public static final int Tablet_Spring_SailAway = 143; // Glow flag = TABLET_GLOW_SPRING_SAIL_AWAY
    public static final int Tablet_Spring_CollectTheFourSigils = 144; // Glow flag = TABLET_GLOW_SPRING_COLLECT_THE_FOUR_SIGILS
    public static final int DamagedTablet_Spring_WaterMovesTheTower = 145; // Glow flag = TABLET_GLOW_SPRING_WATER_MOVES_THE_TOWER_DAMAGED
    public static final int Tablet_Spring_MothersWrath = 146; // Glow flag = TABLET_GLOW_SPRING_MOTHERS_WRATH
    public static final int Tablet_Spring_ThoseSeekingEden = 147; // Glow flag = TABLET_GLOW_SPRING_THOSE_SEEKING_EDEN
    public static final int Tablet_Inferno_SnakesAreEnraged = 150; // Glow flag = TABLET_GLOW_INFERNO_SNAKES_ARE_ENRAGED
    public static final int Tablet_Extinction_Gatekeepers = 154; // Glow flag = TABLET_GLOW_EXTINCTION_GATEKEEPERS
    public static final int Tablet_Inferno_StickToTheWalls = 155; // Glow flag = TABLET_GLOW_INFERNO_STICK_TO_THE_WALLS
    public static final int Tablet_Inferno_ErrJustOnce = 156; // Glow flag = TABLET_GLOW_INFERNO_ERR_JUST_ONCE
    public static final int DamagedTablet_Inferno_PhilosophersStone = 157; // Glow flag = TABLET_GLOW_INFERNO_PHILOSOPHERS_STONE_DAMAGED
    public static final int Tablet_Inferno_TreadADifferentPath = 159; // Glow flag = TABLET_GLOW_INFERNO_TREAD_A_DIFFERENT_PATH
    public static final int DamagedTablet_Inferno_CloakMadeFromIce = 160; // Glow flag = TABLET_GLOW_INFERNO_CLOAK_MADE_FROM_ICE_DAMAGED
    public static final int Tablet_Inferno_TuneOfThineOcarina = 161; // Glow flag = TABLET_GLOW_INFERNO_TUNE_OF_THINE_OCARINA
    public static final int Tablet_Inferno_BottomOfThisLand = 162; // Glow flag = TABLET_GLOW_INFERNO_BOTTOM_OF_THIS_LAND
    public static final int Tablet_Inferno_ThoseSeekingEden = 163; // Glow flag = TABLET_GLOW_INFERNO_THOSE_SEEKING_EDEN
    public static final int Tablet_Extinction_SeekTheRighteousSpirit = 171; // Glow flag = TABLET_GLOW_EXTINCTION_SEEK_THE_RIGHTEOUS_SPIRIT
    public static final int Tablet_Extinction_TwoAngelShield = 173; // Glow flag = TABLET_GLOW_EXTINCTION_TWO_ANGEL_SHIELD
    public static final int DamagedTablet_Extinction_ShellInTheLeftHandPoints = 174; // Glow flag = TABLET_GLOW_EXTINCTION_SHELL_IN_THE_LEFT_HAND_POINTS
    public static final int Tablet_Extinction_LetTheLightBurnHere = 175; // Glow flag = TABLET_GLOW_EXTINCTION_LET_THE_LIGHT_BURN_HERE
    public static final int Tablet_Extinction_SprigganStatue = 176; // Glow flag = TABLET_GLOW_EXTINCTION_SPRIGGAN_STATUE
    public static final int Tablet_Extinction_DragonBone = 177; // Glow flag = TABLET_GLOW_EXTINCTION_DRAGON_BONE
    public static final int Tablet_Extinction_CogOfTheSoulGivesLife = 178; // Glow flag = TABLET_GLOW_EXTINCTION_COG_OF_THE_SOUL_GIVES_LIFE
    public static final int Tablet_Extinction_LargeCrucifixSummonPalenque = 179; // Glow flag = TABLET_GLOW_EXTINCTION_LARGE_CRUCIFIX_SUMMON_PALENQUE
    public static final int Tablet_Extinction_LetTheMapGuideItsPlacement = 180; // Glow flag = TABLET_GLOW_EXTINCTION_LET_THE_MAP_GUIDE_ITS_PLACEMENT
    public static final int Tablet_Extinction_ProceedThroughTheWall = 181; // Glow flag = TABLET_GLOW_EXTINCTION_PROCEED_THROUGH_THE_WALL
    public static final int Tablet_Extinction_EveryHeartHasAColor = 182; // Glow flag = TABLET_GLOW_EXTINCTION_EVERY_HEART_HAS_A_COLOR
    public static final int Tablet_Inferno_LastJewelLiesWithin = 183; // Glow flag = TABLET_GLOW_INFERNO_LAST_JEWEL_LIES_WITHIN
    public static final int DamagedTablet_Extinction_NuwaSleeps = 184; // Glow flag = TABLET_GLOW_EXTINCTION_NUWA_SLEEPS
    public static final int Tablet_Twin_BlackOnyxPurpleAmethyst = 189; // Glow flag = TABLET_GLOW_TWIN_BLACK_ONYX_PURPLE_AMETHYST
    public static final int DamagedTablet_Twin_FrontAndBack = 190; // Glow flag = TABLET_GLOW_TWIN_FRONT_AND_BACK_DAMAGED
    public static final int Tablet_Moonlight_EdenSearchOutThePlace = 191; // Glow flag = TABLET_GLOW_MOONLIGHT_EDEN_SEARCH_OUT_THE_PLACE
    public static final int Tablet_Twin_IdignaBuranunHermes = 192; // Glow flag = TABLET_GLOW_TWIN_IDIGNA_BURANUN_HERMES
    public static final int Tablet_Twin_HeroOfTheThirdChild = 193; // Glow flag = TABLET_GLOW_TWIN_HERO_OF_THE_THIRD_CHILD
    public static final int DamagedTablet_Twin_FootOfTheFootlessNeptune = 194; // Glow flag = TABLET_GLOW_TWIN_FOOT_OF_THE_FOOTLESS_NEPTUNE_DAMAGED
    public static final int Tablet_Twin_ChantASpellToTheSpirit = 195; // Glow flag = TABLET_GLOW_TWIN_CHANT_A_SPELL_TO_THE_SPIRIT
    public static final int DamagedTablet_Twin_BeyondTheSkull = 196; // Glow flag = TABLET_GLOW_TWIN_BEYOND_THE_SKULL_DAMAGED
    public static final int Tablet_Twin_DanceOfLife = 197; // Glow flag = TABLET_GLOW_TWIN_DANCE_OF_LIFE
    public static final int Tablet_Twin_UnsolvablePuzzle = 198; // Glow flag = TABLET_GLOW_TWIN_UNSOLVABLE_PUZZLE
    public static final int Tablet_Twin_FiveWitchesPlusOneMore = 199; // Glow flag = TABLET_GLOW_TWIN_FIVE_WITCHES_PLUS_ONE_MORE
    public static final int Tablet_Twin_Beelzebub = 201; // Glow flag = TABLET_GLOW_TWIN_BEELZEBUB
    public static final int Tablet_Twin_RevealTheLight = 202; // Glow flag = TABLET_GLOW_TWIN_REVEAL_THE_LIGHT
    public static final int Tablet_Twin_HatchSkuldVerdandi = 207; // Glow flag = TABLET_GLOW_TWIN_HATCH_SKULD_VERDANDI
    public static final int Tablet_Twin_PriestsBecamePhilosophers = 208; // Glow flag = TABLET_GLOW_TWIN_PRIESTS_BECAME_PHILOSOPHERS
    public static final int Tablet_Twin_AnkhIsAlwaysInTheFront = 209; // Glow flag = TABLET_GLOW_TWIN_ANKH_IS_ALWAYS_IN_THE_FRONT
    public static final int Tablet_Twin_InnocentGirl = 210; // Glow flag = TABLET_GLOW_TWIN_INNOCENT_GIRL
    public static final int DamagedTablet_Twin_ZuPeryton = 211; // Glow flag = TABLET_GLOW_TWIN_ZU_PERYTON_DAMAGED
    public static final int Tablet_Twin_PowerToStopTime = 212; // Glow flag = TABLET_GLOW_TWIN_POWER_TO_STOP_TIME
    public static final int Tablet_Twin_BrotherShops = 213; // Glow flag = TABLET_GLOW_TWIN_BROTHER_SHOPS
    public static final int Tablet_Twin_DestroyedIn2015 = 214; // Glow flag = TABLET_GLOW_TWIN_DESTROYED_IN_2015
    public static final int Tablet_Endless_Dragon = 224; // Glow flag = TABLET_GLOW_ENDLESS_DRAGON
    public static final int Tablet_Endless_BornLivesReproduceAscension = 225; // Glow flag = TABLET_GLOW_ENDLESS_BORN_LIVES_REPRODUCE_ASCENSION
    public static final int Tablet_Endless_ToilsForNaught = 226; // Glow flag = TABLET_GLOW_ENDLESS_TOILS_FOR_NAUGHT
    public static final int Tablet_Endless_MightOrWisdom = 227; // Glow flag = TABLET_GLOW_ENDLESS_MIGHT_OR_WISDOM
    public static final int Tablet_Endless_EndureTrials = 228; // Glow flag = TABLET_GLOW_ENDLESS_ENDURE_TRIALS
    public static final int Tablet_Extinction_ThoseSeekingEden = 230; // Glow flag = TABLET_GLOW_EXTINCTION_THOSE_SEEKING_EDEN
    public static final int Tablet_Graveyard_ThoseSeekingEden = 232; // Glow flag = TABLET_GLOW_GRAVEYARD_THOSE_SEEKING_EDEN
    public static final int Tablet_Shrine_EndlessnessAndDimensions = 233; // Glow flag = TABLET_GLOW_SHRINE_ENDLESSNESS_AND_DIMENSIONS
    public static final int Tablet_Shrine_WallOfYourCalling = 234; // Glow flag = TABLET_GLOW_SHRINE_WALL_OF_YOUR_CALLING
    public static final int Tablet_Shrine_PhilosopherChosenOne = 235; // Glow flag = TABLET_GLOW_SHRINE_PHILOSOPHER_CHOSEN_ONE
    public static final int Tablet_Shrine_MushussuCombo = 236; // Glow flag = TABLET_GLOW_SHRINE_MUSHUSSU_COMBO
    public static final int Tablet_Shrine_EightSpirits = 238; // Glow flag = TABLET_GLOW_SHRINE_EIGHT_SPIRITS
//    public static final int Tablet_Shrine_Rosetta = 239; // Glow flag = TABLET_GLOW_SHRINE_ROSETTA
    public static final int Tablet_Shrine_SecretTreasureOfLife = 240; // Glow flag = TABLET_GLOW_SHRINE_SECRET_TREASURE_OF_LIFE
    public static final int Tablet_Shrine_PhilosopherImmortal = 241; // Glow flag = TABLET_GLOW_SHRINE_PHILOSOPHER_IMMORTAL
    public static final int Tablet_Shrine_SeventhChildren = 242; // Glow flag = TABLET_GLOW_SHRINE_SEVENTH_CHILDREN
    public static final int Tablet_Shrine_SleepWithinTheWoman = 243; // Glow flag = TABLET_GLOW_SHRINE_SLEEP_WITHIN_THE_WOMAN
    public static final int Tablet_Illusion_KeyToEndlessCorridor = 251; // Glow flag = TABLET_GLOW_ILLUSION_KEY_TO_ENDLESS_CORRIDOR
    public static final int Tablet_Illusion_DeviceThatCreatesLife = 252; // Glow flag = TABLET_GLOW_ILLUSION_DEVICE_THAT_CREATES_LIFE
    public static final int Tablet_Illusion_VirtualWiseMan = 253; // Glow flag = TABLET_GLOW_ILLUSION_VIRTUAL_WISE_MAN
    public static final int Tablet_Illusion_TiamatGrailPowerless = 254; // Glow flag = TABLET_GLOW_ILLUSION_TIAMAT_GRAIL_POWERLESS
    public static final int Tablet_Illusion_PossessTheWisdomOfAWiseMan = 256; // Glow flag = TABLET_GLOW_ILLUSION_POSSESS_THE_WISDOM_OF_A_WISE_MAN
    public static final int Tablet_Illusion_FreeThyselfOfDoubtAndIllusion = 257; // Glow flag = TABLET_GLOW_ILLUSION_FREE_THYSELF_OF_DOUBT_AND_ILLUSION
    public static final int Tablet_Illusion_GiveUp = 258; // Glow flag = TABLET_GLOW_ILLUSION_GIVE_UP_LEFT / TABLET_GLOW_ILLUSION_GIVE_UP_MIDDLE / TABLET_GLOW_ILLUSION_GIVE_UP_RIGHT
    public static final int Tablet_Illusion_FoolDeservesNaughtButDeath = 259; // Glow flag = TABLET_GLOW_ILLUSION_FOOL_DESERVES_NAUGHT_BUT_DEATH
    public static final int Tablet_Illusion_TheFairiesUnlockIt = 260; // Glow flag = TABLET_GLOW_ILLUSION_THE_FAIRIES_UNLOCK_IT
    public static final int Tablet_Illusion_WanderTheLabyrinthForEternity = 261; // Glow flag = TABLET_GLOW_ILLUSION_WANDER_THE_LABYRINTH_FOR_ETERNITY
    public static final int Tablet_Illusion_UnderstandingIsImpressive = 262; // Glow flag = TABLET_GLOW_ILLUSION_UNDERSTANDING_IS_IMPRESSIVE
    public static final int Tablet_Illusion_FoolPuzzle = 263; // Glow flag = TABLET_GLOW_ILLUSION_FOOL_PUZZLE
    public static final int Tablet_Illusion_FoolWillNeverFindHisWay = 264; // Glow flag = TABLET_GLOW_ILLUSION_FOOL_WILL_NEVER_FIND_HIS_WAY
    public static final int Tablet_Illusion_ExtinguishTheWhole = 265; // Glow flag = TABLET_GLOW_ILLUSION_EXTINGUISH_THE_WHOLE
    public static final int Tablet_Illusion_SearchOnBendedKnee = 270; // Glow flag = TABLET_GLOW_ILLUSION_SEARCH_ON_BENDED_KNEE
    public static final int Tablet_Illusion_EnterEden = 271; // Glow flag = TABLET_GLOW_ILLUSION_ENTER_EDEN
    public static final int Tablet_Graveyard_Toujin = 276; // Glow flag = TABLET_GLOW_GRAVEYARD_TOUJIN
    public static final int Tablet_Graveyard_MuIsTheNamelessOne = 277; // Glow flag = TABLET_GLOW_GRAVEYARD_MU_IS_THE_NAMELESS_ONE
    public static final int Tablet_Graveyard_EyesAreNotHollowedOutHoles = 278; // Glow flag = TABLET_GLOW_GRAVEYARD_EYES_ARE_NOT_HOLLOWED_OUT_HOLES
    public static final int Tablet_Graveyard_MoneyCantBuyTheRealThing = 279; // Glow flag = TABLET_GLOW_GRAVEYARD_MONEY_CANT_BUY_THE_REAL_THING
    public static final int Tablet_Graveyard_MeetingOfManAndWoman = 280; // Glow flag = TABLET_GLOW_GRAVEYARD_MEETING_OF_MAN_AND_WOMAN
    public static final int Tablet_Graveyard_DemonEndlesslyConsumesLife = 281; // Glow flag = TABLET_GLOW_GRAVEYARD_DEMON_ENDLESSLY_CONSUMES_LIFE
    public static final int Tablet_Graveyard_MeaningsAreInfusedIntoTheGemstones = 283; // Glow flag = TABLET_GLOW_GRAVEYARD_MEANINGS_ARE_INFUSED_INTO_THE_GEMSTONES
    public static final int Tablet_Graveyard_NewWeaponTakeDownTheWall = 284; // Glow flag = TABLET_GLOW_GRAVEYARD_NEW_WEAPON_TAKE_DOWN_THE_WALL
    public static final int Tablet_Graveyard_SpaulderGoddess = 285; // Glow flag = TABLET_GLOW_GRAVEYARD_SPAULDER_GODDESS
    public static final int Tablet_Graveyard_CursedTreasureRedStone = 286; // Glow flag = TABLET_GLOW_GRAVEYARD_CURSED_TREASURE_RED_STONE
    public static final int Tablet_Graveyard_JewelShopWhereLifeSpringsForth = 287; // Glow flag = TABLET_GLOW_GRAVEYARD_JEWEL_SHOP_WHERE_LIFE_SPRINGS_FORTH
    public static final int Tablet_Graveyard_WeShallAwaitTheeAhead = 288; // Glow flag = TABLET_GLOW_GRAVEYARD_WE_SHALL_AWAIT_THEE_AHEAD
    public static final int Tablet_Moonlight_EveryHeartHasAWeight = 292; // Glow flag = TABLET_GLOW_MOONLIGHT_EVERY_HEART_HAS_A_WEIGHT
    public static final int Tablet_Moonlight_MindThyManners = 293; // Glow flag = TABLET_GLOW_MOONLIGHT_MIND_THY_MANNERS
    public static final int Tablet_Moonlight_AtopTheNavelOfNeptune = 294; // Glow flag = TABLET_GLOW_MOONLIGHT_ATOP_THE_NAVEL_OF_NEPTUNE
    public static final int Tablet_Moonlight_UltimateSacrificeForPower = 295; // Glow flag = TABLET_GLOW_MOONLIGHT_ULTIMATE_SACRIFICE_FOR_POWER
    public static final int Tablet_Moonlight_OcarinaWomanWithChild = 296; // Glow flag = TABLET_GLOW_MOONLIGHT_OCARINA_WOMAN_WITH_CHILD
    public static final int Tablet_Moonlight_WedgesGiveFormToTheSoul = 297; // Glow flag = TABLET_GLOW_MOONLIGHT_WEDGES_GIVE_FORM_TO_THE_SOUL
    public static final int Tablet_Moonlight_WaterWillProvideThePower = 298; // Glow flag = TABLET_GLOW_MOONLIGHT_WATER_WILL_PROVIDE_THE_POWER
    public static final int Tablet_Moonlight_BookOfTheDead = 299; // Glow flag = TABLET_GLOW_MOONLIGHT_BOOK_OF_THE_DEAD
    public static final int Tablet_Moonlight_GrindDownThePyramid = 300; // Glow flag = TABLET_GLOW_MOONLIGHT_GRIND_DOWN_THE_PYRAMID
    public static final int Tablet_Moonlight_UnderworldPalace = 301; // Glow flag = TABLET_GLOW_MOONLIGHT_UNDERWORLD_PALACE
    public static final int Tablet_Moonlight_SigilOfSpiritThatControlsLife = 302; // Glow flag = TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE
    public static final int Tablet_Goddess_HunkOfFlyingIron = 306; // Glow flag = TABLET_GLOW_GODDESS_HUNK_OF_FLYING_IRON
    public static final int Tablet_Goddess_SecretOfLifePowerOfDestruction = 307; // Glow flag = TABLET_GLOW_GODDESS_SECRET_OF_LIFE_POWER_OF_DESTRUCTION
    public static final int Tablet_Goddess_CannotGrantTheMothersWish = 308; // Glow flag = TABLET_GLOW_GODDESS_CANNOT_GRANT_THE_MOTHERS_WISH
    public static final int Tablet_Goddess_ABaoAQu = 309; // Glow flag = TABLET_GLOW_GODDESS_A_BAO_A_QU
    public static final int Tablet_Goddess_ChallengeTheChamberOfBirth = 311; // Glow flag = TABLET_GLOW_GODDESS_CHALLENGE_THE_CHAMBER_OF_BIRTH
    public static final int Tablet_Goddess_FlyWithTheGoldenWings = 312; // Glow flag = TABLET_GLOW_GODDESS_FLY_WITH_THE_GOLDEN_WINGS
    public static final int Tablet_Goddess_MagatamaJewel = 314; // Glow flag = TABLET_GLOW_GODDESS_MAGATAMA_JEWEL
    public static final int Tablet_Goddess_BalanceTheSpirits = 316; // Glow flag = TABLET_GLOW_GODDESS_BALANCE_THE_SPIRITS
    public static final int Tablet_Goddess_AfterThineAscensionToTheTower = 317; // Glow flag = TABLET_GLOW_GODDESS_AFTER_THINE_ASCENSION_TO_THE_TOWER
    public static final int Tablet_Goddess_RusaliiYaksiDakini = 318; // Glow flag = TABLET_GLOW_GODDESS_RUSALII_YAKSI_DAKINI
    public static final int Tablet_Goddess_IllusionOfGoddessStatues = 320; // Glow flag = TABLET_GLOW_GODDESS_ILLUSION_OF_GODDESS_STATUES
    public static final int Tablet_Ruin_IdentifyTheSeductress = 325; // Glow flag = TABLET_GLOW_RUIN_IDENTIFY_THE_SEDUCTRESS
    public static final int Tablet_Ruin_TheOneWhoChallengesNuwa = 326; // Glow flag = TABLET_GLOW_RUIN_THE_ONE_WHO_CHALLENGES_NUWA
    public static final int Tablet_Ruin_FaceTheLastTrial = 327; // Glow flag = TABLET_GLOW_RUIN_FACE_THE_LAST_TRIAL
    public static final int Tablet_Ruin_GlowingRedCrucifixBeacon = 328; // Glow flag = TABLET_GLOW_RUIN_GLOWING_RED_CRUCIFIX_BEACON
    public static final int Tablet_Ruin_TheOnesThatCreatedNuwa = 329; // Glow flag = TABLET_GLOW_RUIN_THE_ONES_THAT_CREATED_NUWA
    public static final int Tablet_Ruin_GreatBirdMercyCrushingThatHand = 330; // Glow flag = TABLET_GLOW_RUIN_GREAT_BIRD_MERCY_CRUSHING_THAT_HAND
    public static final int Tablet_Ruin_TooQuickForTheEyes = 331; // Glow flag = TABLET_GLOW_RUIN_TOO_QUICK_FOR_THE_EYES
    public static final int Tablet_Ruin_Skanda = 332; // Glow flag = TABLET_GLOW_RUIN_SKANDA
//    public static final int Tablet_Ruin_Rosetta = 333; // Glow flag = TABLET_GLOW_RUIN_ROSETTA
    public static final int Tablet_Ruin_UnintentionalMischief = 334; // Glow flag = TABLET_GLOW_RUIN_UNINTENTIONAL_MISCHIEF
    public static final int Tablet_Ruin_FollowTheNameThatMeansUnnamed = 335; // Glow flag = TABLET_GLOW_RUIN_FOLLOW_THE_NAME_THAT_MEANS_UNNAMED
    public static final int Tablet_Ruin_WhiteDiamondRepresentsPurity = 336; // Glow flag = TABLET_GLOW_RUIN_WHITE_DIAMOND_REPRESENTS_PURITY
    public static final int Tablet_Birth_BrightLightWithinTheDarkness = 340; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_BRIGHT_LIGHT_WITHIN_THE_DARKNESS
    public static final int Tablet_Birth_GoldenGlowThinlyStretchedLight = 341; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_GOLDEN_GLOW_THINLY_STRETCHED_LIGHT
    public static final int Tablet_Birth_ShallNotMakeItWithThinePower = 342; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_SHALL_NOT_MAKE_IT_WITH_THINE_POWER
    public static final int Tablet_Birth_BePreparedForDeath = 343; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_BE_PREPARED_FOR_DEATH
    public static final int Tablet_Birth_ClayDollsBecomeHuman = 344; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN
    public static final int Tablet_Birth_BecameHumanAndProspered = 345; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_BECAME_HUMAN_AND_PROSPERED
    public static final int Tablet_Birth_PalenqueSlumbers = 346; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_PALENQUE_SLUMBERS
    public static final int Tablet_Birth_StrikeTheWedgeDisturbTheMother = 347; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_STRIKE_THE_WEDGE_DISTURB_THE_MOTHER
    public static final int Tablet_Birth_PraiseLifeClayDollGoldenKey = 348; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_PRAISE_LIFE_CLAY_DOLL_GOLDEN_KEY
    public static final int Tablet_Birth_BeyondTheManyCorpsesAWomanWaits = 349; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_BEYOND_THE_MANY_CORPSES_A_WOMAN_WAITS
    public static final int Tablet_Birth_ContinuesWithoutEndBirthDeath = 350; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_CONTINUES_WITHOUT_END_BIRTH_DEATH
    public static final int Tablet_Birth_ChallengePalenque = 351; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_CHALLENGE_PALENQUE
    public static final int Tablet_Birth_VishnuBeheadedAsura = 352; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_VISHNU_BEHEADED_ASURA
//    public static final int Tablet_Birth_Rosetta = 353; // Glow flag = TABLET_GLOW_BIRTH_SWORDS_ROSETTA
    public static final int Tablet_Birth_WhiteOpalRepresentsJoy = 354; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_WHITE_OPAL_REPRESENTS_JOY
    public static final int Tablet_Birth_CrystalSkullSuppressesTiamat = 355; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_CRYSTAL_SKULL_SUPPRESSES_TIAMAT
    public static final int Tablet_Birth_DanceInThisPlace = 356; // Glow flag = TABLET_GLOW_BIRTH_SKANDA_DANCE_IN_THIS_PLACE
    public static final int Tablet_Dimensional_BeyondTheBoundariesOfTime = 359; // Glow flag = TABLET_GLOW_DIMENSIONAL_BEYOND_THE_BOUNDARIES_OF_TIME
    public static final int Tablet_Dimensional_RoadToTreasure = 360; // Glow flag = TABLET_GLOW_DIMENSIONAL_ROAD_TO_TREASURE
    public static final int Tablet_Dimensional_TwoVessels = 361; // Glow flag = TABLET_GLOW_DIMENSIONAL_TWO_VESSELS
    public static final int Tablet_Dimensional_LivesThe11ChildrenHave = 362; // Glow flag = TABLET_GLOW_DIMENSIONAL_LIVES_THE_11_CHILDREN_HAVE
    public static final int Tablet_Dimensional_ThrustInfinityThere = 363; // Glow flag = TABLET_GLOW_DIMENSIONAL_THRUST_INFINITY_THERE
    public static final int Tablet_Surface_RuinsEntrance = 473; // Glow flag = TABLET_GLOW_SURFACE_RUINS_ENTRANCE
    public static final int Tablet_Inferno_SwingYourWeapon = 474; // Glow flag = TABLET_GLOW_INFERNO_SWING_YOUR_WEAPON
    public static final int Tablet_Retromausoleum_An8BitWorld = 516; // Glow flag = TABLET_GLOW_HT_SLEEP_ALSO_SET_BY_RETROMAUSOLEUM_ENTRANCE
    public static final int Tablet_Guidance_PushTheWhiteBox = 550; // Glow flag = TABLET_GLOW_GUIDANCE_PUSH_THE_WHITE_BOX
    public static final int Tablet_Endless_MapColor = 612; // Glow flag = TABLET_GLOW_ENDLESS_MAP_COLOR
    public static final int Tablet_Shrine_ChosenOnly = 615; // Glow flag = TABLET_GLOW_SHRINE_CHOSEN_ONLY
    public static final int Tablet_Dimensional_OnlyOnePathToSurvival = 670; // Glow flag = TABLET_GLOW_DIMENSIONAL_ONLY_ONE_PATH_TO_SURVIVAL
    public static final int Tablet_Sun_AimAndShoot = 717; // Glow flag = TABLET_GLOW_SUN_AIM_AND_SHOOT
    public static final int Tablet_Eden = 967; // Glow flag = TABLET_GLOW_EDEN
    public static final int Tablet_HT_Sleep = 1004; // Glow flag = TABLET_GLOW_HT_SLEEP_ALSO_SET_BY_RETROMAUSOLEUM_ENTRANCE
    public static final int Tablet_HT_IExistHere = 1005; // Glow flag = TABLET_GLOW_HT_I_EXIST_HERE
    public static final int Tablet_HT_ClothToMakeTheTreasure = 1009; // Glow flag = TABLET_GLOW_HT_CLOTH_TO_MAKE_THE_TREASURE

    public static final int ResearchMode_CrossOfLight = 552;

    public static final int MegaTablet_HT_Entrance = 918;
    public static final int MegaTablet_HT_BecameAPhantom = 1029;

    public static final int Scannable_ResearchScan_StatueOfThoth = 570;
    public static final int Scannable_Laptop = 237; // Related flag = 0x210

    public static final int GrailTablet_Surface = 38;
    public static final int GrailTablet_Guidance = 41;
    public static final int GrailTablet_Mausoleum = 75;
    public static final int GrailTablet_Sun = 104;
    public static final int GrailTablet_Spring = 136;
    public static final int GrailTablet_Inferno = 149;
    public static final int GrailTablet_Extinction = 170;
    public static final int GrailTablet_TwinFront = 188;
    public static final int GrailTablet_Endless = 221;
    public static final int GrailTablet_Shrine = 231;
    public static final int GrailTablet_Illusion = 250;
    public static final int GrailTablet_Graveyard = 275;
    public static final int GrailTablet_Moonlight = 291;
    public static final int GrailTablet_Goddess = 305;
    public static final int GrailTablet_Ruin = 323;
    public static final int GrailTablet_Birth = 339;
    public static final int GrailTablet_TwinBack = 206;
    public static final int GrailTablet_Dimensional = 358;

    public static final int BrokenTablet_NoText = 471; // Many flags for tablet glow; rando will use TABLET_GLOW_GUIDANCE_ENTRANCE_BROKEN for all

    public static final List<Integer> TABLET_BLOCKS = Arrays.asList(
            Tablet_Guidance_DeathAwaitsThePowerless,
            Tablet_Guidance_Entrance,
            DamagedTablet_Guidance_Guild,
            Tablet_Guidance_HolyGround,
            Tablet_Guidance_ProveThineCourage,
            Tablet_Spring_ChildWasBorn,
            Tablet_Guidance_Offer3Lights,
            Tablet_Guidance_8Ankhs,
            Tablet_Guidance_GiantsHistory,
            Tablet_Guidance_ChiYou,
            Tablet_Sun_StatueOfTheGiant,
            Tablet_Guidance_CrossTheSacredLake,
            Tablet_Guidance_HolyGrailMemories,
            Tablet_Guidance_Watchtower,
            Tablet_Guidance_ItShallConnect,
            Tablet_Mausoleum_CelestialBodies,
            Tablet_Mausoleum_Abuto,
            Tablet_Mausoleum_ThouArtTiny,
            Tablet_Mausoleum_Ribu,
            DamagedTablet_Mausoleum_GhostLord,
            Tablet_Mausoleum_Migela,
            Tablet_Mausoleum_Ledo,
            Tablet_Mausoleum_Ji,
            Tablet_Mausoleum_Bado,
            Tablet_Mausoleum_MigelaLeftHanded,
            Tablet_Mausoleum_AbutoJiRibuSakit,
            Tablet_Mausoleum_Zebu,
            DamagedTablet_Mausoleum_RedLight,
            Tablet_Mausoleum_ZebuUnableToMove,
            Tablet_Mausoleum_Numbers,
            Tablet_Mausoleum_BadoMigelaLedoFuto,
            Tablet_Mausoleum_NineBrothers,
            Tablet_Mausoleum_Sakit,
            Tablet_Sun_JumpIntoTheSun,
            Tablet_Sun_ChallengeTheInfernoCavern,
            Tablet_Sun_CastALight,
            Tablet_Sun_Scalesphere,
            Tablet_Sun_PathThatConnectsTwoPyramids,
            Tablet_Sun_MoonGazingPit,
            Tablet_Sun_FirstMantra,
            Tablet_Sun_SecondMantra,
            Tablet_Sun_ThirdMantra,
            Tablet_Sun_MantraOrder,
            Tablet_Sun_FourthMantra,
            Tablet_Sun_FifthMantra,
            Tablet_Sun_SeventhMantra,
            Tablet_Sun_LastMantra,
            Tablet_Sun_ManWomanWeapon,
            Tablet_Sun_WomanWithChild,
            DamagedTablet_Sun_FillThisPlaceWithWater,
            Tablet_Sun_NoLightUpAhead,
            Tablet_Sun_NoLightUpAhead,
            Tablet_Sun_ThoseThatFlyShallBeCastDown,
            Tablet_Sun_MeditateUnderWedjet,
            Tablet_Sun_PowerOfTheTwins,
            Tablet_Sun_SolvedAllPuzzles,
            Tablet_Spring_AboveTheSun,
            Tablet_Spring_Fairy,
            Tablet_Spring_OpenTheFloodgate,
            Tablet_Spring_OannesFormOfAFish,
            Tablet_Spring_SailAway,
            Tablet_Spring_CollectTheFourSigils,
            DamagedTablet_Spring_WaterMovesTheTower,
            Tablet_Spring_MothersWrath,
            Tablet_Spring_ThoseSeekingEden,
            Tablet_Inferno_SnakesAreEnraged,
            Tablet_Extinction_Gatekeepers,
            Tablet_Inferno_StickToTheWalls,
            Tablet_Inferno_ErrJustOnce,
            DamagedTablet_Inferno_PhilosophersStone,
            Tablet_Inferno_TreadADifferentPath,
            DamagedTablet_Inferno_CloakMadeFromIce,
            Tablet_Inferno_TuneOfThineOcarina,
            Tablet_Inferno_BottomOfThisLand,
            Tablet_Inferno_ThoseSeekingEden,
            Tablet_Extinction_SeekTheRighteousSpirit,
            Tablet_Extinction_TwoAngelShield,
            DamagedTablet_Extinction_ShellInTheLeftHandPoints,
            Tablet_Extinction_LetTheLightBurnHere,
            Tablet_Extinction_SprigganStatue,
            Tablet_Extinction_DragonBone,
            Tablet_Extinction_CogOfTheSoulGivesLife,
            Tablet_Extinction_LargeCrucifixSummonPalenque,
            Tablet_Extinction_LetTheMapGuideItsPlacement,
            Tablet_Extinction_ProceedThroughTheWall,
            Tablet_Extinction_EveryHeartHasAColor,
            Tablet_Inferno_LastJewelLiesWithin,
            DamagedTablet_Extinction_NuwaSleeps,
            Tablet_Twin_BlackOnyxPurpleAmethyst,
            DamagedTablet_Twin_FrontAndBack,
            Tablet_Moonlight_EdenSearchOutThePlace,
            Tablet_Twin_IdignaBuranunHermes,
            Tablet_Twin_HeroOfTheThirdChild,
            DamagedTablet_Twin_FootOfTheFootlessNeptune,
            Tablet_Twin_ChantASpellToTheSpirit,
            DamagedTablet_Twin_BeyondTheSkull,
            Tablet_Twin_DanceOfLife,
            Tablet_Twin_UnsolvablePuzzle,
            Tablet_Twin_FiveWitchesPlusOneMore,
            Tablet_Twin_Beelzebub,
            Tablet_Twin_RevealTheLight,
            Tablet_Twin_HatchSkuldVerdandi,
            Tablet_Twin_PriestsBecamePhilosophers,
            Tablet_Twin_AnkhIsAlwaysInTheFront,
            Tablet_Twin_InnocentGirl,
            DamagedTablet_Twin_ZuPeryton,
            Tablet_Twin_PowerToStopTime,
            Tablet_Twin_BrotherShops,
            Tablet_Twin_DestroyedIn2015,
            Tablet_Endless_Dragon,
            Tablet_Endless_BornLivesReproduceAscension,
            Tablet_Endless_ToilsForNaught,
            Tablet_Endless_MightOrWisdom,
            Tablet_Endless_EndureTrials,
            Tablet_Extinction_ThoseSeekingEden,
            Tablet_Graveyard_ThoseSeekingEden,
            Tablet_Shrine_EndlessnessAndDimensions,
            Tablet_Shrine_WallOfYourCalling,
            Tablet_Shrine_PhilosopherChosenOne,
            Tablet_Shrine_MushussuCombo,
            Tablet_Shrine_EightSpirits,
//            Tablet_Shrine_Rosetta,
            Tablet_Shrine_SecretTreasureOfLife,
            Tablet_Shrine_PhilosopherImmortal,
            Tablet_Shrine_SeventhChildren,
            Tablet_Shrine_SleepWithinTheWoman,
            Tablet_Illusion_KeyToEndlessCorridor,
            Tablet_Illusion_DeviceThatCreatesLife,
            Tablet_Illusion_VirtualWiseMan,
            Tablet_Illusion_TiamatGrailPowerless,
            Tablet_Illusion_PossessTheWisdomOfAWiseMan,
            Tablet_Illusion_FreeThyselfOfDoubtAndIllusion,
            Tablet_Illusion_GiveUp,
            Tablet_Illusion_FoolDeservesNaughtButDeath,
            Tablet_Illusion_TheFairiesUnlockIt,
            Tablet_Illusion_WanderTheLabyrinthForEternity,
            Tablet_Illusion_UnderstandingIsImpressive,
            Tablet_Illusion_FoolPuzzle,
            Tablet_Illusion_FoolWillNeverFindHisWay,
            Tablet_Illusion_ExtinguishTheWhole,
            Tablet_Illusion_SearchOnBendedKnee,
            Tablet_Illusion_EnterEden,
            Tablet_Graveyard_Toujin,
            Tablet_Graveyard_MuIsTheNamelessOne,
            Tablet_Graveyard_EyesAreNotHollowedOutHoles,
            Tablet_Graveyard_MoneyCantBuyTheRealThing,
            Tablet_Graveyard_MeetingOfManAndWoman,
            Tablet_Graveyard_DemonEndlesslyConsumesLife,
            Tablet_Graveyard_MeaningsAreInfusedIntoTheGemstones,
            Tablet_Graveyard_NewWeaponTakeDownTheWall,
            Tablet_Graveyard_SpaulderGoddess,
            Tablet_Graveyard_CursedTreasureRedStone,
            Tablet_Graveyard_JewelShopWhereLifeSpringsForth,
            Tablet_Graveyard_WeShallAwaitTheeAhead,
            Tablet_Moonlight_EveryHeartHasAWeight,
            Tablet_Moonlight_MindThyManners,
            Tablet_Moonlight_AtopTheNavelOfNeptune,
            Tablet_Moonlight_UltimateSacrificeForPower,
            Tablet_Moonlight_OcarinaWomanWithChild,
            Tablet_Moonlight_WedgesGiveFormToTheSoul,
            Tablet_Moonlight_WaterWillProvideThePower,
            Tablet_Moonlight_BookOfTheDead,
            Tablet_Moonlight_GrindDownThePyramid,
            Tablet_Moonlight_UnderworldPalace,
            Tablet_Moonlight_SigilOfSpiritThatControlsLife,
            Tablet_Goddess_HunkOfFlyingIron,
            Tablet_Goddess_SecretOfLifePowerOfDestruction,
            Tablet_Goddess_CannotGrantTheMothersWish,
            Tablet_Goddess_ABaoAQu,
            Tablet_Goddess_ChallengeTheChamberOfBirth,
            Tablet_Goddess_FlyWithTheGoldenWings,
            Tablet_Goddess_MagatamaJewel,
            Tablet_Goddess_BalanceTheSpirits,
            Tablet_Goddess_AfterThineAscensionToTheTower,
            Tablet_Goddess_RusaliiYaksiDakini,
            Tablet_Goddess_IllusionOfGoddessStatues,
            Tablet_Ruin_IdentifyTheSeductress,
            Tablet_Ruin_TheOneWhoChallengesNuwa,
            Tablet_Ruin_FaceTheLastTrial,
            Tablet_Ruin_GlowingRedCrucifixBeacon,
            Tablet_Ruin_TheOnesThatCreatedNuwa,
            Tablet_Ruin_GreatBirdMercyCrushingThatHand,
            Tablet_Ruin_TooQuickForTheEyes,
            Tablet_Ruin_Skanda,
//            Tablet_Ruin_Rosetta,
            Tablet_Ruin_UnintentionalMischief,
            Tablet_Ruin_FollowTheNameThatMeansUnnamed,
            Tablet_Ruin_WhiteDiamondRepresentsPurity,
            Tablet_Birth_BrightLightWithinTheDarkness,
            Tablet_Birth_GoldenGlowThinlyStretchedLight,
            Tablet_Birth_ShallNotMakeItWithThinePower,
            Tablet_Birth_BePreparedForDeath,
            Tablet_Birth_ClayDollsBecomeHuman,
            Tablet_Birth_BecameHumanAndProspered,
            Tablet_Birth_PalenqueSlumbers,
            Tablet_Birth_StrikeTheWedgeDisturbTheMother,
            Tablet_Birth_PraiseLifeClayDollGoldenKey,
            Tablet_Birth_BeyondTheManyCorpsesAWomanWaits,
            Tablet_Birth_ContinuesWithoutEndBirthDeath,
            Tablet_Birth_ChallengePalenque,
            Tablet_Birth_VishnuBeheadedAsura,
//            Tablet_Birth_Rosetta,
            Tablet_Birth_WhiteOpalRepresentsJoy,
            Tablet_Birth_CrystalSkullSuppressesTiamat,
            Tablet_Birth_DanceInThisPlace,
            Tablet_Dimensional_BeyondTheBoundariesOfTime,
            Tablet_Dimensional_RoadToTreasure,
            Tablet_Dimensional_TwoVessels,
            Tablet_Dimensional_LivesThe11ChildrenHave,
            Tablet_Dimensional_ThrustInfinityThere,
            Tablet_Surface_RuinsEntrance,
            Tablet_Inferno_SwingYourWeapon,
            Tablet_Guidance_PushTheWhiteBox,
            Tablet_Endless_MapColor,
            Tablet_Shrine_ChosenOnly,
            Tablet_Dimensional_OnlyOnePathToSurvival,
            Tablet_Sun_AimAndShoot,
            Tablet_Eden,
            Tablet_HT_Sleep,
            Tablet_HT_IExistHere,
            Tablet_HT_ClothToMakeTheTreasure
    );

    public static final int MantraTablet_BIRTH = 1021; // 0x3fd
    public static final int MantraTablet_DEATH = 1022; // 0x3fe
    public static final int MantraTablet_MARDUK = 223;
    public static final int MantraTablet_SABBAT = 200;
    public static final int MantraTablet_MU = 172;
    public static final int MantraTablet_VIY = 153;
    public static final int MantraTablet_BAHRUN = 313;
    public static final int MantraTablet_WEDJET = 115;
    public static final int MantraTablet_ABUTO = 282;
    public static final int MantraTablet_LAMULANA = 72;

    public static final int Email00 = 428; // 0x1ac
    public static final int Email01 = 429; // 0x1ad
    public static final int Email02 = 715;
    public static final int Email03 = 963;
    public static final int Email04 = 365;
    public static final int Email05 = 0x1ae;
    public static final int Email06 = 0x1af;
    public static final int Email07 = 0x1b0;
    public static final int Email08 = 0x1b1;
    public static final int Email09 = 0x1b2;
    public static final int Email10 = 0x1b3;
    public static final int Email11 = 0x1b4;
    public static final int Email12 = 0x1b5;
    public static final int Email13 = 0x1b6;
    public static final int Email14 = 0x1b7;
    public static final int Email15 = 0x1b8;
    public static final int Email16 = 0x1b9;
    public static final int Email17 = 0x1ba;
    public static final int Email18 = 0x1bb;
    public static final int Email19 = 0x1bc;
    public static final int Email20 = 0x1bd;
    public static final int Email21 = 0x1be;
    public static final int Email22 = 0x1bf;
    public static final int Email23 = 0x1c0;
    public static final int Email24 = 0x1c1;
    public static final int Email25 = 0x1c2;
    public static final int Email26 = 0x1c3;
    public static final int Email27 = 0x1c4;
    public static final int Email28 = 0x1c5;
    public static final int Email29 = 0x1c6;
    public static final int Email30 = 0x1c7;
    public static final int Email31 = 0x1c8;
    public static final int Email32 = 0x1c9;
    public static final int Email33 = 0x1ca;
    public static final int Email34 = 0x1cb;
    public static final int Email35 = 0x1cc;
    public static final int Email36 = 0x1cd;
    public static final int Email37 = 0x1ce;
    public static final int Email38 = 0x1cf;
    public static final int Email39 = 0x1d0;
    public static final int Email40 = 0x1d1;
    public static final int Email41 = 0x1d2;
    public static final int Email42 = 0x1d3;
    public static final int Email43 = 0x1d4;
    public static final int Email44 = 0x1d5;

    private BlockConstants() { }

    public static Integer getTabletBlockFromGlowFlag(int tabletGlowFlag) {
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SURFACE_RUINS_ENTRANCE) {
            return BlockConstants.Tablet_Surface_RuinsEntrance;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_ENTRANCE) {
            return BlockConstants.Tablet_Guidance_Entrance;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_OFFER_3_LIGHTS) {
            return BlockConstants.Tablet_Guidance_Offer3Lights;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_HOLY_GROUND) {
            return BlockConstants.Tablet_Guidance_HolyGround;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_PROVE_THINE_COURAGE) {
            return BlockConstants.Tablet_Guidance_ProveThineCourage;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_CROSS_THE_SACRED_LAKE) {
            return BlockConstants.Tablet_Guidance_CrossTheSacredLake;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_DEATH_AWAITS_THE_POWERLESS) {
            return BlockConstants.Tablet_Guidance_DeathAwaitsThePowerless;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_8_ANKHS) {
            return BlockConstants.Tablet_Guidance_8Ankhs;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_PUSH_THE_WHITE_BOX) {
            return BlockConstants.Tablet_Guidance_PushTheWhiteBox;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_CHI_YOU) {
            return BlockConstants.Tablet_Guidance_ChiYou;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_IT_SHALL_CONNECT) {
            return BlockConstants.Tablet_Guidance_ItShallConnect;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_WATCHTOWER) {
            return BlockConstants.Tablet_Guidance_Watchtower;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_HOLY_GRAIL_MEMORIES) {
            return BlockConstants.Tablet_Guidance_HolyGrailMemories;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_GUILD_DAMAGED) {
            return BlockConstants.DamagedTablet_Guidance_Guild;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GUIDANCE_GIANTS_HISTORY) {
            return BlockConstants.Tablet_Guidance_GiantsHistory;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_ABUTO) {
            return BlockConstants.Tablet_Mausoleum_Abuto;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_GHOST_LORD_DAMAGED) {
            return BlockConstants.DamagedTablet_Mausoleum_GhostLord;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_MIGELA) {
            return BlockConstants.Tablet_Mausoleum_Migela;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_THOU_ART_TINY) {
            return BlockConstants.Tablet_Mausoleum_ThouArtTiny;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_LEDO) {
            return BlockConstants.Tablet_Mausoleum_Ledo;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_RIBU) {
            return BlockConstants.Tablet_Mausoleum_Ribu;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_ABUTO_JI_RIBU_SAKIT) {
            return BlockConstants.Tablet_Mausoleum_AbutoJiRibuSakit;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_JI) {
            return BlockConstants.Tablet_Mausoleum_Ji;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_ZEBU) {
            return BlockConstants.Tablet_Mausoleum_Zebu;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_NUMBERS) {
            return BlockConstants.Tablet_Mausoleum_Numbers;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_BADO_MIGELA_LEDO_FUTO) {
            return BlockConstants.Tablet_Mausoleum_BadoMigelaLedoFuto;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_BADO) {
            return BlockConstants.Tablet_Mausoleum_Bado;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_MIGELA_LEFT_HANDED) {
            return BlockConstants.Tablet_Mausoleum_MigelaLeftHanded;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_RED_LIGHT_DAMAGED) {
            return BlockConstants.DamagedTablet_Mausoleum_RedLight;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_ZEBU_UNABLE_TO_MOVE) {
            return BlockConstants.Tablet_Mausoleum_ZebuUnableToMove;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_NINE_BROTHERS) {
            return BlockConstants.Tablet_Mausoleum_NineBrothers;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_SAKIT) {
            return BlockConstants.Tablet_Mausoleum_Sakit;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MAUSOLEUM_CELESTIAL_BODIES) {
            return BlockConstants.Tablet_Mausoleum_CelestialBodies;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_JUMP_INTO_THE_SUN) {
            return BlockConstants.Tablet_Sun_JumpIntoTheSun;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_STATUE_OF_THE_GIANT) {
            return BlockConstants.Tablet_Sun_StatueOfTheGiant;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_CAST_A_LIGHT) {
            return BlockConstants.Tablet_Sun_CastALight;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_AIM_AND_SHOOT) {
            return BlockConstants.Tablet_Sun_AimAndShoot;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_CHALLENGE_THE_INFERNO_CAVERN) {
            return BlockConstants.Tablet_Sun_ChallengeTheInfernoCavern;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_FIRST_MANTRA) {
            return BlockConstants.Tablet_Sun_FirstMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_SECOND_MANTRA) {
            return BlockConstants.Tablet_Sun_SecondMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_THIRD_MANTRA) {
            return BlockConstants.Tablet_Sun_ThirdMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_MANTRA_ORDER) {
            return BlockConstants.Tablet_Sun_MantraOrder;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_FOURTH_MANTRA) {
            return BlockConstants.Tablet_Sun_FourthMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_FIFTH_MANTRA) {
            return BlockConstants.Tablet_Sun_FifthMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_SEVENTH_MANTRA) {
            return BlockConstants.Tablet_Sun_SeventhMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_LAST_MANTRA) {
            return BlockConstants.Tablet_Sun_LastMantra;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_MAN_WOMAN_WEAPON) {
            return BlockConstants.Tablet_Sun_ManWomanWeapon;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_PATH_THAT_CONNECTS_TWO_PYRAMIDS) {
            return BlockConstants.Tablet_Sun_PathThatConnectsTwoPyramids;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_MOON_GAZING_PIT) {
            return BlockConstants.Tablet_Sun_MoonGazingPit;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_THOSE_THAT_FLY_SHALL_BE_CAST_DOWN) {
            return BlockConstants.Tablet_Sun_ThoseThatFlyShallBeCastDown;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_WOMAN_WITH_CHILD) {
            return BlockConstants.Tablet_Sun_WomanWithChild;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_FILL_THIS_PLACE_WITH_WATER_DAMAGED) {
            return BlockConstants.DamagedTablet_Sun_FillThisPlaceWithWater;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_NO_LIGHT_UP_AHEAD) {
            return BlockConstants.Tablet_Sun_NoLightUpAhead;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_SOLVED_ALL_PUZZLES) {
            return BlockConstants.Tablet_Sun_SolvedAllPuzzles;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_MEDITATE_UNDER_WEDJET) {
            return BlockConstants.Tablet_Sun_MeditateUnderWedjet;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_POWER_OF_THE_TWINS) {
            return BlockConstants.Tablet_Sun_PowerOfTheTwins;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SUN_SCALESPHERE) {
            return BlockConstants.Tablet_Sun_Scalesphere;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_OPEN_THE_FLOODGATE) {
            return BlockConstants.Tablet_Spring_OpenTheFloodgate;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_FAIRY) {
            return BlockConstants.Tablet_Spring_Fairy;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_OANNES_FORM_OF_A_FISH) {
            return BlockConstants.Tablet_Spring_OannesFormOfAFish;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_CHILD_WAS_BORN) {
            return BlockConstants.Tablet_Spring_ChildWasBorn;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_COLLECT_THE_FOUR_SIGILS) {
            return BlockConstants.Tablet_Spring_CollectTheFourSigils;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_SAIL_AWAY) {
            return BlockConstants.Tablet_Spring_SailAway;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_WATER_MOVES_THE_TOWER_DAMAGED) {
            return BlockConstants.DamagedTablet_Spring_WaterMovesTheTower;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_MOTHERS_WRATH) {
            return BlockConstants.Tablet_Spring_MothersWrath;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_ABOVE_THE_SUN) {
            return BlockConstants.Tablet_Spring_AboveTheSun;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SPRING_THOSE_SEEKING_EDEN) {
            return BlockConstants.Tablet_Spring_ThoseSeekingEden;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_SWING_YOUR_WEAPON) {
            return BlockConstants.Tablet_Inferno_SwingYourWeapon;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_SNAKES_ARE_ENRAGED) {
            return BlockConstants.Tablet_Inferno_SnakesAreEnraged;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_STICK_TO_THE_WALLS) {
            return BlockConstants.Tablet_Inferno_StickToTheWalls;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_TREAD_A_DIFFERENT_PATH) {
            return BlockConstants.Tablet_Inferno_TreadADifferentPath;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_PHILOSOPHERS_STONE_DAMAGED) {
            return BlockConstants.DamagedTablet_Inferno_PhilosophersStone;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_ERR_JUST_ONCE) {
            return BlockConstants.Tablet_Inferno_ErrJustOnce;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_CLOAK_MADE_FROM_ICE_DAMAGED) {
            return BlockConstants.DamagedTablet_Inferno_CloakMadeFromIce;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_BOTTOM_OF_THIS_LAND) {
            return BlockConstants.Tablet_Inferno_BottomOfThisLand;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_THOSE_SEEKING_EDEN) {
            return BlockConstants.Tablet_Inferno_ThoseSeekingEden;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_TUNE_OF_THINE_OCARINA) {
            return BlockConstants.Tablet_Inferno_TuneOfThineOcarina;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_INFERNO_LAST_JEWEL_LIES_WITHIN) {
            return BlockConstants.Tablet_Inferno_LastJewelLiesWithin;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_SEEK_THE_RIGHTEOUS_SPIRIT) {
            return BlockConstants.Tablet_Extinction_SeekTheRighteousSpirit;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_NUWA_SLEEPS) {
            return BlockConstants.DamagedTablet_Extinction_NuwaSleeps;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_LARGE_CRUCIFIX_SUMMON_PALENQUE) {
            return BlockConstants.Tablet_Extinction_LargeCrucifixSummonPalenque;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_LET_THE_LIGHT_BURN_HERE) {
            return BlockConstants.Tablet_Extinction_LetTheLightBurnHere;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_DRAGON_BONE) {
            return BlockConstants.Tablet_Extinction_DragonBone;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_SPRIGGAN_STATUE) {
            return BlockConstants.Tablet_Extinction_SprigganStatue;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_COG_OF_THE_SOUL_GIVES_LIFE) {
            return BlockConstants.Tablet_Extinction_CogOfTheSoulGivesLife;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_LET_THE_MAP_GUIDE_ITS_PLACEMENT) {
            return BlockConstants.Tablet_Extinction_LetTheMapGuideItsPlacement;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_THOSE_SEEKING_EDEN) {
            return BlockConstants.Tablet_Extinction_ThoseSeekingEden;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_EVERY_HEART_HAS_A_COLOR) {
            return BlockConstants.Tablet_Extinction_EveryHeartHasAColor;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_GATEKEEPERS) {
            return BlockConstants.Tablet_Extinction_Gatekeepers;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_SHELL_IN_THE_LEFT_HAND_POINTS) {
            return BlockConstants.DamagedTablet_Extinction_ShellInTheLeftHandPoints;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_PROCEED_THROUGH_THE_WALL) {
            return BlockConstants.Tablet_Extinction_ProceedThroughTheWall;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EXTINCTION_TWO_ANGEL_SHIELD) {
            return BlockConstants.Tablet_Extinction_TwoAngelShield;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_IDIGNA_BURANUN_HERMES) {
            return BlockConstants.Tablet_Twin_IdignaBuranunHermes;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_BLACK_ONYX_PURPLE_AMETHYST) {
            return BlockConstants.Tablet_Twin_BlackOnyxPurpleAmethyst;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_FRONT_AND_BACK_DAMAGED) {
            return BlockConstants.DamagedTablet_Twin_FrontAndBack;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_FOOT_OF_THE_FOOTLESS_NEPTUNE_DAMAGED) {
            return BlockConstants.DamagedTablet_Twin_FootOfTheFootlessNeptune;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_CHANT_A_SPELL_TO_THE_SPIRIT) {
            return BlockConstants.Tablet_Twin_ChantASpellToTheSpirit;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_HERO_OF_THE_THIRD_CHILD) {
            return BlockConstants.Tablet_Twin_HeroOfTheThirdChild;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_BEYOND_THE_SKULL_DAMAGED) {
            return BlockConstants.DamagedTablet_Twin_BeyondTheSkull;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_INNOCENT_GIRL) {
            return BlockConstants.Tablet_Twin_InnocentGirl;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_UNSOLVABLE_PUZZLE) {
            return BlockConstants.Tablet_Twin_UnsolvablePuzzle;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_BEELZEBUB) {
            return BlockConstants.Tablet_Twin_Beelzebub;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_REVEAL_THE_LIGHT) {
            return BlockConstants.Tablet_Twin_RevealTheLight;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_FIVE_WITCHES_PLUS_ONE_MORE) {
            return BlockConstants.Tablet_Twin_FiveWitchesPlusOneMore;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_HATCH_SKULD_VERDANDI) {
            return BlockConstants.Tablet_Twin_HatchSkuldVerdandi;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_PRIESTS_BECAME_PHILOSOPHERS) {
            return BlockConstants.Tablet_Twin_PriestsBecamePhilosophers;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_ANKH_IS_ALWAYS_IN_THE_FRONT) {
            return BlockConstants.Tablet_Twin_AnkhIsAlwaysInTheFront;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_DANCE_OF_LIFE) {
            return BlockConstants.Tablet_Twin_DanceOfLife;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_DESTROYED_IN_2015) {
            return BlockConstants.Tablet_Twin_DestroyedIn2015;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_ZU_PERYTON_DAMAGED) {
            return BlockConstants.DamagedTablet_Twin_ZuPeryton;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_POWER_TO_STOP_TIME) {
            return BlockConstants.Tablet_Twin_PowerToStopTime;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_TWIN_BROTHER_SHOPS) {
            return BlockConstants.Tablet_Twin_BrotherShops;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ENDLESS_DRAGON) {
            return BlockConstants.Tablet_Endless_Dragon;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ENDLESS_BORN_LIVES_REPRODUCE_ASCENSION) {
            return BlockConstants.Tablet_Endless_BornLivesReproduceAscension;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ENDLESS_TOILS_FOR_NAUGHT) {
            return BlockConstants.Tablet_Endless_ToilsForNaught;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ENDLESS_MAP_COLOR) {
            return BlockConstants.Tablet_Endless_MapColor;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ENDLESS_MIGHT_OR_WISDOM) {
            return BlockConstants.Tablet_Endless_MightOrWisdom;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ENDLESS_ENDURE_TRIALS) {
            return BlockConstants.Tablet_Endless_EndureTrials;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_CHOSEN_ONLY) {
            return BlockConstants.Tablet_Shrine_ChosenOnly;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_ENDLESSNESS_AND_DIMENSIONS) {
            return BlockConstants.Tablet_Shrine_EndlessnessAndDimensions;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_PHILOSOPHER_CHOSEN_ONE) {
            return BlockConstants.Tablet_Shrine_PhilosopherChosenOne;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_EIGHT_SPIRITS) {
            return BlockConstants.Tablet_Shrine_EightSpirits;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_SECRET_TREASURE_OF_LIFE) {
            return BlockConstants.Tablet_Shrine_SecretTreasureOfLife;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_PHILOSOPHER_IMMORTAL) {
            return BlockConstants.Tablet_Shrine_PhilosopherImmortal;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_SEVENTH_CHILDREN) {
            return BlockConstants.Tablet_Shrine_SeventhChildren;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_SLEEP_WITHIN_THE_WOMAN) {
            return BlockConstants.Tablet_Shrine_SleepWithinTheWoman;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_WALL_OF_YOUR_CALLING) {
            return BlockConstants.Tablet_Shrine_WallOfYourCalling;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_SHRINE_MUSHUSSU_COMBO) {
            return BlockConstants.Tablet_Shrine_MushussuCombo;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_VIRTUAL_WISE_MAN) {
            return BlockConstants.Tablet_Illusion_VirtualWiseMan;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_DEVICE_THAT_CREATES_LIFE) {
            return BlockConstants.Tablet_Illusion_DeviceThatCreatesLife;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_POSSESS_THE_WISDOM_OF_A_WISE_MAN) {
            return BlockConstants.Tablet_Illusion_PossessTheWisdomOfAWiseMan;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_FOOL_DESERVES_NAUGHT_BUT_DEATH) {
            return BlockConstants.Tablet_Illusion_FoolDeservesNaughtButDeath;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_KEY_TO_ENDLESS_CORRIDOR) {
            return BlockConstants.Tablet_Illusion_KeyToEndlessCorridor;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_TIAMAT_GRAIL_POWERLESS) {
            return BlockConstants.Tablet_Illusion_TiamatGrailPowerless;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_GIVE_UP_LEFT) {
            return BlockConstants.Tablet_Illusion_GiveUp; // todo: address duplication?
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_GIVE_UP_MIDDLE) {
            return BlockConstants.Tablet_Illusion_GiveUp; // todo: address duplication?
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_GIVE_UP_RIGHT) {
            return BlockConstants.Tablet_Illusion_GiveUp; // todo: address duplication?
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_FREE_THYSELF_OF_DOUBT_AND_ILLUSION) {
            return BlockConstants.Tablet_Illusion_FreeThyselfOfDoubtAndIllusion;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_THE_FAIRIES_UNLOCK_IT) {
            return BlockConstants.Tablet_Illusion_TheFairiesUnlockIt;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_UNDERSTANDING_IS_IMPRESSIVE) {
            return BlockConstants.Tablet_Illusion_UnderstandingIsImpressive;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_FOOL_PUZZLE) {
            return BlockConstants.Tablet_Illusion_FoolPuzzle;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_WANDER_THE_LABYRINTH_FOR_ETERNITY) {
            return BlockConstants.Tablet_Illusion_WanderTheLabyrinthForEternity;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_FOOL_WILL_NEVER_FIND_HIS_WAY) {
            return BlockConstants.Tablet_Illusion_FoolWillNeverFindHisWay;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_SEARCH_ON_BENDED_KNEE) {
            return BlockConstants.Tablet_Illusion_SearchOnBendedKnee;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_EXTINGUISH_THE_WHOLE) {
            return BlockConstants.Tablet_Illusion_ExtinguishTheWhole;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_ILLUSION_ENTER_EDEN) {
            return BlockConstants.Tablet_Illusion_EnterEden;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_EDEN) {
            return BlockConstants.Tablet_Eden;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_TOUJIN) {
            return BlockConstants.Tablet_Graveyard_Toujin;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_THOSE_SEEKING_EDEN) {
            return BlockConstants.Tablet_Graveyard_ThoseSeekingEden;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_MONEY_CANT_BUY_THE_REAL_THING) {
            return BlockConstants.Tablet_Graveyard_MoneyCantBuyTheRealThing;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_MEETING_OF_MAN_AND_WOMAN) {
            return BlockConstants.Tablet_Graveyard_MeetingOfManAndWoman;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_DEMON_ENDLESSLY_CONSUMES_LIFE) {
            return BlockConstants.Tablet_Graveyard_DemonEndlesslyConsumesLife;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_MEANINGS_ARE_INFUSED_INTO_THE_GEMSTONES) {
            return BlockConstants.Tablet_Graveyard_MeaningsAreInfusedIntoTheGemstones;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_MU_IS_THE_NAMELESS_ONE) {
            return BlockConstants.Tablet_Graveyard_MuIsTheNamelessOne;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_EYES_ARE_NOT_HOLLOWED_OUT_HOLES) {
            return BlockConstants.Tablet_Graveyard_EyesAreNotHollowedOutHoles;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_WE_SHALL_AWAIT_THEE_AHEAD) {
            return BlockConstants.Tablet_Graveyard_WeShallAwaitTheeAhead;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_NEW_WEAPON_TAKE_DOWN_THE_WALL) {
            return BlockConstants.Tablet_Graveyard_NewWeaponTakeDownTheWall;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_JEWEL_SHOP_WHERE_LIFE_SPRINGS_FORTH) {
            return BlockConstants.Tablet_Graveyard_JewelShopWhereLifeSpringsForth;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_SPAULDER_GODDESS) {
            return BlockConstants.Tablet_Graveyard_SpaulderGoddess;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GRAVEYARD_CURSED_TREASURE_RED_STONE) {
            return BlockConstants.Tablet_Graveyard_CursedTreasureRedStone;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_ATOP_THE_NAVEL_OF_NEPTUNE) {
            return BlockConstants.Tablet_Moonlight_AtopTheNavelOfNeptune;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_EVERY_HEART_HAS_A_WEIGHT) {
            return BlockConstants.Tablet_Moonlight_EveryHeartHasAWeight;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_MIND_THY_MANNERS) {
            return BlockConstants.Tablet_Moonlight_MindThyManners;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_ULTIMATE_SACRIFICE_FOR_POWER) {
            return BlockConstants.Tablet_Moonlight_UltimateSacrificeForPower;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_OCARINA_WOMAN_WITH_CHILD) {
            return BlockConstants.Tablet_Moonlight_OcarinaWomanWithChild;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_GRIND_DOWN_THE_PYRAMID) {
            return BlockConstants.Tablet_Moonlight_GrindDownThePyramid;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_WATER_WILL_PROVIDE_THE_POWER) {
            return BlockConstants.Tablet_Moonlight_WaterWillProvideThePower;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_SIGIL_OF_SPIRIT_THAT_CONTROLS_LIFE) {
            return BlockConstants.Tablet_Moonlight_SigilOfSpiritThatControlsLife;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_WEDGES_GIVE_FORM_TO_THE_SOUL) {
            return BlockConstants.Tablet_Moonlight_WedgesGiveFormToTheSoul;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_BOOK_OF_THE_DEAD) {
            return BlockConstants.Tablet_Moonlight_BookOfTheDead;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_UNDERWORLD_PALACE) {
            return BlockConstants.Tablet_Moonlight_UnderworldPalace;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_MOONLIGHT_EDEN_SEARCH_OUT_THE_PLACE) {
            return BlockConstants.Tablet_Moonlight_EdenSearchOutThePlace;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_FLY_WITH_THE_GOLDEN_WINGS) {
            return BlockConstants.Tablet_Goddess_FlyWithTheGoldenWings;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_MAGATAMA_JEWEL) {
            return BlockConstants.Tablet_Goddess_MagatamaJewel;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_HUNK_OF_FLYING_IRON) {
            return BlockConstants.Tablet_Goddess_HunkOfFlyingIron;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_A_BAO_A_QU) {
            return BlockConstants.Tablet_Goddess_ABaoAQu;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_RUSALII_YAKSI_DAKINI) {
            return BlockConstants.Tablet_Goddess_RusaliiYaksiDakini;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_CHALLENGE_THE_CHAMBER_OF_BIRTH) {
            return BlockConstants.Tablet_Goddess_ChallengeTheChamberOfBirth;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_ILLUSION_OF_GODDESS_STATUES) {
            return BlockConstants.Tablet_Goddess_IllusionOfGoddessStatues;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_BALANCE_THE_SPIRITS) {
            return BlockConstants.Tablet_Goddess_BalanceTheSpirits;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_AFTER_THINE_ASCENSION_TO_THE_TOWER) {
            return BlockConstants.Tablet_Goddess_AfterThineAscensionToTheTower;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_SECRET_OF_LIFE_POWER_OF_DESTRUCTION) {
            return BlockConstants.Tablet_Goddess_SecretOfLifePowerOfDestruction;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_GODDESS_CANNOT_GRANT_THE_MOTHERS_WISH) {
            return BlockConstants.Tablet_Goddess_CannotGrantTheMothersWish;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_UNINTENTIONAL_MISCHIEF) {
            return BlockConstants.Tablet_Ruin_UnintentionalMischief;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_FOLLOW_THE_NAME_THAT_MEANS_UNNAMED) {
            return BlockConstants.Tablet_Ruin_FollowTheNameThatMeansUnnamed;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_SKANDA) {
            return BlockConstants.Tablet_Ruin_Skanda;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_WHITE_DIAMOND_REPRESENTS_PURITY) {
            return BlockConstants.Tablet_Ruin_WhiteDiamondRepresentsPurity;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_GREAT_BIRD_MERCY_CRUSHING_THAT_HAND) {
            return BlockConstants.Tablet_Ruin_GreatBirdMercyCrushingThatHand;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_TOO_QUICK_FOR_THE_EYES) {
            return BlockConstants.Tablet_Ruin_TooQuickForTheEyes;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_GLOWING_RED_CRUCIFIX_BEACON) {
            return BlockConstants.Tablet_Ruin_GlowingRedCrucifixBeacon;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_THE_ONES_THAT_CREATED_NUWA) {
            return BlockConstants.Tablet_Ruin_TheOnesThatCreatedNuwa;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_IDENTIFY_THE_SEDUCTRESS) {
            return BlockConstants.Tablet_Ruin_IdentifyTheSeductress;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_THE_ONE_WHO_CHALLENGES_NUWA) {
            return BlockConstants.Tablet_Ruin_TheOneWhoChallengesNuwa;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_RUIN_FACE_THE_LAST_TRIAL) {
            return BlockConstants.Tablet_Ruin_FaceTheLastTrial;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SWORDS_BRIGHT_LIGHT_WITHIN_THE_DARKNESS) {
            return BlockConstants.Tablet_Birth_BrightLightWithinTheDarkness;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SWORDS_CONTINUES_WITHOUT_END_BIRTH_DEATH) {
            return BlockConstants.Tablet_Birth_ContinuesWithoutEndBirthDeath;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SWORDS_SHALL_NOT_MAKE_IT_WITH_THINE_POWER) {
            return BlockConstants.Tablet_Birth_ShallNotMakeItWithThinePower;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SWORDS_PALENQUE_SLUMBERS) {
            return BlockConstants.Tablet_Birth_PalenqueSlumbers;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SWORDS_VISHNU_BEHEADED_ASURA) {
            return BlockConstants.Tablet_Birth_VishnuBeheadedAsura;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SWORDS_STRIKE_THE_WEDGE_DISTURB_THE_MOTHER) {
            return BlockConstants.Tablet_Birth_StrikeTheWedgeDisturbTheMother;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CLAY_DOLLS_BECOME_HUMAN) {
            return BlockConstants.Tablet_Birth_ClayDollsBecomeHuman;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_BECAME_HUMAN_AND_PROSPERED) {
            return BlockConstants.Tablet_Birth_BecameHumanAndProspered;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_PRAISE_LIFE_CLAY_DOLL_GOLDEN_KEY) {
            return BlockConstants.Tablet_Birth_PraiseLifeClayDollGoldenKey;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_BEYOND_THE_MANY_CORPSES_A_WOMAN_WAITS) {
            return BlockConstants.Tablet_Birth_BeyondTheManyCorpsesAWomanWaits;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_BE_PREPARED_FOR_DEATH) {
            return BlockConstants.Tablet_Birth_BePreparedForDeath;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_GOLDEN_GLOW_THINLY_STRETCHED_LIGHT) {
            return BlockConstants.Tablet_Birth_GoldenGlowThinlyStretchedLight;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CHALLENGE_PALENQUE) {
            return BlockConstants.Tablet_Birth_ChallengePalenque;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_WHITE_OPAL_REPRESENTS_JOY) {
            return BlockConstants.Tablet_Birth_WhiteOpalRepresentsJoy;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_CRYSTAL_SKULL_SUPPRESSES_TIAMAT) {
            return BlockConstants.Tablet_Birth_CrystalSkullSuppressesTiamat;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_BIRTH_SKANDA_DANCE_IN_THIS_PLACE) {
            return BlockConstants.Tablet_Birth_DanceInThisPlace;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_DIMENSIONAL_BEYOND_THE_BOUNDARIES_OF_TIME) {
            return BlockConstants.Tablet_Dimensional_BeyondTheBoundariesOfTime;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_DIMENSIONAL_LIVES_THE_11_CHILDREN_HAVE) {
            return BlockConstants.Tablet_Dimensional_LivesThe11ChildrenHave;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_DIMENSIONAL_ROAD_TO_TREASURE) {
            return BlockConstants.Tablet_Dimensional_RoadToTreasure;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_DIMENSIONAL_TWO_VESSELS) {
            return BlockConstants.Tablet_Dimensional_TwoVessels;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_DIMENSIONAL_THRUST_INFINITY_THERE) {
            return BlockConstants.Tablet_Dimensional_ThrustInfinityThere;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_DIMENSIONAL_ONLY_ONE_PATH_TO_SURVIVAL) {
            return BlockConstants.Tablet_Dimensional_OnlyOnePathToSurvival;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_HT_SLEEP_ALSO_SET_BY_RETROMAUSOLEUM_ENTRANCE) {
            return BlockConstants.Tablet_HT_Sleep;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_HT_I_EXIST_HERE) {
            return BlockConstants.Tablet_HT_IExistHere;
        }
        if(tabletGlowFlag == FlagConstants.TABLET_GLOW_HT_CLOTH_TO_MAKE_THE_TREASURE) {
            return BlockConstants.Tablet_HT_ClothToMakeTheTreasure;
        }
        return null;
    }
}
