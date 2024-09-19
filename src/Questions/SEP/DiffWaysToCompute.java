package Questions.SEP;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
//241. Different Ways to Add Parentheses

//Approach-(Simple and straight forward convert to minutes and sort)
//T.C : O(n*2^n)
//S.C : O(2^n) //The result vector stores all possible outcomes.
// The number of results is at most exponential in terms of the number of operators, so the space required to store the results is O(2^n).
public class DiffWaysToCompute {

    public List<Integer> diffWaysToCompute(String expression) {
        return solve(expression);
    }

    private List<Integer> solve(String s) {
        List<Integer> result = new ArrayList<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is an operator
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> leftResults = solve(s.substring(0, i));
                List<Integer> rightResults = solve(s.substring(i + 1));

                // Combine the results from left and right parts
                for (int x : leftResults) {
                    for (int y : rightResults) {
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else if (c == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        // If no operator is found, it means the string is a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(s));
        }

        return result;
    }

    public static void main(String[] args) {
        DiffWaysToCompute calculator = new DiffWaysToCompute();
        String expression = "2-1-1";
        List<Integer> results = calculator.diffWaysToCompute(expression);
        System.out.println(results); // Output will be [0, 2]
    }
}