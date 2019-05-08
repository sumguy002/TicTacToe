package com.company;

public class Squareboard {
    //implementation as a 2d array of ints
    private square[][] board;
    private int winLen; //winLen is the number of things in a row that is needed
    public Squareboard(int dimensions, int winCon){
        board = new square[dimensions][dimensions];
        winLen = winCon;

    }
    public boolean checkRowWin(){
        int consecutives = 0;
        int curID = 0; //the number ID of the last one tested
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){

            }
        }

    }
    public boolean checkWin(){
        for (int i = 0; i < 3; i++){

        }
    }

}
