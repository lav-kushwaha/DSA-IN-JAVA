package Questions;
//https://www.geeksforgeeks.org/problems/peak-element/0
//Peak element

class PeakElement {
	public static int peakElement(int[] arr, int n)
    {
       //add code here.
       int start = 0;
       int end = n-1;
       while(start<end){
           int mid = start+(end-start)/2;
           
           if(arr[mid]<arr[mid+1]){
               start = mid + 1;
           }else{
               end = mid;
           }
       }
       
       return start;
    }

    public static void main(String[] args) {
       int arr[] = {1, 2, 3};
       int n = 3;
       System.out.println(peakElement(arr,n));
    }
}