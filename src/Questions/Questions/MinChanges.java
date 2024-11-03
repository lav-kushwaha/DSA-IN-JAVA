package Questions.Questions;

public class MinChanges {
    public int minChanges(String s) {
        int count = 0;
        // Loop through the string, checking pairs of consecutive characters
        for (int i = 0; i < s.length() - 1; i += 2) {
            // If the characters in the current pair are not the same, increase the count
            if (s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinChanges mc = new MinChanges();
        
        // Test cases
        String test1 = "aabb";
        String test2 = "abab";
        String test3 = "aaaa";
        
        System.out.println("Minimum changes required for " + test1 + ": " + mc.minChanges(test1));
        System.out.println("Minimum changes required for " + test2 + ": " + mc.minChanges(test2));
        System.out.println("Minimum changes required for " + test3 + ": " + mc.minChanges(test3));
    }
}
