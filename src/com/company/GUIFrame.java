package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFrame extends JFrame { //a specific JFrame that will hopefully let me play tic tac toe
    private DetailsPanel detailsPanel;
    private String curUsername;
    private GamePanel gamePanel;
    private JTextArea welcome;
    private JButton DoublePlayer;
    private JSpinner spin;
    ///////////////constructor: initialization/////////////////////////
    public GUIFrame(String title){
        super(title);
        detailsPanel = new DetailsPanel();
        setLayout(new BorderLayout());

        //next area and stuff
        welcome = new JTextArea("Welcome to Bryan's Tic Tac Toe GUI! As of now this probably doesn't event work. \n");
        DoublePlayer = new JButton("Start Double Player Game");
        welcome.setEditable(false);
        Container c = getContentPane();

        //addinh stuff to the layout
        c.add(welcome, BorderLayout.CENTER);
        c.add(DoublePlayer, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.EAST);


        detailsPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!(detailsPanel.getCurUsername().equals(""))){
                    welcome.append("login successful on this end\n");
                    welcome.append(detailsPanel.getCurUsername());
                    //TODO: actually make this do something
                }
            }
        });
        DoublePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//I should write this as another function and just call it here
                setSize();
            }
        });


        //TODO: when the game starts, get a new layout that suits the tic tac toe game.
        // Looks like a bunch of JButtons is the way to go.


        //////////////////////
    }



    /////////////////////screens for choosing win condition and size
    private void setSize(){
        welcome.setText("First, please choose a board size below. Max size is 9!");
        DoublePlayer.setVisible(false);
        detailsPanel.setVisible(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.PAGE_END;
        add(welcome, gc);
        spin = new JSpinner(new SpinnerNumberModel(3, 1, 9, 1));
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(spin, gc);
        gc.gridy = 2;
        gc.weighty = 1;
        JButton next = new JButton("next");
        gc.anchor = GridBagConstraints.PAGE_START;
        add(next,gc);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWC((Integer)spin.getValue(), gc);
                next.setVisible(false);
            }
        });

    }

    private void setWC(int size, GridBagConstraints gc){
        JButton next = new JButton("next");
        add(next, gc);
        welcome.setText("Set your win condition. This is the number in a row needed to win!");
        spin.setModel(new SpinnerNumberModel(3 , 1, size, 1));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buildMatch(size, (Integer)spin.getValue());
                next.setVisible(false);
                spin.setVisible(false);
            }
        });
        //TODO: create startgame function that opens
        //Note: making the questionable decision here to just put the game INTO GUIFrame.

    }
    private void buildMatch(int size, int winC){

        gamePanel = new GamePanel(size, winC);
        gamePanel.setGameOver(new Object(){
            public String toString(){ //VERY VERY BAD PRACTICE. replacing the default function "just cuz it's there"
                add(new EndPanel(), BorderLayout.SOUTH); //TODO: concurrent thread this so I don't have this monstrosity.
                return null;
            }});
        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);
        welcome.setVisible(false);


    }




}
