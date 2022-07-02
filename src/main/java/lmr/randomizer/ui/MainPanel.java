package lmr.randomizer.ui;

import lmr.randomizer.FileUtils;
import lmr.randomizer.HolidaySettings;
import lmr.randomizer.Settings;
import lmr.randomizer.Translations;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainPanel extends JPanel {
    private JTextField laMulanaDirectory;
    private JTextField laMulanaSaveDirectory;
    private JTextField seedNumber;
    private JComboBox language;

    private JLabel seedNumberLabel;
    private JLabel languageLabel;
    private JLabel laMulanaDirectoryLabel;
    private JLabel laMulanaSaveDirectoryLabel;

    public MainPanel() {
        super(new MigLayout("fillx", "[][sg fields, fill, grow 80]", "[]"));
        setBorder(BorderFactory.createTitledBorder(Translations.getText("settings.main")));

        if(!HolidaySettings.isFools2022Mode()) {
            seedNumber = new JTextField(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)));
            seedNumberLabel = new JLabel(Translations.getText("settings.seed"));
            add(seedNumberLabel, "gap related");
            add(seedNumber);
        }

        languageLabel = new JLabel(Translations.getText("settings.language"));
        language = new JComboBox(new String[]{"English", "日本語"});
        language.setSelectedIndex("en".equals(Settings.getLanguage()) ? 0 : 1);
        add(languageLabel, "gap related");
        add(language, "grow 50, wrap");

        laMulanaDirectory = new JTextField(Settings.getLaMulanaBaseDir());
        laMulanaDirectoryLabel = new JLabel(Translations.getText("settings.dir"));
        add(laMulanaDirectoryLabel, "gap related");
        add(laMulanaDirectory, "span 2, grow 100, wrap");

        laMulanaSaveDirectory = new JTextField(Settings.getLaMulanaSaveDir());
        laMulanaSaveDirectoryLabel = new JLabel(Translations.getText("settings.saveDir"));
        add(laMulanaSaveDirectoryLabel, "gap related");
        add(laMulanaSaveDirectory, "span 2, grow 100");
    }

    public void addActionListener(ActionListener actionListener) {
        language.addActionListener(actionListener);
    }

    public void rerollRandomSeed() {
        if(!HolidaySettings.isFools2022Mode()) {
            seedNumber.setText(Integer.toString(new Random().nextInt(Integer.MAX_VALUE)));
        }
    }

    public void updateTranslations() {
        Settings.setLanguage(language.getSelectedIndex() == 0 ? "en" : "jp", true);
        setBorder(BorderFactory.createTitledBorder(Translations.getText("settings.main")));
        if(!HolidaySettings.isFools2022Mode()) {
            seedNumberLabel.setText(Translations.getText("settings.seed"));
        }
        languageLabel.setText(Translations.getText("settings.language"));
        laMulanaDirectoryLabel.setText(Translations.getText("settings.dir"));
        laMulanaSaveDirectoryLabel.setText(Translations.getText("settings.saveDir"));
    }

    public void updateSettings() {
        try {
            if(!HolidaySettings.isFools2022Mode()) {
                Settings.setStartingSeed(Integer.parseInt(seedNumber.getText()));
            }
            Settings.setLaMulanaBaseDir(laMulanaDirectory.getText(), true);
            Settings.setLaMulanaSaveDir(laMulanaSaveDirectory.getText(), true);
            Settings.setLanguage(language.getSelectedIndex() == 0 ? "en" : "jp", true);
        }
        catch (Exception ex) {
            FileUtils.log("unable to save edit for seedNumber");
        }
    }

    public void reloadSettings() {
        if(!HolidaySettings.isFools2022Mode()) {
            seedNumber.setText(String.valueOf(Settings.getStartingSeed()));
        }
    }
}
