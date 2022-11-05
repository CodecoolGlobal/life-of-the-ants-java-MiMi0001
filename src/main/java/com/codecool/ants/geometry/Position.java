package com.codecool.ants.geometry;

public class Position {

    private final int x;
    private final int y;
    private int colonyWidth;

    public Position(int colonyWidth, int x, int y) {
        this.colonyWidth = colonyWidth;
        this.x = x;
        this.y = y;
    }

    public int[] getCoordinates(){
        return new int[] {x, y};
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public Position moveToDirection(Direction direction, int moves){
        Position out;
        Position newPosition = new Position( colonyWidth, ( x+(moves*direction.getOffset()[0]) ), ( y+(moves*direction.getOffset()[1]) ) );
        if (newPosition.getX() < colonyWidth && newPosition.getY() < colonyWidth
            && newPosition.getX() >= 0 && newPosition.getY() >= 0) out = newPosition;
        else out = this;
        return out;
    }
}
