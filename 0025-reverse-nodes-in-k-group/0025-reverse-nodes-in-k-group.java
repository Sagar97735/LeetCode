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
    private int lengthOfLinkedList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
    
    private ListNode reverseKGroup(ListNode head, int k, int length) {
        if (length < k) {
            return head;
        }
        
        int count = 0;
        ListNode prev = null, next = null, curr = head;
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        
        if (next != null) {
            head.next = reverseKGroup(next, k, length - k);
        }
        
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = lengthOfLinkedList(head);
        return reverseKGroup(head, k, length);
    }
}
