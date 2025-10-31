package oct31;

public class LC_206_Reverse_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            while(curr!=null){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }
    }
    class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            return helper(curr, prev);
        }
        public ListNode helper(ListNode curr, ListNode prev){
            if(curr==null){
                return prev;
            }
            ListNode temp = curr.next;
            curr.next = prev;
            return helper(temp, curr);
        }
    }
}
