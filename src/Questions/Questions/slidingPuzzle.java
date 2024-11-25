package Questions.Questions;

import java.util.*;

//https://leetcode.com/problems/sliding-puzzle/description/
//773. Sliding Puzzle
class slidingPuzzle {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }
        
        String target = "123450";
        
        Map<Integer, int[]> mp = new HashMap<>();
        mp.put(0, new int[]{1, 3});
        mp.put(1, new int[]{0, 2, 4});
        mp.put(2, new int[]{1, 5});
        mp.put(3, new int[]{0, 4});
        mp.put(4, new int[]{1, 3, 5});
        mp.put(5, new int[]{2, 4});
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start.toString());
        
        Set<String> visited = new HashSet<>();
        visited.add(start.toString());
        
        int level = 0; 
        
        while (!queue.isEmpty()) {
            int n = queue.size();
            
            for (int i = 0; i < n; i++) {
                String curr = queue.poll();
                
                if (curr.equals(target)) {
                    return level;
                }
                
                int indexOfZero = curr.indexOf('0'); 
                for (int swapIdx : mp.get(indexOfZero)) {
                    char[] newStateArray = curr.toCharArray();
                    char temp = newStateArray[indexOfZero];
                    newStateArray[indexOfZero] = newStateArray[swapIdx];
                    newStateArray[swapIdx] = temp;
                    
                    String newState = new String(newStateArray);
                    
                    if (!visited.contains(newState)) {
                        queue.offer(newState);
                        visited.add(newState);
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}