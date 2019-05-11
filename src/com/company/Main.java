package com.company;

public class Main {

    public static void main(String[] args) {
        new GUI().createWindow();
        TTTMatch bob = new TTTMatch(4,6);
        bob.startmatch();
    }
}
