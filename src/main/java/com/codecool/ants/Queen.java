package com.codecool.ants;

import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Queen extends Ant{
    int matingMood;
    public Queen(int colonyWidth, Position position){
        super(colonyWidth, position);
        symbol = "Q";
        matingMood = 10;
    }

    public void act(){
        matingMood = matingMood>0 ? matingMood-1 : matingMood;
    }

    public boolean mating(){
        boolean successfulMating = false;
        if (matingMood == 0) {
            Random random = new Random();
            matingMood = random.nextInt(51)+50;
            successfulMating = true;
        }
        System.out.println("matingMood: "+matingMood);
        return successfulMating;
    }
}
