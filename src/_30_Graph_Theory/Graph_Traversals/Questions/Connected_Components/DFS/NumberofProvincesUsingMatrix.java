package _30_Graph_Theory.Graph_Traversals.Questions.Connected_Components.DFS;

//https://leetcode.com/problems/number-of-provinces/
//547. Number of Provinces
//APPROACH : DFS

class NumberofProvincesUsingMatrix {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        boolean[] visited = new boolean[isConnected.length];

        for(int i = 0; i<isConnected.length;i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected, visited, i);
            }
        }
        return provinces;
    }

    //dfs
    private void dfs(int[][] isConnected, boolean[] visited, int i){
        visited[i] = true;

        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(isConnected,visited,j);
            }
        }
    }
}