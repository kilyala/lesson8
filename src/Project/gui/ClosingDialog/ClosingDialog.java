package Project.gui.ClosingDialog;

import Project.gui.component.StatusBar;

import javax.swing.*;

public class ClosingDialog extends JLabel {

    public void closingDialog() {


        StatusBar closingBar = new StatusBar();
        closingBar.setMessage("Game over");
    }
}
