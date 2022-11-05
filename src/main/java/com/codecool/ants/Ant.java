package com.codecool.ants;

import com.codecool.ants.geometry.Position;

abstract public class Ant {

    protected Position position;

    protected String symbol;
    protected final int colonyWidth;

    public Ant(int colonyWidth, Position position){
        this.position = position;
        this.colonyWidth = colonyWidth;
    }
    abstract public void act();

    public Position getPosition() {
        return position;
    }

    public String getSymbol(){
        return symbol;
    }
}
