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
}
