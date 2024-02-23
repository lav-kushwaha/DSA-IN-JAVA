package _08_Sorting;
import java.util.Arrays;

public class CyclicSort {
    static void CyclicSort(int[] arr){
        int i=0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]!=arr[correct]){
              Swap(arr,i,correct);
            } else{
                i++;
            }
        }
    }
    static void Swap(int[] arr,int i, int correct){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
    }
    public static void main(String[] args) {
        int [] arr = {5,3,4,1,2};
        CyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
