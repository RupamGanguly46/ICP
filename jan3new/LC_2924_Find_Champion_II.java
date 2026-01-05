package jan3new;

public class LC_2924_Find_Champion_II {
    class Solution {
        public int findChampion(int n, int[][] edges) {

            boolean[] lost = new boolean[n];
            int candidates = n;

            // Mark losing teams
            for (int[] e : edges) {
                if (!lost[e[1]]) {
                    lost[e[1]] = true;
                    candidates--;
                }
            }

            // Exactly one team never lost
            if (candidates == 1) {
                for (int i = 0; i < n; i++) {
                    if (!lost[i]) return i;
                }
            }

            return -1;
        }
    }

}
