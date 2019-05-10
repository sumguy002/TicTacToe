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
        int totalturns = 0;
        int win;
        System.out.println(board);
        while ((win = board.checkWin()) == 0){
            int curPlayer = (totalturns++%2 + 1);
            board.makeMove(curPlayer);
            System.out.println(board);
        }
        System.out.println("player " + win +" wins after " + totalturns + " turns!");
        return win;
    }
}
