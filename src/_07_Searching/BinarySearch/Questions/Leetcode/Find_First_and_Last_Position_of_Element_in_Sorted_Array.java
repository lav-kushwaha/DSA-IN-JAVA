package _07_Searching.BinarySearch.Questions.Leetcode;
//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int [] arr = {5,7,7,7,7,8,8,10};
        int target = 7;
        int startIndex = Searching(arr,target,true);
        int endIndex = Searching(arr,target,false);
        System.out.println("["+startIndex+","+endIndex+"]");
    }
    static int Searching(int[] arr, int target, boolean startIndex){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = start+(end - start)/2;
            if(target<arr[mid]){
                end = mid -1;
            }
            else if(target>arr[mid]){
                start = mid + 1;
            }
            else{
                ans = mid;
                //start-index occurrence
                if(startIndex){
                    end = mid - 1;
                }
                //lastIndex occurrence
                else{
                    start = mid +1;
                }
            }
        }
        return ans;
    }
}