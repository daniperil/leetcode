/**
 *Problem: 92. Reverse Linked List II
 *Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //Using two pointers
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for(int i = 0; i<left-1; ++i){
            prev = prev.next;
        }

        ListNode current = prev.next;

        for(int i = 0; i< right-left; ++i){
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }

        return dummy.next;
        
    }
}
/**
Complexity Analysis
Time Complexity: O(n) — A single traversal does the job.
Space Complexity: O(1) — Smart pointer manipulation eliminates the need for additional data structures.
 */
