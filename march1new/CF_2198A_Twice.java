package march1new;
import java.util.*;
public class CF_2198A_Twice{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- > 0){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        int score = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        
        for(int i : map.keySet()){
            score += map.get(i)/2;
        }
        
        System.out.println(score);
    }
  }
}