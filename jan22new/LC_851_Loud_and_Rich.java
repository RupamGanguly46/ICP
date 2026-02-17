package jan22new;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class LC_851_Loud_and_Rich {
    class Solution {
        class Graph{
            HashMap<Integer, HashSet<Integer>> map;
            Graph(int v){
                map = new HashMap<>();
                for(int i=0; i<v; i++) map.put(i, new HashSet<>());
            }
            void addEdge(int v1, int v2){
                map.get(v1).add(v2);
            }
        }
        public void dfs(int node, Graph g, boolean[] vis, Stack<Integer> st){
            vis[node] = true;
            for(int nbr: g.map.get(node)){
                if(!vis[nbr]){
                    dfs(nbr, g, vis, st);
                }
            }
            st.push(node);
        }
        public int[] loudAndRich(int[][] richer, int[] quiet) {
            int n = quiet.length;
            Graph g = new Graph(n);
            for(int[] i: richer){
                g.addEdge(i[1], i[0]);
            }
            boolean[] vis = new boolean[n];
            Stack<Integer> st = new Stack<>();
            for(int i=0; i<n; i++){
                if(!vis[i]){
                    dfs(i, g, vis, st);
                }
            }
            List<Integer> list = new ArrayList<>();
            while(!st.isEmpty()){
                list.add(st.pop());
            }

    /*      
            1 → 3
            2 → 3
            Meaning:
            1 richer than 3
            2 richer than 3
            1 aur 2 ka aapas me koi relation nahi
            So, we find richer people not through topo list, but graph itself
    */

            int[] ans = new int[n];
            for(int i = 0; i < n; i++){
                ans[i] = i;   // har banda pehle khud ko quietest maanta hai
            }

            // richer se poor bharte jaenge jisse ki poorer person ke paas ab tk ka "richer persons me quietest kon hai" ka data available ho
            for (int i = list.size() - 1; i >= 0; i--) {
                int u = list.get(i);
                for (int v : g.map.get(u)) {   // v is richer than u
                    if (quiet[ans[v]] < quiet[ans[u]]) {
                        ans[u] = ans[v];
                    }
                }
            }


            return ans;
        }
    }
}
