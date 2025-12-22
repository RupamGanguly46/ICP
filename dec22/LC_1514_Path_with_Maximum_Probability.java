package dec22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC_1514_Path_with_Maximum_Probability {
    class Solution {
        static class Graph{
            HashMap<Integer, HashMap<Integer, Double>> map;
            Graph(int v){
                map = new HashMap<>();
                for(int i=0; i<v; i++){
                    map.put(i, new HashMap<>());
                }
            }
            void addEdge(int v1, int v2, double prob){
                map.get(v1).put(v2, prob);
                map.get(v2).put(v1, prob);
            }
        }
        static class Pair{
            int node;
            double pathprob;
            Pair(int node, double pathprob){
                this.node = node;
                this.pathprob = pathprob;
            }
        }
        public void LargestProbs(int src, Graph g, HashMap<Integer, Double> LP){
            Set<Integer> vis = new HashSet<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b) -> Double.compare(b.pathprob, a.pathprob)
            );
            pq.offer(new Pair(src, 1));

            while(!pq.isEmpty()){
                Pair rem = pq.poll();

                if(vis.contains(rem.node)) continue;

                vis.add(rem.node);

                LP.put(rem.node, rem.pathprob);

                for(int nbr: g.map.get(rem.node).keySet()){
                    if(!vis.contains(nbr)){
                        double currprob = g.map.get(rem.node).get(nbr);
                        pq.offer(new Pair(nbr, currprob * rem.pathprob));
                    }
                }
            }
            
        }
        public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

            Graph g = new Graph(n);
            for(int i=0; i<edges.length; i++){
                g.addEdge(edges[i][0], edges[i][1], succProb[i]);
            }

            HashMap<Integer, Double> LP = new HashMap<>();

            LargestProbs(start_node, g, LP);
            return LP.containsKey(end_node) ? LP.get(end_node) : 0;
        }
    }
}
