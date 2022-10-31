package com.codecool.ants;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        Scanner scanner = new Scanner(System.in);

        Colony colony = new Colony(9);
        colony.generateAnts(3, 3, 3);

        boolean running = true;
        do {
            colony.display();
            colony.update();
            System.out.println("Press Enter to continue, q to quit");

            String pressed = scanner.nextLine();
            if (pressed.toLowerCase().equals("q")) running =false;
        } while (running);
        System.out.println("Have a nice day! Good bye!");
    }
}
