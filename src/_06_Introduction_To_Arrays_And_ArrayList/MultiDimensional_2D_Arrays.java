package _06_Introduction_To_Arrays_And_ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensional_2D_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int [][] arr2D = new int[3][];
        //Creating 2D arrays.
        int [][] arr2D = {
                {1,2,3},
                {4,5},
                {6,7,8,9}
        };
        //System.out.println(arr2D[2][1]);//7

        //Input and output in 2D arrays.
        int [][] arr = new int[3][3];

        for(int row=0; row<arr.length;row++){
            for(int column=0;column<arr[row].length;column++){
               arr[row][column] = sc.nextInt();
            }
        }
        //printing 2D arrays.
//        for(int row=0; row<arr.length;row++){
//            for(int column=0;column<arr[row].length;column++){
//                System.out.print(arr[row][column]+ " ");
//            }
//            //adding new line here.
//            System.out.println();
//        }

        //Using Arrays.toString method to printing 2D arrays
        for (int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        //Output:
        //[1, 2, 3]
        //[4, 5, 6]
        //[7, 8, 9]

        //using for-each to printing an 2D arrays.
        for(int a[] : arr){
            System.out.println(Arrays.toString(a));
        }
        //Output:
        //[1, 2, 3]
        //[4, 5, 6]
        //[7, 8, 9]


    }
}
