package Day_2;
public class LC_875_Koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int h) {
        // int minSpeed = sum(piles)/h;
        int minSpeed = Math.max(1, sum(piles) / h);
        int maxSpeed = max(piles);
        // while(!check(piles, h, minSpeed)){
        //     minSpeed++;
        // }
        // return minSpeed;
        return bananas(piles, h, minSpeed, maxSpeed);
    }
    // public boolean check(int[] arr, int h, int k){
    //     int[] res = new int[arr.length];
    //     for(int i=0; i<arr.length; i++){
    //         res[i] = arr[i];
    //     }

    //     int i = 0;
    //     while(h>0 && i<res.length){
    //         if(res[i]==0){
    //             i++;
    //             continue;
    //         }
    //         if(res[i]<k){
    //             res[i]=0;
    //         }
    //         else{
    //             res[i]-=k;
    //         }
    //         h--;
    //     }
    //     return res[res.length-1]==0;
    // }
    public int sum(int[] arr){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
    public int max(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }
    public int bananas(int[] arr, int h, int low, int high){
        while(low<high){
            int mid = low + (high-low)/2;
            if(check(arr, h, mid)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean check(int[] arr, int h, int k){
        int total=0;
        for(int i=0; i<arr.length; i++){
            total+=(arr[i]+k-1)/k; // Same as math.ceil(arr[i]/k)
        }
        return total<=h;
    }
}
