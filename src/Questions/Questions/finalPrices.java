package Questions.Questions;

//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/
//1475. Final Prices With a Special Discount in a Shop

class finalPrices {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); 

        //loops
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] -= prices[j];
                    break;
                }
            }
        }
        return result;
    }
}