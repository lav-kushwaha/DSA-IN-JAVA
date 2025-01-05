package Questions.Questions;

//https://leetcode.com/problems/shifting-letters-ii/description/
//2381. Shifting Letters II

class shiftingLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        long[] prefixSum = new long[n + 1];
        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            int value = (direction == 1) ? 1 : -1;
            
            prefixSum[start] += value;
            prefixSum[end + 1] -= value;
        }
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            long totalShifts = prefixSum[i];
            
            totalShifts = ((totalShifts % 26) + 26) % 26;
            
            int newChar = (chars[i] - 'a' + (int)totalShifts) % 26;
            chars[i] = (char)('a' + newChar);
        }
        
        return new String(chars);
    }
}