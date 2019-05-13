package com.company;
import javax.swing.*;
import java.awt.*;

public class GUIFrame extends JFrame { //a specific JFrame that will hopefully let me play tic tac toe
    public GUIFrame(String title){
        super(title);

        setLayout(new BorderLayout());
        JTextArea welcome = new JTextArea("Welcome to Bryan's Tic Tac Toe GUI! As of now this probably doesn't event work. \n");
        JButton DoublePlayer = new JButton("Start Double Player Game");
        welcome.setEditable(false);
        Container c = getContentPane();

        c.add(welcome, BorderLayout.CENTER);
        c.add(DoublePlayer, BorderLayout.SOUTH);


    }


}
