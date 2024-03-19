package _11_Recursion.Questions;
import java.util.Arrays;
//https://leetcode.com/problems/reverse-string/
public class ReverseStringUsingRecursion {
    public static void main(String[] args) {
        char [] s ={'h','e','l','l','o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public static void reverseString(char[] s) {
        recursiveArray(s.length - 1, s);
    }
    static void recursiveArray(int index, char[] s) {
        if (index < s.length / 2) {
            return;
        }
        char temp = s[index];
        s[index] = s[s.length - index - 1];
        s[s.length - index - 1] = temp;
        recursiveArray(index - 1, s);
    }
}

//Two Pointers Approach.
// static void Pointers(char[] s){
//        int start  = 0;
//        int end = s.length-1;
//        while(start<=end){
//            char temp = s[start];
//            s[start] = s[end];
//            s[end] = temp;
//            start++;
//            end--;
//        }
//   }
