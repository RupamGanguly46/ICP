package oct31;
import java.util.*;

public class cutSegmentsMaze {
    static int maxCuts = 0;                  // store maximum cuts found
    static List<Integer> currentPath = new ArrayList<>(); // current sequence of cuts
    static List<Integer> bestPath = new ArrayList<>();    // best (maximum) sequence of cuts

    public static void main(String[] args) {
        int n = 5;
        int x = 5;
        int y = 3;
        int z = 2;

        System.out.println("Exploring all possible cut paths like a maze...");
        exploreCuts(n, x, y, z);

        System.out.println("\nMaximum number of cuts = " + maxCuts);
        if (bestPath.isEmpty())
            System.out.println("No valid cuts possible.");
        else
            System.out.println("One optimal sequence of cuts: " + bestPath);
    }

    public static void exploreCuts(int n, int x, int y, int z) {
        // Base case — reached a valid complete cut combination
        if (n == 0) {
            System.out.println("✅ Valid combination found: " + currentPath);
            if (currentPath.size() > maxCuts) {
                maxCuts = currentPath.size();
                bestPath = new ArrayList<>(currentPath);
            }
            return;
        }

        // Base case — invalid (overshot)
        if (n < 0) {
            return;
        }

        // Try all possible "directions" (like moves in maze)
        if (n >= x) {
            currentPath.add(x); // choose this cut
            exploreCuts(n - x, x, y, z); // move to next state
            currentPath.remove(currentPath.size() - 1); // backtrack
        }

        if (n >= y) {
            currentPath.add(y);
            exploreCuts(n - y, x, y, z);
            currentPath.remove(currentPath.size() - 1);
        }

        if (n >= z) {
            currentPath.add(z);
            exploreCuts(n - z, x, y, z);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}

