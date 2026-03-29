package feb21new;

import java.util.ArrayList;
import java.util.List;

public class LC_109_Convert_Sorted_List_to_Binary_Search_Tree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head.next.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode nn = new TreeNode(slow.next.val);
        nn.right = sortedListToBST2(slow.next.next);
        
        slow.next = null;
        nn.left = sortedListToBST2(head);
        
        return nn;
    }


    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        while(head != null){
            arr.add(head.val);
            head = head.next;
        }
        return populateSorted(arr, 0, arr.size());
    }
    private TreeNode populateSorted(List<Integer> arr, int start, int end){
        if(start >= end) return null;
        int mid = (end - start)/2 + start;
        TreeNode nn = new TreeNode(arr.get(mid));
        nn.left = populateSorted(arr, start, mid);
        nn.right = populateSorted(arr, mid+1, end);
        return nn;
    }
}
