package Questions.ArrayQuestions;

//
public class LargestElement {
    public static void main(String[] args) {
        int [] arr = {12,10,23,45,25,30};
        int ans = findLargest(arr);
        System.out.println(ans);
    }

    private static int findLargest(int[] arr) {
        int largest = arr[0];
        for(int i=0; i<arr.length;i++){
            if(arr[i]>largest){
                largest = arr[i];
            }
        }
        return largest;
    }
}
