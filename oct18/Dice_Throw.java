package oct18;
import java.util.*;
// 43 and 34 both are allowed as dice throw can give 4 first then 3, or 3 first then 4, these two outcomes are different, not same!
// We write code to return combination of dice throws that yield fiven target.
public class Dice_Throw {
    public static void main(String[] args) {
        // System.out.println(helper("", 7));
        System.out.println(helper2("", 10, 8));
    }
    private static List<String> helper(String p, int target){
        if(target==0){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        List<String> ans = new ArrayList<>();

        for(int i=1; i<=target && i<=6; i++){
            ans.addAll(helper(p+i, target-i));
        }

        return ans;
    }

    // 8 face dice:
    private static List<String> helper2(String p, int target, int face){
        if(target==0){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        List<String> ans = new ArrayList<>();

        for(int i=1; i<=target && i<=face; i++){
            ans.addAll(helper(p+i, target-i));
        }

        return ans;
    }
}
