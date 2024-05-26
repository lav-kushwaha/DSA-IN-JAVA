package Questions;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/find-triplets-with-zero-sum/0
//Find triplets with zero sum.

class TripletsZeroSum
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public static boolean findTriplets(int arr[], int n)
    {
        //add code here.
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
        int arr[] = {0, -1, 2, -3, 1};
        int n = 5;
        System.out.println(findTriplets(arr,n));
    }
}