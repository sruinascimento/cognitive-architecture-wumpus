package br.com.rsfot.domain;

import br.com.rsfot.util.*;

import java.util.*;

public class Environment {
    private String[][] cave;
    private int dimension;
    private Map<String, Set<EnvironmentFeelings>> feelingsByCoordinate;

    public Environment(int dimension) {
        if (dimension < 4) {
            throw new IllegalArgumentException("Dimension must be at least 4");
        }
        this.dimension = dimension;
        this.cave = InitializeElementsMatrix.setup(dimension);
        this.feelingsByCoordinate = InitializeFeelingsMatrix.setup(cave);
    }

    public Environment(String[][] cave, int dimension) {
        this.cave = cave;
        this.dimension = dimension;
        this.feelingsByCoordinate = InitializeFeelingsMatrix.setup(cave);
    }

    public String[][] getCave() {
        return cave;
    }

    public int getDimension() {
        return dimension;
    }

    public Map<String, Set<EnvironmentFeelings>> getFeelingsByCoordinate() {
        return Collections.unmodifiableMap(feelingsByCoordinate);
    }

    public void showCave() {
        System.out.println(MatrixFormatter.formatMatrix(cave, 2, 1));
    }

    public void setCave(String[][] cave) {
        this.cave = cave;
    }

    public boolean isThereAPitAt(int x, int y) {
        return cave[x][y].equals(EnvironmentObject.PIT.name());
    }

    public boolean isThereAWumpusAt(int x, int y) {
        return cave[x][y].equals(EnvironmentObject.WUMPUS.name());
    }

    @Override
    public String toString() {
        return "Environment{" +
                "cave=" + Arrays.toString(cave) +
                ", dimension=" + dimension +
                ", feelingsByCoordinate=" + feelingsByCoordinate +
                '}';
    }
}
