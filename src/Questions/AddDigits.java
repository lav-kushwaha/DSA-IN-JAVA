package Questions;

//https://leetcode.com/problems/add-digits/
//258. Add Digits


class AddDigits {

    public static int addDigits(int num) {
        // Repeat until the number becomes a single digit
        while (num >= 10) {
            num = digitsSum(num);
        }
        return num;
    }

    static int digitsSum(int num) {
        int sum = 0;
        // Loop through each digit of the number
        while (num != 0) {
            sum += num % 10; // Add the last digit to the sum
            num /= 10;       // Remove the last digit from the number
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test the addDigits method with an example input
        System.out.println(addDigits(38));
    }
}
