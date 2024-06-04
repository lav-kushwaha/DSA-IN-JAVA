package Questions;

class GCDOFTWONUM {
    public static int gcd(int a, int b) {
        // code here
        if(a==0){ //if a becomes zero return b.
            return b;
        }
        return gcd((b%a),a); //recursive call
    }

    public static void main(String[] args) {
        int ans = gcd(12,21);
        System.out.println(ans);
    }
}
