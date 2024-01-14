package _07_Searching.LinearSearch.Questions;
public class MaxValueIn2DArrays {
    public static void main(String[] args) {
        int [][] arr = new int[][]{
                {12,13,25,28,40,80},
                {67,34,18,70},
                {35,45,50,60,55},
        };
        int ans = MaxValue(arr);
        //finding max element in 2D Arrays
        System.out.println(ans);
    }

    //Finding max element in 2DArrays.
    static int MaxValue(int [][]arr){
        int max = arr[0][0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]>max){
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

}
