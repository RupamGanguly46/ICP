package jan7new;
import java.util.*;
public class LC_1976_Number_of_Ways_to_Arrive_at_Destination {
    class Solution2 {
        int MOD = 1000000007;
        class Graph{
            HashMap<Integer, HashMap<Integer, Integer>> map;
            Graph(int v){
                map = new HashMap<>();
                for(int i=0; i<v; i++) map.put(i, new HashMap<>());
            }
            void addEdge(int v1, int v2, int time){
                map.get(v1).put(v2, time);
                map.get(v2).put(v1, time);
            }
        }
        class Pair implements Comparable<Pair>{
            int node;
            long pathtime;
            Pair(int node, long pathtime){
                this.node = node;
                this.pathtime = pathtime;
            }
            @Override
            public int compareTo(Pair p2){
                return Long.compare(this.pathtime, p2.pathtime);
            }

        }
        public int countPaths(int n, int[][] roads) {
            Graph g = new Graph(n);
            for(int[] arr : roads){
                g.addEdge(arr[0], arr[1], arr[2]);
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.offer(new Pair(0, 0));

            long[] SD = new long[n];
            Arrays.fill(SD, Long.MAX_VALUE);
            SD[0] = 0L;

            long[] ways = new long[n];
            ways[0] = 1L;

            while(!pq.isEmpty()){
                Pair rm = pq.poll();

                if(SD[rm.node] < rm.pathtime) continue;

                for(int nbr : g.map.get(rm.node).keySet()){
                    long newtime = rm.pathtime + g.map.get(rm.node).get(nbr);
                    if(newtime < SD[nbr]){
                        SD[nbr] = newtime;
                        ways[nbr] = ways[rm.node];
                        pq.add(new Pair(nbr, newtime));
                    }
                    else if(newtime == SD[nbr]){
                        ways[nbr] = ( ways[nbr] + ways[rm.node] ) % MOD; 
                    }
                }
            }
            return (int) ways[n-1];
        }
    }



    
    class Solution {
        private static final int MOD = 1000000007;

        public int countPaths(int n, int[][] roads) {

            long INF = Long.MAX_VALUE / 4;

            long[][] g = new long[n][n];
            for (long[] row : g)
                Arrays.fill(row, INF);

            for (int[] r : roads) {
                int x = r[0], y = r[1], w = r[2];
                g[x][y] = Math.min(g[x][y], w); // handle multiple edges
                g[y][x] = Math.min(g[y][x], w);
            }

            long[] dist = new long[n];
            Arrays.fill(dist, INF);
            dist[0] = 0;

            boolean[] done = new boolean[n];

            int[] ways = new int[n];
            ways[0] = 1; // ⭐ CRITICAL

            for (int iter = 0; iter < n; iter++) {

                int x = -1;
                for (int i = 0; i < n; i++) {
                    if (!done[i] && (x == -1 || dist[i] < dist[x])) {
                        x = i;
                    }
                }

                if (x == -1) break; // safety
                done[x] = true;

                for (int i = 0; i < n; i++) {
                    if (dist[x] + g[x][i] < dist[i]) {
                        dist[i] = dist[x] + g[x][i];
                        ways[i] = ways[x];
                    } 
                    else if (dist[x] + g[x][i] == dist[i]) {
                        ways[i] = (ways[i] + ways[x]) % MOD;
                    }
                }
            }

            return ways[n - 1];
        }
    }

}
