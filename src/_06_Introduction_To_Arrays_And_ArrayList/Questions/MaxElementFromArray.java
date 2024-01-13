package _06_Introduction_To_Arrays_And_ArrayList.Questions;

public class MaxElementFromArray {
    public static void main(String[] args) {
        int [] arr = {10,20,2,90,60,40,25};
        int max =arr[0];
        int ans = MaximumArrayElement(arr);
        System.out.println(ans);
    }
    static int MaximumArrayElement(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

}
