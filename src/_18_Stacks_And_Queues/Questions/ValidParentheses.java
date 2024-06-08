package _18_Stacks_And_Queues.Questions;
import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
//20. Valid Parentheses

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If it's a closing bracket, check for a matching opening bracket
                if (ch == ')') {
                    // Check if the stack is empty or if the top element is not a matching opening bracket
                    // If the stack is empty or the top element is not '(', return false
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                } else if (ch == '}') {
                    // Check if the stack is empty or if the top element is not '{', return false
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                } else if (ch == ']') {
                    // Check if the stack is empty or if the top element is not '[', return false
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        // After processing all characters, check if the stack is empty
        // If the stack is empty, all opening brackets had matching closing brackets
        // If the stack is not empty, return false because there are unmatched opening brackets
        return stack.isEmpty();
    }
}


/*
Note :
Only "({[" these brackets are PUSH into the stack "]})" these brackets are used to check the matching brackets.
if all brackets are match to each other empty the stack and return true. otherwise, if it's not match return false.
 */