package jan6new;
import java.util.*;
public class Prims_Algo {
    static class Graph{
        HashMap<Integer, HashMap<Integer, Integer>> map;
        Graph(int v){
            map = new HashMap<>();
            for(int i=0; i<v; i++) map.put(i, new HashMap<>());
        }
        public void addEdge(int v1, int v2, int cost){
            map.get(v1).put(v2, cost);
            map.get(v2).put(v1, cost);
        }
    }
    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int cost;
        Edge(int v1, int v2, int cost){
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge p2){
            return this.cost - p2.cost;
        }
    }
    public void Prims(Graph g, HashSet<Integer> vis, ArrayList<Integer> edges){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0, 0));
        while(!pq.isEmpty()){
            Edge rm = pq.poll();
            if(vis.contains(rm.v2)) continue;
            vis.add(rm.v2);
            edges.add();

        }

    }

}
