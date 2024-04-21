package _13_MathsForDSA.Maths;
public class PrimeNumber {
    public static void main(String[] args) {
        int n = 25;
//        Prime(n);
     //System.out.println(Prime(n));
        for (int i = 1; i<=n;i++){
            System.out.println(i+ " " +isPrime(i));
        }
    }
    //1st method to check prime or not.
//    static void Prime(int n){
//        boolean check = false;
//        for (int i=1;i<n;i++){
//            if(i==1){
//                continue;
//            }
//            if(n%i==0){
//                check = true;
//            }
//        }
//        if(check){
//            System.out.println("Number is not a prime no.");
//        }else{
//            System.out.println("Number is prime no.");
//        }
//    }

    //2nd method to check prime or not.
    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        int c = 2;
        while (c * c <= n){
            if(n % c == 0){
                return false;
            }
            c++;
        }
        return true;
    }
}
