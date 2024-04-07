package _14_Recursion_Questions.Recursion_Subset_and_Subsequence_String_Questions;

import java.util.ArrayList;
import java.util.List;

public class Q7_Subsets_II {
    public static void main(String[] args) {
        int [] arr = {1,2,2};
        List<List<Integer>> ans = subset(arr);
        System.out.print(ans+" ");
    }

    private static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();// [ [] [1]] //empty list we added like this :- [[]]

        outer.add(new ArrayList<>());//[[]]

        for (int num: arr){        //1 2 3
            int n = outer.size();  // 1
            for (int i=0; i<n;i++){ // 0
                List<Integer> internal = new ArrayList<>(outer.get(i)); //[1]
                internal.add(num); //1
                outer.add(internal); //[1] //indivisual list added to the main list using this line of code.
            }
        }
        return outer;
    }
}
