package Day_7;
import java.util.*;
public class LC_216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        solve(arr, k, target, 0, ans, new ArrayList<>());
        return ans;
    }
    public void solve(int[] arr, int k, int target, int idx, List<List<Integer>> ans, List<Integer> res){
        if(target==0 && res.size()==k){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i = idx; i < arr.length; i++){
            if(arr[i]<=target && res.size()<k){
                res.add(arr[i]);
                solve(arr, k, target - arr[i], i+1, ans, res);
                res.remove(res.size()-1);
            }
            else{
                break;
            }
        }
    }
}