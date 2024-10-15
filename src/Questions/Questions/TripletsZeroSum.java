package Questions.Questions;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/0
//Find triplets with zero sum.

class TripletsZeroSum{
	public static boolean findTriplets(int arr[], int n){
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            int j=i+1;
            int k=n-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]==0){
                    return true;
                } else if(arr[i]+arr[j]+arr[k]<=0){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {0, -1, 2, -3, 1,3,8};
        int n = 7;
        System.out.println(findTriplets(arr,n));
    }
}
