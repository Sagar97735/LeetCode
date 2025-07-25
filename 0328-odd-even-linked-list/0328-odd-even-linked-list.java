class Solution {
    public ListNode oddEvenList(ListNode head) {
       if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        
        ListNode curr = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
           
        }
         odd.next = curr;
        return head;
    }
}