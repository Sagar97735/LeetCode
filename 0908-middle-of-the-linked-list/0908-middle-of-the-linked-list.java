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
        if(head==null){
            return head;
        }
        ListNode curr = head;
        ListNode curr1 = head;
        while(curr1!=null && curr1.next!=null){
            curr = curr.next;
            curr1 = curr1.next.next;
        }
    return curr;
    }
}