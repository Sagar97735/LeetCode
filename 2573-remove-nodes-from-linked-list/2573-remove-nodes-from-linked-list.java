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
    public ListNode removeNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp1;
        while(curr!= null){
            temp1 = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp1;
        }
        head = prev;
       ListNode temp = head;
       while(temp.next!=null){
        if(temp.val>temp.next.val){
            temp.next = temp.next.next;
        }
        else{
            temp = temp.next;
        }
       }
      temp = head;
       ListNode prev1 = null;
        ListNode curr1 = head;
        ListNode temp11;
        while(curr1!= null){
            temp11 = curr1.next;
            curr1.next = prev1;
            prev1 = curr1;
            curr1 = temp11;
        }
        head = prev1;

         return head;
        
    }
}