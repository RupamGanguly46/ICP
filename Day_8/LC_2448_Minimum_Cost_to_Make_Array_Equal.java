package Day_8;
import java.util.*;
public class LC_2448_Minimum_Cost_to_Make_Array_Equal {
    // Approach 1: Brute force, try costs for all targets and return mincost
    public long minCost(int[] nums, int[] cost) {
        int min = nums[0];
        int max = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]<min) min = nums[i];
            if(nums[i]>max) max = nums[i];
        }

        long minCost = Integer.MAX_VALUE;
        for(int i=min; i<=max; i++){
            long curCost = totalCost(nums, cost, i);
            if(curCost<minCost) minCost = curCost;
        }

        return minCost;
    }
    public long totalCost(int[] nums, int[] cost, int target){
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += (long) Math.abs(nums[i]-target) * cost[i]; 
        }
        return sum;
    }

    // Approach 2: Sorting and Weighted Cost
    public long minCost2(int[] nums, int[] cost) {
        
        int[][] arr = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            arr[i][0] = nums[i];
            arr[i][1] = cost[i];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        
        long weightedSum = 0;
        for(int[] i: arr) weightedSum += i[1];
        long halfSum = (weightedSum+1)/2;
        long curSum = 0;
        int median=0;
        for(int i=0; i<arr.length; i++){
            curSum+=arr[i][1];
            if(curSum>=halfSum){
                median = arr[i][0];
                break;
            }
        }

        long steps = 0;
        for(int i=0; i<nums.length; i++){
            steps += (long) Math.abs(arr[i][0]-median)*arr[i][1];
        }
        return steps;
    }

    // Approach 3: Minimizing Cost Function (Using Binary Search)
    public long minCost3(int[] nums, int[] cost) {
        int left = nums[0];
        int right = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i]<left) left = nums[i];
            if(nums[i]>right) right = nums[i];
        }

        // So, left is minimum of nums, and right is maximum of nums, as target can't be out of the given range. Target is the numnber to which all the elements will be changed to in order to make them same.

        // We didn't use left<=right, as mid+1 can go greater than right or Integer.MAX_VALUE!
        while(left<right){
            int mid = left + (right-left)/2;

            // Decreasing (next point less than current point)
            if(totalCost3(nums, cost, mid+1)<totalCost3(nums, cost, mid)){
                left = mid + 1;
            }
            // Increasing or
            // Equal Condition (Flattened convex graph, many equal cost points, we need leftmost cost. )
            else{
                right = mid;
            }
        }

        return totalCost3(nums, cost, left);
    }
    public long totalCost3(int[] nums, int[] cost, int target){
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += (long) Math.abs(nums[i]-target) * cost[i];
        }
        return sum;
    }
}
