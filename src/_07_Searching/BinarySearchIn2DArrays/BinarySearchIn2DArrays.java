package _07_Searching.BinarySearchIn2DArrays;

import java.util.Arrays;
public class BinarySearchIn2DArrays {
    public static void main(String[] args) {
        int[][] num = {
                    {10,20,30,40},
                    {15,25,35,45},
                    {28,29,37,49},
                    {33,34,38,50}
        };
        int target = 29;
        int[] ans = Searching(num , target);
        System.out.println(Arrays.toString(ans));
    }
    static int[] Searching(int[][] matrix, int target){
        int row = 0;
        int column = matrix.length-1;
        while(row<matrix.length-1 && column>=0){
            if(matrix[row][column] == target){
                return new int[] {row,column};
            }
            if(matrix[row][column]<target){
                 row++;
            }
            else{
                column--;
            }
        }
        return new int[]{-1,-1};
    }
}
