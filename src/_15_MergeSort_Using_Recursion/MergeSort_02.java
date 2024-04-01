package _15_MergeSort_Using_Recursion;
import java.util.Arrays;

//MergeSort By Striver.
//https://takeuforward.org/sorting/merge-sort-algorithm

public class MergeSort_02 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2 ;
        mergeSort(arr, start, mid);  // left half
        mergeSort(arr, mid + 1, end); // right half
        merge(arr, start, mid, end);  // merging sorted halves
    }

     static void merge(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end - start+1];
        int i = start;      // starting index of i half of arr
        int j = mid + 1;   // starting index of j half of arr
        int k = 0;

        //storing elements in the mix array in a sorted manner//
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                mix[k]=arr[i];
                i++;
            } else {
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        // if elements on the i half are still i //
        while (i <= mid) {
            mix[k]=arr[i];
            i++;
            k++;
        }

        //  if elements on the j half are still j //
        while (j <= end) {
            mix[k]=arr[j];
            j++;
            k++;
        }

        // transfering all elements from mix to arr //
        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
        }
    }

}
