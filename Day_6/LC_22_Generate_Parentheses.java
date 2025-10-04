package Day_6;
import java.util.*;
public class LC_22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recur(ans, new StringBuilder(), n, 0, 0);
        return ans;
        
    }
    public void recur(List<String> ans, StringBuilder res, int n, int left, int right){
        if(res.length()==n*2){
            ans.add(res.toString());
            return;
        }
        if(left<n){
            res.append('(');
            recur(ans, res, n, left+1, right);
            res.deleteCharAt(res.length()-1);
        }
        if(right<left){
            res.append(')');
            recur(ans, res, n, left, right+1);
            res.deleteCharAt(res.length()-1);
        }
    }
}

// In case of string, when i pass string + '(', new string created is passed, and original string is reserved for next if condition.
// But, for stringbuilder, the original one is updated, so we have to revert it back(backpropagate) before going for another condition.