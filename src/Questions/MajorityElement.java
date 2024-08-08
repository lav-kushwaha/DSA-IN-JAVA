package Questions;

class MajorityElement
{
    static int majorityElement(int arr[], int N)
    {
        // your code here
        int candidate = -1;
        int count = 0;

        // Find the potential candidate for the majority element
        for (int i = 0; i < N; i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else if (candidate == arr[i]) {
                count++;
            } else {
                count--;
            }
        }
        // Check if the candidate is the majority element
        count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == candidate) {
                count++;
            }
        }

        return count > N / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        int [] arr = {3,1,3,3,2};
        System.out.println(majorityElement(arr,arr.length));
    }
}