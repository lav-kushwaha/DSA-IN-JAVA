package _13_MathsForDSA.BitwiseAndNumberSystem.Questions;

public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 16;
        boolean ans = (n&(n-1)) == 0;
        System.out.println(ans);
    }
}
