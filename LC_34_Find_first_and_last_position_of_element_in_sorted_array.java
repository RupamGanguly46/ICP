public class LC_34_Find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                int i = mid;
                while(i>=0 && nums[i]==target){
                    i--;
                }
                int j = mid;
                while(j<nums.length && nums[j]==target){
                    j++;
                }
                ans[0]=i+1;
                ans[1]=j-1;
                return ans;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}