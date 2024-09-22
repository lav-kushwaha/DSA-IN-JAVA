package Questions.SEP;

//https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
//440. K-th Smallest in Lexicographical Order

class FindKthNumberLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--;
        while (k > 0) {
            int count = count(n, curr, curr + 1);
            if (count <= k) {
                curr++;
                k -= count;
            } else {
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    public int count(int n, long curr, long next) {
        int countNum = 0;
        while (curr <= n) {
            countNum += Math.min(next, n + 1) - curr; // Ensure we don't exceed n
            curr *= 10;
            next *= 10;
        }
        return countNum;
    }

    public static void main(String[] args) {
        FindKthNumberLexicographicalOrder finder = new FindKthNumberLexicographicalOrder();
        int n = 13; // Example value for n
        int k = 2;  // Example value for k
        int result = finder.findKthNumber(n, k);
        System.out.println("The " + k + "th smallest number in lexicographical order is: " + result);
    }
}
