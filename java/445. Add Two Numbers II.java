/**
 *Problem: 445. Add Two Numbers II
 *You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Using Stack: The advantage of using a stack is that when we loop over a given linked list from the first node to the last and push all the digist in the stack, the top of the stack will have the least significant digit and the bottom will contain the most significant digit.

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        } 

        int totalSum = 0, carry = 0;
        ListNode ans = new ListNode();
        while(!s1.empty() || !s2.empty()){
            if(!s1.empty()) totalSum += s1.pop();
            if(!s2.empty()) totalSum += s2.pop();

            ans.val = totalSum%10;
            carry = totalSum/10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }

        return carry == 0 ? ans.next : ans;         
    }
}
