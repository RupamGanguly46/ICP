import java.util.*;

public class CF_1857_D_Strong_Vertices {
    class Solution1{
        public static class Graph{
            HashMap<Integer, HashSet<Integer>> map;
            
            public Graph(int v){
                map = new HashMap<>();
                for(int i=1; i<=v; i++){
                    map.put(i, new HashSet<>());
                }
            }

            public void addEdge(int v1, int v2){
                map.get(v1).add(v2);
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();

                Graph g = new Graph(n);

                int[] a = new int[n];
                for(int i = 0; i<n; i++) a[i] = sc.nextInt();

                int[] b = new int[n];
                for(int i = 0; i<n; i++) b[i] = sc.nextInt();

                for(int i=0; i<n-1; i++){
                    for(int j=i+1; j<n; j++){
                        if(a[i] - a[j] >= b[i] - b[j]) g.addEdge(i+1, j+1);
                        if(a[j] - a[i] >= b[j] - b[i]) g.addEdge(j+1, i+1);
                    }
                }

                List<Integer> ans = new ArrayList<>();

                for(int i : g.map.keySet()){
                    if(g.map.get(i).size() == n-1) ans.add(i);
                }

                System.out.println(ans.size());
                for(int i=0; i<ans.size() ; i++) System.out.print(ans.get(i) + " ");
                System.out.println();
            }

        }
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();

            int[] a = new int[n];
            for(int i = 0; i<n; i++) a[i] = sc.nextInt();

            int[] b = new int[n];
            for(int i = 0; i<n; i++) b[i] = sc.nextInt();
            
            // Create a-b values array
            int[] val = new int[n];
            for(int i=0; i<n; i++) val[i] = a[i] - b[i];

            // Find maximum value, which is greater than other values, thus respective node wil be strong node, as it will make edge with every other node as it's value is larger
            // ai-aj >= bi-bj is same as ai-bi >= aj-bj
            
            int maxval = val[0];
            for(int i=1; i<n; i++) maxval = Math.max(maxval, val[i]);

            // Check which nodes have maxval, thus they are strong nodes
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<n; i++) if(val[i] == maxval) ans.add(i+1);

            // Print number of strong nodes and which nodes are strong
            System.out.println(ans.size());
            for(int i=0; i<ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            
        }
    }
}
