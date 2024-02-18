package _08_Sorting;
import java.util.Arrays;
//Kunal Kushwaha Concepts.
public class SelectionSort2ndMethod {
    public static void main(String[] args) {
        int [] arr ={2,3,-10,0,5,1,4};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for(int i=0; i<arr.length;i++){
            //find the max item in the remaining array and swap with correct index.
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }
    static void swap (int[] arr,int maxIndex,int last){
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[last];
        arr[last]= temp;
    }
    static int getMaxIndex(int[]arr,int start,int end){
        int max = start;
        for(int i=start; i<=end;i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
}
