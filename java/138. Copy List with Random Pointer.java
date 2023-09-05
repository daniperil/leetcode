/**
 *Problem: 138. Copy List with Random Pointer
 *A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *Return the head of the copied linked list.
 *The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *val: an integer representing Node.val
 *random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
*Your code will only be given the head of the original linked list.
 */

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

public class Solution {
    //Interweaving Nodes method
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Node curr = head;
        while (curr != null) {
            Node new_node = new Node(curr.val, curr.next);
            curr.next = new_node;
            curr = new_node.next;
        }
        
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }
        
        Node old_head = head;
        Node new_head = head.next;
        Node curr_old = old_head;
        Node curr_new = new_head;
        
        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }
        
        return new_head;
    }
}
/**
Complexity Analysis
Time Complexity: O(n)O(n)O(n) — Each node is visited multiple times but it's still linear time.
Space Complexity: O(1)O(1)O(1) — No additional memory is used for mapping; we only allocate nodes for the new list. */
