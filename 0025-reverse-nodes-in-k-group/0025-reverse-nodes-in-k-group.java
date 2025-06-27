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
    ListNode ans;
    public ListNode reverse(ListNode head){
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next;
        while(curr!=null){
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        ans = prev;
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode s1 = head;
        int size = 0;
        while(s1!=null){
            size++;
            s1= s1.next;
        }
        int j = 0;
        ListNode curr = head;
        ListNode newnode = new ListNode(0);
        ListNode n1 = newnode;
        while(j<(size/k)){
            int i = 1;
            ListNode curr1 = curr;
            while(i<k){
              curr1 = curr1.next;
              i++;
            }
           ListNode next = curr1.next;
           curr1.next = null;
           ListNode temp = reverse(curr);
           temp.next = next;
           n1.next = ans;
           n1 = temp;
           curr = next;
           j++;
        }
          return newnode.next;
    }
}