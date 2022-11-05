package com.codecool.ants;

import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Colony {

    private int colonyWidth;
    ArrayList<Ant> ants;

    Position queenPosition;
    Queen queen;

    public Colony(int colonyWidth){
        this.colonyWidth = colonyWidth;
        ants = new ArrayList<Ant>();

        int center = (int)Math.ceil(colonyWidth / 2.0)-1;
        queenPosition=new Position(colonyWidth, center, center);
        queen = new Queen(colonyWidth, queenPosition);
        ants.add(queen);
    }

    public void generateAnts(int drones, int workers, int soldiers){
        Random random = new Random();
        for (int i=0; i<drones; i++){
            Drone newDrone = new Drone(colonyWidth, queenPosition, queen, getRandomCoordinate(random));
            ants.add(newDrone);
        }

        for (int i=0; i<workers; i++){
            Worker newWorker = new Worker(colonyWidth, getRandomCoordinate(random));
            ants.add(newWorker);
        }

        for (int i=0; i<soldiers; i++){
            Soldier newSoldier = new Soldier(colonyWidth, getRandomCoordinate(random));
            ants.add(newSoldier);
        }
    }

    public void update(){
        for (Ant ant: ants){
            try {
                ant.act();
            }
            catch (MatingException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void display(){
        String out = "";
        for (int y = 0; y< colonyWidth; y++){
            for (int x = 0; x< colonyWidth; x++){
                Position currentPosition = new Position(colonyWidth, x,y);
                out += getCoordinateSymbol(currentPosition);
            }
            out += "\n";
        }
        System.out.println(out);
    }

    private String getCoordinateSymbol(Position position){
        String out = ". ";
        for (Ant ant: ants){
            if ( Arrays.equals(ant.getPosition().getCoordinates(), position.getCoordinates()) ) out = ant.getSymbol() + " ";
        }
        return out;
    }

    private Position getRandomCoordinate(Random random){
        int x = random.nextInt(colonyWidth);
        int y = random.nextInt(colonyWidth);
        return new Position(colonyWidth, x, y);
    }
}