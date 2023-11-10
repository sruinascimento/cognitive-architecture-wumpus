package br.com.rsfot;

import br.com.rsfot.util.MatrixFormatter;

import java.util.*;

import static br.com.rsfot.EnvironmentFeelings.GLITTER;
import static br.com.rsfot.EnvironmentObject.*;

public class Environment {
    private String[][] elementsBoard;
    private int dimension;
    private Agent agent;
    private Random random;
    private Map<String, Set<EnvironmentFeelings>> feelingsByCoordinate = new LinkedHashMap<>();

    public Environment(int dimension) {
        if (dimension < 4) {
            throw new IllegalArgumentException("Dimension must be at least 4");
        }
        this.dimension = dimension;
        agent = new Agent();
        random = new Random();

        initializeBoard();
    }

    public Map<String, Set<EnvironmentFeelings>> getFeelingsByCoordinate() {
        return feelingsByCoordinate;
    }

    private void initializeBoard() {
        elementsBoard = new String[dimension][dimension];
        fillBoardsWithBlankSpaces();
        generateObjectsOnElementsBoard();
        fillFeelingsByCoordinate();
    }

    private void fillBoardsWithBlankSpaces() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                elementsBoard[i][j] = "";
            }
        }
    }

    private void generateObjectsOnElementsBoard() {
        initializePositionOfAgent();
        initializePositionOfPit();
        initializePositionOfGold();
        initializePositionOfWumpus();
    }

    private void initializePositionOfAgent() {
        elementsBoard[0][0] = agent.getName();
    }

    private void initializePositionOfWumpus() {
        int[] positions = getRandomEmptyPosition();
        elementsBoard[positions[0]][positions[1]] = EnvironmentObject.WUMPUS.name();
    }

    private void initializePositionOfPit() {
        for (int i = 0; i < getTotalOfPit(); i++) {
            int[] positions = getRandomEmptyPosition();
            elementsBoard[positions[0]][positions[1]] = PIT.name();
        }
    }

    private int getTotalOfPit() {
        return dimension - 1;
    }

    private void initializePositionOfGold() {
        int[] positions = getRandomEmptyPosition();
        elementsBoard[positions[0]][positions[1]] = GOLD.name();
    }

    private int[] getRandomEmptyPosition() {
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

    private boolean isEmptyPosition(int x, int y) {
        return "".equals(elementsBoard[x][y]);
    }
    private boolean isDifferentFromInitialPosition(int x, int y) {
        return x != 0 || y != 0;
    }

    public void showElementsBoard() {
        System.out.println(MatrixFormatter.formatMatrix(elementsBoard, 4, 2));
    }

    private void fillFeelingsByCoordinate() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {

                Set<EnvironmentFeelings> feelings = new HashSet<>();

                if (isGlitter(i, j)) {
                    feelings.add(GLITTER);
                }
                if (isStench(i, j)) {
                    feelings.add(EnvironmentFeelings.STENCH);
                }
                if (isBreeze(i, j)) {
                    feelings.add(EnvironmentFeelings.BREEZE);
                }

                feelingsByCoordinate.put(i + "," + j, feelings);
            }
        }
    }

    private boolean isGlitter(int x, int y) {
       return elementsBoard[x][y].equals(GOLD.name());
    }
    private boolean hasAdjacentElement(int x, int y, String elementType) {
        if (x + 1 < dimension && elementsBoard[x + 1][y].equals(elementType)) {
            return true;
        }
        if (x - 1 >= 0 && elementsBoard[x - 1][y].equals(elementType)) {
            return true;
        }
        if (y + 1 < dimension && elementsBoard[x][y + 1].equals(elementType)) {
            return true;
        }
        if (y - 1 >= 0 && elementsBoard[x][y - 1].equals(elementType)) {
            return true;
        }
        return false;
    }

    private boolean isStench(int x, int y) {
        return hasAdjacentElement(x, y, WUMPUS.name());
    }

    private boolean isBreeze(int x, int y) {
        return hasAdjacentElement(x, y, PIT.name());
    }

    private void showBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
