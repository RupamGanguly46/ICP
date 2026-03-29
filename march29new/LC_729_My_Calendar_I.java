package march29new;

public class LC_729_My_Calendar_I {
    class MyCalendar {
        class Node{
            private int start, end;
            private Node left, right;

            public Node(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        private Node root;

        public MyCalendar() {
        }

        public boolean book(int startTime, int endTime) {
            if(this.root == null){
                this.root = new Node(startTime, endTime);
                return true;
            }
            return book(startTime, endTime, this.root);
        }

        private boolean book(int start, int end, Node node){
            if(end <= node.start){
                if(node.left == null){
                    node.left = new Node(start, end);
                    return true;
                }
                return book(start, end, node.left);
            }
            else if(start >= node.end){
                if(node.right == null){
                    node.right = new Node(start, end);
                    return true;
                }
                return book(start, end, node.right);
            }
            else{
                return false;
            }
        }
    }
}
