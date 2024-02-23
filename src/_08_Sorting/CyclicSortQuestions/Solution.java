package _08_Sorting.CyclicSortQuestions;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int majorityElement(final int[] A) {
        int i = 0;
        if(A.length==1){
            return A[A.length-1];
        }
        while(i<A.length){
            int correct = A[i]-1;
            if(A[i]!=A[correct]){
                int temp = A[i];
                A[i]=A[correct];
                A[correct]=temp;
            }
            else{
                i++;
            }
        }
        for(int index=0;index<A.length;index++){
            if(A[index]!=index+1){
                return A[index];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,2};
        int maj = majorityElement(arr);
        System.out.println(maj);
    }
}
