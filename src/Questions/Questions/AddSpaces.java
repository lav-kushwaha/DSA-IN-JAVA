package Questions.Questions;

///https://leetcode.com/problems/adding-spaces-to-a-string/description/
//2109. Adding Spaces to a String
class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder result = new StringBuilder(); // Using StringBuilder for efficiency
        int j = 0; // Pointer to traverse the spaces array

        for (int i = 0; i < m; i++) {
            // Check if the current index matches the position in the spaces array
            if (j < n && i == spaces[j]) {
                result.append(" "); // Add space at the correct position
                j++; // Move to the next space index
            }
            result.append(s.charAt(i)); // Append the character from the original string
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AddSpaces solution = new AddSpaces();
        String s = "HelloWorld";
        int[] spaces = {5}; // Space should be added after the 5th index
        System.out.println(solution.addSpaces(s, spaces)); // Output: "Hello World"
    }
}
