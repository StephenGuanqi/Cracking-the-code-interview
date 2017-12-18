package arraystring;

public class ZeroMatrix {

    void setZeros(int[][] matrix) {

        // check if the first row and first col contain zero
        boolean setRowZero = false;
        boolean setColZero = false;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                setRowZero = true;
                break;
            }
        }
        //TODO same for the row
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setColZero = true;
                break;
            }
        }

        // traverse matrix, and put the zero row and col in matrix[0][:] and matrix[:][0]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // nullify the cols and rows
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyCol(matrix, j);
            }
        }

        // nullify the first row and col
        if (setRowZero) {
            nullifyRow(matrix, 0);
        }
        if (setColZero) {
            nullifyCol(matrix, 0);
        }

    }

    private void nullifyRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void nullifyCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

}
