package Questions.Questions;

//https://www.geeksforgeeks.org/problems/binary-array-sorting-1587115620/1?page=1&category=Arrays,Strings&difficulty=Basic&sortBy=submissions
//Binary Array Sorting.

import java.util.Arrays;

public class BinaryArraySorting {
    public static void binSort(int A[], int N) {
        int count = 0; // Count of 0's

        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            A[i] = 0;
        }

        for (int i = count; i < N; i++) {
            A[i] = 1;
        }

    }
//    public static void binSort(int A[], int N) {
//        int count = 0; // Count of 0's
//
//        for (int i = 0; i < N; i++) {
//            if (A[i] == 0) {
//                count++;
//            }
//        }
//
//        for (int i = 0; i < count; i++) {
//            A[i] = 0;
//        }
//
//        for (int i = count; i < N; i++) {
//            A[i] = 1;
//        }
//
//    }
    public static void main(String[] args) {
        int [] arr = {1,0,1,1,0,0,1,0};
        int N = 5;

        binSort(arr,N);
        System.out.println(Arrays.toString(arr));
    }
}
