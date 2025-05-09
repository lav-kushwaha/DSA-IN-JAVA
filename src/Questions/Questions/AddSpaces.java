package Questions.Questions;

///https://leetcode.com/problems/adding-spaces-to-a-string/description/
//2109. Adding Spaces to a String
class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder result = new StringBuilder();
        int j = 0;

        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        AddSpaces solution = new AddSpaces();
        String s = "lavkushwaha ";
        int[] spaces = {5};
        System.out.println(solution.addSpaces(s, spaces));
    }
}
