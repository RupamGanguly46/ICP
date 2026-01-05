package jan5new;
import java.util.*;

public class LC_2467_Most_Profitable_Path_in_a_Tree {

    class Solution {

        List<Integer>[] graph;
        int[] bobTime;
        int result = Integer.MIN_VALUE;

        public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
            
            int n = amount.length;

            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }

            bobTime = new int[n];
            Arrays.fill(bobTime, Integer.MAX_VALUE);

            dfsBob(bob, -1, 0);

            dfsAlice(0, -1, 0, 0, amount);

            return result;
        }

        private boolean dfsBob(int cur, int parent, int time) {

            if (cur == 0) {
                bobTime[cur] = time;
                return true;
            }

            for (int nbr : graph[cur]) {
                if (nbr == parent) continue;

                if (dfsBob(nbr, cur, time + 1)) {
                    bobTime[cur] = time;
                    return true;
                }
            }

            return false;
        }

        private void dfsAlice(int node, int parent, int time, int income, int[] amount) {

            if (time < bobTime[node]) {
                income += amount[node];
            } else if (time == bobTime[node]) {
                income += amount[node] / 2;
            }

            boolean isLeaf = true;

            for (int nei : graph[node]) {
                if (nei == parent) continue;
                isLeaf = false;
                dfsAlice(nei, node, time + 1, income, amount);
            }

            if (isLeaf) {
                result = Math.max(result, income);
            }
        }
    }

}
