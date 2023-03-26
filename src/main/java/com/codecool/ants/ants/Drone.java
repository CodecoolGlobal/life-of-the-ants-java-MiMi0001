package com.codecool.ants.ants;

import com.codecool.ants.MatingException;
import com.codecool.ants.ants.Ant;
import com.codecool.ants.ants.Queen;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Arrays;

public class Drone extends Ant {

    private Position queenPosition;
    Queen queen;
    int matingTurnsLeft = 0;

    public Drone(int colonyWidth, Position queenPosition, Queen queen, Position position){
        super(colonyWidth, position);
        this.queenPosition = queenPosition;
        this.queen = queen;
        symbol = "D";
    }

    public void act() throws MatingException {
        if ( Arrays.equals(position.getCoordinates(), queenPosition.getCoordinates()) ) {
            if (queen.mating()) {
                matingTurnsLeft = 9;
                throw new MatingException("Nice! They are mating! Turns left " + matingTurnsLeft);
            }
            else {
                matingTurnsLeft = matingTurnsLeft > 0 ? matingTurnsLeft-1 : matingTurnsLeft;
                if (matingTurnsLeft == 0) kickedAway();
                else throw new MatingException("Nice! They are mating! Turns left: " + matingTurnsLeft);
            }
        }
        else {
            Direction directionToQueen = Direction.getDirectionTo(position, queenPosition);
            position = position.moveToDirection(directionToQueen, 1);
        }
        System.out.println("matingTurnsLeft: "+matingTurnsLeft);
    }

    private void kickedAway(){
        Direction direction = Direction.getRandomDirection();
        position = position.moveToDirection(direction, colonyWidth/2);
    }
}
