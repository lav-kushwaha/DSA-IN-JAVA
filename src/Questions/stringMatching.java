package Questions;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/string-matching-in-an-array/description/
//1408. String Matching in an Array
class stringMatching {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && words[j].contains(words[i])) {
                    ans.add(words[i]);
                    break;
                }
            }
        }

        return ans;
    }
}