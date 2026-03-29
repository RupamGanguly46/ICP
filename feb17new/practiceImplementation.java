package feb17new;

public class practiceImplementation{
    static class BST{
        class Node{
            private int val, height;
            private Node left, right;

            Node(int val){
                this.val = val;
            }
        }

        private Node root;

        public int height(Node n){
            if(n == null) return -1;
            return n.height;
        }

        public boolean isempty(){
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
            else{
                n.right = insert(n.right, val);
            }
            n.height = Math.max(height(n.left), height(n.right)) + 1;
            return n;
        }

        public boolean isbalanced(){
            return isbalanced(root);
        }

        private boolean isbalanced(Node n){
            if(n == null) return true;
            return Math.abs(height(n.left) - height(n.right)) <= 1 && isbalanced(n.left) && isbalanced(n.right);
        }

        public void populatewitharr(int[] arr){
            for(int i: arr){
                this.insert(i);
            }
        }

        public void populatesorted(int[] arr){
            populatesorted(arr, 0, arr.length);
        }

        private void populatesorted(int[] arr, int start, int end){
            if(start >= end) return;
            int mid = (end - start) / 2 + start;
            this.insert(arr[mid]);
            populatesorted(arr, start, mid);
            populatesorted(arr, mid+1, end);
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

        public void display(){
            display(root, "");
        }

        private void display(Node n, String indent){
            if(n == null) return;
            System.out.println(indent + n.val);
            display(n.left, indent + "\t");
            display(n.right, indent + "\t");
        }
    }

    public static void main(String[] args){
        BST tree = new BST();
        int[] nums = {4, 5, 6, 10, 12, 15, 16};
        tree.populatewitharr(nums);
        tree.display();

        System.out.println();

        BST tree2 = new BST();
        tree2.populatesorted(nums);
        tree2.display();

        System.out.println();
        tree2.preorder();
        System.out.println();
        tree2.inorder();
        System.out.println();
        tree2.postorder();
    }
}