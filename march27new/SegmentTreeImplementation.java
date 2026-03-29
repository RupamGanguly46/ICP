package march27new;

public class SegmentTreeImplementation {

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, -2, -8, 4, 9};
        SegmentTree t = new SegmentTree(arr);
        t.display();
        System.out.println(t.query(2, 6));

        t.update(3, 14);
        t.display();

    }

    static class SegmentTree{
        private class Node{
            int data;
            int start;
            int end;
            Node left;
            Node right;

            public Node(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        Node root;

        public SegmentTree(int[] arr){
            this.root = createTree(arr, 0, arr.length - 1);
        }

        private Node createTree(int[] arr, int start, int end){
            if(start == end){
                Node leaf = new Node(start, end);
                leaf.data = arr[start];
                return leaf;
            }
            
            Node nn = new Node(start, end);

            int mid = (end - start)/2 + start;

            nn.left = createTree(arr, start, mid);
            nn.right = createTree(arr, mid+1, end);

            nn.data = nn.left.data + nn.right.data;

            return nn;
        }

        public void display(){
            display(this.root, "");
        }

        private void display(Node node, String str){
            if(node == null) return;
            System.out.println(str + "Data: " + node.data + " Interval: [" + node.start + ", " + node.end + "]" );
            display(node.left, str+"\t");
            display(node.right, str+"\t");
        }

        public int query(int qstart, int qend){
            return query(this.root, qstart, qend);
        }

        // Many valid node intervals inside One query interval give the sum
        private int query(Node node, int qsi, int qei){

            // Node inside query
            if(node.start >= qsi && node.end <= qei){
                return node.data;
            }

            // Node outside query
            else if(node.end < qsi || node.start > qei){
                return 0;
            }

            // Overlap
            else{
                return query(node.left, qsi, qei) + query(node.right, qsi, qei);
            }
        }

        public void update(int idx, int val){
            this.root.data = update(this.root, idx, val);
        }

        private int update(Node node, int idx, int val){
            // Index not in interval
            if(idx < node.start || idx > node.end){
                return node.data;
            }
            // Index in interval
            else{
                // Index at leaf
                if(idx == node.start && idx == node.end){
                    node.data = val;
                    return node.data;
                }
                else{
                    int leftans = update(node.left, idx, val);
                    int rightans = update(node.right, idx, val);
                    node.data = leftans + rightans;

                    return node.data;

                }

            }
        }

    }
}
