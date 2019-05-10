package com.company;
import java.util.*;

public class Squareboard {
    //implementation as a 2d array of boards
    private Square[][] board;
    private int winLen; //winLen is the number of things in a row that is needed
    public Squareboard() { //defaults to a 3 by 3. tbh not that useful.
        board = new Square[3][3];
        winLen = 3;
        for (int r = 0; r<board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                board[r][c] = new Square();
            }
        }
    }
    public Squareboard(int dimensions, int winCon){
        board = new Square[dimensions][dimensions];
        winLen = winCon;
        for (int r = 0; r<board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                board[r][c] = new Square();
            }
        }
    }

    private int checkRowWin(){ // maybe this foreach loop isn't the best idea
        // 0 means no winner, 1 means player 1 wins, 2 means player 2 wins
        int consecutive = 0;
        int curID = 0; //the number ID of the last one tested
        for (int r = 0; r < board[0].length; r++){
            for (int c = 0; c < board.length; c++){
                int face = board[r][c].getFace();
                if (face == curID && curID != 0) {
                    consecutive++;
                } else {
                    consecutive = 0;
                    curID = face;
                }
                if (consecutive == winLen - 1) {return face;}
            }
            consecutive = 0;
            curID = 0;
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
                if (consecutive == winLen-1) {return face;}
            }
            consecutive = 0;
            curID = 0;
        }
        return 0;
    }
    private int checkDiagonalWin(){
        /*
        assumes squareboard. A rectangle would be even worse tbh
         */
        int consecutive;
        int curID; //the number ID of the last one tested
        for (int ind = 0; ind < board.length; ind++){
            int r = 0;
            int c = ind;
            consecutive = 0; curID = 0;
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

            consecutive = 0; curID = 0; r = board[0].length-1; c = ind;
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

            consecutive = 0; curID = 0; r = board[0].length-1; c = ind;
            while (c < board.length && c >= 0){// diagonally search to the down right  from the left
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
        int x;
        if ((x = checkColWin()) != 0) return x;
        if ((x = checkRowWin()) != 0) return x;
        if ((x = checkDiagonalWin()) != 0) {
            System.out.println("DiagonalWin");
            return x;
        }

        return 0;
    }
    public String toString(){
        int countR = 1;
        int countC = 1;
        StringBuilder ret = new StringBuilder();
        for (Square[] row: board){
            ret.append(countR++);
            ret.append(" ");
            for (Square col: row){
                if (col.getFace() == 0) ret.append("_ ");
                else if (col.getFace() == 1) ret.append("O ");
                else if (col.getFace() == 2) ret.append("X ");
            }
            ret.append("\n");
            //todo: this numbering scheme doesn't work if the dimension is 2 digits or more. Fix that somehow?
        }
        ret.append(" ");
        while (countC < countR){
            ret.append(" ").append(countC++);
        }

        return ret.toString();
    }

    public void makeMove(int player){// I feel like this would be better in the TTTmatch class. Whatever.
        Scanner inputScan = new Scanner(System.in);
        int count = 0;
        int maxTries = 3;
        String a = "X";
        if (player == 1) a = "O";
        System.out.println("Player " + player + " (" + a + ") move:");
        while(true) {
            try {
                System.out.print("Row:");
                int row = Integer.parseInt(inputScan.nextLine()) - 1;
                System.out.print("Columns:");
                int col = Integer.parseInt(inputScan.nextLine()) - 1;
                board[row][col].move(player);
                return;
            }
            catch (SquareFullException e) {
                System.out.println("That square is already taken. Please choose a new square");
                if (++count == maxTries){
                    System.out.println("you have tried to move on an occupied square too much. You have lost your turn");
                }
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("That square is not in the board. Please choose a new square");
            }
        }

    }

}
