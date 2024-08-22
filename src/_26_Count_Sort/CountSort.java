package _26_Count_Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {
    public static void countSort(int[] array){
        if(array == null || array.length <= 1) {
            return;
        }

        int max = array[0];
        for(int num : array) {
            if(num > max) {
                max = num;
            }
        }

        int[] countArray = new int[max + 1];

        //traverse over the original array and create frequency array.
        for(int num : array) {
            countArray[num]++;
        }

        int index = 0;
        for(int i=0; i<= max; i++) {
            while(countArray[i] > 0) {
                array[index] = i;
                index++;
                countArray[i]--;
            }
        }
    }

    //count-sort using hash
    public static void countSortHash(int [] array){
        if(array == null || array.length <= 1) {
            return;
        }

        int max = Arrays.stream(array).max().getAsInt();//max value in array
        int min = Arrays.stream(array).min().getAsInt();//min value in array

        Map<Integer,Integer> coutMap = new HashMap<>();

        //count
        for(int num : array){
            coutMap.put(num,coutMap.getOrDefault(num,0)+1);
        }

        int index = 0;
        for(int i = min;i<=max;i++){
            int count = coutMap.getOrDefault(i,0);
            //iterate no of times count is appearing.
            for(int j=0;j<count;j++){
                array[index] = i;
                index++;
            }
        }

    }

    public static void main(String[] args) {
        int [] arr = {2,1,4,3,5};

        //count sort.
        countSort(arr);
//        System.out.println(Arrays.toString(arr));

        //count sort using hash
        countSortHash(arr);
        System.out.println(Arrays.toString(arr));
    }
}
