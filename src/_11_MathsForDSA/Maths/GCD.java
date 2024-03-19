package _11_MathsForDSA.Maths;

public class GCD {
    public static void main(String[] args) {
        int ans = GCD(48,18);
        System.out.println(ans);
    }
    static int GCD(int a, int b){
        if(a==0){
            return b;
        }
        return GCD(b%a,a);
    }
}
