package _13_MathsForDSA.BitwiseAndNumberSystem.Leetcode;

public class FindUniqueUsingXOR {
    public static void main(String[] args) {
        int [] arr = {2,3,4,1,2,1,3,6,4};
        System.out.println(UniqueElement(arr));
    }
    static int UniqueElement(int[] arr){
        int unique = 0;
        for(int num : arr){
            unique^=num;
        }
        return unique;
    }

}
