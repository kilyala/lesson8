package Project.gui;

import Project.component.StatusBar;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static final String DOT_EMPTY = "*";

    public MainWindow() {
        setTitle("Крестики нолики 2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        StatusBar statusBar = new StatusBar();
        statusBar.setMessage("Ожидание хода игрока");

        int mapSize = 3;

        JPanel gridPanel = createGridButtons(mapSize);

        setLayout(new BorderLayout());
        add(gridPanel);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createGridButtons(int mapSize) {
        JPanel gridPanel = new JPanel(new GridLayout(mapSize, mapSize));
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {

                JButton btn = new JButton(DOT_EMPTY);

                Font font = new Font(btn.getFont().getName(), btn.getFont().getStyle(), 32);
                btn.setFont(font);

                gridPanel.add(btn);

            }

        }
        return gridPanel;
    }
}
