package lmr.randomizer.graphics;

import lmr.randomizer.FileUtils;
import lmr.randomizer.HolidaySettings;
import lmr.randomizer.Settings;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

public class GraphicsFileUpdater {
    public static final int EXISTING_FILE_WIDTH = 1024;
    public static final int EXISTING_FILE_HEIGHT = 512;
    public static final int GRAPHICS_VERSION = 6;

    public static boolean updateGraphicsFiles() {
        if(!update01Effect()) {
            return false;
        }
        return true;
    }

    private static boolean update01Effect() {
        BufferedImage custom;
        try {
            custom = ImageIO.read(FileUtils.class.getResource("01effect-custom.png"));
        }
        catch (IOException ex) {
            return false;
        }

        for(File graphicsPack : getGraphicsPacks()) {
            try {
                if(!backupGraphicsFile(graphicsPack, "01effect.png")) {
                    return false;
                }
                File graphicsFile = new File(graphicsPack, "01effect.png");
                BufferedImage existing = ImageIO.read(graphicsFile);
                boolean updateGraphics = false;
                if(existing.getHeight() < 1024) {
                    updateGraphics = true;
                }
                else {
                    int version = existing.getRGB(1023, 1023);
                    if(version != GRAPHICS_VERSION || HolidaySettings.isGraphicsUpdateRequired()) {
                        updateGraphics = true;
                    }
                }
                if(updateGraphics) {
                    FileUtils.logFlush("Updating graphics file: " + graphicsFile.getAbsolutePath());
                    // Hasn't been updated yet.
                    BufferedImage newImage = new BufferedImage(EXISTING_FILE_WIDTH, EXISTING_FILE_HEIGHT + custom.getHeight(), BufferedImage.TYPE_INT_ARGB);
                    BufferedImage backupImage = ImageIO.read(new File(graphicsPack, "01effect.png.bak"));
                    Graphics2D graphics2D = newImage.createGraphics();
                    graphics2D.drawImage(backupImage, null, 0, 0); // Use backup to ensure no duplication of file
                    graphics2D.drawImage(custom, null, 0, EXISTING_FILE_HEIGHT);
                    graphics2D.dispose();
                    newImage.setRGB(1023, 1023, GRAPHICS_VERSION);
                    ImageIO.write(newImage, "png", graphicsFile);
                    FileUtils.log("Graphics file successfully updated");
                }
                else {
                    FileUtils.logFlush("Graphics file is already up to date: " + graphicsFile.getAbsolutePath());
                }
            }
            catch (IOException ex) {
                return false;
            }
        }
        return true;
    }

