package _06_Introduction_To_Arrays_And_ArrayList.Questions;

public class FindingMaxElementInRange {
    public static void main(String[] args) {
        int [] arr = {10,30,20,25,30,60};
        int ans = MaxInRange(arr,2,4);
        System.out.println(ans);
    }
    static int MaxInRange(int arr[], int start, int end){
        //we can do this question using for-loop as well as;
        if(end<start){
            return -1;
        }
        if(arr == null){
            return -1;
        }
        int maxVal = arr[0];
        while(start<=end){
            if(maxVal<arr[start]){
                maxVal=arr[start];
                start++;
            }
        }
        return maxVal;
    }

}
