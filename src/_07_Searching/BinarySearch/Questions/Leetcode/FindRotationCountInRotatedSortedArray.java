package _07_Searching.BinarySearch.Questions.Leetcode;

public class FindRotationCountInRotatedSortedArray {
    public static void main(String[] args) {
        int [] arr = {3,4,5,6,7,0,1,2};
        int ans = CountOfRotation(arr);
        System.out.println(ans);
    }
    static int CountOfRotation(int[] arr) {
        int pivot = FindingPivot(arr);
        return pivot+1;
    }
    //it is a pivot method.
    //if we have to find rotation count of array then just do pivot+1
    static int FindingPivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start<=end){

            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
