package dec1;
// Fixed Window
// MaxSum
public class sw1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int k = 3;

        if (k <= 0 || k > arr.length) {
            System.out.println("Invalid k");
            return;
        }

        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];

        int maxsum = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            maxsum = Math.max(maxsum, sum);
        }

        System.out.println(maxsum); 
        System.out.println(minsum(arr, k));
    }
    
    public static int minsum(int[] arr, int k){
        int sum = 0;
        for(int i=0; i<k; i++){
            sum+=arr[i];
        }
        int minsum = sum;
        for(int i=k; i<arr.length; i++){
            sum += arr[i];
            sum -= arr[i-k];
            minsum = Math.min(minsum, sum);
        }

        return minsum;
    }
}