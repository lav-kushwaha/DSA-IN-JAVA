package Questions.Questions;

//https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/
//1910. Remove All Occurrences of a Substring
class removeOccurrences {
    public String removeOccurrences(String s, String part) {
        StringBuilder res = new StringBuilder();
        int m = part.length();
        
        for (char c : s.toCharArray()) {
            res.append(c);
            if (res.length() >= m && res.substring(res.length() - m).equals(part)) {
                res.delete(res.length() - m, res.length());
            }
        }
        return res.toString();
    }
}