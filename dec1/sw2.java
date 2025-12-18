package dec1;
// Longest subarray with condition
// sum <= k
// maxsum
public class sw2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 10;
        System.out.println(brute(arr, k));
    }
    public static int brute(int[] arr, int k){
        int sum = 0;
        int maxlen = 0;
        for(int i=0; i<arr.length; i++){
            sum=0;
            for(int j=i; j<arr.length; j++){
                sum+=arr[j];
                if(sum<=k){
                    maxlen = Math.max(j-i+1, maxlen);
                }
                else{
                    break;
                }
            }
        }
        return maxlen;
    }
}
