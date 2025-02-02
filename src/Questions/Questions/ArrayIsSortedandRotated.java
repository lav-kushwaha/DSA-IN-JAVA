package Questions.Questions;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
//1752. Check if Array Is Sorted and Rotated
class  ArrayIsSortedandRotated {

    public boolean check(int[] nums) {
        int n = nums.length;

        int[] checkSorted = new int[n];

        for (int rotationOffset = 0; rotationOffset < n; ++rotationOffset) {
            int currIndex = 0;
            for (int index = rotationOffset; index < n; ++index) {
                checkSorted[currIndex++] = nums[index];
            }
            for (int index = 0; index < rotationOffset; ++index) {
                checkSorted[currIndex++] = nums[index];
            }

            boolean isSorted = true;
            for (int index = 0; index < n - 1; ++index) {
                if (checkSorted[index] > checkSorted[index + 1]) {
                    isSorted = false;
                    break;
                }
            }

            // If sorted, return true
            if (isSorted) {
                return true;
            }
        }

        return false;
    }
}