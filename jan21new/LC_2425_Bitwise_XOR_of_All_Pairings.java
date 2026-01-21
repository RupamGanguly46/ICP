package jan21new;

public class LC_2425_Bitwise_XOR_of_All_Pairings {
    class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            if(n1%2==0 && n2%2==0){
                return 0;
            }
            int xor1 = xorer(nums1);
            int xor2 = xorer(nums2);
            if(n1%2!=0 && n2%2!=0){
                return xor1 ^ xor2;
            }
            else if(n1%2==0){
                return xor1;
            }
            else{
                return xor2;
            }
        }
        public int xorer(int[] arr){
            int xor = 0;
            for(int i: arr) xor ^= i;
            return xor;
        }
    }
}
