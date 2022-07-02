package lmr.randomizer.ui;

import lmr.randomizer.Settings;
import lmr.randomizer.Translations;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class GameItemRadio extends JPanel {
    private ButtonGroup itemRandomization;
    private String itemName;
    private JLabel itemLabel;
    private JRadioButton randomItem;
    private JRadioButton initialItem;
    private JRadioButton startingItem;

    public GameItemRadio(String item) {
        super(new MigLayout("gap rel 0, wrap, aligny top", "sizegroup rowheight", ""));

        itemLabel = new JLabel(Translations.getItemText(item, false), JLabel.LEFT);
        itemLabel.setVerticalAlignment(JLabel.TOP);
        add(itemLabel);

        itemRandomization = new ButtonGroup();

        randomItem = new JRadioButton(Translations.getText("randomization.random"));
        randomItem.setActionCommand("RANDOM");
        itemRandomization.add(randomItem);

        if("xmailer.exe".equals(item)) {
            initialItem = null;

            startingItem = new JRadioButton(Translations.getText("randomization.xelpud"));
            startingItem.setActionCommand("XELPUD");
            itemRandomization.add(startingItem);

            CheckboxContainer checkboxContainer = new CheckboxContainer(1);
            checkboxContainer.add(randomItem);
            checkboxContainer.add(startingItem);
            add(checkboxContainer);

            if (Settings.isRandomizeXmailer()) {
                randomItem.setSelected(true);
            }
            else {
                startingItem.setSelected(true);
            }
        }
        else {
            initialItem = new JRadioButton(Translations.getText("randomization.initial"));
            initialItem.setActionCommand("INITIAL");
            itemRandomization.add(initialItem);

            CheckboxContainer checkboxContainer = new CheckboxContainer(1);
            checkboxContainer.add(randomItem);
            checkboxContainer.add(initialItem);
            add(checkboxContainer);

            startingItem = new JRadioButton(Translations.getText("randomization.starting"));
            startingItem.setActionCommand("STARTING");
            itemRandomization.add(startingItem);
            checkboxContainer.add(startingItem);

            if (Settings.getInitiallyAccessibleItems().contains(item)) {
                initialItem.setSelected(true);
            }
            else if (Settings.getStartingItems().contains(item)) {
                startingItem.setSelected(true);
            }
            else {
                randomItem.setSelected(true);
            }
        }

        this.itemName = item;
    }

    public String getActionCommand() {
        return itemRandomization.getSelection().getActionCommand();
    }

    public String getItemName() {
        return itemName;
    }

    public void updateTranslations() {
        itemLabel.setText(Translations.getItemText(itemName, false));
        randomItem.setText(Translations.getText("randomization.random"));
        if(initialItem != null) {
            initialItem.setText(Translations.getText("randomization.initial"));
        }
        startingItem.setText(Translations.getText("randomization." + startingItem.getActionCommand().toLowerCase()));
    }

    public void setSelected(String actionCommand) {
        if("RANDOM".equals(actionCommand)) {
            randomItem.setSelected(true);
        }
        else if("INITIAL".equals(actionCommand)) {
            initialItem.setSelected(true);
        }
        else if ("STARTING".equals(actionCommand)) {
            startingItem.setSelected(true);
        }
        else {
            randomItem.setSelected(true);
        }
    }
}
