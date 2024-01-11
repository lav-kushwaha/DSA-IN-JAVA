package _06_Introduction_To_Arrays_And_ArrayList;

import java.util.Arrays;
import java.util.Scanner;

public class Taking_Input_In_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //This line of code declares and initializes an array named "num" of integer type with a length of 5 in Java.
        int [] num = new int[5];

        //Taking array input using for-loops.
        for(int i=0;i<num.length;i++){
           num[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(num));

        //System.out.println(num[5]);//error: Index 5 out of bounds for length 5

        //applying bubble-sort to implement shorting.
        for(int i=0;i<num.length;i++){
            for(int j=1;j<num.length;j++){
                if(num[i]<num[j-1]){
                    int temp = num[i];
                    num[i] = num[j-1];
                    num[j-1] = temp;
                }
            }
        }
        //Sorted array.
        System.out.println(Arrays.toString(num));
    }
}
