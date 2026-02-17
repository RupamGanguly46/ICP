package feb17new;

public class LC_98_Validate_Binary_Search_Tree {
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

    //  The following solution is fine to check the left right at each subtree, but
    // What if we have a tree: 10 > 15 < 6 : 6 is to the left of 15, thus valid!
    // But, 6 is to the right of 10, invalid!!!
    // class Solution {
    //     public boolean isValidBST(TreeNode root) {
    //         return func(root);
    //     }
    //     public boolean larger(TreeNode a, TreeNode b){
    //         if(a == null || b == null) return true;
    //         return a.val > b.val;
    //     }
    //     private boolean func(TreeNode n){
    //         if(n == null) return true;
    //         return larger(n, n.left) && larger(n.right, n) && func(n.left) && func(n.right);
    //     }
    // }

    public boolean isValidBST(TreeNode root) {
        // Integer.MIN_VALUE or Integer.MAX_VALUE fails as:
        // if root has the smallest/largest integer value, it may get equal to min/max
        // Thus, we use min and max that will be outside the range of values of root
        // That is, min and max will be smaller/larger than the smallest/largest root
        return func(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean func(TreeNode n, long min, long max){
        if(n == null) return true;
        // Equality/Duplicates should also be not allowed!
        if(n.val <= min || n.val >= max) return false;
        return func(n.left, min, n.val) && func(n.right, n.val, max);
    }
}
