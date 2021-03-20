package ru.geekbrains.javaLevel1.Application;

import ru.geekbrains.javaLevel1.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private int counter = 0;

    public MainWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 200, 200);
        JButton button = new JButton(String.valueOf(counter));


        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                button.setText(String.valueOf(counter));
            }
        });


        add(button, BorderLayout.CENTER);

        setVisible(true);

    }


    public static void main(String[] args) {
        new MainWindow();

    }
}