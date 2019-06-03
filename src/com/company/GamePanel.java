package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        for (int i = 0; i < boardSize*boardSize; i++){//to delete in the buture
            add(board.getSquare(i));
            //TODO: Add actionlistener here to connect it to Squareboard

        }
    }

    public String makeMove(){

        return null; //temporary
    }

}
