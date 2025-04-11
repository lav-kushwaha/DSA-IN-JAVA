package Questions.Questions;

//https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/0
//Sort 0s, 1s and 2s
class Sort0s1sand2s{
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
         int n=arr.length;
        int low=0,high=n-1,temp=0,mid=0;
        while(mid<=high)
        {
            if(arr[mid]==0)
            {
                swap(arr,mid,low);
                mid++;low++;
            }
            else if(arr[mid]==1)
            {
                mid++;
            }
            else
            {
                swap(arr,mid,high);
                high--;
            }
        }
    }
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
