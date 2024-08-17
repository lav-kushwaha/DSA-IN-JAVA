package _06_Intro_To_Arrays_And_ArrayList;

import java.util.Arrays;
import java.util.Scanner;
public class ArraysOfStringObjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[5];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.next();
        }
        System.out.println(Arrays.toString(arr));//[a, v, v, d, f]
    }
}
