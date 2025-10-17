package oct15;

public class Bubble_Sort_Using_Recursion {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bsort(arr, arr.length, 0);
        for(int i: arr){System.out.println(i);}
    }
    private static void bsort(int[] arr, int n, int i) {
        if(n==0) return;
        if(i==n-1){
            bsort(arr, n-1, 0);
        }
        else{
            if(arr[i]>arr[i+1]){
                int temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
            }
            bsort(arr, n, i+1);
        }
    }
}
