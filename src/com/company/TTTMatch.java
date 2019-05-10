package com.company;

public class TTTMatch {
    private int winLen=3;
    private int size=3;
    public TTTMatch(){}
    public TTTMatch(int winCond, int dimensions){
        winLen = winCond;
        size = dimensions;
    }
    public int startmatch(){ //returns the winner
        //player 1 is O, player 2 is X
        Squareboard board = new Squareboard(size, winLen);

        int win;
        System.out.println(board);
        while ((win = board.checkWin()) == 0){
            int curPlayer = (board.totalTurns++%2 + 1);
            board.makeMove(curPlayer);
            System.out.println(board);

        }
        if (win == -1){System.out.println("The game has been drawn. Surprise!");}
        else {System.out.println("player " + win +" wins after " + board.totalTurns + " turns!"); }
        return win;
    }
}
