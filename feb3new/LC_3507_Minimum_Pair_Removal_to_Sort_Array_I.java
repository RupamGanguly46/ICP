import java.util.ArrayList;
import java.util.List;

public class LC_3507_Minimum_Pair_Removal_to_Sort_Array_I {
    class Solution {
        public int minimumPairRemoval(int[] nums) {
            int count = 0 ;
            
            List<Integer> arr = new ArrayList<>();
            for(int i=0; i<nums.length; i++) arr.add(nums[i]);

            while(!isSorted(arr) && !arr.isEmpty()){
                int[] min = minSumPairIdx(arr);
                arr.set(min[0], min[1]);
                arr.remove(min[0]+1);
                count++;
            }
            return count;
        }
        public boolean isSorted(List<Integer> arr){
            for(int i=0; i<arr.size()-1; i++){
                if(arr.get(i) > arr.get(i+1)){
                    return false;
                }
            }
            return true;
        }
        public int[] minSumPairIdx(List<Integer> arr){
            int[] min = {-1, Integer.MAX_VALUE};

            for(int i=0; i < arr.size() - 1; i++){
                int sum = arr.get(i) + arr.get(i+1);
                if(sum < min[1]){
                    min[1] = sum;
                    min[0] = i;
                }
            }
            return min;
        }
    }
}
