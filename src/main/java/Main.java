import br.com.rsfot.game.HuntWumpus;

import java.util.Scanner;

import static br.com.rsfot.domain.Rotation.LEFT;
import static br.com.rsfot.domain.Rotation.RIGHT;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HuntWumpus huntWumpus = new HuntWumpus();

        boolean exit = false;
        while (!exit) {
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
                case 5:
                    exit = true;
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
                4 - Shoot
                5 - Exit
                """;
    }
}