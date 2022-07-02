package lmr.randomizer.ui;

import lmr.randomizer.HolidaySettings;
import lmr.randomizer.Translations;

import javax.swing.*;

public class TabbedPanel extends JTabbedPane {
    private EventPanel eventPanel;
    private RandomizationPanel randomizationPanel;
    private LocationPanel locationPanel;
//    private EnemiesPanel enemiesPanel;
    private LogicPanel logicPanel;
    private AppearancePanel appearancePanel;
    private GameplayChangesPanel gameplayChangesPanel;
    private RemovedItemsPanel removedItemsPanel;
    private SettingsTransportPanel settingsTransportPanel;
    private MainPanel mainPanel;

    public TabbedPanel(MainPanel _mainPanel) {
        mainPanel = _mainPanel;

        if(HolidaySettings.isHalloweenMode()) {
            eventPanel = new EventPanel(this);
            addTab(Translations.getText("settings.event.halloween"), eventPanel);
        }
        else if(HolidaySettings.isFools2020Mode()) {
            eventPanel = new EventPanel(this);
            addTab(Translations.getText("settings.event.fools2020"), eventPanel);
        }
        else if(HolidaySettings.isFools2021Mode()) {
            eventPanel = new EventPanel(this);
            addTab(Translations.getText("settings.event.fools2021"), eventPanel);
        }
        else if(HolidaySettings.isFools2022Mode()) {
            eventPanel = new EventPanel(this);
            addTab(Translations.getText("settings.event.fools2022"), eventPanel);
        }

        randomizationPanel = new RandomizationPanel();
        addTab(Translations.getText("settings.items"), randomizationPanel);

        locationPanel = new LocationPanel();
        addTab(Translations.getText("settings.locations"), locationPanel);

//        enemiesPanel = new EnemiesPanel();
//        addTab(Translations.getText("settings.enemies"), enemiesPanel);

        logicPanel = new LogicPanel();
        addTab(Translations.getText("settings.logic"), logicPanel);

        appearancePanel = new AppearancePanel();
        addTab(Translations.getText("settings.appearance"), appearancePanel);

        gameplayChangesPanel = new GameplayChangesPanel();
        addTab(Translations.getText("settings.gameplay"), gameplayChangesPanel);

        removedItemsPanel = new RemovedItemsPanel();
        addTab(Translations.getText("settings.removal"), removedItemsPanel);

        settingsTransportPanel = new SettingsTransportPanel(this);
        addTab(Translations.getText("settings.share"), settingsTransportPanel);
    }

    public void reloadSettings() {
        mainPanel.reloadSettings();
        if (eventPanel != null) {
            eventPanel.reloadSettings();
        }
        randomizationPanel.reloadSettings();
        locationPanel.reloadSettings();
//        enemiesPanel.reloadSettings();
        logicPanel.reloadSettings();
        appearancePanel.reloadSettings();
        gameplayChangesPanel.reloadSettings();
        removedItemsPanel.reloadSettings();
    }

    public void updateSettings() {
        if (eventPanel != null) {
            eventPanel.updateSettings();
        }
        mainPanel.updateSettings();
        randomizationPanel.updateSettings();
        locationPanel.updateSettings();
//        enemiesPanel.updateSettings();
        logicPanel.updateSettings();
        appearancePanel.updateSettings();
        gameplayChangesPanel.updateSettings();
        removedItemsPanel.updateSettings();
    }

    public void updateTranslations() {
        if (eventPanel != null) {
            eventPanel.updateTranslations();
        }
        randomizationPanel.updateTranslations();
        locationPanel.updateTranslations();
//        enemiesPanel.updateTranslations();
        logicPanel.updateTranslations();
        appearancePanel.updateTranslations();
        gameplayChangesPanel.updateTranslations();
        removedItemsPanel.updateTranslations();

        int i = 0;
        if(HolidaySettings.isHalloweenMode()) {
            setTitleAt(i++, Translations.getText("settings.event.halloween"));
        }
        else if(HolidaySettings.isFools2020Mode()) {
            setTitleAt(i++, Translations.getText("settings.event.fools2020"));
        }
        else if(HolidaySettings.isFools2021Mode()) {
            setTitleAt(i++, Translations.getText("settings.event.fools2021"));
        }
        setTitleAt(i++, Translations.getText("settings.items"));
        setTitleAt(i++, Translations.getText("settings.locations"));
//        setTitleAt(2, Translations.getText("settings.enemies"));
        setTitleAt(i++, Translations.getText("settings.logic"));
        setTitleAt(i++, Translations.getText("settings.appearance"));
        setTitleAt(i++, Translations.getText("settings.gameplay"));
        setTitleAt(i++, Translations.getText("settings.removal"));
        setTitleAt(i++, Translations.getText("settings.share"));
    }
}
