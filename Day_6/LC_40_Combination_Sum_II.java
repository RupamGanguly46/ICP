package Day_6;
import java.util.*;
public class LC_40_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void solve(int[] arr, int target, List<List<Integer>> ans, List<Integer> res, int idx){
        if(target==0){
            // Adds new copy instead of same reference of res, else, ans will contain all same res
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = idx; i < arr.length; i++){
            if(i>idx && arr[i]==arr[i-1]) continue;
            if(arr[i]<=target){
                res.add(arr[i]);
                solve(arr, target-arr[i], ans, res, i+1);
                res.remove(res.size()-1);
            }
            else{break;}
        }
    }
}