package br.com.rsfot.util;

import br.com.rsfot.domain.EnvironmentObject;

import java.util.Random;

import static br.com.rsfot.domain.EnvironmentObject.GOLD;
import static br.com.rsfot.domain.EnvironmentObject.PIT;

public class InitializeElementsMatrix {
    private static Random random = new Random();
    private static String[][] environmentMatrix;

    private void InitializeFeelingsMatrix() {
        throw new UnsupportedOperationException("Object can't be instancied");
    }

    public static String[][] setup(int dimension) {
        environmentMatrix = new String[dimension][dimension];
        fillBoardsWithBlankSpaces();
        generateObjectsOnElementsBoard();
        return environmentMatrix;
    }


    private static void fillBoardsWithBlankSpaces() {
        int dimension = environmentMatrix.length;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                environmentMatrix[i][j] = "";
            }
        }
    }

    private static void generateObjectsOnElementsBoard() {
        initializePositionOfPit();
        initializePositionOfGold();
        initializePositionOfWumpus();
    }

    private static void initializePositionOfWumpus() {
        int[] positions = getRandomEmptyPositionFrom();
        environmentMatrix[positions[0]][positions[1]] = EnvironmentObject.WUMPUS.name();
    }

    private static void initializePositionOfPit() {
        int amountOfPit = environmentMatrix.length - 1;
        for (int i = 0; i < amountOfPit; i++) {
            int[] positions = getRandomEmptyPositionFrom();
            environmentMatrix[positions[0]][positions[1]] = PIT.name();
        }
    }

    private static void initializePositionOfGold() {
        int[] positions = getRandomEmptyPositionFrom();
        environmentMatrix[positions[0]][positions[1]] = GOLD.name();
    }

    private static int[] getRandomEmptyPositionFrom() {
        int dimension = environmentMatrix.length;
        int[] positions = new int[2];
        while (true) {
            int x = random.nextInt(dimension);
            int y = random.nextInt(dimension);
            if (isDifferentFromInitialPosition(x, y) && isEmptyPosition(x, y)) {
                positions[0] = x;
                positions[1] = y;
                break;
            }
        }
        return positions;
    }

    private static boolean isEmptyPosition(int x, int y) {
        return "".equals(environmentMatrix[x][y]);
    }

    private static boolean isDifferentFromInitialPosition(int x, int y) {
        return x != 0 || y != 0;
    }

}
