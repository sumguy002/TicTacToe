package com.company;

import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {
    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Menu"));

        JLabel nameLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        JTextField nameField = new JTextField(0);
        JTextField passField = new JTextField(0);
        JButton logIn = new JButton("Log into Scoreboard!");
        JButton DoublePlayer = new JButton("Start Double Player Game");
        setLayout(new GridBagLayout());
        logIn.addActionListener( (e) -> {
            String userN = nameField.getText();
            String pass = passField.getText();

            System.out.println(userN + pass);
            //check with login map. If not create new, otherwise set a current variable as is.
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



}
