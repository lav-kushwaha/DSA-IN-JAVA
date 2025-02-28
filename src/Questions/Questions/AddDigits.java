package Questions.Questions;

//https://leetcode.com/problems/add-digits/
//258. Add Digits (Easy Question)
class AddDigits {

    public static int addDigits(int num) {
        while (num >= 10) {
            num = digitsSum(num);
        }
        return num;
    }

    //method to sum of digits..
    static int digitsSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digitsSum(565));
    }
}
