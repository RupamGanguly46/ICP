package march27new;

public class GFG_max_sum_subarray_of_size_k5313__1 {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        
        max = Math.max(max, sum);
        
        for(int i=k; i<arr.length; i++){
            sum += arr[i];
            sum -= arr[i - k];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}
