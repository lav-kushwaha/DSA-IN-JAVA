package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

//90. Subsets II
//https://leetcode.com/problems/subsets-ii/description/
//Facebook ,Amazon, Bloomberg ,Adobe asked question.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q7_Subsets_II {
    public static void main(String[] args) {
        int [] arr = {1,2,2};
        List<List<Integer>> ans = subset(arr);
        System.out.print(ans+" ");
    }
     static List<List<Integer>> subset(int[] arr) {
         Arrays.sort(arr);
         List<List<Integer>> outer = new ArrayList<>();// [[], [1], [2], [1, 2]] //empty list we added like this :- [[]]
         outer.add(new ArrayList<>());//[[]]
         int start = 0;
         int end = 0; //3
         for(int i=0;i<arr.length;i++)  {
             start = 0;
             //if current and previous element is same, s = e+1
             if(i>0 && arr[i] == arr[i-1]){
                 start = end + 1; // 4
             }
             end = outer.size()-1;//3
             int n = outer.size();  //4
             for (int j=start;j<n;j++){
                 List<Integer> internal = new ArrayList<>(outer.get(j));
                 internal.add(arr[i]);
                 outer.add(internal);
             }
         }
         return outer;
    }
}
