package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Worker extends Ant{
    public Worker(int colonyWidth,Position position){
        super(colonyWidth, position);
        symbol = "W";
    }

    public void act(){
        Direction direction = Direction.getRandomDirection();
        position = position.moveToDirection(direction);
    }
}
