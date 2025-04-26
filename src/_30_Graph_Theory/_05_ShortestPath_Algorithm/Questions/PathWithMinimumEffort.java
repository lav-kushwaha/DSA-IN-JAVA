package _30_Graph_Theory.ShortestPath_Algorithm.Questions;
import java.util.*;

//https://leetcode.com/problems/path-with-minimum-effort/description/
//1631. Path With Minimum Effort
class PathWithMinimumEffort {

    class Tuple{
        int dis, n, m;
        Tuple(int dis, int n, int m) {
            this.dis = dis;
            this.n = n;
            this.m = m;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int [][] dis = new int[n][m];
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        pq.add(new Tuple(0,0,0));

        int [] dr = {-1,0,1,0};
        int [] dc = {0,-1,0,1};

        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int diff = curr.dis;
            int row = curr.n;
            int col = curr.m;

            if(row == n-1 && col == m-1) return diff;

            for(int i = 0; i<4;i++){
               int nrow = row + dr[i];
               int ncol = col + dc[i];

               if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort = Math.max(Math.abs(heights[row][col]-heights[nrow][ncol]),diff);
                    if(newEffort<dis[nrow][ncol]){
                        dis[nrow][ncol] = newEffort;
                        pq.add(new Tuple(newEffort,nrow,ncol));
                    }
               }
            }
        }

        return 0;

    }

    public static void main(String[] args) {

        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        PathWithMinimumEffort obj = new PathWithMinimumEffort();
        int ans = obj.minimumEffortPath(heights);

        System.out.print(ans);
        System.out.println();
    }
}