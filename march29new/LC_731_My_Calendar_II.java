package march29new;

public class LC_731_My_Calendar_II {
    class MyCalendarTwo {
        class Node{
            private int start, end;
            private Node left, right;

            public Node(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        private Node singleRoot, doubleRoot;

        public MyCalendarTwo() {
            
        }
        
        public boolean book(int startTime, int endTime) {
            if(!check(startTime, endTime, doubleRoot)) return false;
            this.singleRoot = addToSingle(startTime, endTime, this.singleRoot);
            return true;
        }

        public boolean check(int start, int end, Node n){
            if(n == null) return true;
            if(start >= n.end) return check(start, end, n.right);
            if(end <= n.start) return check(start, end, n.left);
            return false;
        }
        
        public Node addToSingle(int start, int end, Node n){
            if(n == null) return new Node(start, end);
            if(end <= n.start) n.left = addToSingle(start, end, n.left);
            else if(start >= n.end) n.right = addToSingle(start, end, n.right);
            else{
                int overlapStart = Math.max(start, n.start);
                int overlapEnd = Math.min(end, n.end);

                this.doubleRoot = addToDouble(overlapStart, overlapEnd, this.doubleRoot);

                n.left = addToSingle(start, overlapStart, n.left);
                n.right = addToSingle(overlapEnd, end, n.right);
            }
            return n;
        }

        public Node addToDouble(int start, int end, Node n){
            if(n == null) return new Node(start, end);
            if(end <= n.start) n.left = addToDouble(start, end, n.left);
            else if(start >= n.end) n.right = addToDouble(start, end, n.right);
            return n;
        }

    }

}
