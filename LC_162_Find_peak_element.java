public class LC_162_Find_peak_element {
    public static int findPeakElement(int[] nums) {
        if(nums.length==1 || nums[0]>nums[1]){
            return 0;
        }
        else if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        else{
            for(int i = 1; i <= nums.length - 2; i++){
                if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                    return i;
                }
            }
        }
        return -1;
    }
    // public static binS(int[] nums){
    //     int left = 0;
    //     int right = nums.length-1;
    //     while(left<right){
    //         int mid = 
    //     }
    // }
}