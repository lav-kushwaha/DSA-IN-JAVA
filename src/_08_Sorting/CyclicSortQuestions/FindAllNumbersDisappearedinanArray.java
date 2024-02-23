package _08_Sorting.CyclicSortQuestions;
import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
//448. Find All Numbers Disappeared in an Array
//Google Question.
public class FindAllNumbersDisappearedinanArray {
    static List<Integer> CyclicSort(int[]nums){
        int i = 0 ;
        while (i < nums.length){
            int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
                Swap(nums,i,correct);
            }
            else{
                i++;
            }

        }
        List<Integer> ans = new ArrayList<>();
        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1){
                ans.add(index+1);
            }
        }
        return ans;
    }
    static void Swap(int[]nums, int i,int correct){
        int temp = nums[i];
        nums[i]=nums[correct];
        nums[correct]=temp;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = CyclicSort(nums);
        System.out.println(ans);
    }
}
