package Home_Assignment_5;
import java.util.*;

public class LC_881_Boats_to_Save_People {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i = 0;
        int j = people.length - 1;
        
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            boats++;
        }
        
        return boats;
    }
    
    public static void main(String[] args) {
        int[] people1 = {1, 2};
        int limit1 = 3;
        System.out.println("Test 1: " + numRescueBoats(people1, limit1)); // Expected: 1
        
        int[] people2 = {3, 2, 2, 1};
        int limit2 = 3;
        System.out.println("Test 2: " + numRescueBoats(people2, limit2)); // Expected: 3
        
        int[] people3 = {3, 5, 3, 4};
        int limit3 = 5;
        System.out.println("Test 3: " + numRescueBoats(people3, limit3)); // Expected: 4
    }
}