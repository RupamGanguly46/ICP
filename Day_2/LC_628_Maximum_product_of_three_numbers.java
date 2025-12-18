package Day_2;
import java.util.*;
public class LC_628_Maximum_product_of_three_numbers {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[0]*nums[1]*nums[n-1]);
    }
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[] {-100, -90, -30, -5}));
        System.out.println(maximumProduct(new int[] {-100, -90, 2, 5}));
        System.out.println(maximumProduct(new int[] {-100, -90, 92, 95, 100}));
        // -100*-90*100 vs 100*95*92
    }
}