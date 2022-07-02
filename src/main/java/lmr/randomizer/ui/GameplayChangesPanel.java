package lmr.randomizer.ui;

import lmr.randomizer.Settings;
import lmr.randomizer.Translations;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GameplayChangesPanel extends JPanel {
    private ConveniencePanel conveniencePanel;
    private JCheckBox alternateMotherAnkh;
    private JCheckBox reducedBossCount;
    private JCheckBox automaticHardmode;

    public GameplayChangesPanel() {
        super(new MigLayout("fillx, wrap"));

        conveniencePanel = new ConveniencePanel();
        add(conveniencePanel, "growx");

        alternateMotherAnkh = new JCheckBox();
        alternateMotherAnkh.setSelected(Settings.isAlternateMotherAnkh());

        reducedBossCount = new JCheckBox();
        reducedBossCount.setSelected(Settings.isReducedBossCount());

        automaticHardmode = new JCheckBox();
        automaticHardmode.setSelected(Settings.isAutomaticHardmode());

        CheckboxContainer checkboxContainer = new CheckboxContainer(1);
        checkboxContainer.add(alternateMotherAnkh);
        checkboxContainer.add(reducedBossCount);
        checkboxContainer.add(automaticHardmode);
        add(checkboxContainer, "growx, wrap");

        updateTranslations();
    }

    public void updateTranslations() {
        conveniencePanel.updateTranslations();
        alternateMotherAnkh.setText(Translations.getText("gameplay.alternateMotherAnkh"));
        reducedBossCount.setText(Translations.getText("gameplay.reducedBossCount"));
        automaticHardmode.setText(Translations.getText("challenge.automaticHardmode"));
    }

    public void updateSettings() {
        conveniencePanel.updateSettings();
        Settings.setAlternateMotherAnkh(alternateMotherAnkh.isSelected(), true);
        Settings.setReducedBossCount(reducedBossCount.isSelected(), true);
        Settings.setAutomaticHardmode(automaticHardmode.isSelected(), true);
    }

    public void reloadSettings() {
        conveniencePanel.reloadSettings();
        alternateMotherAnkh.setSelected(Settings.isAlternateMotherAnkh());
        reducedBossCount.setSelected(Settings.isReducedBossCount());
        automaticHardmode.setSelected(Settings.isAutomaticHardmode());
    }
}
