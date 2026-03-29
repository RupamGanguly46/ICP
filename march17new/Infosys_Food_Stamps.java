package march17new;
import java.util.*;
public class Infosys_Food_Stamps{

    public static class Food{
        long v;
        long d;

        Food(long v, long d){
            // Value 
            this.v = v;
            // Decay
            this.d = d;
        }
    }

    public static void main(String[] args){
        // v[i] - d[i] * (ti - 1)
        Scanner sc = new Scanner(System.in);
        // Number of types of food you can buy
        int n = sc.nextInt();

        // Max. no. of meals you can buy
        int m = sc.nextInt();
        
        // Type of foods and the points they offer on eating
        long[] arrV = new long[n];
        for(int i=0; i<n; i++){
            // Food's initial points
            arrV[i] = sc.nextLong();
        }

        // Type of foods and their decay rates 
        long[] arrD = new long[n];
        for(int i=0; i<n; i++){
            arrD[i] = sc.nextLong();
        }

        PriorityQueue<Food> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(b.v, a.v)
        );

        for(int i=0; i<n; i++){
            pq.add(new Food(arrV[i], arrD[i]));
        }

        long sum = 0;
        while(!pq.isEmpty() && m-- > 0){
            
            Food rm = pq.poll();
            
            if(rm.v < 0) break;
            
            sum += rm.v;
            
            rm.v -= rm.d;
            if(rm.v > 0){ 
                pq.add(rm);
            }
        }

        System.out.println(sum);
    }
}