package com.codecool.ants.geometry;

import com.codecool.ants.Soldier;

import java.util.Random;

public enum Direction {
        NORTH(0,-1),
        EAST(1,0),
        SOUTH(0,1),
        WEST(-1,0);

        private int offsetX;
        private  int offsetY;
        static Random random = new Random();

        Direction (int offsetX, int offsetY){
            this.offsetX = offsetX;
            this.offsetY = offsetY;
        }

        public static Direction getRandomDirection(){
            int randomDirection = random.nextInt(4);
            Direction result = null;
            switch (randomDirection){
                case 0 -> result = NORTH;
                case 1 -> result = EAST;
                case 2 -> result = SOUTH;
                case 3-> result = WEST;
            }
            return result;
        }

        public int[] getOffset(){
            return new int[] {offsetX, offsetY};
        }

        public Direction turnLeft(){
            Direction out = null;
            switch (this){
                case NORTH -> out = WEST;
                case EAST -> out = NORTH;
                case SOUTH -> out = EAST;
                case WEST -> out = SOUTH;
            }
            return out;
        }

        public static Direction getDirectionTo(Position fromPosition, Position toPosition){
            Direction out = null;
            if (fromPosition.getY() < toPosition.getY()) out = SOUTH;
            if (fromPosition.getY() > toPosition.getY()) out = NORTH;

            if (fromPosition.getX() < toPosition.getX()) out = EAST;
            if (fromPosition.getX() > toPosition.getY()) out = WEST;

            return out;
        }
 }
