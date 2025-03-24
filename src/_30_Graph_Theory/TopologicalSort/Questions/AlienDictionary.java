package _30_Graph_Theory.TopologicalSort.Questions;

import java.util.*;

//https://www.geeksforgeeks.org/problems/alien-dictionary/1
//Alien Dictionary
class AlienDictionary {
    private List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
    
    public String findOrder(String[] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char) (it + 'a'));
        }

        return ans.toString();
    }
        public static void main(String[] args) {
            int N = 5, K = 4;
            String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
            AlienDictionary obj = new AlienDictionary();
            String ans = obj.findOrder(dict, N, K);

            for (int i = 0; i < ans.length(); i++) {
                System.out.print(ans.charAt(i) + " ");
            }
            System.out.println();
        }

}

