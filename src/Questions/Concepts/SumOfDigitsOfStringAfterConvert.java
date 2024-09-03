package Questions.Concepts;

//https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/?envType=daily-question&envId=2024-09-03
//1945. Sum of Digits of String After Convert

class SumOfDigitsOfStringAfterConvert {
    public static int getLucky(String s, int k) {

        StringBuilder build = new StringBuilder();

        for(int c : s.toCharArray()){
            int position = c - 'a'+ 1;
            build.append(position);
        }

        String numStr = build.toString();
        int sum = 0;

        while(k!=0){
           sum = 0;
           for(char ch : numStr.toCharArray()){
                int digit = ch - '0';
                sum+=digit;
           }
           numStr = Integer.toString(sum);
           k--;
        }
        return sum;

    }
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(getLucky(str,2));
    }
}