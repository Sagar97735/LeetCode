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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp  = head;
        ListNode temp1  = head;
        ListNode temp2  = temp1.next;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp.next!=null){
            int next = temp.next.val;
            int curr = temp.val;
            int var = Math.min(curr,next);
              int var1 = Math.max(curr,next);
             for(int i = var; i>0; i--){
                if(var%i==0 && var1%i==0){
                   arr.add(i);
                   temp = temp.next;
                    break;
                }
            }
        }
        int k = 0;
        while(temp1.next!= null){
           ListNode temp3 = new ListNode(arr.get(k));
           temp1.next = temp3;
           temp3.next = temp2;
           temp1 = temp1.next.next;
           temp2 = temp1.next;
           k++;
        }
        return head;
    }
}