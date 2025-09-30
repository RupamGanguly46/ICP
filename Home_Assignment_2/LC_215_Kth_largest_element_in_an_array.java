package Home_Assignment_2;
import java.util.*;
public class LC_215_Kth_largest_element_in_an_array{
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}