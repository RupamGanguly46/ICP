package dec21;

import java.util.HashSet;
import java.util.Set;

public class LC_1763_Longest_Nice_Substring {
    class Solution {
        public String longestNiceSubstring(String s) {
            if (s.length() < 2) return "";

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (set.contains(Character.toUpperCase(c)) &&
                    set.contains(Character.toLowerCase(c))) {
                    continue;
                }

                String sub1 = longestNiceSubstring(s.substring(0, i));
                String sub2 = longestNiceSubstring(s.substring(i + 1));

                return sub1.length() >= sub2.length() ? sub1 : sub2;
            }

            return s;
        }
    }
}
