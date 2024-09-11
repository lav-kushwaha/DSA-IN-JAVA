package Questions.SEP;

//2220. Minimum Bit Flips to Convert Number
//https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/?envType=daily-question&envId=2024-09-11

class minBitFlipsToConvertNumber {
    public int minBitFlips(int start, int goal) {
        
        int xor = start ^ goal;
        int count = 0;

        while(xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        minBitFlipsToConvertNumber solution = new minBitFlipsToConvertNumber();
        
        int start1 = 10;  // Binary: 1010
        int goal1 = 20;   // Binary: 10100
        int result1 = solution.minBitFlips(start1, goal1);
        System.out.println("Minimum bit flips to convert " + start1 + " to " + goal1 + ": " + result1);
    }
}
