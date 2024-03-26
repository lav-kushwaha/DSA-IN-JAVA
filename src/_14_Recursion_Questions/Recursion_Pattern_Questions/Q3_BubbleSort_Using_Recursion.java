package _14_Recursion_Questions.Recursion_Pattern_Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Q3_BubbleSort_Using_Recursion {
    public static void main(String[] args) {
        int arr [] = {4,3,2,1};
        BubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }

     static void BubbleSort(int[] arr, int r,int c) {
         if(r==0){
             return;
         }
         if(c<r){
             if(arr[c]>arr[c+1]){
                 //swap
                 int temp = arr[c];
                 arr[c] = arr[c+1];
                 arr[c+1] = temp;
             }
             BubbleSort(arr,r,c+1);

         }else{
             BubbleSort(arr,r-1,0);
         }
    }
}
