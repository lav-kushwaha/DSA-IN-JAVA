package _08_Sorting;
import java.util.Arrays;

public class InsertionSort {
    static void InsertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {5,3,4,1,2};
        InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
