package Questions.Array_Questions.Array_Easy_Questions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {3, 4, 5, 6};
        System.out.println(Arrays.toString(unionOfTwoArrays(array1,array2))); //brute force
        System.out.println(IntersectionOfTwoArrays(array1,array2));
    }

    //Time (TC)  O(n + m)
    //Space (SC) O(n + m)
    private static int[] unionOfTwoArrays(int[] array1, int[] array2) {
        Set<Integer> unionSet = new HashSet<>();
        for (int num : array1) unionSet.add(num);
        for (int num : array2) unionSet.add(num);

        int[] union = new int[unionSet.size()];
        int i = 0;
        for (int num : unionSet) {
            union[i++] = num;
        }
        return union;
    }

    //Time: O(n + m)
    //Space: O(n)
    private static Set<Integer> IntersectionOfTwoArrays(int[] array1, int[] array2) {

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();

        for(int i=0;i<array1.length;i++){
            set.add(array1[i]);
        }

        for(int i=0;i<array2.length;i++){
            if(set.contains(array2[i])){
                resultSet.add(array2[i]);
            }
        }

        return resultSet;
    }
}
