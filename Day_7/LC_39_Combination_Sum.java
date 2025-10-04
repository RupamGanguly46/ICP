package Day_7;
import java.util.*;
public class LC_39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        // Arrays.sort(candidates);
        f(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void f(int[] arr, int target, List<List<Integer>> ans, List<Integer> res, int idx){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=idx; i<arr.length; i++){
            // if(i>idx && arr[i]==arr[i-1]) continue;
            if(target>=arr[i]){
                res.add(arr[i]);
                f(arr, target-arr[i], ans, res, i);
                // f(arr, target-arr[i], ans, res, i+1);

                res.remove(res.size()-1);
            }
        }
    }   
}
// The commented section: Used when we need to skip duplicates, and can not select same number again
// Also we do not need to sort here.
// Here we wont break as it is not sorted that the next numbers would be larger, but the next numbers can also be smaller, 
// So, we should not break searching