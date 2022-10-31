package com.codecool.ants;

import com.codecool.ants.geometry.Position;

abstract public class Ant {

    protected Position position;

    protected String symbol;

    public Ant(Position position){
        this.position = position;
    }
    abstract public void act();

    public Position getPosition() {
        return position;
    }

    public String getSymbol(){
        return symbol;
    }

}
