package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
/*


This details panel handles logins and appears on the main menu to log in for the leaderboard.
For the leaderboard itself I can either make another panel that appears at the end of games,
or I could just redraw this login panel. But that would mean that they can't log in again.

This is pretty pointless unless I get into server-client though so I don't really know as of now, because
if it is over a single run of the program the program itself will be closed. So I would need to store leaderboard
info on the server anyways. So maybe just have this part be mostly obselete for now?



 */
public class DetailsPanel extends JPanel {

    public HashMap<String, String> logInMap = new HashMap<String, String>();

    private String curUsername;

    JTextField nameField;
    JTextField passField;
    public String getCurUsername(){
        curUsername = nameField.getText(); //to be moved out
        return curUsername;
    }
    private String curPass;
    public String getCurPass(){
        curPass = passField.getText(); //to be moved out
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

        nameField = new JTextField(0);
        passField = new JTextField(0);
        JButton DoublePlayer = new JButton("Start Double Player Game");
        setLayout(new GridBagLayout());
        logIn.addActionListener( (e) -> {
            if (logInMap.containsKey(nameField.getText())){
                if (passField.getText().equals(logInMap.get(nameField.getText()))){
                    //logs in to namefield.getText
                }
                else{
                    GridBagConstraints gCons = new GridBagConstraints();
                    gCons.gridy = 3;
                    gCons.weighty = 20;
                    gCons.anchor = GridBagConstraints.LAST_LINE_END;
                    gCons.gridwidth=2;
                    add(new JLabel("<html>Your password is incorrect.<br>Please try again.</html>"), gCons);


                    //TODO: this is temporary fix. I should add to the bottom a message
                    // saying password is incorrect instead of putting it in a field. Should'nt be hard
                }
            }
            else {
                logInMap.put(nameField.getText(), passField.getText());
            }
            curUsername = nameField.getText();
            curPass = passField.getText();

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
