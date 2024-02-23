package _08_Sorting.CyclicSortQuestions;
//287. Find the Duplicate Number.
//https://leetcode.com/problems/find-the-duplicate-number/description/
//Amazon/Microsoft Questions.
public class FindtheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
           int i =0;
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
                   return nums[index];
               }
           }
           return -1;
    }
    static void Swap(int [] nums, int i, int correct){
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp ;
    }

    public static void main(String[] args) {
       int[] nums = {1,3,4,2,2};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }
}
