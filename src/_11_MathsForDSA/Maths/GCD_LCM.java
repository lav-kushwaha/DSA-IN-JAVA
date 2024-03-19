package _11_MathsForDSA.Maths;

public class GCD_LCM {
    public static void main(String[] args) {
//      int ans = gcd(52,10);//2
        int ans = lcm(2,7);
        System.out.println(ans);
    }
    static int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }


    //another way
    // Function to find the gcd of two numbers using Euclid's algorithm
//    public static int gcd(int a, int b) {
//        while (b != 0) {
//            int temp = b;
//            b = a % b;
//            a = temp;
//        }
//        return a;
//    }

}
