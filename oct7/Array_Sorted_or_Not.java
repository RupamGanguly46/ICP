package oct7;
import java.util.*;
public class Array_Sorted_or_Not {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        System.out.println(isSorted3(arr, 0));
    }
    public static boolean isSorted(int[] arr){
        if(arr.length<=1){
            return true;
        }
        if(arr[0]>arr[1]){
            return false;
        }
        return isSorted(Arrays.copyOfRange(arr, 1, arr.length));
    }
    public static boolean isSorted2(int[] arr, int i){
        if(i+1>=arr.length){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted2(arr, i+1);
    }
    public static boolean isSorted3(int[] arr, int i){
        if(i+1>=arr.length){
            return true;
        }
        return arr[i]<=arr[i+1] && isSorted3(arr, i+1);
    }
}
