package march30new;

import java.util.ArrayList;
import java.util.List;

public class LC_732_My_Calendar_III {
    class Node{
        int start, end;
        Node left, right;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    List<Node> roots = new ArrayList<>();

    public int book(int startTime, int endTime) {
        addLevel(startTime, endTime, 0);
        return roots.size();
    }

    public void addLevel(int start, int end, int level){
        if(this.roots.size() <= level) this.roots.add(null);
        this.roots.set(level, add(start, end, this.roots.get(level), level));
    }

    public Node add(int start, int end, Node n, int level){
        if(n == null) return new Node(start, end);
        if(end <= n.start) n.left = add(start, end, n.left, level);
        else if(start >= n.end) n.right = add(start, end, n.right, level);
        else{
            int overlapStart = Math.max(start, n.start);
            int overlapEnd = Math.min(end, n.end);

            addLevel(overlapStart, overlapEnd, level + 1);

            n.left = add(start, overlapStart, n.left, level);
            n.right = add(overlapEnd, end, n.right, level);
        }

        return n;
    }
}
