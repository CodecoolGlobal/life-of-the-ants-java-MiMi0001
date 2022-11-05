package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Drone extends Ant{

    private Position queenPosition;

    public Drone(int colonyWidth, Position queenPosition, Position position){
        super(colonyWidth, position);
        this.queenPosition = queenPosition;
        symbol = "D";
    }
    public void act(){
        Direction directionToQueen = Direction.getDirectionTo(position, queenPosition);
        position = position.moveToDirection(directionToQueen);
    }
}
