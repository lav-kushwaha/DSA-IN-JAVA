package _07_Searching.BinarySearch.Questions.Leetcode;
//https://leetcode.com/problems/split-array-largest-sum/description/
//410. Split Array Largest Sum
public class SplitArrayLargestSum {
    public static void main(String[] args) {
            int [] arr = {7,2,5,10,8};
            int k = 2;
            int ans = splitArray(arr,k);
            System.out.println(ans);
    }
    public static int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);//In the end it will contain the maximum item in the array.
            end = end + nums[i];

            //binary search
            while (start < end) {
                //try for the middle as potential ans.
                int mid = start + (end - start) / 2;
                //calculate how many pieces you can divide this in with this max sum
                int sum = 0;
                int pieces = 1;
                for (int num : nums) {
                    if (sum + num > mid) {
                        //you cannot this into a subarray make in subarray.
                        //say you add this num into new subarray, then sum = num
                        sum = num;
                        pieces++;
                    } else {
                        sum += num;
                    }
                }
                if (pieces > m) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return end; //here start == end

    }

}
