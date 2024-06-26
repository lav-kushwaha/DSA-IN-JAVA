package _08_Sorting.CyclicSortQuestions;
import java.util.Arrays;
//https://leetcode.com/problems/missing-number/
//268. Missing Number
//Amazon Question very easy.

public class MissingNumber {
    static int MissingNumber(int[] nums){
        int i=0;
        while(i<nums.length){
            int correct = nums[i];
            if(nums[i]<nums.length&&nums[i]!=nums[correct]){
                Swap(nums,i,correct);//swap
            }
            else{
                i++;
            }
        }

        //return element if its not equal to nums element.
        for(int index=0; index<nums.length;index++){
            if(index!=nums[index]){
                return index;
            }
        }
        return nums.length;
    }

    //method to swap
    static void Swap(int[] arr,int i, int correct){
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
    
    public static void main(String[] args) {
        int [] nums = {0,1,2};
        int ans = MissingNumber(nums);//passed nums array as an argument.
        System.out.println(ans);//print ans
    }
}