    private static boolean copyGraphicsFiles(File graphicsPack, File destinationFolder) {
        try {
            for(File graphicsFile : graphicsPack.listFiles()) {
                if(graphicsFile.isFile()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(destinationFolder, graphicsFile.getName()));
                    Files.copy(graphicsFile.toPath(), fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
            return true;
        }
        catch (IOException ex) {
            return false;
        }
    }

    public static boolean updateGraphicsFilesForHalloween2019(String graphicsPack) {
        String graphicsBase = Settings.getLaMulanaBaseDir() + "/data/graphics";
        String halloweenFolderPath = graphicsBase + "/HALLOWEEN";
        File halloweenGraphicsFolder = new File(halloweenFolderPath);
        File graphicsBaseFolder = new File(graphicsBase, graphicsPack);
        if(halloweenGraphicsFolder.exists()) {
            halloweenGraphicsFolder.delete();
        }
        halloweenGraphicsFolder.mkdir();

        if(!copyGraphicsFiles(graphicsBaseFolder, halloweenGraphicsFolder)) {
            FileUtils.logFlush("Problem copying graphics from source folder " + graphicsPack);
            halloweenGraphicsFolder.delete();
            return false;
        }

        if(!copyModifiedFiles(halloweenFolderPath, halloweenGraphicsFolder, Arrays.asList("02comenemy.png", "_banner.png",
                "eveg01.png", "eveg03.png", "eveg04.png", "eveg05.png", "eveg06.png", "eveg08.png", "eveg09.png",
                "eveg10.png", "eveg11.png", "eveg12.png", "eveg13.png", "eveg14.png", "eveg15.png", "eveg16.png",
                "eveg17.png", "eveg18.png", "eveg19.png", "eveg20.png", "map18_1.png"))) {
            return false;
        }

        if(!updateTitle01(halloweenFolderPath)) {
            return false;
        }
        if(!update01Menu(halloweenFolderPath)) {
            return false;
        }

        return true;
    }

    private static boolean copyModifiedFiles(String folderPath, File graphicsFolder, List<String> modifiedFilesToCopy) {
        for(String file : modifiedFilesToCopy) {
            try {
                File graphicsFileToWrite = new File(folderPath, file);
                BufferedImage modified;
                try {
                    modified = ImageIO.read(FileUtils.class.getResource(getPathFromSettings(file)));
                }
                catch (IOException ex) {
                    FileUtils.logFlush("Problem copying graphics file " + file);
                    graphicsFolder.delete();
                    return false;
                }
                BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
                BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D graphics2D = newImage.createGraphics();
                graphics2D.drawImage(modified, null, 0, 0); // Use backup to ensure no duplication of file
                graphics2D.dispose();

                ImageIO.write(newImage, "png", graphicsFileToWrite);
            }
            catch(IOException ex) {
                FileUtils.logFlush("Problem copying graphics file " + file);
                graphicsFolder.delete();
                return false;
            }
        }
        return true;
    }

    public static boolean updateGraphicsFilesForFools2022(String graphicsPack) {
        String graphicsBase = Settings.getLaMulanaBaseDir() + "/data/graphics";
        String foolsFolderPath = graphicsBase + "/FOOLS22";
        File foolsGraphicsFolder = new File(foolsFolderPath);
        File graphicsBaseFolder = new File(graphicsBase, graphicsPack);
        if(foolsGraphicsFolder.exists()) {
            foolsGraphicsFolder.delete();
        }
        foolsGraphicsFolder.mkdir();

        if(!copyGraphicsFiles(graphicsBaseFolder, foolsGraphicsFolder)) {
            FileUtils.logFlush("Problem copying graphics from source folder " + graphicsPack);
            foolsGraphicsFolder.delete();
            return false;
        }

        if(!copyModifiedFiles(foolsFolderPath, foolsGraphicsFolder, Arrays.asList("_banner.png"))) {
            return false;
        }

        if(!updateSlate00(foolsFolderPath, new ArrayList<>(0))) {
            return false;
        }
        if(!updateSlate01(foolsFolderPath, new ArrayList<>(0))) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map00_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map02_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map03_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map04_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map05_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map06_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map07_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map08_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map10_1.png")) {
            return false;
        }
        if(!updateSmallMapGraphics_Fools2022(foolsFolderPath, "map11_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map12_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map13_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map14_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map15_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map16_1.png")) {
            return false;
        }
        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map18_1.png")) {
            return false;
        }
//        if(!updateMapGraphics_Fools2022(foolsFolderPath, "map17_1.png")) {
//            return false;
//        }
//        if(!updateTitle01(foolsFolderPath)) {
//            return false;
//        }
        if(!update01Effect_Fools2022(foolsFolderPath)) {
            return false;
        }
        if(!update00Item_Fools2022(foolsFolderPath)) {
            return false;
        }
        if(!updateEveg01_Fools2022(foolsFolderPath)) {
            return false;
        }
        if(!updateEveg17_Fools2022(foolsFolderPath)) {
            return false;
        }
        if(!updateEveg18_Fools2022(foolsFolderPath)) {
            return false;
        }
        return true;
    }

