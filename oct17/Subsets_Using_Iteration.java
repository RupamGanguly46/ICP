package oct17;
import java.util.*;
public class Subsets_Using_Iteration {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2};
        System.out.println(Subset(arr));
        // Work pending on duplicate remover!
        System.out.println(Subset2(arr));
    }
    private static List<List<Integer>> Subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n = outer.size();
            for(int j=0; j<n; j++){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(num);
                outer.add(inner);
            }
        }

        return outer;
    }

    private static List<List<Integer>> Subset2(int[] arr){
        // We handle duplicates too!
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        int end = 0;
        for(int i=0; i<arr.length; i++){

            int n = outer.size();
            int j = 0;
            if(i!=0 && arr[i]==arr[i-1]) j = end + 1;
            while(j<n){
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
                end++;
                j++;
            }
        }
        return outer;
    }
}
