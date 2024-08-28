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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        ListNode prev = head;
        int size = 0;
        int i = 1;
        while(temp!= null){
            temp = temp.next;
            size++;
        }
        while(i<size/2){
                 prev = prev.next;
                 i++;
        }
        if(size == 1){
            head = null;
            return head;
        }
        prev.next = prev.next.next;
          return head;
    }
}