package _03_Conditionals_and_Loops.Questions;

public class CountNums {
    public static void main(String[] args) {
        //Q. count how many 7 are there?
        int num = 1385757879;
        int target  = 7;
        int count = 0;
        while(num!=0){
            int digit = num%10;
            if(digit==target){
                count++;
            }
            num = num/10;
        }
        System.out.println(count);
    }
}
