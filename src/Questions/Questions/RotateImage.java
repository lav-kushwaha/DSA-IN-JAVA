package Questions.Questions;
import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/description/
//48. Rotate Image

class RotateImage {
    private static void transpose(int[][] matrix) {
        //transpose
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseRows(int[][] matrix) {
        //reverse rows
        for(int row=0; row<matrix.length; row++) {
            int left = 0;
            int right = matrix.length-1;

            while(left < right) {
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;

                left++;
                right--;
            }
        }

    }
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRows(matrix);
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        //calling method.
        rotate(matrix);

        //print
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }
}

/*
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/