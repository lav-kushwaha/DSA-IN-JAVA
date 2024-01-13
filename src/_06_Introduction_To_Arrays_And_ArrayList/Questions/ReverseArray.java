package _06_Introduction_To_Arrays_And_ArrayList.Questions;

import java.util.Arrays;
public class ReverseArray {
    public static void main(String[] args) {
        int [] arr ={10,20,30,40,50,60};
        ReverseArrayElement(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void ReverseArrayElement(int[] arr){
        //Reversing Element Using While Loop.
        //This is also Known as Two-Pointers.
//        int start = 0;
//        int end = arr.length-1;
//        while(start<=end){
//            int temp = arr[start];
//            arr[start] = arr[end];
//            arr[end] = temp;
//            start++;
//            end--;
//        }
        //Reversing Element using Forloop
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

    }
}
