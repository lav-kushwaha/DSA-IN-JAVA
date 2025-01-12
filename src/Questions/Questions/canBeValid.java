package Questions.Questions;

import java.util.Stack;

//https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
//2116. Check if a Parentheses String Can Be Valid

// Approach (Using stack)
// T.C : O(n)
// S.C : O(n)
class canBeValid {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if (n % 2 != 0) { // odd
            return false;
        }

        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                openClose.push(i);
            } else if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!openClose.isEmpty()) {
                    openClose.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty() && !openClose.isEmpty() && open.peek() < openClose.peek()) {
            open.pop();
            openClose.pop();
        }

        return open.isEmpty(); // true
    }
}
