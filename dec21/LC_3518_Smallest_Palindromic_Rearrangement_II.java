package dec21;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_3518_Smallest_Palindromic_Rearrangement_II {
    public static String kthPal(String s, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        permut(arr, used, new StringBuilder(), pq);

        String ans = ""; 
        for(int i=0; i<k; i++){
            ans = pq.poll();
        }

        return ans==null ? "" : ans;
    }

    public static void permut(char[] arr, boolean[] used, StringBuilder sb, PriorityQueue pq) {
        if (sb.length() == arr.length) {
            String res = sb.toString();
            if(isPal(res)) pq.offer(res);
            return;
        }

        for (int i=0; i<arr.length; i++) {
            if (used[i]) continue;
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            sb.append(arr[i]);
            permut(arr, used, sb, pq);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static boolean isPal(String s){
        int i=0, j=s.length()-1;
        while(i<s.length()/2){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        int k = 2;

        System.out.print(kthPal(s,k));

    }
}
