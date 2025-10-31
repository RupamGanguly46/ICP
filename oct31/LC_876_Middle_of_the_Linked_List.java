package oct31;


public class LC_876_Middle_of_the_Linked_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        // For second middle element in even length lists
        public ListNode middleNode(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }

            ListNode slow = head;
            ListNode fast = head;

            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // For first middle element in even length lists
        // Simply stop fast earlier
        public ListNode middleNode2(ListNode head) {
            if(head==null || head.next==null){
                return head;
            }

            ListNode slow = head;
            ListNode fast = head;

            while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
