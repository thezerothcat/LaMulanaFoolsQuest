package lmr.randomizer.ui;

import lmr.randomizer.HolidaySettings;
import lmr.randomizer.Settings;
import lmr.randomizer.Translations;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EventPanel extends JPanel {
    private JCheckBox holidayMode;
    private JCheckBox holidayOption1;
    private JCheckBox fools2021Pt1;
    private JCheckBox holidayOption2;
    private JCheckBox fools2021Pt3;
    private JTextField graphicsPack;
    private JLabel graphicsPackLabel;
    private JButton chooseGraphicsButton;

    public EventPanel(TabbedPanel tabbedPanel) {
        super(new MigLayout("fillx, wrap"));
        holidayMode = new JCheckBox();
        holidayMode.setSelected(true);
        holidayMode.setEnabled(false);

        holidayOption1 = new JCheckBox();
        holidayOption1.setSelected(true);

        CheckboxContainer checkboxContainer = new CheckboxContainer(1);
        if (HolidaySettings.isHalloween2019Mode() || HolidaySettings.isHalloween2021Mode() || HolidaySettings.isFools2020Mode() || HolidaySettings.isFools2022Mode()) {
            checkboxContainer.add(holidayMode);
            checkboxContainer.add(holidayOption1);
        }
        add(checkboxContainer, "growx, wrap");

        graphicsPack = new JTextField(Settings.getGraphicsPack());
        graphicsPackLabel = new JLabel(Translations.getText("settings.graphicsPack"));

        chooseGraphicsButton = new JButton(Translations.getText("button.browse"));
        chooseGraphicsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser graphicsFileChooser = new JFileChooser();
                graphicsFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                graphicsFileChooser.setCurrentDirectory(new File(Settings.getLaMulanaBaseDir() + "/data/graphics"));
                if(graphicsFileChooser.showOpenDialog(tabbedPanel.getParent()) == JFileChooser.APPROVE_OPTION) {
                    graphicsPack.setText(graphicsFileChooser.getSelectedFile().getName());
                }
            }
        });
        JPanel panel = new JPanel(new MigLayout("fillx", "[right]rel[grow,fill]rel[]", "[]10[]10[]"));
        panel.add(graphicsPackLabel);
        panel.add(graphicsPack);
        panel.add(chooseGraphicsButton);
        add(panel, "growx, wrap");

        updateTranslations();
    }

    public void updateTranslations() {
        holidayMode.setText(Translations.getText("event.fools2022"));
        holidayOption1.setText(Translations.getText("event.fools2022.preserveTabletGlow"));
    }

    public void updateSettings() {
        HolidaySettings.setPreserveCustomTabletGlow(holidayOption1.isSelected(), true);
    }

    public void reloadSettings() {
        holidayOption1.setSelected(HolidaySettings.isPreserveCustomTabletGlow());
    }
}
