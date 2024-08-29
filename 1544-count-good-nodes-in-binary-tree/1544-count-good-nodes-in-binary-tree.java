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
    public static int countnodes(TreeNode root,int max){
        if(root==null){
            return 0;
        }
      int rootanswer = 0;
      if(root.val>=max){
        max = root.val;
        rootanswer = 1;
      }
     int leftans  = countnodes(root.left,max);
     int rightans = countnodes(root.right, max);
     return leftans + rightans + rootanswer;
    }
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int max = root.val;
        int count =  countnodes(root, max);
       
        return count;
    
        }
}