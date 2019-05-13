package com.company;

import javax.swing.*;

public class GUIWindow { //creates and runs an instance of the window of GUIFrame

    public void createWindow(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame window = new GUIFrame("Tic Tac Toe!");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
                window.setSize(500,500);
            }

        });



    }
}
