package Questions.Questions;


import java.util.stream.IntStream;

//https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/
//1718. Construct the Lexicographically Largest Valid Sequence
class LexicographicallyLargestValidSequence {
    int n, length;
    boolean[] used;
    int[] sequence;

    public boolean dfs(int pos) {
        if (pos == length)
            return (int) IntStream.range(1, n + 1).filter(i -> used[i]).count() == n;

        if (sequence[pos] != 0)
            return dfs(pos + 1);

        for (int j = n; j >= 1; j--) {
            if (used[j]) 
                continue;

            int next_pos = (j > 1) ? pos + j : pos;
            if (next_pos >= length || sequence[next_pos] != 0)
                continue;

            sequence[pos] = sequence[next_pos] = j;
            used[j] = true;

            if (dfs(pos + 1)) 
                return true;

            sequence[pos] = sequence[next_pos] = 0;
            used[j] = false;
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        length = 2 * n - 1;
        sequence = new int[length];
        used = new boolean[n + 1];
        dfs(0);
        return sequence;
    }
}
