package _07_Searching.BinarySearch.Questions.Leetcode;

public class MountainArrays {
    public static void main(String[] args) {

    }
    public int peakIndexMountainArray(int [] arr){
        int start =0;
        int end = arr.length-1;
        while(start<end){
            int mid = start+(end- start)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in decreasing part of array.
                //this may be the ans, but look at left
                //this is why end!= mid -1
                end = mid;
            }else{
                //you are in asc part of array
                start = mid + 1;//because we know that mid+1 element > mid element
            }
        }
        //in the end, start == end and pointing to the largest number
        return -1;
    }
}
