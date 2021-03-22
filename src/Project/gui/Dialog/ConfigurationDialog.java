package Project.gui.Dialog;

import Project.enums.DotType;
import Project.gui.component.Configurable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ConfigurationDialog extends JDialog implements Configurable {

    public static final int MARGIN_VALUE = 10;

    public DotType playerType = DotType.X;
    public int mapSize = 3;

    public ConfigurationDialog(JFrame parentFrame) {
        super(parentFrame, "Set parameters", true);

        setBounds(300, 300, 400, 200);

        JTextField mapSizeTextField = new JTextField(String.valueOf(mapSize));

        JPanel commonPanel = getConfigurationPanel(mapSizeTextField);

        JButton applyButton = createApplyButton(mapSizeTextField);

        setLayout(new BorderLayout());
        add(commonPanel, BorderLayout.CENTER);
        add(applyButton, BorderLayout.SOUTH);

        commonPanel.setBorder(BorderFactory.createEmptyBorder(MARGIN_VALUE,MARGIN_VALUE, MARGIN_VALUE, MARGIN_VALUE));

        setVisible(true);
    }

    @Override
    public DotType getPlayerType() {
        return playerType;
    }

    @Override
    public int getMapSize() {
        return mapSize;
    }

    private JPanel getConfigurationPanel(JTextField mapSizeTextField) {
        int gridSize = 2;
        int horizontalGap = 10;
        int verticalGap = 20;

        JPanel commonPanel = new JPanel(new GridLayout(gridSize, gridSize, horizontalGap, verticalGap));
        commonPanel.add(new JLabel("Choose: crosses or holes?"));
        commonPanel.add(createChoiceButtonPanel());
        commonPanel.add(new JLabel("Choose your size!"));
        commonPanel.add(mapSizeTextField);

        return commonPanel;
    }

    private JButton createApplyButton(JTextField mapSizeTextField) {
        JButton applyButton = new JButton("Apply");

        WindowEvent closeEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapSize = Integer.parseInt(mapSizeTextField.getText());
                dispatchEvent(closeEvent);
            }
        });
        return applyButton;
    }

    private JPanel createChoiceButtonPanel() {
        JRadioButton xButtonChoice = getRadioButton("X", DotType.X, true);
        JRadioButton oButtonChoice = getRadioButton("0", DotType.O, false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(xButtonChoice);
        buttonPanel.add(oButtonChoice);

        ButtonGroup group = new ButtonGroup();
        group.add(xButtonChoice);
        group.add(oButtonChoice);

        return buttonPanel;
    }

    private JRadioButton getRadioButton(String text, DotType buttonDotType, boolean selected) {
        JRadioButton choiceBtn = new JRadioButton(text, selected);
        choiceBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerType = buttonDotType;
            }
        });
        return choiceBtn;
    }
}
