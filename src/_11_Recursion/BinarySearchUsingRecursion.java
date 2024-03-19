package Recursion;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr ={1, 2, 4, 6, 8, 12};
        int target = 6;
        System.out.println(BinarySearch(arr,target,0,arr.length-1));
    }
    static int BinarySearch(int[] arr,int target, int s, int e){
        if(s>e){
            return -1;
        }
        int m = s + (e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(target<arr[m]){
            return BinarySearch(arr,target,s,m-1);
        }
        return BinarySearch(arr,target,m+1,e);
    }
}
