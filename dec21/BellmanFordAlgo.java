package dec21;
import java.util.*;
public class BellmanFordAlgo {
    public static class Graph{
        HashMap<Integer, HashMap<Integer, Integer>> map;

        Graph(int v){
            map = new HashMap<>();
            for(int i=0; i<v; i++){
                map.put(i, new HashMap<>());
            }
        }

        public void addEdge(int v1, int v2, int cost){
            map.get(v1).put(v2, cost);
        }
    }

    public static void bellman(int src, Graph g, HashMap<Integer, Integer> dis){
        int V = g.map.size();
        
        for(int i=0; i<V; i++){
            dis.put(i, Integer.MAX_VALUE);
        }
        dis.put(src, 0);

        for(int j=0; j<V-1; j++){
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

        for(int u: g.map.keySet()){
            for(int v: g.map.get(u).keySet()){
                int wt = g.map.get(u).get(v);
                if(dis.get(u)+wt < dis.get(v)){
                    System.out.println("Negative Cycle Found");
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        HashMap<Integer, Integer> dis = new HashMap<>();
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 5);
        g.addEdge(1, 2, -3);
        g.addEdge(2, 3, 4);
        g.addEdge(1, 3, 6);
        g.addEdge(3, 4, 2);
        bellman(0, g, dis);
        System.out.println(dis);

        Graph g2 = new Graph(3);
        HashMap<Integer, Integer> dis2 = new HashMap<>();
        g2.addEdge(0, 1, 1);
        g2.addEdge(1, 2, -2);
        g2.addEdge(2, 0, -2);
        bellman(0, g2, dis2);
        System.out.println(dis2);   

    }
}
