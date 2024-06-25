package _16_QuickSort_Algorithm;

import java.util.Arrays;

public class QuickSortAlgo {
    public static void main(String[] args) {
        int [] arr = {10,80,30,90,40,50,70};
        QuickSort(arr,0,arr.length-1); //passing arrays and length.
        System.out.println(Arrays.toString(arr));

        // Arrays.sort(arr);=>This method is used quick sort behind the scene.
    }

    //Quick sort algorithm is in-place algorithm that means, no need to return anything.
    static void QuickSort(int[] arr,int low,int high){
        if(low>=high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start+(end-start)/2;
        int pivot = arr[mid];

        while(start<=end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }

            //Swap elements, if any of elements are less than pivot and its lie on the r.h.s or
            // if any element greater than pivot and its lie on the l.h.s.
            if(start<=end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        //now my pivot is at correct index, please sort two halves now
        //recursive call.
        QuickSort(arr,low,end);
        QuickSort(arr,start,high);

    }
}
