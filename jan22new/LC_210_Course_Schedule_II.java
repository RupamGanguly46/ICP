package jan22new;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LC_210_Course_Schedule_II {
    class Solution {
        boolean hasCycle;

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

        public void dfs(int node, Graph g, boolean[] visited, Stack<Integer> st, boolean[] visiting){
            visited[node] = true;
            visiting[node] = true;

            for(int nbr: g.map.get(node)){
                if(visiting[nbr]){
                    hasCycle = true;
                    return;
                }
                if(!visited[nbr]){
                    dfs(nbr, g, visited, st, visiting);
                    if(hasCycle) return;
                }
            }

            st.push(node);
            visiting[node] = false;
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            boolean[] visiting = new boolean[numCourses];
            boolean[] visited = new boolean[numCourses];
            Stack<Integer> st = new Stack<>();
            
            Graph g = new Graph(numCourses);
            for(int[] i : prerequisites){
                g.addEdge(i[1], i[0]);
            }

            for(int i=0; i<numCourses; i++){
                if(!visited[i]){
                    dfs(i, g, visited, st, visiting);
                    if(hasCycle) return new int[0];
                }
            }

            int[] ans = new int[numCourses];
            for(int i=0; i<numCourses; i++){
                ans[i] = st.pop();
            }

            return ans;
        }
    }
}
