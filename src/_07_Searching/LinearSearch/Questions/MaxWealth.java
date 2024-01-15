package _07_Searching.LinearSearch.Questions;

// https://leetcode.com/problems/richest-customer-wealth/
public class MaxWealth {
    public static void main(String[] args) {
        int accounts [][] = {{1,5,3},{3,2,1}};
        int ans = maximumWealth(accounts);
        System.out.println(ans);
    }
    public static int maximumWealth(int[][] accounts) {
        // person = rol
        // account = col
        int ans = Integer.MIN_VALUE;
        for (int[] ints : accounts) {
            // when you start a new row, take a new sum for that row
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            // now we have sum of accounts of person
            // check with overall ans
            if (sum > ans) {
                ans = sum;
            }
        }
        return ans;
    }
}
