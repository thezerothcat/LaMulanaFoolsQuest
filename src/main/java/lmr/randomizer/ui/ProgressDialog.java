package lmr.randomizer.ui;

import lmr.randomizer.Translations;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class ProgressDialog extends JDialog {
    public JProgressBar progressBar;
    JLabel statusText;

    private boolean safeClose;

    public ProgressDialog(Frame owner) {
        super(owner, Translations.getText("progress"), true);
        setLayout(new MigLayout("wrap 1", "", "align center"));
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        //setSize(400, 100);

        progressBar = new JProgressBar(0,100);
        statusText = new JLabel(Translations.getText("progress.generating"));
        safeClose = true;

        add(statusText, "growx, width 300!");
        add(progressBar, "growx, height 1.5*pref");
        pack();
    }

    public void updateProgress(int percentage, String progressText) {
         statusText.setText(progressText);
         progressBar.setValue(percentage);
    }

    public void updateTranslations() {
        setTitle(Translations.getText("progress"));
    }

    public boolean isSafeClose() {
        return safeClose;
    }

    public void setSafeClose(boolean safeClose) {
        this.safeClose = safeClose;
    }
}
