package Questions;

//https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/
//2914. Minimum Number of Changes to Make Binary String Beautiful

public class minChanges {
    public int minChanges(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }
}