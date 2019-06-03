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
        for (int i = 0; i < boardSize*boardSize; i++){
            add(board.getSquare(i));
        }
        startMatch();
    }
    public int startMatch(){
        int win;
        int curPlayer = 2;
        while ((win = board.checkWin()) == 0){
            curPlayer = 3 - curPlayer; //alternates between 1/2, starting w/ 1
            while (!board.makeMove(curPlayer));
            break; //TODO: remove when I've implemented the game
        }

        //create another pop up indicating who wins via GUI
        return win;
    }

}
