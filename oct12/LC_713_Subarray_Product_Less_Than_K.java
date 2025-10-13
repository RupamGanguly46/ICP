package oct12;

public class LC_713_Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, prod=1, count = 0;
        for(int right=0; right<nums.length; right++){
            prod*=nums[right];
            while(prod>=k && left<=right){
                prod/=nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}