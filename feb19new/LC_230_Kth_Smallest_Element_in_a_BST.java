public class LC_230_Kth_Smallest_Element_in_a_BST {
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

    int count = 0;
    int ans = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    public void inorder(TreeNode n, int k){
        if(n == null) return;
        
        inorder(n.left, k);

        count++;
        if(count == k){
            ans = n.val;
            return;
        }

        inorder(n.right, k);
    }
}
