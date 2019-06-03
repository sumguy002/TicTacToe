package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    Squareboard board;
    int curPlayer = 2;
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
            Square square = board.getSquare(i);
            add(square);
            if (board.getSize() > 8){
                square.setFont(new Font("Arial", Font.PLAIN, 40));
            }
            else if (board.getSize() > 6){
                square.setFont(new Font("Arial", Font.PLAIN, 50));
            }
            square.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (square.getFace() == 0){
                        square.setFace(curPlayer = 3-curPlayer);//
                    }
                    if (board.checkWin() != 0){
                        endMatch(board.checkWin());
                    }
                }
            });
        }
    }
    public void endMatch(int winner){
        if (winner == 0){
            //tie
        }
        //TODO: create another pop up indicating who wins via GUI
    }


}
