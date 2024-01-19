package _07_Searching.BinarySearch;
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
//intuition is we just have to find start and end.
public class InfiniteArary {
    public static void main(String[] args) {
            int [] arr ={1,2,3,4,5,6,8};
            int target = 5;
            int ans = ans(arr,target);
           System.out.println(ans);
    }
    static int ans (int [] arr,int target){
        //first find the range
        //first start with a box of size 2
        int start = 0;
        int end = 1;
        //condition for the target  to lie in the range
        while (target>arr[end]){
            int newStart = 0;
            //double the box value
            //end = previous end + sizeofbox*2
            end = end + (end - start+1)*2;
            start = newStart;
        }
        return BinarySearch(arr,target,start,end);
    }
    static int BinarySearch(int [] arr,int target, int start, int end){
        while (start<=end){
            int mid = start+(end - start)/2;
            if(target>arr[mid]){
                start = mid+1;
            }
            else if(target<arr[mid]){
                end = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
