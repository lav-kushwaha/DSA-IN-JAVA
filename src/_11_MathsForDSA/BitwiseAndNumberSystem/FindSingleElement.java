package _11_MathsForDSA.BitwiseAndNumberSystem;

public class FindSingleElement {
    public static int findSingle(int[] arr,int n) {
        int ones = 0, twos = 0;
        int common_bit_mask;
        for (int i = 0; i < n; i++) {
            twos = twos | (ones & arr[i]);
            ones = ones ^ arr[i];
            common_bit_mask = ~(ones & twos);
            ones &= common_bit_mask;
            twos &= common_bit_mask;
        }
        return ones;
    }
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2};
        int singleElement = findSingle(arr,arr.length);
        System.out.println("The element appearing only once is: " + singleElement);
    }
}
