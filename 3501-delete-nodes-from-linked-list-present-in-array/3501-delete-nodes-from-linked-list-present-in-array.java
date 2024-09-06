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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode temp1 = temp;
        while(temp1.next!=null){
         if(set.contains(temp1.next.val)){
             temp1.next = temp1.next.next;
         }
         else{
            temp1 = temp1.next;
         }
        }
        return temp.next;
    }
}