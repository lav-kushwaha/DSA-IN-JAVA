package _07_Searching.BinarySearch.Questions.Leetcode;
//https://leetcode.com/problems/find-in-mountain-array/description/
//1095. Find in Mountain Array.
public class FindinMountainArray {
    public static void main(String[] args) {

    }
    static int Search(int [] arr, int target){
        int peak = peakIndexMountainArray(arr);
        int firstTry = orderAgnosticBS(arr,target,0,peak);
        if(firstTry!=-1){
            return firstTry;
        }
        //try to search second half
        return orderAgnosticBS(arr,target,peak+1,arr.length-1);
    }
    public static int peakIndexMountainArray(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start<end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start; //or return end as both are =
    }

    static int orderAgnosticBS(int[] arr, int target,int start,int end) {

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
            //int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //This is for descending order
                //only sign change is : ">"
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
