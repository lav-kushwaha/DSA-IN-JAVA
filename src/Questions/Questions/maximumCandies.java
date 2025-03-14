package Questions.Questions;

//https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
//2226. Maximum Candies Allocated to K Children
class maximumCandies {
    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = 10_000_000;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long childrenCount = 0;

            for (int candy : candies) {
                childrenCount += candy / mid;
            }

            if (childrenCount >= k) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}