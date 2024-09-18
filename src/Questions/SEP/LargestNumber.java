package Questions.SEP;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] elements = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            elements[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(elements, new Comparator<String>() {
            public int compare(String a, String b) {
                String first = a + b;
                String second = b + a;
                return second.compareTo(first);
            }
        });

        if (elements[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elements.length; i++) {
            result.append(elements[i]);
        }

        return result.toString();
    }


}
