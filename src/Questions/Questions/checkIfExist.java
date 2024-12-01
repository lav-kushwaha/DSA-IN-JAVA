package Questions.Questions;

//https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
//1346. Check If N and Its Double Exist
class checkIfExist {
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;

        // Iterate over each pair (i, j)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // If i != j and arr[i] is 2 times arr[j]
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}