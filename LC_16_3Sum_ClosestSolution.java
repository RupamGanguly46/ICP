import java.util.Arrays;

public class LC_16_3Sum_ClosestSolution {
    public static int threeSumClosest(int[] nums, int target) {
        int reqSum = Integer.MAX_VALUE - 1;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int left = i+1, right = nums.length-1;
            while(right>left){
                int currentSum = nums[i]+nums[left]+nums[right];
                if(Math.abs(currentSum-target)<Math.abs(reqSum-target)){
                    reqSum = currentSum;
                }
                if(currentSum<target){
                    left++;
                }
                else if(currentSum > target){
                    right--;
                }
                else{
                    return currentSum;
                }
            }
        }
        return reqSum;
    }
}
