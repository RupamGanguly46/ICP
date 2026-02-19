package feb18new;

import java.util.ArrayList;
import java.util.List;

public class LC_94_Binary_Tree_Inorder_Traversal {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        func(root, ans);
        return ans;
    }
    public void func(TreeNode n, List<Integer> list){
        if(n == null) return;
        func(n.left, list);
        list.add(n.val);
        func(n.right, list);
    }
}
