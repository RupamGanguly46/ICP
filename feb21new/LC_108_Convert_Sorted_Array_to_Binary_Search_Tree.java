package feb21new;

public class LC_108_Convert_Sorted_Array_to_Binary_Search_Tree {
    
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end){
        if(start >= end) return null;
        int mid = start + (end - start)/2;
        TreeNode nn = new TreeNode(nums[mid]);
        nn.left = sortedArrayToBST(nums, start, mid);
        nn.right = sortedArrayToBST(nums, mid+1, end);
        return nn;
    }
}
