/**
 *Problem: 876. Middle of the Linked List
 *Given the head of a singly linked list, return the middle node of the linked list.
 *If there are two middle nodes, return the second middle node.
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
    public ListNode middleNode(ListNode head) {
        ListNode resp = head;
        ListNode counter = head;
        int length = 0;

        while(counter != null){
            length++;
            counter = counter.next;
        }

        length=length/2;
        System.out.println(length);

        while(length != 0){
            length--;
            resp = resp.next;
        }
        return resp;    
    }
}
