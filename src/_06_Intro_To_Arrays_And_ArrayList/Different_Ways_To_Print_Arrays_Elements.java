package _06_Intro_To_Arrays_And_ArrayList;

import java.util.Arrays;
public class Different_Ways_To_Print_Arrays_Elements {
    public static void main(String[] args) {
        int [] arr = {12,11,8,7,5};

        //Using for-loop to print arary elements.
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");//12 11 8 7 5
        }

        //using for-each loop to printing arary elements.
        //here nums represents elements of the arrays.
        for(int nums : arr){//for every element in array, print the element.
            System.out.print(nums+" ");//12 11 8 7 5
        }

        //Using inbuilt method "Arrays.toString()" to print.
        System.out.println(Arrays.toString(arr));//[12, 11, 8, 7, 5]

        //Using While Loops
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " "); // Output: 12 11 8 7 5
            i++;
        }

    }
}
