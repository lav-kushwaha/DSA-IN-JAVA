package Questions.SEP;

//https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/
//3043. Find the Length of the Longest Common Prefix

import java.util.HashSet;

public class LongestCommonPrefix {
    
    public static int commonPrefixLength(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return i;
    }
    
    public static int findLongestCommonPrefix(int[] arr1, int[] arr2) {
        int maxLength = 0;
        for (int num1 : arr1) {
            String str1 = String.valueOf(num1);
            for (int num2 : arr2) {
                String str2 = String.valueOf(num2);
                int commonLength = commonPrefixLength(str1, str2);
                maxLength = Math.max(maxLength, commonLength);
            }
        }
        return maxLength;
    }

    //2nd approach : using hashset for fastest lookups.
//    public static int findLongestCommonPrefix(int[] arr1, int[] arr2) {
//        HashSet<String> prefixSet = new HashSet<>();
//        for (int num : arr1) {
//            String strNum = Integer.toString(num);
//            String prefix = "";
//            for (char ch : strNum.toCharArray()) {
//                prefix += ch;
//                prefixSet.add(prefix);
//            }
//        }
//
//        int maxLength = 0;
//        for (int num : arr2) {
//            String strNum = Integer.toString(num);
//            String prefix = "";
//            for (char ch : strNum.toCharArray()) {
//                prefix += ch;
//                if (prefixSet.contains(prefix)) {
//                    maxLength = Math.max(maxLength, prefix.length());
//                } else {
//                    break;
//                }
//            }
//        }
//        return maxLength;
//    }

    public static void main(String[] args) {
        int[] arr1 = {1, 10, 100};
        int[] arr2 = {1000};
        System.out.println(findLongestCommonPrefix(arr1, arr2));
    }
}
