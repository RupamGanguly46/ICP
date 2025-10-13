package oct12;

public class LC_26_Remove_Duplicates_from_Sorted_Array {
    
    public int removeDuplicatesRecursive(int[] nums) {
        if(nums.length==0) return 0;
        return remove(nums, 0, 0);
    }
    private int remove(int[] nums, int see, int put){
        if(see==nums.length-1){
            nums[put] = nums[see];
            return put+1;
        }
        if(nums[see]!=nums[see+1]){
            nums[put] = nums[see];
            return remove(nums, see+1, put+1);
        }
        else{
            return remove(nums, see+1, put);
        }
    }

    public int removeDuplicates(int[] nums) {
        // We can't return j = 1 for empty nums. So we handle this edge case directly.
        if(nums.length == 0){
            return 0;
        }
        
        // j points to the locations where unique number is to be filled from left to right, and then in the end it gives number of unique elements.
        // i searches for unique numbers
        int i = 1;
        int j = 1;
        while(i < nums.length){
            if(nums[i] == nums[i-1]){
                i++;
            }
            else{
                nums[j] = nums[i];
                j++;
                i++;
            }
        }
        return j;
    }
}