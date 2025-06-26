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
    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        if(slow.next==null){
            return true;
        }
        if(slow.next.next==null){
            if(slow.val!=slow.next.val){
                return false;
            }
        }
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = reverse(slow.next);
        slow.next = temp;
        ListNode curr = head;
        ListNode curr1 = slow.next;
        while(curr1!=null){
            if(curr.val!=curr1.val){
                return false;
            }  
            curr1 = curr1.next;
            curr = curr.next; 
        }
        return true;
    }
}