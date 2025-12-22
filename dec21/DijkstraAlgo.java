package dec21;
import java.util.*;
public class DijkstraAlgo {
    public static class Graph{
        HashMap<Integer, HashMap<Integer, Integer>> map;

        Graph(int v){
            map = new HashMap<>();

            for(int i=0; i<v; i++){
                map.put(i, new HashMap<>());
            }
        }

        public void addEdge(int v1, int v2, int dis){
            map.get(v1).put(v2, dis);
            map.get(v2).put(v1, dis);
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

    public static void ShortestDistances(int src, Graph g){
        HashMap<Integer, Integer> SD = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.pathdis - b.pathdis
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

        System.out.print(SD);
    }

    public static void main(String[] args){
        Graph g = new Graph(6);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 4);

        g.addEdge(1, 2, 1);
        g.addEdge(1, 3, 7);

        g.addEdge(2, 4, 3);

        g.addEdge(4, 3, 2);

        g.addEdge(3, 5, 1);
        g.addEdge(4, 5, 5);


        ShortestDistances(0, g);
    }
}
