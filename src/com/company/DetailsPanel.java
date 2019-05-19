package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DetailsPanel extends JPanel {
    private String curUsername;
    public String getCurUsername(){
        return curUsername;
    }
    private String curPass;
    public String getCurPass(){
        return curPass;
    }
    private JButton logIn = new JButton("Log into Scoreboard!");
    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Menu"));

        JLabel nameLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField nameField = new JTextField(0);
        JTextField passField = new JTextField(0);
        JButton DoublePlayer = new JButton("Start Double Player Game");
        setLayout(new GridBagLayout());
        logIn.addActionListener( (e) -> {
            curUsername = nameField.getText();
            curPass = passField.getText();
            //TODO: currently this executes AFTER I print. I will need to find a way to get that through.

            //check with login map. If not create new, otherwise set a current variable as is.
            //note that I should do that here since this detaillsPanel is exclusively for a leaderboard login.
            // I would simply return the username as a "curPlayer" or something in GUIFrame
        } );



        GridBagConstraints gCons = new GridBagConstraints();


        /////// First Column ///////////////////
        gCons.weightx = 5;
        gCons.weighty = 5;
        gCons.anchor = GridBagConstraints.LINE_END;
        gCons.gridy = 0;
        gCons.gridx = 0;
        add(nameLabel, gCons);
        gCons.gridy = 1;
        gCons.gridx = 0;
        add(passLabel, gCons);

        ///////////Second Column.////////////////
        gCons.fill = GridBagConstraints.HORIZONTAL;
        gCons.anchor = GridBagConstraints.LINE_START;
        gCons.gridy = 0;
        gCons.gridx = 1;
        add(nameField, gCons);
        gCons.gridy = 1;
        gCons.gridx = 1;
        add(passField, gCons);

        ////lastrow////////////////////////////////
        gCons.weighty = 100;
        gCons.anchor = GridBagConstraints.FIRST_LINE_START;
        gCons.gridx = 1;
        gCons.gridy = 2;
        add(logIn,gCons);
        gCons.weightx = 1000;
        gCons.gridx = 0;
        add(new JLabel(""), gCons);
    }

    public void addActionListener(ActionListener al)
    {
        // attach this listener to the button
        logIn.addActionListener(al);
    }


}
