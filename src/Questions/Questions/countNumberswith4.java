package Questions.Questions;

class countNumberswith4 {
    public static int countNumberswith4(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (containsDigit4(i)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean containsDigit4(int num) {
        while (num > 0) {
            if (num % 10 == 4) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}