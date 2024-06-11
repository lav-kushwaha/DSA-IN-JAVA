package _18_Stacks_And_Queues.Questions;
import java.util.Stack;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
//921. Minimum Add to Make Parentheses Valid

public class MakeParenthesesValid {
    public static void main(String[] args) {
        String s = "(()))";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == ')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}

/*
NOTE :
=> Just pop() the valid "()" parenthesis from the stack and return the size of remaining parenthesis.
 */
