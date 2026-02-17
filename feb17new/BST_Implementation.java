package feb17new;

public class BST_Implementation {
    static class BST{
        class Node{
            private int val;
            private Node left;
            private Node right;
            private int height;
    
            Node(int val){
                this.val = val;
            }
        }

        Node root;

        public int height(Node n){
            if(n == null) return -1;
            return n.height;
        }

        public boolean isEmpty(){
            return root == null;
        }

        public void insert(int val){
            root = insert(root, val);
        }

        private Node insert(Node n, int val){
            if(n == null){
                Node nn = new Node(val);
                return nn;
            }

            if(val < n.val){
                n.left = insert(n.left, val);
            }

            if(val > n.val){
                n.right = insert(n.right, val);
            }

            n.height = Math.max(height(n.left), height(n.right)) + 1;

            return n;
        }

        public boolean isBalanced(){
            return isBalanced(root);
        }

        private boolean isBalanced(Node n){
            if(n == null) return true;
            return Math.abs(height(n.left) - height(n.right)) <= 1 && isBalanced(n.left) && isBalanced(n.right);
        }

        public void populate(int[] nums){
            for(int i: nums){
                this.insert(i);
            }
        }

        public void populateSorted(int[] nums){
            populateSorted(nums, 0, nums.length);
        }

        private void populateSorted(int[] nums, int start, int end){
            if(start >= end) return;
            int mid = (end - start)/2 + start;
            this.insert(nums[mid]);
            populateSorted(nums, start, mid);
            populateSorted(nums, mid+1, end);
        }

        public void prettyDisplay(){
            prettyDisplay(this.root, 0);
        }

        private void prettyDisplay(Node n, int lvl){
            if(n == null) return;
            prettyDisplay(n.right, lvl+1);
            if(lvl != 0){
                for(int i=0; i<lvl-1; i++){
                    System.out.print("|\t");
                }
                System.out.println("|------>" + n.val);
            }
            else{
                System.out.println(n.val);
            }
            prettyDisplay(n.left, lvl+1);
        }
    }

    public static void main(String[] args) {
        BST tree = new BST();
        int[] nums = {1,3, 2, 5, 4, 7};
        tree.populateSorted(nums);
        tree.prettyDisplay();
        System.out.println(tree.isBalanced());

    }
}
