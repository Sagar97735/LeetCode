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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void ans(HashSet<String> set,TreeNode root,String s){
        if(root==null){
            set.add(s);
            return;
        }
        s+=root.val;
        ans(set,root.left,s);
        ans(set,root.right,s);
    } 
    public boolean isSubPath(ListNode head, TreeNode root) {
        String s = "";
        String s1 = "";
      HashSet<String> set = new HashSet<>();
      ans(set,root,s);
      ListNode temp = head;
      while(temp!=null){
        s1+= temp.val;
        temp = temp.next;
      }
      if(set.contains(s1)){
        return true;
      }
    else{
        for (String element :set){
            if(element.contains(s1)){
                return true;
            }
        }
    }
      return false;
    }
}