package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JButton {
    //0 = blank, 1 is x, 2 is O
    private int face;
    public Square(){
        super("_");
        face = 0;
        setFont(new Font("Arial", Font.PLAIN, 60));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fires action to squareboard with coordinates
            }
        });
    }
    public Square(int squaretoplace){
        super("_");
        face = squaretoplace;
        setFont(new Font("Arial", Font.PLAIN, 60));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fire event to indicate move made
            }
        });
    }
    public void move(int faceID) throws SquareFullException{
        if (face != 0)
        {
            throw new SquareFullException("square is already marked!");
        }
        else face = faceID;
    }
    public int getFace(){
        return face;
    }


}
