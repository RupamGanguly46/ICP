package dec30;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class gfg_minimum_multiplications_to_reach_end {
    class Solution {
        int minimumMultiplications(int[] arr, int start, int end) {
            int mod = 100000;

            // Distance array
            int[] dist = new int[mod];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{start, 0});
            dist[start] = 0;

            while (!q.isEmpty()) {
                int[] rm = q.poll();
                int node = rm[0];
                int steps = rm[1];

                // If reached end
                if (node == end) {
                    return steps;
                }

                for (int val : arr) {
                    int newNode = (node * val) % mod;

                    if (steps + 1 < dist[newNode]) {
                        dist[newNode] = steps + 1;
                        q.offer(new int[]{newNode, steps + 1});
                    }
                }
            }

            return -1;
        }
    }

}
