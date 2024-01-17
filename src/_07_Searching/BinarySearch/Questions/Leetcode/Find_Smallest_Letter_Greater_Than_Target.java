package _07_Searching.BinarySearch.Questions.Leetcode;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class Find_Smallest_Letter_Greater_Than_Target {
    //this is like a ceiling just a little bit change.
    static char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // If left is within bounds, return letters[left], otherwise return letters[0]
        return letters[left % letters.length];
    }
    public static void main(String[] args) {
        char [] letters = {'c','f','j'};
        char target = 'j';
        char ans = nextGreatestLetter(letters,target);
        System.out.println(ans);
    }
}
