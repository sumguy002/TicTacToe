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
        JTextArea welcome = new JTextArea("Welcome to Bryan's Tic Tac Toe GUI! As of now this probably doesn't event work. \n");
        JButton DoublePlayer = new JButton("Start Double Player Game");
        welcome.setEditable(false);
        Container c = getContentPane();
        c.add(welcome, BorderLayout.CENTER);
        c.add(DoublePlayer, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.EAST);

        DoublePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcome.append("(Hey. pssst. I haven't actually gotten the game to run yet, okay? \n keep your " +
                        "grubby fingers off my button for now. \nIt's best if everyone just wows at the menu instead.)\n");
            }
        });


    }


}
