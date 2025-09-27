import java.util.*;
public class LC_49_Group_anagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // We use hashmap to collect all anagrams with same letter count
        Map<String, List<String>> ans = new HashMap<>();
        for(String s: strs){
            // for every word we create letter count array
            // this array will be same for multiple anagrams
            int[] counts = new int[26];
            for(char c: s.toCharArray()){
                counts[c - 'a']++;
            }
            // We add # as for mulit-digit numbers we won't be able to distinguish
            // eg. 1 and 10 or 11 and 0 for 110.
            StringBuilder sb = new StringBuilder();
            for(int num: counts){
                sb.append(num).append("#");
            }
            
            // We shall compare strings rather than arrays, thus easier and faster
            String key = sb.toString();
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }
        // ans.values returns a collection, we can use it to construct our array
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args){
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(words));
    }
}