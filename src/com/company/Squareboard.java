package com.company;

public class Squareboard {
    //implementation as a 2d array of ints
    private Square[][] board;
    private int winLen; //winLen is the number of things in a row that is needed
    public Squareboard(int dimensions, int winCon){
        board = new Square[dimensions][dimensions];
        winLen = winCon;

    }
    public int checkRowWin(){ // maybe this foreach loop isn't the best idea
        // 0 means no winner, 1 means player 1 wins, 2 means player 2 wins
        int consecutive = 0;
        int curID = 0; //the number ID of the last one tested
        for (Square[] row : board) {
            for (Square cur: row) {
                int face = cur.getFace();
                if (face == curID && curID != 0) {
                    consecutive++;
                } else {
                    consecutive = 0;
                    curID = face;
                }
                if (consecutive == winLen - 1) return face;
            }
        }
        return 0;
    }
    public int checkColWin(){
        // 0 means no winner, 1 means player 1 wins, 2 means player 2 wins
        int consecutive = 0;
        int curID = 0; //the number ID of the last one tested
        for (int c = 0; c < board[0].length; c++){
            for (int r = 0; r < board.length; r++){
                int face = board[r][c].getFace();
                if (face == curID && curID != 0){
                    consecutive++;
                }
                else{
                    consecutive = 0;
                    curID = face;
                }
                if (consecutive == winLen-1) return face;
            }
        }
        return 0;
    }
    public boolean checkWin(){
        for (int i = 0; i < 3; i++){

        }
    }

}
