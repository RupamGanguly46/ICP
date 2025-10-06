package Day_8;
import java.util.*;
public class LC_462_Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int moves = 0;
        for(int i: nums){
            moves+=Math.abs(nums[nums.length/2]-i);
        }
        return moves;
    }
}