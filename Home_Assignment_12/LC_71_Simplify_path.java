package Home_Assignment_12;

import java.util.Stack;

public class LC_71_Simplify_path {
    class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>(); 
        String[] directories = path.split("/"); 
        for (String dir : directories) { 
            if (dir.equals(".") || dir.isEmpty()) { 
                continue;
            } else if (dir.equals("..")) { 
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else { 
                stack.push(dir);
            }
        }
        return "/" + String.join("/", stack); 
    }
}
}
