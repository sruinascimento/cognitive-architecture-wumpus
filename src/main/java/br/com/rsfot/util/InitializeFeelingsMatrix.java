package br.com.rsfot.util;

import br.com.rsfot.domain.EnvironmentFeelings;

import java.util.*;

import static br.com.rsfot.domain.EnvironmentFeelings.GLITTER;
import static br.com.rsfot.domain.EnvironmentObject.*;

public class InitializeFeelingsMatrix {
    private static Map<String, Set<EnvironmentFeelings>> feelingsByCoordinate = new LinkedHashMap<>();

    private void InitializeElementsMatrix() {
        throw new UnsupportedOperationException("Object cannot be instancied!");
    }

    public static Map<String, Set<EnvironmentFeelings>> setup(String[][] environmentMatrix) {
        int dimension = environmentMatrix.length;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {

                Set<EnvironmentFeelings> feelings = new HashSet<>();

                if (isGlitter(i, j, environmentMatrix)) {
                    feelings.add(GLITTER);
                }
                if (isStench(i, j, environmentMatrix)) {
                    feelings.add(EnvironmentFeelings.STENCH);
                }
                if (isBreeze(i, j, environmentMatrix)) {
                    feelings.add(EnvironmentFeelings.BREEZE);
                }

                feelingsByCoordinate.put(i + "," + j, feelings);
            }
        }
        return feelingsByCoordinate;
    }

    private static boolean isGlitter(int x, int y, String[][] environmentMatrix) {
        return environmentMatrix[x][y].equals(GOLD.name());
    }

    private static boolean isStench(int x, int y, String[][] environmentMatrix) {
        return hasAdjacentElement(x, y, WUMPUS.name(), environmentMatrix);
    }

    private static boolean isBreeze(int x, int y, String[][] environmentMatrix) {
        return hasAdjacentElement(x, y, PIT.name(), environmentMatrix);
    }

    private static boolean hasAdjacentElement(int x, int y, String elementType, String[][] environmentMatrix) {
        int dimension = environmentMatrix.length;

        if (x + 1 < dimension && environmentMatrix[x + 1][y].equals(elementType)) {
            return true;
        }
        if (x - 1 >= 0 && environmentMatrix[x - 1][y].equals(elementType)) {
            return true;
        }
        if (y + 1 < dimension && environmentMatrix[x][y + 1].equals(elementType)) {
            return true;
        }
        if (y - 1 >= 0 && environmentMatrix[x][y - 1].equals(elementType)) {
            return true;
        }
        return false;
    }
}
