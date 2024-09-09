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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int [] [] arr = new int[m][n];
        int left =0;
        int right = n-1;
        int top = 0;
        int down = m-1;
        int size = m*n;
        ListNode temp = head;
        while(size>0){
            for(int i = left; i<=right;i++){
                if(temp!=null){
             arr[top][i] = temp.val;
             temp = temp.next;
              size--;
            }
            else if(temp==null && size>0){
                 arr[top][i] = -1;
                  size--;
            }
           
            }
            top++;
             
            for(int i = top; i<=down;i++){
             if(temp!=null){
            arr[i][right] = temp.val;
            temp = temp.next;
            size--;
            }
            else if(temp==null && size>0){
                 arr[i][right] = -1;
                 size--;
            }}
            right--;
         
            for(int i = right; i>=left;i--){
              
                 if(temp!=null){
            arr[down][i] = temp.val;
            temp = temp.next;
              size--;
            }
            else if(temp==null && size>0){
                 arr[down][i] = -1;
                   size--;
            }}
            down--;
          
            for(int i = down; i>=top;i--){
             if(temp!=null){
            arr[i][left] = temp.val;
            temp = temp.next;
              size--;
            }
           else if(temp==null && size>0){
                 arr[i][left] = -1;
                   size--;
            }}
            left++;
        } 
        return arr;
    }
}