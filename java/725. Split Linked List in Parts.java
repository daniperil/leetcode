/**
 *Problem: 725. Split Linked List in Parts
 *Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.
 *The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.
 *The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.
 *Return an array of the k parts.
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
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        List<ListNode> parts = new ArrayList<>();

        while (current != null) {
            length++;
            current = current.next;
        }

        int baseSize = length / k, extra = length % k;
        current = head;

        for (int i = 0; i < k; i++) {
            int partSize = baseSize + (extra > 0 ? 1 : 0);
            ListNode partHead = null, partTail = null;

            for (int j = 0; j < partSize; j++) {
                if (partHead == null) {
                    partHead = partTail = current;
                } else {
                    partTail.next = current;
                    partTail = partTail.next;
                }

                if (current != null) {
                    current = current.next;
                }
            }

            if (partTail != null) {
                partTail.next = null;
            }

            parts.add(partHead);
            extra = Math.max(extra - 1, 0);
        }

        return parts.toArray(new ListNode[0]);
    }
}
/**
Complexity Analysis
Time Complexity: O(n)O(n)O(n) — The list is traversed twice: once to calculate its length and once to create the parts.
Space Complexity: O(k)O(k)O(k) — The parts list stores kkk heads of the resulting parts. */
