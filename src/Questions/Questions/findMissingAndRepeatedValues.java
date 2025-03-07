package Questions.Questions;

//https://leetcode.com/problems/find-missing-and-repeated-values/description/
//2965. Find Missing and Repeated Values
class findMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] count = new int[size + 1];

        //loop
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[grid[i][j]]++;
            }
        }

        int a = -1;
        int b = -1;

        for (int num = 1; num <= size; num++) {
            if (count[num] == 2) {
                a = num;
            } else if (count[num] == 0) {
                b = num;
            }
        }

        return new int[]{a, b};
    }
}