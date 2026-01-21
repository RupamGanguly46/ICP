package jan21new;

public class LC_2683_Neighboring_Bitwise_XOR {
    class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int xor = 0;
            for(int v: derived){
                xor ^= v;
            }
            return xor == 0;
        }
    }
}
