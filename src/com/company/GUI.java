package com.company;

import javax.swing.*;

public class GUI {

    public void createWindow(){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame window = new JFrame("Tic Tac Toe!");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setVisible(true);
                window.setSize(500,500);
            }

        });



    }
}
