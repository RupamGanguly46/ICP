public class LC_88_Merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m];
        for(int i=0; i<m; i++){
            nums3[i] = nums1[i];
        }
        int left = 0, right = 0, i = 0;
        while(left < m && right < n){
            if(nums3[left]<nums2[right]){
                nums1[i]=nums3[left];
                left++;
            }
            else{
                nums1[i]=nums2[right];
                right++;
            }
            i++;
        }
        while(left<m){
            nums1[i] = nums3[left];
            left++;
            i++;
        }
        while(right<n){
            nums1[i] = nums2[right];
            right++;
            i++;
        }
    }
}