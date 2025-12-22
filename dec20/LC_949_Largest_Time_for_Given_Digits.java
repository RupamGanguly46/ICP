package dec20;

public class LC_949_Largest_Time_for_Given_Digits {
    class Solution {

        boolean[] used = new boolean[4];
        String best = "";

        public String largestTimeFromDigits(int[] arr) {
            dfs(arr, 0, new StringBuilder());
            return best;
        }

        private void dfs(int[] arr, int pos, StringBuilder curr) {

            if (pos == 4) {
                int hour = (curr.charAt(0)-'0')*10 + (curr.charAt(1)-'0');
                int min  = (curr.charAt(2)-'0')*10 + (curr.charAt(3)-'0');

                if (hour < 24 && min < 60) {
                    String time = String.format("%02d:%02d", hour, min);
                    best = time.compareTo(best) > 0 ? time : best;
                }
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (used[i]) continue;

                used[i] = true;
                curr.append(arr[i]);

                dfs(arr, pos + 1, curr);

                curr.deleteCharAt(curr.length() - 1);
                used[i] = false;
            }
        }
    }
}
