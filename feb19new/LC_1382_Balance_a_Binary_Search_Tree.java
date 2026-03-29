import java.util.ArrayList;
import java.util.List;

public class LC_1382_Balance_a_Binary_Search_Tree {
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

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> ls = new ArrayList<>();
        inorder(ls, root);
        return populateSorted(ls, 0, ls.size());
    }

    public void inorder(List<TreeNode> ls, TreeNode n){
        if(n == null) return;
        inorder(ls, n.left);
        ls.add(n);
        inorder(ls, n.right);
    }

    private TreeNode populateSorted(List<TreeNode> ls, int start, int end){
        if(start >= end) return null;
        int mid = (end - start)/2 + start;
        
        TreeNode nn = ls.get(mid);
        nn.left = populateSorted(ls, start, mid);
        nn.right = populateSorted(ls, mid+1, end);

        return nn;
    }
}
