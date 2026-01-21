package jan21new;

public class LC_1835_Find_XOR_Sum_of_All_Pairs_Bitwise_AND {
    class Solution {
        public int getXORSum(int[] arr1, int[] arr2) {
            return xorer(arr1) & xorer(arr2);
        }
        public int xorer(int[] arr){
            int xor = 0;
            for(int i : arr) xor ^= i;
            return xor;
        }
    }
}
