package br.com.rsfot.util;

public class MatrixFormatter {
    public static String formatMatrix(String[][] matrix, int horizontalSpacing, int verticalSpacing) {
        StringBuilder formattedMatrix = new StringBuilder();

        int numRows = matrix.length;
        int numCols = matrix[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                String cell = matrix[i][j];
                formattedMatrix.append("|");

                for (int k = 0; k < horizontalSpacing; k++) {
                    formattedMatrix.append(" ");
                }

                formattedMatrix.append(cell);

                for (int k = 0; k < horizontalSpacing; k++) {
                    formattedMatrix.append(" ");
                }
            }
            formattedMatrix.append("|\n");

            for (int k = 0; k < verticalSpacing; k++) {
                formattedMatrix.append("\n");
            }
        }

        return formattedMatrix.toString();
    }
}
