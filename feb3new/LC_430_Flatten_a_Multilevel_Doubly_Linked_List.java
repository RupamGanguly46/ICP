public class LC_430_Flatten_a_Multilevel_Doubly_Linked_List {
// Definition for a Node.
    class Solution {

        public static class Node {
            public int val;
            public Node prev;
            public Node next;
            public Node child;

            Node(int n){
                val = n;
            }
        };

        Node flattened = new Node(0);
        Node tail = flattened;

        public Node flatten(Node head) {
            traverse(head);
            Node ans = flattened.next;
            if (ans != null) ans.prev = null;
            return ans;
        }

        public void traverse(Node node) {
            if (node != null) {
                Node newNode = node;
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

                Node nextNode = newNode.next;
                traverse(node.child);
                node.child = null;
                traverse(nextNode);
            }
        }
    }
}
