package com.company;

public class Squareboard {
    //implementation as a 2d array of boards
    private Square[][] board;
    private int winLen; //winLen is the number of things in a row that is needed
    public Squareboard(){ //defaults to a 3 by 3
        board = new Square[3][3];
        winLen = 3;

    }
    public Squareboard(int dimensions, int winCon){
        board = new Square[dimensions][dimensions];
        winLen = winCon;

    }

    private int checkRowWin(){ // maybe this foreach loop isn't the best idea
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
    private int checkColWin(){
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
    private int checkDiagonalWin(){
        /*
        assumes squareboard. A rectangle would be even worse tbh
         */
        int consecutive = 0;
        int curID = 0; //the number ID of the last one tested
        for (int ind = 0; ind < board.length; ind++){
            int r = 0;
            int c = ind;
            while (c < board.length && c >= 0){// diagonally search to the up right
                int face = board[r++][c++].getFace();
                if (face == curID && curID != 0){
                    consecutive++;
                }
                else{
                    consecutive = 0;
                    curID = face;
                }
                if (consecutive == winLen-1) return face;
            }
            consecutive = 0; curID = 0; r = 0; c = ind;
            while (c < board.length && c >= 0){// diagonally search to the down right
                int face = board[r++][c--].getFace();
                if (face == curID && curID != 0){
                    consecutive++;
                }
                else{
                    consecutive = 0;
                    curID = face;
                }
                if (consecutive == winLen-1) return face;
            }

            consecutive = 0; curID = 0; r = board[0].length; c = ind;
            while (c < board.length && c >= 0){// diagonally search to the down left from the right
                int face = board[r--][c--].getFace();
                if (face == curID && curID != 0){
                    consecutive++;
                }
                else{
                    consecutive = 0;
                    curID = face;
                }
                if (consecutive == winLen-1) return face;
            }

            consecutive = 0; curID = 0; r = board[0].length; c = ind;
            while (c < board.length && c >= 0){// diagonally search to the down left from the right
                int face = board[r--][c++].getFace();
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
    public int checkWin(){
        if (checkColWin() != 0) return checkColWin();
        if (checkRowWin() != 0) return checkRowWin();
        if (checkDiagonalWin() != 0) return checkDiagonalWin();
        return 0;
    }
    public String toString(){
        String ret = "";
        for (Square[] row: board){
            for (Square col: row){
                if (col.getFace() == 0) ret += "_";
                else if (col.getFace() == 1) ret += "O";
                else if (col.getFace() == 2) ret += "X";

            }
            ret +=  "\n";
        }
        return ret;
    }

}
