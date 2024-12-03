package Questions.Questions;

///https://leetcode.com/problems/adding-spaces-to-a-string/description/
//2109. Adding Spaces to a String
class addSpaces {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder result = new StringBuilder(); // Using StringBuilder for efficiency
        int j = 0; // Pointer to traverse the spaces array

        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}