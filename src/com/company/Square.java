package com.company;

public class Square {
    //0 = blank, 1 is x, 2 is O
    private int face;
    public Square(){
        face = 0;
    }
    public Square(int squaretoplace){
        face = squaretoplace;
    }
    public void move(int faceID) throws SquareFullException{
        if (face != 0)
        {
            throw new SquareFullException("square is already marked!");
        }
        else face = faceID;
    }
    public int getFace(){
        return face;
    }


}
