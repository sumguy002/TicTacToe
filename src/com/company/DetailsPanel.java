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

    private HashMap<String, String> logInMap = new HashMap<String, String>();

    private String curUsername = "";//the current logged in username
    public String getCurUsername(){
        return curUsername;
    }

    JTextField nameField;
    JTextField passField;
    JLabel message = new JLabel("");

    private JButton logIn = new JButton("Log into Scoreboard!");
    public DetailsPanel(){
        Dimension size = getPreferredSize();
        size.width = 250;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Log into scoreboard"));

        JLabel nameLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");

        nameField = new JTextField(0);
        passField = new JTextField(0);
        setLayout(new GridBagLayout());
        logIn.addActionListener( (e) -> {//login attempted
            if (logInMap.containsKey(nameField.getText())){
                if (passField.getText().equals(logInMap.get(nameField.getText()))){
                    curUsername = nameField.getText();
                    message.setText("<html>Login Successful.<br>This menu will disappear in 5 seconds.</html>");
                    fireActionPerformed();
                    //TODO: wait 5 seconds as appropriate and then hide the DetailsPanel window
                }
                else{
                    message.setText("<html>Your password is incorrect.<br>Please try again.</html>");
                    curUsername = "";

                }
            }
            else {
                logInMap.put(nameField.getText(), passField.getText());
                //curUsername = nameField.getText(); //should I log in immediately or re-login?
                message.setText("<html>You have created a new account <br> Use this username to log in in the future</html>");
            }


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
        gCons.gridy = 3;
        gCons.weighty = 20;
        gCons.anchor = GridBagConstraints.LAST_LINE_END;
        gCons.gridwidth=2;
        add(message, gCons);
    }

    public void addActionListener(ActionListener al) {
        listenerList.add(ActionListener.class, al);
    }

    protected void fireActionPerformed() {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners.length == 0) {
            return;
        }
        ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "login successful");
        for (ActionListener listener : listeners) {
            listener.actionPerformed(evt);
        }
    }




}
