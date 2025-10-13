package Day_10;
import java.util.*;

public class LC_131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ps = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ps);
        return ps;
    }

    private void helper(String s, int start, List<String> path, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (isPal(s, start, end - 1)) {
                path.add(s.substring(start, end));
                helper(s, end, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPal(s, left + 1, right - 1);
    }
}