    public static boolean updateGraphicsFilesForFools2020(String graphicsPack) {
        String graphicsBase = Settings.getLaMulanaBaseDir() + "/data/graphics";
        String foolFolderPath = graphicsBase + "/FOOLS2020";
        File foolGraphicsFolder = new File(foolFolderPath);
        File graphicsBaseFolder = new File(graphicsBase, graphicsPack);
        if(foolGraphicsFolder.exists()) {
            foolGraphicsFolder.delete();
        }
        foolGraphicsFolder.mkdir();

        if(!copyGraphicsFiles(graphicsBaseFolder, foolGraphicsFolder)) {
            FileUtils.logFlush("Problem copying graphics from source folder " + graphicsPack);
            foolGraphicsFolder.delete();
            return false;
        }

        if(!copyModifiedFiles(foolFolderPath, foolGraphicsFolder, Arrays.asList("_banner.png"))) {
            return false;
        }

        if(!update01Menu(foolFolderPath)) {
            return false;
        }

        return true;
    }

    private static boolean updateTitle01(String folderPath) {
        String file = "title01.png";
        try {
            File graphicsFileToWrite = new File(folderPath, file);
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            if(HolidaySettings.isHalloween2021Mode()) {
                drawImageWithMissingSection(existingImage, graphics2D, 942, 740, 16, 20);
                graphics2D.drawImage(getCustomGraphic("mapcandy_small.png"), null, 944, 740);
            }
            else {
                drawImageWithMissingSection(existingImage, graphics2D, 942, 740, 16, 20);
                graphics2D.drawImage(getCustomGraphic("candycornoflife_small.png"), null, 942, 740);
            }
            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file " + file);
            return false;
        }
        return true;
    }

