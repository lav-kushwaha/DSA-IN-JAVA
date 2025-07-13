package Questions.ArrayQuestions;

public class checkArrayIsSortedOrNot {
    public static boolean arraySortedOrNot(int[] arr) {
        // code here
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(arraySortedOrNot(arr));
    }
}
