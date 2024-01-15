package _07_Searching.BinarySearch;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int [] arr = {10,20,30,40,50,60,70};
        int target = 50;
        int ans = OrderAgnosticBinarySearch(arr,target);
        System.out.println(ans);
    }
    static int OrderAgnosticBinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        // find whether the array is sorted in ascending or descending
        boolean isAscending = arr[start]<arr[end];//ascending order.

        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]==target) {
                return mid;
            }
            if(isAscending){
                if(target<arr[mid]){
                    end = mid -1;
                }
                else {
                    start = start+1;
                }
            }else {
                //This is for descending order.
                // only sign change is : ">"
                if(target>arr[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
