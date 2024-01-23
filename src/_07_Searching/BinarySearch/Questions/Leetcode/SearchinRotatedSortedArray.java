package _07_Searching.BinarySearch.Questions.Leetcode;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//33. Search in Rotated Sorted Array

public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr ={4,5,6,7,0,1,2};
        int target = 0;
        int pivot =  Pivot(arr);
        System.out.println(pivot);
        int ans = Search(arr,pivot,target);
        System.out.println(ans);
    }
    static int Search(int[] arr,int pivot,int target){
        int start = 0;
        int end = pivot;
        while (start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if (target>arr[mid]){
                start = pivot+1;
            }
            else if(target<arr[mid]) {
                end = arr.length-1;
            }
        }
        return -1;
    }
    static int Pivot(int[] nums){
        int start =0;
        int end = nums.length -1;
        while (start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]){
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return start;
    }

//    public int search(int[] nums, int target) {
//        int low = 0, high = nums.length - 1;
//
//        while (low <= high) {
//            int mid = (low + high) / 2;
//
//            if (nums[mid] == target) {
//                return mid;
//            }
//
//            if (nums[low] <= nums[mid]) {
//                if (nums[low] <= target && target < nums[mid]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            } else {
//                if (nums[mid] < target && target <= nums[high]) {
//                    low = mid + 1;
//                } else {
//                    high = mid - 1;
//                }
//            }
//        }
//
//        return -1;
//    }


}
