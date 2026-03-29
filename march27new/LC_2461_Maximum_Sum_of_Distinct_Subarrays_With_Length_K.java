package march27new;

import java.util.HashMap;

public class LC_2461_Maximum_Sum_of_Distinct_Subarrays_With_Length_K {
    class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int dups = 0;
        long sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++){
            if(!map.containsKey( arr[i] )){
                map.put(arr[i], 0);
            }

            map.put(arr[i], map.get(arr[i]) + 1);

            sum += arr[i];

            if(map.get(arr[i]) > 1){
                dups++;
            }
        }

        if(dups == 0){
            max = Math.max(max, sum);
        }

        for(int i = k; i < arr.length; i++){

            int add = arr[i];
            if(!map.containsKey( add )){
                map.put(add, 0);
            }
            map.put(add, map.get(add) + 1);
            if(map.get(add) > 1) dups++;
            sum += add;

            int sub = arr[i - k];
            if(map.get(sub) > 1) dups--;
            map.put(sub, map.get(sub) - 1);
            sum -= sub;

            if(dups == 0) max = Math.max(max, sum);
        }

        return max;

    }
}
}
