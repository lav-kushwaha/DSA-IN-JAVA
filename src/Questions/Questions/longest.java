package Questions.Questions;

class longest {
    public static String longest(int n, String[] names) {
        // code here
          String longestName = names[0];

        for (int i = 1; i < n; i++) {
            if (names[i].length() > longestName.length()) {
                longestName = names[i];
            }
        }

        return longestName;
    }
}