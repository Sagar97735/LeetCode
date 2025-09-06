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
    public ListNode reverseList(ListNode head) {
        ListNode prev = head;
        if( head ==null || head.next==null){
          return head;
        }
        ListNode curr = head.next;
        if(head.next.next==null){
            curr.next = prev;
            head.next = null;
            head = curr;
            return head;
        }
        
        ListNode next = curr.next;
        while(curr!=null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(curr!=null){
               next = curr.next;
            }  
        }
        head.next = null;
        head = prev;
        return head;
    }
}