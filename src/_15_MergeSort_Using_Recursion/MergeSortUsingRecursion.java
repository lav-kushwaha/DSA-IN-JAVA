package _15_MergeSort_Using_Recursion;

import java.util.Arrays;
////Merge Sort By Kunal Kushwaha
public class MergeSortUsingRecursion {
    public static void main(String[] args) {
        int [] arr = {5,6,7,4,3,2,1};
        int [] ans = MergeSort(arr);
        System.out.println(Arrays.toString(ans)); // Use Arrays.toString() to print the array
    }

    static int [] MergeSort(int [] arr){
        if(arr.length <= 1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = MergeSort(Arrays.copyOfRange(arr,0,mid));//it is exculsive means it will take mid -1
        int[] right = MergeSort(Arrays.copyOfRange(arr,mid,arr.length)); // Include the last element
        return Merge(left,right);
    }

    static int[] Merge(int[] left, int[] right) {
        int[] mix  = new int[left.length+right.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < left.length && j < right.length){ // Use lengths of left and right arrays
            if(left[i] < right[j]){
                mix[k] = left[i];
                i++;
            }
            else {
                mix[k] = right[j];
                j++;
            }
            k++;
        }

        //it may be possible that one of the arrays is not complete.
        // Copy remaining elements from left array.
        while(i < left.length){
            mix[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements from right array
        while(j < right.length){
            mix[k] = right[j];
            j++;
            k++;
        }
        return mix;
    }
}
