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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode tempo = head;
        ListNode tempe = head.next;
        ListNode t = head.next;
        temp = temp.next.next;
        while(temp != null){
            tempo.next = temp;
            temp = temp.next;
            tempo = tempo.next;
            if(temp == null){
                break;
            }
            tempe.next = temp;
            temp = temp.next;
            tempe = tempe.next;
        }
        tempe.next = null;
        tempo.next = t;
        return head;
    }
}