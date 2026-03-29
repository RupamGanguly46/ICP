package march27new;

import java.util.*;

public class LC_102_Binary_Tree_Level_Order_Traversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize = q.size();
            List<Integer> curlevel = new ArrayList<>();
            for(int i = 0; i < levelsize; i++){
                TreeNode rm = q.poll();
                curlevel.add(rm.val);
                
                if(rm.left != null) q.offer(rm.left);
                if(rm.right != null) q.offer(rm.right);
            }
            ans.add(curlevel);
        }
        return ans;
    }
}
