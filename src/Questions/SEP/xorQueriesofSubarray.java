package Questions.SEP;

class xorQueriesofSubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] cumXOR = new int[arr.length];
        cumXOR[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            cumXOR[i] = cumXOR[i-1] ^ arr[i];
        }

        int [] result = new int[arr.length];
        int i = 0;
        for(int[] query : queries){
            int L = query[0];
            int R = query[1];

            int xorVal = cumXOR[R] ^ (L==0?0:cumXOR[L-1]);
            result[i] = xorVal;
            i++;
        }

        return result;
    }
}