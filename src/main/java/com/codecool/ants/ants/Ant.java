package com.codecool.ants.ants;

import com.codecool.ants.MatingException;
import com.codecool.ants.geometry.Position;

abstract public class Ant {

    protected Position position;
    protected String symbol;
    protected final int colonyWidth;

    public Ant(int colonyWidth, Position position){
        this.position = position;
        this.colonyWidth = colonyWidth;
    }

    abstract public void act() throws MatingException;

    public Position getPosition() {
        return position;
    }

    public String getSymbol(){
        return symbol;
    }
}
