package _30_Graph_Theory._06_MinimumSpanningTree_And_DisjointSet.Questions;

import java.util.*;

class Disjoint_Set {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public Disjoint_Set(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
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

public class AccountMerge {
    public static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();
        Disjoint_Set ds = new Disjoint_Set(n);
        HashMap<String, Integer> mapMailNode = new HashMap<>();

        // Step 1: Map each email to an account index and union if shared
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) {
                    mapMailNode.put(mail, i);
                } else {
                    ds.unionBySize(i, mapMailNode.get(mail));
                }
            }
        }

        // Step 2: Merge emails by their ultimate parent
        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<>();

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        // Step 3: Combine and format final result
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // username
            temp.addAll(mergedMail[i]);
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();

        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));

        ArrayList<ArrayList<String>> result = accountsMerge(accounts);

        for (ArrayList<String> account : result) {
            System.out.println(account);
        }
    }
}
