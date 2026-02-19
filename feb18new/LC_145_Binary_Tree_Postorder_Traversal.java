package feb18new;

import java.util.ArrayList;
import java.util.List;

public class LC_145_Binary_Tree_Postorder_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
        public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        func(ans, root);
        return ans;
    }
    private void func(List<Integer> ans, TreeNode n){
        if(n == null) return;
        func(ans, n.left);
        func(ans, n.right);
        ans.add(n.val);
    }
}
