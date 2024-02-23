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
                Swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        for(int index=0; index<nums.length;index++){
            if(index!=nums[index]){
                return index;
            }
        }
        return nums.length;
    }
    static void Swap(int[] arr,int i, int correct){
        int temp = arr[i];
        arr[i] = arr[correct];
        arr[correct] = temp;
    }
    public static void main(String[] args) {
        int [] nums = {0,1,2};
        int ans = MissingNumber(nums);
        System.out.println(ans);

    }
}
