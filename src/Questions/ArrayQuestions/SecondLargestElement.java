package Questions.ArrayQuestions;

public class SecondLargestElement {
    public static void main(String[] args) {
        int [] arr = {12,35,30,40,25,10};
//        int ans = secondLargestElementBrute(arr); //NlogN + N
        int ans1 = secondLargestElementBetter(arr); //O(2N)
        System.out.println(ans1);
    }

    //Brute force
    private static int secondLargestElementBrute(int[] arr) {
        //sort the array.
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                //swap.
               if(arr[i]>arr[j]){
                   int temp = arr[j];
                   arr[j] = arr[i];
                   arr[i] = temp;
               }
            }
        }

        int secondLargest = -1;
        int largest = arr[arr.length-1];

        //check secondLargest is not equal to largest element present.
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]!=largest){
                secondLargest = arr[i];
                break;
            }
        }
        return secondLargest;
    }

    private static int secondLargestElementBetter(int[] arr) {
        //first find the largest element
        int largest = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }

        //now, find the second largest which is not equal to largest.
        int secondLargest = -1;
        for(int i=0; i<arr.length;i++){
            if(arr[i]>secondLargest && arr[i]!=largest){
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }
}
