package _11_MathsForDSA.Maths;

public class PrimeNoInRange {
    public static void main(String[] args) {
        int n = 40;
        prime(n);
    }

    static void prime(int n) {
        if (n <= 0) {
            System.out.println("Enter a number greater than zero");
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int c = 2;
        while (c * c <= num) {
            if (num % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
