package Home_Assignment_1;
import java.util.*;
public class LC_452_Minimum_Number_of_Arrows_to_Burst_Balloons {
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