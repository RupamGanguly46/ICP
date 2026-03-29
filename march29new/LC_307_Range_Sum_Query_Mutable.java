package march29new;

public class LC_307_Range_Sum_Query_Mutable {
    class NumArray {
        class Node{
            private int val;
            private int start;
            private int end;
            private Node left;
            private Node right;

            public Node(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        private Node root;

        public NumArray(int[] nums) {
            this.root = createTree(nums, 0, nums.length - 1);
        }

        private Node createTree(int[] nums, int start, int end){
            if(start == end){
                Node leaf = new Node(start, end);
                leaf.val = nums[start];
                return leaf;
            } 

            Node nn = new Node(start, end);
            int mid = (end - start) / 2 + start;
            nn.left = createTree(nums, start, mid);
            nn.right = createTree(nums, mid+1, end);
            nn.val = nn.left.val + nn.right.val;

            return nn;
        }
        
        public void update(int index, int val) {
            this.root.val = update(this.root, index, val);
        }

        private int update(Node n, int index, int val){
            if(index < n.start || index > n.end){
                return n.val;
            }
            else if(index == n.start && index == n.end){
                n.val = val;
                return n.val;
            }
            else{
                n.val = update(n.left, index, val) + update(n.right, index, val);
                return n.val;
            }
        }
        
        public int sumRange(int left, int right) {
            return sumRange(this.root, left, right);
        }

        private int sumRange(Node n, int qsi, int qei){
            if(n.start >= qsi && n.end <= qei){
                return n.val;
            }
            else if(n.start > qei || n.end < qsi){
                return 0;
            }
            else{
                return sumRange(n.left, qsi, qei) + sumRange(n.right, qsi, qei); 
            }
        }
    }
}
