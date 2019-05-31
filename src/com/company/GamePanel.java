package com.company;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Squareboard board;
    public GamePanel(int boardSize, int winCond){ //creating the board
        Dimension size = getPreferredSize();
        size.width = 2;
        size.height = 2;
        setPreferredSize(size);
        board = new Squareboard(boardSize, winCond);
        setLayout(new GridLayout(boardSize, boardSize));
        setBorder(BorderFactory.createTitledBorder("game border"));
        setVisible(true);
        for (int i = 0; i < boardSize*boardSize; i++){
            add(new JButton("hi" + i));
            //TODO: how to reference these objects and change it later?
            // And how to correspond these to squareBoard if GridLayout just uses numbers?
        }
    }

}
