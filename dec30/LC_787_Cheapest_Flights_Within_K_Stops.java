package dec30;
import java.util.*;
public class LC_787_Cheapest_Flights_Within_K_Stops {
    class Solution {
        static class Graph {
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

            Graph(int n) {
                for (int i = 0; i < n; i++) {
                    map.put(i, new HashMap<>());
                }
            }

            void addEdge(int u, int v, int cost) {
                map.get(u).put(v, cost);
            }
        }

        static class Pair {
            int node;
            int cost;
            int flights;

            Pair(int node, int cost, int flights) {
                this.node = node;
                this.cost = cost;
                this.flights = flights;
            }
        }

        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            // Build graph using HashMap
            Graph g = new Graph(n);
            for (int[] f : flights) {
                g.addEdge(f[0], f[1], f[2]);
            }

            // dist[node][flights] = min cost to reach node using flights flights
            int[][] dist = new int[n][k + 2];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.cost - b.cost);

            pq.offer(new Pair(src, 0, 0));
            dist[src][0] = 0;

            while (!pq.isEmpty()) {

                Pair cur = pq.poll();

                if (cur.node == dst) {
                    return cur.cost;
                }

                if (cur.flights == k + 1) continue;

                for (int nbr : g.map.get(cur.node).keySet()) {
                    int edgeCost = g.map.get(cur.node).get(nbr);
                    int newCost = cur.cost + edgeCost;

                    if (newCost < dist[nbr][cur.flights + 1]) {
                        dist[nbr][cur.flights + 1] = newCost;
                        pq.offer(new Pair(nbr, newCost, cur.flights + 1));
                    }
                }
            }

            return -1;
        }
    }

}
