package br.com.rsfot;

import java.util.Random;

public class Environment {
    private String[][] board;
    private int dimension;
    private Agent agent;
    private Random random;

    public Environment(int dimension) {
        if (dimension < 4) {
            throw new IllegalArgumentException("Dimension must be at least 4");
        }
        this.dimension = dimension;
        agent = new Agent();
        random = new Random();
        initializeBoard();
    }

    private void initializeBoard() {
        board = new String[dimension][dimension];
        fillBoardWithBlankSpaces();
        generateObjectsOnBoard();
    }

    private void fillBoardWithBlankSpaces() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                board[i][j] = "";
            }
        }
    }

    private void generateObjectsOnBoard() {
        initializePositionOfAgent();
        initializePositionOfPit();
        initializePositionOfGold();
        initializePositionOfWumpus();
    }

    private void initializePositionOfAgent() {
        board[0][0] = agent.getName();
    }

    private void initializePositionOfWumpus() {
        int[] positions = getRandomEmptyPosition();
        board[positions[0]][positions[1]] = EnvironmentObject.WUMPUS.name();
    }

    private void initializePositionOfPit() {
        for (int i = 0; i < getTotalOfPit(); i++) {
            int[] positions = getRandomEmptyPosition();
            board[positions[0]][positions[1]] = EnvironmentObject.PIT.name();
        }
    }

    private int getTotalOfPit() {
        return dimension - 1;
    }

    private void initializePositionOfGold() {
        int[] positions = getRandomEmptyPosition();
        board[positions[0]][positions[1]] = EnvironmentObject.GOLD.name();
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
        return "".equals(board[x][y]);
    }

    private boolean isDifferentFromInitialPosition(int x, int y) {
        return x != 0 ||  y != 0;
    }

    public void showBoard() {
        for (int i = 0; i < dimension; i++) {
            System.out.print("|");
            for (int j = 0; j < dimension; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
