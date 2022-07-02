package lmr.randomizer.dat.blocks;

import lmr.randomizer.dat.blocks.contents.entries.TextEntry;

public class ItemDescriptionBlock extends Block {
    public static final int Whip = 0;
    public static final int ChainWhip = 1;
    public static final int FlailWhip = 2;
    public static final int Knife = 3;
    public static final int KeySword = 4;
    public static final int Axe = 5;
    public static final int Katana = 6;
    public static final int EmpoweredKeySword = 7;
    public static final int Shuriken = 8;
    public static final int RollingShuriken = 9;
    public static final int EarthSpear = 10;
    public static final int FlareGun = 11;
    public static final int Bomb = 12;
    public static final int Chakram = 13;
    public static final int Caltrops = 14;
    public static final int Pistol = 15;
    public static final int Buckler = 16;
    public static final int SilverShield = 17;
    public static final int AngelShield = 18;
    public static final int AnkhJewel = 19;
    public static final int HandScanner = 20;
    public static final int DjedPillar = 21;
    public static final int MiniDoll = 22;
    public static final int MagatamaJewel = 23;
    public static final int CogOfTheSoul = 24;
    public static final int LampOfTime = 25;
    public static final int PochetteKey = 26;
    public static final int DragonBone = 27;
    public static final int CrystalSkull = 28;
    public static final int Vessel = 29;
    public static final int Pepper = 30;
    public static final int WomanStatue = 31;
    public static final int KeyOfEternity = 32;
    public static final int SerpentStaff = 33;
    public static final int Talisman = 34;
    public static final int MSX1 = 35;
    public static final int WaterproofCase = 36;
    public static final int HeatproofCase = 37;
    public static final int ShellHorn = 38;
    public static final int Glove = 39;
    public static final int HolyGrail = 40;
    public static final int IsisPendant = 41;
    public static final int Crucifix = 42;
    public static final int Helmet = 43;
    public static final int GrappleClaw = 44;
    public static final int BronzeMirror = 45;
    public static final int EyeOfTruth = 46;
    public static final int Ring = 47;
    public static final int Scalesphere = 48;
    public static final int Gauntlet = 49;
    public static final int Anchor = 50;
    public static final int PlaneModel = 51;
    public static final int PhilosophersOcarina = 52;
    public static final int Feather = 53;
    public static final int BookOfTheDead = 54;
    public static final int FairyClothes = 55;
    public static final int Scriptures = 56;
    public static final int HermesBoots = 57;
    public static final int FruitOfEden = 58;
    public static final int TwinStatue = 59;
    public static final int Bracelet = 60;
    public static final int Perfume = 61;
    public static final int Spaulder = 62;
    public static final int DimensionalKey = 63;
    public static final int IceCape = 64;
    public static final int OriginSeal = 65;
    public static final int BirthSeal = 66;
    public static final int LifeSeal = 67;
    public static final int DeathSeal = 68;
    public static final int SacredOrb = 69;
    public static final int Map = 70;
    public static final int Treasures = 71;
    public static final int Diary = 72;
    public static final int MulanaTalisman = 73;
    public static final int ProvocativeBathingSuit = 74;
    public static final int FakeSilverShield = 75;
    public static final int MSX2 = 76;
    public static final int YellowMedicine = 77;
    public static final int GreenMedicine = 78;
    public static final int RedMedicine = 79;
    public static final int LampOfTimeEmpty = 80;
    public static final int MaternityStatue = 81;
    public static final int BrokenGrail = 82;
    public static final int EmpoweredGrail = 83;
    public static final int SecretTreasureOfLife = 84;
    public static final int SoftwareReader = 85;
    public static final int SoftwareXmailer = 86;
    public static final int SoftwareYagomap = 87;
    public static final int SoftwareYagostr = 88;
    public static final int SoftwareBunemon = 89;
    public static final int SoftwareBunplus = 90;
    public static final int SoftwareTorude = 91;
    public static final int SoftwareGuild = 92;
    public static final int SoftwareMantra = 93;
    public static final int SoftwareEmusic = 94;
    public static final int SoftwareBeolamu = 95;
    public static final int SoftwareDeathv = 96;
    public static final int SoftwareRandc = 97;
    public static final int SoftwareCapstar = 98;
    public static final int SoftwareMove = 99;
    public static final int SoftwareMekuri = 100;
    public static final int SoftwareBounce = 101;
    public static final int SoftwareMiracle = 102;
    public static final int SoftwareMirai = 103;
    public static final int SoftwareLamulana = 104;

    public ItemDescriptionBlock(int blockNumber) {
        super(blockNumber);
    }

    public TextEntry getDescription(int index) {
        return (TextEntry)getBlockContents().get(index);
    }
    public void setDescription(int index, TextEntry newItemDescriptionData) {
        getBlockContents().set(index, newItemDescriptionData);
    }
}