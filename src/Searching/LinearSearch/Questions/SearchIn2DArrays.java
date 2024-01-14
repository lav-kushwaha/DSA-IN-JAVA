package Searching.LinearSearch.Questions;

import java.util.Arrays;

public class SearchIn2DArrays {
    public static void main(String[] args) {
        //This way we can also create array.
//        int [][] arr =new int[][] {
//                {1,2,3,4},
//                {5,6},
//                {7,8,9,10}
//        };

        //2nd way to  create array.
        int [][] arr = {
                {1,2,3,4},
                {5,6},
                {7,8,9,10}
        };
        int target = 10;
        int[] ans = Search(arr,target);//format of return value {row,col}
        System.out.println(Arrays.toString(ans));
    }
    static int[] Search(int[][] arr, int target){
        if(arr.length==0){
            return new int[] {-1,-1};
        }
        for(int row = 0; row<arr.length;row++){
            for(int column=0;column<arr[row].length;column++){
                if(arr[row][column] == target){
                    return new int[]{row,column};
                }
            }
        }
        return new int[] {-1,-1};
    }
}
