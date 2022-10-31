package com.codecool.ants;

import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Colony {

    private int width;
    ArrayList<Ant> ants;


    public Colony(int width){
        this.width = width;
        ants = new ArrayList<Ant>();

        int center = (int)Math.ceil(width / 2.0)-1;
        Position queenPosition=new Position(center, center);
        Queen queen = new Queen(queenPosition);
        ants.add(queen);
    }

    private void generateAnts(int drones, int workers, int soldiers){
        Random random = new Random();
        for (int i=1; i<drones; i++){
            Drone newDrone = new Drone(getRandomCoordinate(random));
            ants.add(newDrone);
        }

        for (int i=1; i<workers; i++){
            Worker newWorker = new Worker(getRandomCoordinate(random));
            ants.add(newWorker);
        }

        for (int i=1; i<soldiers; i++){
            Soldier newSoldier = new Soldier(getRandomCoordinate(random));
            ants.add(newSoldier);
        }
    }

    public void update(){
        for (Ant ant: ants){
            ant.act();
        }
    }

    public void display(){
        String out = "";
        for (int y=0; y<width; y++){
            for (int x=0; x<width; x++){
                Position currentPosition = new Position(x,y);
                out += getCoordinateSymbol(currentPosition);
            }
            out += "\n";
        }
        System.out.println(out);
    }

    private String getCoordinateSymbol(Position position){
        for (Ant ant: ants){
            if ( Arrays.equals(ant.getPosition().getCoordinates(), position.getCoordinates()) ) return ant.getSymbol();
        }
        return ".";
    }

    private Position getRandomCoordinate(Random random){
        int x = random.nextInt(width);
        int y = random.nextInt(width);
        return new Position(x, y);
    }
}