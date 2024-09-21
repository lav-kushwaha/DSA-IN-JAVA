package Questions.Questions;
public class MaxElement {
    public static void main(String[] args) {
        int [] arr = {10,23,200,35,56,80};
        int max = 0;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        System.out.println("Maximum element is : "+max);//array max element
    }
}
