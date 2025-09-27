public class LC_33_Search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        int targetIdx = -1;
        int k = 0;
        int decider = -1;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]<nums[i]){
                k = nums.length - (i+1);
                decider = i+1;
                break;
            }
        }

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==target){
                targetIdx = i;
                break;
            }
        }
        if(targetIdx<decider){
            return k + targetIdx;
        }
        else{
            return targetIdx - k - 1;
        }

    }
}
