package dec28;

public class LC_3255_Find_the_Power_of_K_Size_Subarrays_II {
    // Fastest
    class Solution1{
        public int[] resultsArray(int[] nums, int k){
            if(k == 1) return nums;

            int[] result = new int[nums.length - k + 1];
            for(int i = 0; i < result.length; i++) result[i] = -1;

            int start = 0; int prev = nums[0] - 1;
            for(int end = 0; end<nums.length; end++){
                if(nums[end] - 1 != prev){
                    prev = nums[end]; start = end;
                    continue;
                }
                if(end - start + 1 >= k){
                    result[end - k + 1] = nums[end];
                }
                prev = nums[end];
            }
            
            return result;
        }
    }

    // Paired
    class Solution2 {
        public int[] resultsArray(int[] nums, int k) {
            int n = nums.length;
            // Count of true consecutive pairs
            // True is when a<b in (a,b) by exactly 1 (consecutive)
            int t = 0; 
            
            // First window
            for (int i = 1; i < k; i++) {
                if (nums[i - 1] + 1 == nums[i]) {
                    t++;
                }
            }

            // Total number of possible subarrays of length k is n-k+1
            int[] ans = new int[n - k + 1];
            // For tracking index in ans[]
            int idx = 0; 

            int start = 1, end = k;

            // Sliding windows
            while(end < n){
                // eg. for windowsize k=3, maxpairs = 2. If all pairs are true..
                // Max of sorted ascending subarray is the last element.
                if(t == k-1){
                    ans[idx++] = nums[end-1];
                }
                else{
                    ans[idx++] = -1;
                }

                // Remove left pair
                if(nums[start - 1] + 1 == nums[start]){
                    t--;
                }

                // Add right pair
                if(nums[end - 1] + 1 == nums[end]){
                    t++;
                }

                start++;
                end++;
            }

            // Last window
            if(t == k - 1){
                ans[idx] = nums[n - 1];
            }
            else{
                ans[idx] = -1;
            }

            return ans;
        }
    }
}
