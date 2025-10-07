package Home_Assignment_9;

public class LC_83_Remove_Duplicates_from_Sorted_List {
    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode temp = head;

        while (temp != null) {

            if (temp.next != null && temp.val == temp.next.val) {
                temp.next = temp.next.next;
            }

            else
                temp = temp.next;

        }

        return head;
    }
}