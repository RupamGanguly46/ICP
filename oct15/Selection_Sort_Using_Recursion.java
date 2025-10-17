package oct15;

public class Selection_Sort_Using_Recursion {
    public static void main(String[] args) {
        int[] a = {5, 4, 2, 1};
        selsort(a, a.length, 1, 0);
        for(int i: a) System.out.println(i);
    }
    private static void selsort(int[] arr, int n, int i, int rowmax){
        if(n==1) return;
        if(i<n){
            if(arr[rowmax]<arr[i]) rowmax = i;
            selsort(arr, n, i+1, rowmax);
        }
        else{
            int temp = arr[n-1];
            arr[n-1] = arr[rowmax];
            arr[rowmax] = temp;
            selsort(arr, n-1, 1, 0);
        }
    }
}
