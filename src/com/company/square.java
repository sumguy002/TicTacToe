package com.company;

public class square {
    //0 = blank, 1 is x, 2 is O
    private int face;
    public square(){
        face = 0;
    }
    public square(int squaretoplace){
        face = squaretoplace;
    }
    public void move(int faceID) throws SquareFullException{
        if (face != 0)
        {
            throw new SquareFullException("square is already marked!");
        }
        else face = faceID;
    }


}
