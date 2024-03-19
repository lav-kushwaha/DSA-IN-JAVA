package _11_MathsForDSA.BitwiseAndNumberSystem.Questions;
//https://www.geeksforgeeks.org/sum-of-all-elements-up-to-nth-row-in-a-pascals-triangle/
//if you don't understand check it. gfg there is best explaination given.
public class PascalsTriangle {
    public static void main(String[] args) {
        int n = 2;
        System.out.println("Sum of all elements:"
                + calculateSum(n));
    }
    static long calculateSum(int n)
    {
        // Initialize sum with 0
        long sum = 0;

        // Loop to calculate power of 2
        // upto n and add them
        for (int row = 0; row < n; row++) {
            sum = sum + (1 << row);
        }

        return sum;
    }
}
