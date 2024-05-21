package Questions;

class GCDOFTWONUM {
    public static int gcd(int a, int b) {
        // code here
        if(a==0){
            return b;
        }
        return gcd((b%a),a);
    }

    public static void main(String[] args) {
        int ans = gcd(12,21);
        System.out.println(ans);
    }
}
