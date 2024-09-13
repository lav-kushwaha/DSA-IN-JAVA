package Questions.SEP;

import java.util.Arrays;

class xorQueriesofSubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Calculate cumulative XOR
        int[] cumXOR = new int[arr.length];
        cumXOR[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            cumXOR[i] = cumXOR[i - 1] ^ arr[i];
        }

        int[] result = new int[queries.length];
        int i = 0;

        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];

            int xorVal = cumXOR[R] ^ (L == 0 ? 0 : cumXOR[L - 1]);
            result[i] = xorVal;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        xorQueriesofSubarray solution = new xorQueriesofSubarray();

        int[] arr = {1, 3, 4, 8};

        int[][] queries = {
                {0, 1},
                {1, 2},
                {0, 3},
                {3, 3}
        };

        int[] result = solution.xorQueries(arr, queries);

        System.out.println(Arrays.toString(result)); // Output: [2, 7, 14, 8]
    }
}
