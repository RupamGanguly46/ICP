package Day_6;
import java.util.*;
public class LC_90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, ans, new ArrayList<>());
        return ans;
    }
    public void solve(int[] arr, int idx, List<List<Integer>> ans, List<Integer> res){
        ans.add(new ArrayList<>(res));
        for(int i=idx; i<arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            res.add(arr[i]);
            solve(arr, i+1, ans, res);
            res.remove(res.size()-1);
        }
    }

}