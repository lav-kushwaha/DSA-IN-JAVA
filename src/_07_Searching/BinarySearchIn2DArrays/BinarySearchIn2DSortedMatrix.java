package _07_Searching.BinarySearchIn2DArrays;

import java.util.Arrays;

public class BinarySearchIn2DSortedMatrix {
    public static void main(String[] args) {
        int [][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        System.out.println(Arrays.toString(search(arr,9)));
    }
    static int [] search(int[][] matrix , int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //be cautions, matrix may be empty.

        if(rows == 1){
            return binarySearch(matrix,0,0,cols-1,target);
        }

        int rowStart = 0;
        int rowEnd = rows-1;
        int colMid = cols/2;

        //run the loop till 2 rows are remaining.
        while (rowStart<(rowEnd-1)){//while this is true it will have more than 2 rows.
            int mid = rowStart+(rowEnd-rowStart)/2;
            if(matrix[mid][colMid] == target){
                return new int[]{mid,colMid};
            }
            if(matrix[mid][colMid] < target){
                 rowStart = mid;
            }else {
                rowEnd = mid;
            }
            //now we have two rows
            //check whether the target is in the col of 2 rows.
            if(matrix[rowStart][colMid]==target){
                return new int[]{rowStart,colMid};
            }
            if(matrix[rowStart+1][colMid]==target){
                return new int[]{rowStart+1,colMid};
            }
            //search in 1st half
            if(target <= matrix[rowStart][colMid-1]){
                return binarySearch(matrix,rowStart,0,colMid-1,target);
            }
            //search in 2nd half
            if(target >= matrix[rowStart][colMid+1] && target<=matrix[rowStart][cols-1]){
                return binarySearch(matrix,rowStart,colMid+1,cols-1,target);
            }
            //search in 3rd half
            if(target <= matrix[rowStart+1][colMid-1]) {
                return binarySearch(matrix,rowStart+1,0,colMid-1,target);
            }else {
                return binarySearch(matrix,rowStart+1,colMid+1,cols-1,target);
            }

        }
        return new int[]{-1,-1};
    }

    //Search in the row provided between the cols provided
    static int[] binarySearch(int [][] matrix,int row, int colStart,int colEnd,int target){
        while (colStart<=colEnd){
            int mid = colStart+(colEnd-colStart)/2;
            if(matrix[row][mid] == target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid]<target){
                colStart = mid+1;
            }else {
                colEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
