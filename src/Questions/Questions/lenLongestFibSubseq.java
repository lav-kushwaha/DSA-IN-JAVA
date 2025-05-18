package Questions.Questions;

import java.util.HashSet;
import java.util.Set;

class lenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int maxLen = 0;
        for (int start = 0; start < n; ++start) {
            for (int next = start + 1; next < n; ++next) {
                int prev = arr[next];
                int curr = arr[start] + arr[next];
                int len = 2;

                while (numSet.contains(curr)) {
                    int temp = curr;
                    curr += prev;
                    prev = temp;
                    maxLen = Math.max(maxLen, ++len);
                }
            }
        }

        return maxLen;
    }
}