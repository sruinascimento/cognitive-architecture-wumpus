package br.com.rsfot.main;

import br.com.rsfot.game.HuntWumpus;

import java.util.Scanner;

import static br.com.rsfot.domain.Rotation.LEFT;
import static br.com.rsfot.domain.Rotation.RIGHT;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HuntWumpus huntWumpus = new HuntWumpus();

        boolean gameOver = true;
        while (gameOver) {

            if (huntWumpus.isTheAgentDead()) {
                System.out.println("You died - GAME OVER");
                gameOver = false;
                continue;
            }
            huntWumpus.getEnvironment().showCave();
            System.out.println(menu());
            System.out.println(huntWumpus.getAgent());
            System.out.println(huntWumpus.getEnvironment().getFeelingsByCoordinate());
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    huntWumpus.turnAgentTo(LEFT);
                    break;
                case 2:
                    huntWumpus.turnAgentTo(RIGHT);
                    break;
                case 3:
                    huntWumpus.moveForward();
                    break;
                case 4:
                    huntWumpus.grabGold();
                    break;
                case 5:
                    huntWumpus.shoot();
                    break;
                case 6:
                    gameOver = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }

    public static String menu() {
        return """
                1 - Turn left
                2 - Turn right
                3 - Move forward
                4 - Grab Gold
                5 - Shoot
                6 - Exit
                """;
    }
}