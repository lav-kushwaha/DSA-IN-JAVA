package _15_MergeSort_Using_Recursion.Questions;

import java.util.*;

//Optimal Approach 1 (without using any extra space):
//https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/

public class MergeSortWithoutUsingExtraSpace {

    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("arr1[] = ");
        System.out.print(Arrays.toString(arr2));
    }

}
