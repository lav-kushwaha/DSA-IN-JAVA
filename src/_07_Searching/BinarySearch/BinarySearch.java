package _07_Searching.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 60, 70, 80, 90};
        int target = 70;
        int ans = SearchElement(arr, target);
        System.out.println(ans);
    }
    static int SearchElement(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <=end) {
            //find the middle element
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
