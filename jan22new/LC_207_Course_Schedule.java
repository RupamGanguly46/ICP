package jan22new;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LC_207_Course_Schedule {
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
        boolean hasCycle = false;
        public boolean canFinish(int n, int[][] prerequisites) {
            Graph g = new Graph(n);
            for(int[] i: prerequisites){
                g.addEdge(i[1], i[0]);
            }
            
            boolean[] visiting = new boolean[n];
            boolean[] visited = new boolean[n];
            Stack<Integer> st = new Stack<>();
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    dfs(i, g, visited, visiting, st);
                    if(hasCycle) return false;
                }
            }
            return true;
        }
        void dfs(int node, Graph g, boolean[] visited, boolean[] visiting, Stack<Integer> st){
            visited[node] = true;
            visiting[node] = true;

            for(int nbr: g.map.get(node)){
                if(visiting[nbr]){
                    hasCycle = true;
                    return;
                }
                if(!visited[nbr]){
                    dfs(nbr, g, visited, visiting, st);
                    if(hasCycle) return;
                }
            }

            visiting[node] = false;
            st.push(node);
        }

    }
}
