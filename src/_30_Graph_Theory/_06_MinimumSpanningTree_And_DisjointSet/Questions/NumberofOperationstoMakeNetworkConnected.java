package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.Questions;

import java.util.*;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/
//1319. Number of Operations to Make Network Connected

class NumberofOperationstoMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        DisjointSett ds = new DisjointSett(n);
        int extra = 0;
        for(int [] edge : connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findUPar(u)==ds.findUPar(v)){
                extra++;
            }else{
                ds.unionByRank(u,v);
            }
        }

        //count component.
         int cntC = 0;
         for(int i=0;i<n;i++){
             if (ds.parent.get(i) == i) cntC++;
         }

        int ans  = cntC - 1;
        if(extra>=ans) return ans;
        return -1;
    }
}
class DisjointSett {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSett(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

