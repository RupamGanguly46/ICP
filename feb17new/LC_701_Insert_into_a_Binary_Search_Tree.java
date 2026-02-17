package feb17new;

public class LC_701_Insert_into_a_Binary_Search_Tree {
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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }
    private TreeNode insert(TreeNode n, int val){
        if(n == null){
            TreeNode nn = new TreeNode(val);
            return nn;
        }
        if(val < n.val){
            n.left = insert(n.left, val);
        }
        else if(val > n.val){
            n.right = insert(n.right, val);
        }

        return n;
    }
}
