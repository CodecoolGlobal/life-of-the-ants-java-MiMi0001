package com.codecool.ants;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Soldier extends Ant{

    private Direction direction;

    public Soldier(int colonyWidth, Position position){
        super(colonyWidth, position);
        symbol = "S";
        direction = Direction.getRandomDirection();
    }

    public void act(){
        position = position.moveToDirection(direction);
        direction = direction.turnLeft();
    }
}
