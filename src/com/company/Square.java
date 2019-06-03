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
        super("X");
        face = squaretoplace;
        setFont(new Font("Arial", Font.PLAIN, 60));
    }
    public void setFace(int faceID){
        face = faceID;
        if (faceID == 1) {setText("X");}
        if (faceID == 2) {setText("O");}
    }
    public int getFace(){
        return face;
    }


}
