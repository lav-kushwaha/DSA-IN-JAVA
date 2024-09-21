package Questions.Questions;

//https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04
//874. Walking Robot Simulation.

import java.util.HashSet;
import java.util.Set;

class RobotSimulation {
    public static int robotSim(int[] commands, int[][] obstacles) {
        // Define directions: north, east, south, west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;  // Starting position (0, 0)
        int curDir = 0;  // Starting facing north
        int maxDistance = 0;  
        
        // Store obstacles as a set of strings "x,y"
        Set<String> obstacleSet = new HashSet<>(); //"2","4"
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Process each command
        for (int command : commands) {//{4,-1,4,-2,4}

            if (command == -1) {  // Turn right
                curDir = (curDir + 1) % 4;
            } 
            else if (command == -2) {  // Turn left
                curDir = (curDir - 1);
                if(curDir==-1){
                    curDir=3;
                }
//                curDir = (curDir + 3) % 4;  // (curDir - 1 + 4) % 4 to handle negative direction
            } 
            else {  // Move forward

                int[] direction = directions[curDir];//{0,1},{1,0}
                for (int step = 0; step < command; step++) {//4: 0,1,2,3 => 4: 0,1,2,3,4  => 4: 0,1,2,3,4

                    int nextX = x + direction[0];//0
                    int nextY = y + direction[1];//1
                    //{4,0}
                    
                    // Check if the next position is an obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;  
                    }
                    
                    // Update position
                    x = nextX;//0,4
                    y = nextY;//4,0
                }
                
                maxDistance = Math.max(maxDistance, x * x + y * y);//16
            }
        }
        
        return maxDistance;
    }

    public static void main(String[] args) {
        int [] commands = {4,-1,4,-2,4};
        int [][] obstacles = {{2,4}};
        System.out.println(robotSim(commands,obstacles));
    }
}
