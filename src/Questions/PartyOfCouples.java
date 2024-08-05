package Questions;

class PartyOfCouples{
    static int findSingle(int n, int arr[]){
          // code here
        int single = 0;
        for(int i=0;i<n;i++){
            single = single ^ arr[i];
        }
        return single;
    }

    public static void main(String[] args) {
        int arr [] = {1, 2, 3, 2, 1};
        int n = 5;
        System.out.println(findSingle(n,arr));
    }
}