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
    public int getDecimalValue(ListNode head) {
        int base = 2;
        int ans = 0;
        int size = 0;
        ListNode curr = head;
        ListNode curr1 = head;
        while(curr!=null){
            size++;
            curr = curr.next;
        }
        int x = size-1;
        while(curr1!=null){
            int a = curr1.val;
            if(a==1){
                ans += Math.pow(2,x);
                curr1 = curr1.next;
                x--;
            }
            else{
                x--;
                curr1 = curr1.next;
            }

        }
        return ans;
    }
}