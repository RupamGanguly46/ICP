package dec28;
// Sliding Window
public class LC_3095_Shortest_Subarray_With_OR_at_Least_K_I {
    // Using Bitmasks
    class Solution1 {
        // orVal is an array of size 1 as we can't modify integer using functions.
        // orVal[0] is the result of all OR operations in the window.
        // We maintain setBitNumCount as we need to be able to remove numbers from window, else we are simply performing OR operations.
        public int minimumSubarrayLength(int[] nums, int k) {
            int[] orVal = {0};
            int minLength = Integer.MAX_VALUE;
            int[] setBitNumCount = new int[32];
            for(int start=0, end=0; end<nums.length; end++){
                add(setBitNumCount, orVal, nums[end]);
                if(orVal[0] < k) continue; // Keep adding, expanding window
                
                while(start<=end && orVal[0]>=k){
                    minLength = Math.min(minLength, end-start+1);
                    remove(setBitNumCount, orVal, nums[start]);
                    start++;
                }
            }
            return minLength==Integer.MAX_VALUE ? -1 : minLength;
        }

        // if ith bit of number is 0/unset, we don't increase count of set ith bit
        // if ith bit of number is 1/set, we increase count of set ith bit by 1
        // We find if ith bit of number is set or not by performing and operation with say i=2 then 000... 00000100, which can either give 0000... if unset, else it's set.
        public void add(int[] setBitNumCount, int[] orVal, int n){
            orVal[0] = orVal[0] | n;
            for(int i=0; i<32; i++){
                setBitNumCount[i] += (n & (1 << i)) == 0 ? 0 : 1;
            }
        }

        // If set bit count is 0, we need to remove that bit from result, so, we perform AND operation with eg. 111...11110111 to remove i=3 bit, and keep rest of the number as it is.
        public void remove(int[] setBitNumCount, int[] orVal, int n){
            for(int i=0; i<32; i++){
                setBitNumCount[i] += (n & (1 << i)) == 0 ? 0 : -1;
                if(setBitNumCount[i] == 0){
                    orVal[0] = orVal[0] & ~(1 << i);
                }
            }
        }
    }

    class Solution2 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        for(int start=0; start<nums.length; start++){
            if(nums[start]>=k){
                minLength=1;
                break;
            }
            // 0 OR n is n
            int orVal = 0;

            for(int end=start; end<nums.length; end++){
                orVal |= nums[end];
                if(orVal>=k){
                    minLength = Math.min(minLength, end-start+1);
                    break;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}


}
