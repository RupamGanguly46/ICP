public class AVLTree_Implementation {
    static class AVL{
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

            return rotate(n);
        }

        public Node rotate(Node node){
            // Left Heavy and unbalanced (Left-Left or Left-Right)
            if(height(node.left) - height(node.right) > 1){
                // Left - Left case
                if(height(node.left.left) - height(node.left.right) > 0){
                    return rightRotate(node); // parent
                }
                // Left - Right case
                if(height(node.left.left) - height(node.left.left) < 0){
                    node.left = leftRotate(node.left); // child
                    return rightRotate(node); // parent, left-left case
                }
            }

            // Right Heavy and unbalanced (Right-Left or Right-Right)
            if(height(node.left) - height(node.right) < -1){
                // Right - Right case
                if(height(node.right.left) - height(node.right.right) < 0){
                    return leftRotate(node); // parent
                }
                // Right - Left case
                if(height(node.right.left) - height(node.right.left) > 0){
                    node.right = rightRotate(node.right); // child
                    return leftRotate(node); // parent, right-right case
                }
            }

            return node;
        }

        public Node rightRotate(Node p){
            Node c = p.left;
            Node t = c.right;

            c.right = p;
            p.left = t;

            p.height = Math.max(height(p.left), height(p.right)) + 1;
            c.height = Math.max(height(c.left), height(c.right)) + 1;

            return c;
        } 

        public Node leftRotate(Node c){
            Node p = c.right;
            Node t = p.left;

            p.left = c;
            c.right = t;

            p.height = Math.max(height(p.left), height(p.right)) + 1;
            c.height = Math.max(height(c.left), height(c.right)) + 1;

            return p;
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
        
        // n*log(n)
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

        public void preorder(){
            preorder(root);
        }
        private void preorder(Node n){
            if(n == null) return;
            System.out.print(n.val + " ");
            preorder(n.left);
            preorder(n.right);
        }

        public void inorder(){
            inorder(root);
        }
        private void inorder(Node n){
            if(n == null) return;
            inorder(n.left);
            System.out.print(n.val + " ");
            inorder(n.right);
        }

        public void postorder(){
            postorder(root);
        }
        private void postorder(Node n){
            if(n == null) return;
            postorder(n.left);
            postorder(n.right);
            System.out.print(n.val + " ");
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
        AVL tree = new AVL();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        // tree.populateSorted(nums);
        // tree.prettyDisplay();
        // System.out.println(tree.isBalanced());
        // tree.preorder();
        // System.out.println();
        // tree.inorder();
        // System.out.println();
        // tree.postorder();

        tree.populate(nums);
        tree.prettyDisplay();

    }
}
