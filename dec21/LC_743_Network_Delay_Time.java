package dec21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_743_Network_Delay_Time {
    // Dijkstra Algo
    class Solution1 {
        public static class Graph{
            HashMap<Integer, HashMap<Integer, Integer>> map;

            Graph(int v){
                map = new HashMap<>();

                for(int i=1; i<=v; i++){
                    map.put(i, new HashMap<>());
                }
            }

            public void addEdge(int v1, int v2, int dis){
                map.get(v1).put(v2, dis);
                // map.get(v2).put(v1, dis);
            }
        }

        public static class Pair{
            int node;
            int pathdis;

            Pair(int node, int pathdis){
                this.node = node;
                this.pathdis = pathdis;
            }
        }

        public static void ShortestDistances(int src, Graph g, HashMap<Integer, Integer> SD){
            Set<Integer> visited = new HashSet<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.pathdis, b.pathdis)
            );

            pq.add(new Pair(src, 0));

            while(!pq.isEmpty()){

                Pair rem = pq.poll();

                if(visited.contains(rem.node)){
                    continue;
                }

                visited.add(rem.node);

                SD.put(rem.node, rem.pathdis);

                for(int nbr: g.map.get(rem.node).keySet()){
                    if(!visited.contains(nbr)){
                        int edgedis = g.map.get(rem.node).get(nbr);
                        pq.add(new Pair(nbr, rem.pathdis + edgedis));
                    }
                }
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            Graph g = new Graph(n);
            for(int i[]: times){
                g.addEdge(i[0], i[1], i[2]);
            }

            HashMap<Integer, Integer> SD = new HashMap<>();

            ShortestDistances(k, g, SD);

            int ans = 0;
            for(int node: g.map.keySet()){
                if(!SD.containsKey(node)){
                    return -1;
                }
                // Maximum as we want to take enough time for signal to complete reaching all nodes, not just the shortest time node.
                ans = Math.max(SD.get(node), ans);
            }

            return ans;
        }
    }    

    // Bellman-Ford Algo
    class Solution {
        static class Graph{
            HashMap<Integer, HashMap<Integer, Integer>> map;

            Graph(int v){
                map = new HashMap<>();
                for(int i=1; i<=v; i++) map.put(i, new HashMap<>());
            }

            void addEdge(int v1, int v2, int cost){
                map.get(v1).put(v2, cost);
            }
        }

        public void bellman(Graph g, HashMap<Integer, Integer> dis){
            int V = g.map.size();
            for(int i=0; i<V-1; i++){
                for(int u: g.map.keySet()){
                    if(dis.get(u) == Integer.MAX_VALUE) continue;
                    for(int v: g.map.get(u).keySet()){
                        int wt = g.map.get(u).get(v);
                        if(dis.get(u) + wt < dis.get(v)){
                            dis.put(v, dis.get(u)+wt);
                        }
                    }
                }
            }
        }

        public int networkDelayTime(int[][] times, int n, int k) {
            Graph g = new Graph(n);
            for(int[] t: times){
                g.addEdge(t[0], t[1], t[2]);
            }

            HashMap<Integer, Integer> dis = new HashMap<>();
            for(int i=1; i<=n; i++){
                dis.put(i, Integer.MAX_VALUE);
            }
            dis.put(k, 0);

            bellman(g, dis);

            int ans = Integer.MIN_VALUE;
            for(int i: dis.keySet()){
                if(dis.get(i)==Integer.MAX_VALUE) return -1;
                ans = Math.max(ans, dis.get(i));
            }
            return ans;
        }
    }

    // Most Optimized
    class Solution3 {
        public int networkDelayTime(int[][] times, int n, int k) {

            List<int[]>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

            for (int[] t : times) {
                graph[t[0]].add(new int[]{t[1], t[2]});
            }

            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[1] - b[1]);

            dist[k] = 0;
            pq.add(new int[]{k, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int node = cur[0];
                int d = cur[1];

                if (d > dist[node]) continue;

                for (int[] e : graph[node]) {
                    int nd = d + e[1];
                    if (nd < dist[e[0]]) {
                        dist[e[0]] = nd;
                        pq.add(new int[]{e[0], nd});
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) return -1;
                ans = Math.max(ans, dist[i]);
            }

            return ans;
        }
    }

}
