package _06_Intro_To_Arrays_And_ArrayList.Questions;

import java.util.Arrays;
import java.util.Scanner;

public class SwapArrayElement {
    public static void main(String[] args) {
        int [] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        Swap(arr,1,2);
        System.out.println(Arrays.toString(arr));
    }
    static void Swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
