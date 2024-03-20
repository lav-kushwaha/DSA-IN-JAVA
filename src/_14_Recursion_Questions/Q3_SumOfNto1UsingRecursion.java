package _14_Recursion_Questions;
//Q.Sum of n to 1
public class Q3_SumOfNto1UsingRecursion {
    public static void main(String[] args) {
        int ans = sum(5);
        System.out.println(ans);
    }

    static int sum(int n){
        //base condition
        if(n==1){
            return n;
        }
        return n+sum(n-1);

    }

}
