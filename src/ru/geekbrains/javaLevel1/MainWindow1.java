package ru.geekbrains.javaLevel1;

public class MainWindow1 {

    public static void main(String[] args) {
        checkWin(DotType.DOT_0);
    }

    public static void checkWin(DotType type) {
        type.name();
        char displaySymbol = type.getDisplaySymbol();
        String message = type.getMessage();

    }

}