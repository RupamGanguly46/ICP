package Home_Assignment_10;
import java.util.*;

public class LC_85_Maximal_Rectangle {

class Solution {
    
    public int[] nse(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans, n);

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int[] pse(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public int largestRectangle(int[] heights) {
        int n = heights.length;
        int[] next = nse(heights);
        int[] prev = pse(heights);

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int width = next[i] - prev[i] - 1;
            maxi = Math.max(maxi, heights[i] * width);
        }
        return maxi;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            maxi = Math.max(maxi, largestRectangle(heights));
        }
        return maxi;
    }
}
}
