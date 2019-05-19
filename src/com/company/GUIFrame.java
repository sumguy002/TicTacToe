package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame { //a specific JFrame that will hopefully let me play tic tac toe
    private DetailsPanel detailsPanel;

    public GUIFrame(String title){
        super(title);
        detailsPanel = new DetailsPanel();
        setLayout(new BorderLayout());

        //next area and stuff
        JTextArea welcome = new JTextArea("Welcome to Bryan's Tic Tac Toe GUI! As of now this probably doesn't event work. \n");
        JButton DoublePlayer = new JButton("Start Double Player Game");
        welcome.setEditable(false);
        Container c = getContentPane();

        //addinh stuff to the layout
        c.add(welcome, BorderLayout.CENTER);
        c.add(DoublePlayer, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.EAST);


        detailsPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome.append("\nUsername: " + detailsPanel.getCurUsername()) ;
                welcome.append("\nPassword: " + detailsPanel.getCurPass());
            }
        });
        DoublePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome.append("(Hey. pssst. I haven't actually gotten the game to run yet, okay? \n keep your " +
                        "grubby fingers off my button for now. \nIt's best if everyone just wows at the menu instead.)\n");
            }
        });



        //TODO: when the game starts, get a new layout that suits the tic tac toe game.


    }


}
