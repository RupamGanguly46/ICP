package Home_Assignment_9;

public class LC_234_Palindrome_Linked_List {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode revmid = reverse(mid(head));
        while(revmid!=null){
            if(revmid.val!=head.val){
                return false;
            }
            revmid = revmid.next;
            head = head.next;
        }
        return true;
    }
    public ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}