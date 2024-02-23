package _08_Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void BubbleSort(int [] arr){
        for(int i=0;i<arr.length;i++){
            boolean check = false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    check = true;
                }
            }
            //if this condition is true that means array is sorted.
            if(!check){
                break;
            }
        }

    }

}
