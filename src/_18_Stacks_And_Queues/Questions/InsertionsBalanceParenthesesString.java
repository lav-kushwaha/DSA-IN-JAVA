package _18_Stacks_And_Queues.Questions;
import java.util.Stack;

//1541. Minimum Insertions to Balance a Parentheses String
//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/description/

public class InsertionsBalanceParenthesesString {
    public static void main(String[] args) {
        String s = "))())(";
        System.out.println(minInsertions(s));
    }
    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    i++;
                }else{
                    count++;
                }

                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    count++;
                }
            }
        }
        count+=2*stack.size();
        return count;
        }
    }

/*
NOTE : The line count += 2 * stack.size(); is written to account for any
unmatched opening parentheses '(' that remain in the stack after processing the entire input string s.
 */