package Project.gui;

import Project.Core.impl.GameService;
import Project.Domain.MatrixCoordinate;
import Project.enums.DotType;
import Project.factory.GameFactory;
import Project.gui.Dialog.ConfigurationDialog;
import Project.gui.component.Configurable;
import Project.gui.component.StatusBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public static final String DOT_EMPTY = "*";

    private JButton[][] buttons;

    private final GameService gameService;
    private final DotType playerType;

    public MainWindow() {
        setTitle("Крестики нолики 2.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        StatusBar statusBar = new StatusBar();
        statusBar.setMessage("Player's turn");

        Configurable configurable = new ConfigurationDialog(this);
        int mapSize = configurable.getMapSize();
        playerType = configurable.getPlayerType();

        gameService = GameFactory.getGameService(mapSize, playerType);

        JPanel gridPanel = createGridButtons(mapSize);

        setLayout(new BorderLayout());
        add(gridPanel);
        add(statusBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createGridButtons(int mapSize) {
        JPanel gridPanel = new JPanel(new GridLayout(mapSize, mapSize));

        buttons = new JButton[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {

                JButton btn = new JButton(DOT_EMPTY);

                Font font = new Font(btn.getFont().getName(), btn.getFont().getStyle(), 32);
                btn.setFont(font);
                btn.putClientProperty("INDEX_ROW", i);
                btn.putClientProperty("INDEX_COLUMN", j);

                btn.addActionListener(getButtonListener());

                buttons[i][j] = btn;
                gridPanel.add(btn);

            }
        }
        return gridPanel;
    }

    private ActionListener getButtonListener() {
        return e -> {
            doHumanTurn((JButton) e.getSource());

            if (isGameContinue()) {
                doAiTurn();
            } else {
                disableAllButtons();
            }
        };
    }

    private boolean isGameContinue() {
        return !gameService.checkWin(playerType) && !gameService.isMapFull();

    }

    public void disableAllButtons() {
        for (JButton[] button : buttons) {
            for (int j = 0; j < buttons.length; j++) {
                button[j].setEnabled(false);
            }
        } JOptionPane.showMessageDialog(null, "Game over!");
    }

    private void doAiTurn() {
        MatrixCoordinate matrixCoordinate = gameService.aiTurn();
        JButton aiSelectedButton = buttons[matrixCoordinate.getRowIndex()][matrixCoordinate.getColumnIndex()];

        disabledButtonWithMark(aiSelectedButton, DotType.getEnemyType(playerType));

        if (!isGameContinue()) {
            disableAllButtons();
        }
    }

    private void doHumanTurn(JButton selectedButton) {
        int indexRow = (int) selectedButton.getClientProperty("INDEX_ROW");
        int index_column = (int) selectedButton.getClientProperty("INDEX_COLUMN");

        gameService.humanTurn(indexRow, index_column);
        disabledButtonWithMark(selectedButton, playerType);

    }

    private void disabledButtonWithMark(JButton button, DotType dotType) {
        button.setEnabled(false);
        button.setText(dotType.toString());

    }
}
