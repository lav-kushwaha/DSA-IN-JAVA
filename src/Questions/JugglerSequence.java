package Questions;

//https://www.geeksforgeeks.org/problems/juggler-sequence3930/1
//Juggler Sequence.

import java.util.ArrayList;
import java.util.List;

public class JugglerSequence {
    public static List<Long> recursiveFunction(long n) {
        List<Long> arr = new ArrayList<>();
        arr.add(n);
        return recursiveHelper(n, arr);//recursive call
    }
    
    //recursion helper function.
    private static List<Long> recursiveHelper(long n, List<Long> arr) {
        if (n <= 1) {
            return arr;
        }
        if (n % 2 == 0) {
            n = (long) Math.pow(n, (float) 1 / 2);
            arr.add(n);
        } else {
            n = (long) Math.pow(n, (float) 3 / 2);
            arr.add(n);
        }
        return recursiveHelper(n, arr);
    }

    public static void main(String[] args) {
        List<Long> result = recursiveFunction(9); // Change the argument as needed
        System.out.println(result);
    }
}
