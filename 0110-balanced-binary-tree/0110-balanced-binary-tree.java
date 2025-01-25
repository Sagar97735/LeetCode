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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
       int a = height(root.left);
       int b = height(root.right);
        return Math.max(a,b) +1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
              return true;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        if(Math.abs(h1-h2)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}