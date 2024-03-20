package _14_Recursion_Questions;
//Q.5 DigitsProduct
public class Q5_ProductsOfDigits {
    public static void main(String[] args) {
        int n =1342;
        int ans = DigitsProduct(n);
        System.out.println(ans);

    }
    static int DigitsProduct(int n){
        if(n<=1){
            return 1;
        }
        return (n%10)*DigitsProduct(n/10);
    }
}
