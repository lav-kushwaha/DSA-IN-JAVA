package _14_Recursion_Questions.Recursion_Permutations;

public class PermutationsQuestions {
    public static void main(String[] args) {
        permutations("", "abc");
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p + " ");
            return;
        }
        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            String remaining = up.substring(0, i) + up.substring(i + 1);
            permutations(p + ch, remaining);
        }
    }
}
