package feb17new;

public class LC_700_Search_in_a_Binary_Search_Tree {
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
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
    private TreeNode search(TreeNode n, int val){
        if(n == null) return null;
        
        if(val == n.val) return n;
        
        else if(val < n.val) return search(n.left, val);
        
        else return search(n.right, val);
    }
}
