package ru.geekbrains.javaLevel1;

public enum DotType {

     DOT_X('X', "hello"),
     DOT_0('0', "pc"),
     DOT_EMPTY('*', "empty");

     private char displaySynbol;
     private String message;

     DotType(char displaySymbol, String message) {

     }

}
