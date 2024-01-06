package _03_Conditionals_and_Loops.Questions;

public class ConvertNumberReverse {
    public static void main(String[] args) {
        int num = 23597;
        int reverse = 0;
        while(num!=0){
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num = num/10;
        }
        System.out.println(reverse);
    }
}
