package Questions;
//https://leetcode.com/problems/add-digits/
//258. Add Digits
class AddDigits {
    public static int addDigits(int num) {
        while (num >= 10) {
            num = digitsSum(num);
        }
        return num;
    }

    static int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
