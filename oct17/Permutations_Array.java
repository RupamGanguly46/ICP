package oct17;
import java.util.*;
public class Permutations_Array {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println(helper(arr, ans, new ArrayList<Integer>()));
    }
    private static List<List<Integer>> helper(int[] arr, List<List<Integer>> ans, List<Integer> res){
        if(res.size()==arr.length){
            ans.add(new ArrayList<>(res));
            return ans;
        }
        for(int i=0; i<arr.length; i++){
            if(res.contains(arr[i])) continue;
            res.add(arr[i]);
            helper(arr, ans, res);
            res.remove(res.size()-1);
        }
        return ans;
    }

}