    private static boolean update01Menu(String folderPath) {
        String file = "01menu.png";
        String filepath = getPathFromSettings(file);

        try {
            File graphicsFileToWrite = new File(folderPath, file);
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            if(HolidaySettings.isHalloween2019Mode()) {
                BufferedImage modified;
                try {
                    modified = ImageIO.read(FileUtils.class.getResource(filepath));
                }
                catch (IOException ex) {
                    return false;
                }

                drawImageWithMissingSection(existingImage, graphics2D, 780, 320, 40, 40);
                graphics2D.drawImage(modified.getSubimage(780, 320, 40, 40), null, 780, 320);
            }
            else if(HolidaySettings.isFools2020Mode()) {
                final int itemsBeginX = 620;
                final int itemsBeginY = 0;
                final int itemsEndY = 440;
                final int fullWidth = 1024;
                final int fullHeight = 1024;
                BufferedImage leftOfItems = existingImage.getSubimage(0, 0, itemsBeginX, fullHeight);
                BufferedImage belowItems = existingImage.getSubimage(itemsBeginX, itemsEndY, fullWidth - itemsBeginX, fullHeight - itemsEndY);
                graphics2D.drawImage(leftOfItems, null, 0, 0);
                graphics2D.drawImage(belowItems, null, itemsBeginX, itemsEndY);

                for(int verticalIndex = 0; verticalIndex < 11; verticalIndex++) {
                    for(int horizontalIndex = 0; horizontalIndex < 10; horizontalIndex++) {
                        int itemDrawBeginX = itemsBeginX + horizontalIndex * 40;
                        int itemDrawBeginY = itemsBeginY + verticalIndex * 40;
                        int sourceGraphicsBeginX = itemDrawBeginX;
                        int sourceGraphicsBeginY = itemDrawBeginY;
                        if(horizontalIndex == 7 && verticalIndex == 3) {
                            // Heatproof case
                            sourceGraphicsBeginX = itemsBeginX + 240;
                            sourceGraphicsBeginY = itemsBeginY + 200;
                        }
                        else if(horizontalIndex == 6 && verticalIndex == 5) {
                            // Scriptures
                            sourceGraphicsBeginX = itemsBeginX + 280;
                            sourceGraphicsBeginY = itemsBeginY + 120;
                        }
                        else if(horizontalIndex == 4 && verticalIndex == 8) {
                            // Secret Treasure of Life
                            sourceGraphicsBeginX = itemsBeginX + 120;
                            sourceGraphicsBeginY = itemsBeginY + 200;
                        }
                        if(horizontalIndex != 0 || verticalIndex != 7) {
                            BufferedImage itemGraphic = existingImage.getSubimage(sourceGraphicsBeginX, sourceGraphicsBeginY, 40, 40);
                            graphics2D.drawImage(itemGraphic, null, itemDrawBeginX, itemDrawBeginY);
                        }
                    }
                }
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file " + file);
            return false;
        }
        return true;
    }

    private static boolean update01Menu_Halloween2021(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "01menu.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getMenuGraphicsFileEntries();

            GraphicsFileEntry existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.MAP);
            graphics2D.drawImage(getCustomGraphic("mapcandy.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.SECRET_TREASURE_OF_LIFE);
            graphics2D.drawImage(getCustomGraphic("mapcandy.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            GraphicsFileEntry yellowMedicine = graphicsFileEntries.remove(GraphicsFileData.MEDICINE_OF_THE_MIND_YELLOW);
            GraphicsFileEntry redMedicine = graphicsFileEntries.remove(GraphicsFileData.MEDICINE_OF_THE_MIND_RED);
            BufferedImage yellowMedicineSubimage = existingImage.getSubimage(yellowMedicine.getX(), yellowMedicine.getY(), yellowMedicine.getWidth(), yellowMedicine.getHeight());
            BufferedImage redMedicineSubimage = existingImage.getSubimage(redMedicine.getX(), redMedicine.getY(), redMedicine.getWidth(), redMedicine.getHeight());
            graphics2D.drawImage(yellowMedicineSubimage, null, redMedicine.getX(), redMedicine.getY());
            graphics2D.drawImage(redMedicineSubimage, null, yellowMedicine.getX(), yellowMedicine.getY());

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file 01menu.png");
            return false;
        }
        return true;
    }

    private static boolean update02ComEnemy_Halloween2021(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "02comenemy.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getCommonEnemyGraphicsFileEntries();

            GraphicsFileEntry existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.MUDMAN_FLAT);
            graphics2D.drawImage(getCustomGraphic("mudman_flat.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.MUDMAN_WALKING);
            graphics2D.drawImage(getCustomGraphic("mudman_walking.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.MUDMAN_EXTRA_1);
            graphics2D.drawImage(getCustomGraphic("mudman_extra1.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.MUDMAN_EXTRA_2);
            graphics2D.drawImage(getCustomGraphic("mudman_extra2.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.TOG);
            graphics2D.drawImage(getCustomGraphic("tog.png"), null, existingGraphicsFileEntry.getX(), existingGraphicsFileEntry.getY());

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file 02comenemy.png");
            return false;
        }
        return true;
    }

    private static boolean updateB08_Halloween2021(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "b08.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getB08GraphicsFileEntries();

            GraphicsFileEntry yellowMedicine = graphicsFileEntries.remove(GraphicsFileData.BOSS_MOTHER_POUR_YELLOW_MEDICINE);
            GraphicsFileEntry redMedicine = graphicsFileEntries.remove(GraphicsFileData.BOSS_MOTHER_POUR_RED_MEDICINE);
            BufferedImage yellowMedicineSubimage = existingImage.getSubimage(yellowMedicine.getX(), yellowMedicine.getY(), yellowMedicine.getWidth(), yellowMedicine.getHeight());
            BufferedImage redMedicineSubimage = existingImage.getSubimage(redMedicine.getX(), redMedicine.getY(), redMedicine.getWidth(), redMedicine.getHeight());
            graphics2D.drawImage(yellowMedicineSubimage, null, redMedicine.getX(), redMedicine.getY());
            graphics2D.drawImage(redMedicineSubimage, null, yellowMedicine.getX(), yellowMedicine.getY());

            GraphicsFileEntry existingGraphicsFileEntry = graphicsFileEntries.remove(GraphicsFileData.BOSS_MOTHER_SECRET_TREASURE_OF_LIFE_SMALL);
            graphics2D.drawImage(getCustomGraphic("mapcandy_small.png"), null, existingGraphicsFileEntry.getX() + 2, existingGraphicsFileEntry.getY() + 2);

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file b08.png");
            return false;
        }
        return true;
    }

    private static boolean updateMapGraphics_Fools2022(String folderPath, String filename) {
        try {
            File graphicsFileToWrite = new File(folderPath, filename);
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getLargeMapGraphicsFileEntries();

            if(!"map18_1.png".equals(filename)) {
                graphicsFileEntries.remove(GraphicsFileData.MAP_CROSS_OF_LIGHT);
            }

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            if("map03_1.png".equals(filename)) {
                graphics2D.drawImage(getCustomGraphic("sunpot.png"), null, 0, 820);
            }
            if("map15_1.png".equals(filename)) {
                graphics2D.drawImage(getCustomGraphic("cogtablet.png"), null, 700, 700);
            }
            if("map18_1.png".equals(filename)) {
                graphics2D.drawImage(getCustomGraphic("wedges.png"), null, 0, 800);
                graphics2D.drawImage(getCustomGraphic("motherankh.png"), null, 803, 863);
                graphics2D.drawImage(ImageIO.read(new File(folderPath, "eveg18.png")).getSubimage(900, 60, 80, 80), null, 0, 900);
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file " + filename);
            return false;
        }
        return true;
    }

    private static boolean updateSmallMapGraphics_Fools2022(String folderPath, String filename) {
        try {
            File graphicsFileToWrite = new File(folderPath, filename);
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getSmallMapGraphicsFileEntries();

            graphicsFileEntries.remove(GraphicsFileData.MAP_CROSS_OF_LIGHT);

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file " + filename);
            return false;
        }
        return true;
    }

    private static boolean updateSlate00(String folderPath, List<Integer> entriesToRemove) {
        try {
            File graphicsFileToWrite = new File(folderPath, "slate00.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getSlate00GraphicsFileEntries();
            for(Integer entryToRemove : entriesToRemove) {
                graphicsFileEntries.remove(entryToRemove);
            }

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file slate00.png");
            return false;
        }
        return true;
    }

    private static boolean updateSlate01(String folderPath, List<Integer> entriesToRemove) {
        try {
            File graphicsFileToWrite = new File(folderPath, "slate01.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getSlate01GraphicsFileEntries();
            for(Integer entryToRemove : entriesToRemove) {
                graphicsFileEntries.remove(entryToRemove);
            }

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file slate01.png");
            return false;
        }
        return true;
    }

    private static boolean update01Effect_Fools2022(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "01effect.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            BufferedImage subimage = existingImage.getSubimage(0, 0, EXISTING_FILE_WIDTH, 512);
            graphics2D.drawImage(subimage, null, 0, 0);

            graphics2D.drawImage(getDefaultGraphic("01effect-custom.png"), null, 0, 512);
            graphics2D.drawImage(getCustomGraphic("sphinx.png"), null, 240, 788);
            graphics2D.drawImage(getCustomGraphic("frowney.png"), null, 417, 802);
            graphics2D.drawImage(getCustomGraphic("tabletflip.png"), null, 417, 850);

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file 01effect.png");
            return false;
        }
        return true;
    }

    private static boolean update00Item_Fools2022(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "00item.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            BufferedImage subimage = existingImage.getSubimage(0, 0, 1024, 1024);
            graphics2D.drawImage(subimage, null, 0, 0);

            graphics2D.drawImage(getCustomGraphic("deathfield.png"), null, 0, 600);

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file 00item.png");
            return false;
        }
        return true;
    }

    private static boolean updateEveg01_Fools2022(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "eveg01.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getEveg01GraphicsFileEntries();

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.drawImage(getCustomGraphic("toggleblocks.png"), null, 0, 200);

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file eveg01.png");
            return false;
        }
        return true;
    }

    private static boolean updateEveg17_Fools2022(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "eveg17.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getEveg17GraphicsFileEntries();

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.drawImage(getCustomGraphic("extendablespikes.png"), null, 0, 320);

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file eveg17.png");
            return false;
        }
        return true;
    }

    private static boolean updateEveg18_Fools2022(String folderPath) {
        try {
            File graphicsFileToWrite = new File(folderPath, "eveg18.png");
            BufferedImage existingImage = ImageIO.read(graphicsFileToWrite);
            BufferedImage newImage = new BufferedImage(existingImage.getWidth(), existingImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics2D = newImage.createGraphics();

            Map<Integer, GraphicsFileEntry> graphicsFileEntries = GraphicsFileData.getEveg18GraphicsFileEntries();

            for(GraphicsFileEntry graphicsFileEntry : graphicsFileEntries.values()) {
                BufferedImage subimage = existingImage.getSubimage(graphicsFileEntry.getX(), graphicsFileEntry.getY(), graphicsFileEntry.getWidth(), graphicsFileEntry.getHeight());
                graphics2D.drawImage(subimage, null, graphicsFileEntry.getX(), graphicsFileEntry.getY());
            }

            graphics2D.drawImage(getCustomGraphic("toggleblocks.png"), null, 0, 200);

            graphics2D.dispose();

            ImageIO.write(newImage, "png", graphicsFileToWrite);
        }
        catch(IOException ex) {
            FileUtils.logFlush("Problem copying graphics file eveg01.png");
            return false;
        }
        return true;
    }

    private static BufferedImage getCustomGraphic(String filename) throws IOException {
        return ImageIO.read(FileUtils.class.getResource(getPathFromSettings(filename)));
    }

    private static BufferedImage getDefaultGraphic(String filename) throws IOException {
        return ImageIO.read(FileUtils.class.getResource(filename));
    }

    private static boolean backupGraphicsFile(File graphicsPack, String filename) {
        try {
            File backup = new File(graphicsPack, filename + ".bak");
            if(!backup.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(backup);
                Files.copy(new File(graphicsPack, filename).toPath(), fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return true;
        }
        catch (IOException ex) {
            return false;
        }
    }

    private static void drawImageWithMissingSection(BufferedImage existingImage, Graphics2D graphics2D, int x, int y, int width, int height) throws IOException{
        BufferedImage leftPart = existingImage.getSubimage(0, 0, x, existingImage.getHeight());
        BufferedImage topPart = existingImage.getSubimage(x, 0, width, y);
        BufferedImage rightPart = existingImage.getSubimage(x + width, 0, existingImage.getWidth() - x - width, existingImage.getHeight());
        BufferedImage bottomPart = existingImage.getSubimage(x, y + height, width, existingImage.getHeight() - y - height);
        graphics2D.drawImage(leftPart, null, 0, 0);
        graphics2D.drawImage(topPart, null, x, 0);
        graphics2D.drawImage(rightPart, null, x + width, 0);
        graphics2D.drawImage(bottomPart, null, x, y + height);
    }

    private static String getPathFromSettings(String file) {
        if(HolidaySettings.isHalloween2019Mode()) {
            return "graphics/halloween/" + file;
        }
        if(HolidaySettings.isHalloween2021Mode()) {
            return "graphics/halloween2021/" + file;
        }
        if(HolidaySettings.isFools2020Mode()) {
            return "graphics/fools2020/" + file;
        }
        if(HolidaySettings.isFools2022Mode()) {
            return "graphics/fools2022/" + file;
        }
        return  "";
    }

    private static List<File> getGraphicsPacks() {
        File graphicsFolder = new File(Settings.getLaMulanaBaseDir() + "/data/graphics");
        if(graphicsFolder.exists() && graphicsFolder.isDirectory()) {
            List<File> graphicsSubfolders = new ArrayList<>();
            for(File file : graphicsFolder.listFiles()) {
                if(file.isDirectory()) {
                    graphicsSubfolders.add(file);
                }
            }
            return graphicsSubfolders;
        }
        return new ArrayList<>(0);
    }
}
