package _02_First_Java_Program.Questions;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 18;
        if (num == 1) {
            System.out.println("Neither prime nor composite");
        } else {
            int count = 2;
            boolean isPrime = true;
            while (count * count <= num) {
                if (num % count == 0) {
                    isPrime = false;
                    System.out.println("Number is not a prime number");
                    break;
                }
                count++;
            }
            if (isPrime) {
                System.out.println("Number is a prime number");
            }
        }
    }
}
