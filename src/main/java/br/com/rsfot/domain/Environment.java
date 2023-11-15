package br.com.rsfot.domain;

import br.com.rsfot.util.InitializeElementsMatrix;
import br.com.rsfot.util.InitializeFeelingsMatrix;

import java.util.*;

public class Environment {
    private String[][] world;
    private int dimension;
    private Map<String, Set<EnvironmentFeelings>> feelingsByCoordinate;

    public Environment(int dimension) {
        if (dimension < 4) {
            throw new IllegalArgumentException("Dimension must be at least 4");
        }
        this.dimension = dimension;
        this.world = InitializeElementsMatrix.setup(dimension);
        this.feelingsByCoordinate = InitializeFeelingsMatrix.setup(world);
    }

    public String[][] getWorld() {
        return world;
    }

    public int getDimension() {
        return dimension;
    }

    public Map<String, Set<EnvironmentFeelings>> getFeelingsByCoordinate() {
        return Collections.unmodifiableMap(feelingsByCoordinate);
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
