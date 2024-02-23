package _08_Sorting.CyclicSortQuestions;
import java.util.Arrays;
//645. Set Mismatch
//https://leetcode.com/problems/set-mismatch/description/
public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                Swap(nums,i,correct);
            }
            else{
                i++;
            }
        }
        for(int index=0; index<nums.length;index++){
            if(nums[index]!=index+1){
                return new int[] {nums[index],index+1};
            }
        }
        return new int[]{-1,-1};
    }
    public static void Swap(int[]nums,int i,int correct){
        int temp = nums[i];
        nums[i]=nums[correct];
        nums[correct]=temp;
    }
    public static void main(String[] args) {
        int [] arr = {1,2,2,4};
        int [] ans = findErrorNums(arr);
        System.out.println(Arrays.toString(ans));
    }
}
