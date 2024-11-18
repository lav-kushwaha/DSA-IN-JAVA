package Questions.Questions;

//Approach-1 (Brute Force)
//T.C : O(n*|k|)
//S.C : O(1)
class  DefusetheBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (k < 0) {
                for (int j = i - Math.abs(k); j < i; j++) {
                    result[i] += code[(j + n) % n];
                }
            } else {
                for (int j = i + 1; j < i + k + 1; j++) {
                    result[i] += code[j % n];
                }
            }
        }

        return result;
    }
}
