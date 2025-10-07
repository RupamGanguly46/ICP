package Home_Assignment_5;
import java.util.*;
class LC_452_minimum_number_of_arrows_to_burst_balloons {
    public int findMinArrowShots(int[][] segments) {
        Arrays.sort(segments, (a,b) -> Integer.compare(a[1],b[1]));
        int arrows = 0;
        int lastArrow = 0;
        for(int balloon=0; balloon<segments.length; balloon++){
            int start = segments[balloon][0];
            int end = segments[balloon][1];
            if(arrows==0 || lastArrow < start){
                arrows++;
                lastArrow = end;
            }
        }
        return arrows;
    }
}
