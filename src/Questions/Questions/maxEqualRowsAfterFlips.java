package Questions.Questions;

import java.util.Arrays;

//https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/description/
//1072. Flip Columns For Maximum Number of Equal Rows
class maxEqualRowsAfterFlips {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix[0].length;
        int maxRows = 0;

        for (int[] currRow : matrix) {
            int[] inverted = new int[n];
            int count = 0;

            for (int col = 0; col < n; col++) {
                inverted[col] = currRow[col] == 0 ? 1 : 0;
            }

            for (int[] row : matrix) {
                if (Arrays.equals(row, currRow) || Arrays.equals(row, inverted)) {
                    count++;
                }
            }

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}