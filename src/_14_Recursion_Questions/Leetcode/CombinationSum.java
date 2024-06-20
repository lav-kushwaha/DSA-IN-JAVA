package _14_Recursion_Questions.Leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//Q: 39. Combination Sum
//Amazon,Facebook,Microsoft,Airbnb,Apple asked questions.

class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> combinations = combinationSum(candidates, target);

        // Print the result
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return  combinations(candidates, new ArrayList<>(), target, 0);
    }

    static List<List<Integer>> combinations(int[] arr, List<Integer> current, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return result;
        }

        if (target < 0)
            return result;

        for (int i = start; i < arr.length; i++) {
            current.add(arr[i]);
            result.addAll(combinations(arr, current, target - arr[i], i));//addAll method
            current.remove(current.size() - 1);//remove
        }

        return result;
    }
}
