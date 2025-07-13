package Questions.Array_Questions.Array_Easy_Questions;

//https://leetcode.com/problems/majority-element/description/
// Moore’s Voting Algorithm (for finding the majority element)
public class MajorityElement {

    //optimal solution
    public static int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count = 1;
                element = nums[i];
            }else if(nums[i]==element){
                count++;
            }else{
                count--;
            }
        }

        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(element==nums[i]){
                n++;
            }
        }

        return n > nums.length/2 ? element : -1;

    }
    public static void main(String[] args) {
       int [] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
}


/*
*  Moore’s Voting Algorithm (for finding the majority element)
Purpose:
Find the element that appears more than ⌊n/2⌋ times in an array (majority element), if it exists.

#How It Works (Two Steps)
1. Find a Candidate
Initialize:
candidate = None, count = 0

#Traverse the array:
If count == 0: set candidate = current element
If element == candidate: count += 1
Else: count -= 1

2. Verify the Candidate
Count how many times the candidate appears in the array.
If count > n/2 → it's the majority element.
Else → no majority.

Time Complexity: O(n)
Space Complexity: O(1)
*
* */