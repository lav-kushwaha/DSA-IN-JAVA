package Questions;

public class sqrt {
    public static void main(String[] args) {
        int n = 625;
        int ans = squareroot(n);
        if (ans == -1) {
            System.out.println("Not a perfect square");
        } else {
            System.out.println(ans);
        }
    }
    static int squareroot(int n) {
        for (int i = 1; i <= n; i++) {
            if (i * i == n) {
                return i;
            }
        }
        return -1; // Not a perfect square
    }
}
