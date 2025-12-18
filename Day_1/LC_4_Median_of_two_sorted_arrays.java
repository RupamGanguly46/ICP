import java.util.*;
public class LC_4_Median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];
        int left = 0, right = 0, i = 0;
        while(left<m && right<n){
            if(nums1[left]<nums2[right]){
                nums[i] = nums1[left];
                left++;
            }
            else{
                nums[i] = nums2[right];
                right++;
            }
            i++;
        }
        while(left<m){
            nums[i] = nums1[left];
            i++;
            left++;
        }
        while(right<n){
            nums[i] = nums2[right];
            i++;
            right++;
        }
        System.out.println(Arrays.toString(nums));
        if((m+n)%2==0){
            return (nums[(m+n)/2] + nums[((m+n)/2)-1])/2.0;
        }
        else{
            return nums[(m+n-1)/2];
        }
    }
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1, 3}, new int[] {2}));
    }
}