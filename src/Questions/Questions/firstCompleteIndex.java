package Questions.Questions;

import java.util.*;

//https://leetcode.com/problems/first-completely-painted-row-or-column/description/
//2661. First Completely Painted Row or Column

class firstCompleteIndex {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int numRows = mat.length;
        int numCols = mat[0].length;
        int[] rowCount = new int[numRows];
        int[] colCount = new int[numCols];
        Map<Integer, int[]> numToPos = new HashMap<>();

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int value = mat[row][col];
                numToPos.put(value, new int[] { row, col });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] pos = numToPos.get(num);
            int row = pos[0];
            int col = pos[1];

            rowCount[row]++;
            colCount[col]++;

            if (rowCount[row] == numCols || colCount[col] == numRows) {
                return i;
            }
        }

        return -1; 
    }
}