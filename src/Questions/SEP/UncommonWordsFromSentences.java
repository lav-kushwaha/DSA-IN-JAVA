package Questions.SEP;
import java.util.*;

//https://leetcode.com/problems/uncommon-words-from-two-sentences/?envType=daily-question&envId=2024-09-17
//884. Uncommon Words from Two Sentences

class UncommonWordsFromSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Combine both sentences into one string
        String combined = s1 + " " + s2;

        // Split the combined string into words
        String[] words = combined.split(" ");

        // Use a HashMap to count occurrences of each word
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Collect words that appear exactly once
        List<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }

        // Convert the result list to an array and return it
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Create an instance of the class
        UncommonWordsFromSentences solution = new UncommonWordsFromSentences();

        // Scanner for input
        Scanner scanner = new Scanner(System.in);

        // Input sentences
        System.out.println("Enter the first sentence:");
        String s1 = scanner.nextLine();

        System.out.println("Enter the second sentence:");
        String s2 = scanner.nextLine();

        // Call the method to find uncommon words
        String[] result = solution.uncommonFromSentences(s1, s2);

        // Output the result
        System.out.println("Uncommon words are:");
        for (String word : result) {
            System.out.println(word);
        }

        // Close the scanner
        scanner.close();
    }
}
