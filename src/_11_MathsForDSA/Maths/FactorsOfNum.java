package _11_MathsForDSA.Maths;

public class FactorsOfNum {
    public static void main(String[] args) {
        int n = 20;
       Factors(n);
    }
    //
    static void Factors(int n){
        for (int i=1;i<=n;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
    }
}
