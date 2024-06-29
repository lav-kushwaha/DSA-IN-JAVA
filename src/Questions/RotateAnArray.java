package Questions;

//https://www.geeksforgeeks.org/problems/reversal-algorithm5340/0
//Rotating an Array

import java.util.Arrays;

class RotateAnArray {

     static void leftRotate(int[] arr, int n, int d) {

        d=d%n;
        reverse(arr,0,d-1);//function call
        reverse(arr,d,n-1);//function call
        reverse(arr,0,n-1);//function call
    }

    //Reverse method.
    public static void reverse(int arr[], int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++; end--;
        }
    }

    public static void main(String[] args) {
       int arr [] = {-1, -2, -3, 4, 5, 6, 7};
        leftRotate(arr,7,2);//calling a method
        System.out.println(Arrays.toString(arr));//print array
    }
}
