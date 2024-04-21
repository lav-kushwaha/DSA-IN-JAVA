package _13_MathsForDSA.BitwiseAndNumberSystem.Questions;
public class FindbitofNumb {
    public static void main(String[] args) {
        //Q.Find ith bit of number.
        int num = 10;
        int i = 5;
        int ans = num & (1<<(i-1));
        System.out.println(ans);

        //Q.set ith bit of number.
        /*
        0->1
        1->1
        */

    }
}
