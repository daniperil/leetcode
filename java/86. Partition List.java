/**
 *Problem: 86. Partition List
 *Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *You should preserve the original relative order of the nodes in each of the two partitions.
 */

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode before_curr = before;
        ListNode after_curr = after;
        
        while(head != null) {
            if(head.val < x) {
                before_curr.next = head;
                before_curr = before_curr.next;
            } else {
                after_curr.next = head;
                after_curr = after_curr.next;
            }
            head = head.next;
        }
        
        after_curr.next = null;
        before_curr.next = after.next;
        
        return before.next;
    }
}

/**
Time Complexity: $$O(n)$$

We traverse the linked list once, making the time complexity linear in the size of the list.
Space Complexity: $$O(1)$$

We use constant extra space since we are only creating two dummy nodes and reusing the existing nodes in the linked list.
*/
