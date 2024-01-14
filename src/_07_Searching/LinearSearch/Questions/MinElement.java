package _07_Searching.LinearSearch.Questions;
public class MinElement {
    public static void main(String[] args) {
        int [] arr ={10,20};
        int ans = MinNumb(arr);
        System.out.println(ans);
    }
    static int MinNumb(int[] arr){
        if(arr.length == 0){
            return -1;
        }
        int min = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
