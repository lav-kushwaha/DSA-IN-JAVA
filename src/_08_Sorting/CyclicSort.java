package _08_Sorting;
import java.util.Arrays;
public class CyclicSort {
    public static void main(String[] args) {
        int [] arr = {5,4,2,1,3};
        Cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void Cyclic(int [] arr){
        int i = 0;
        while(i<arr.length){
            int CorrectIndex = arr[i]-1;
            if(arr[CorrectIndex]!=arr[i]){
                int temp = arr[CorrectIndex];
                arr[CorrectIndex] = arr[i];
                arr[i] = temp;
            }else{
                i++;
            }
        }
    }
}
