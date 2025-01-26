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
    public boolean solve(TreeNode temp1, TreeNode temp2){
        if(temp1==null && temp2==null){
            return true;
        }
        if(temp1==null || temp2==null){
            return false;
        }
        if(temp1.val!=temp2.val){
            return false;
        }
        return solve(temp1.left,temp2.right) && solve(temp1.right,temp2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.left==null || root.right==null){
            return false;
        }
        TreeNode temp1 = root.left;
        TreeNode temp2 = root.right;
        if(temp1.val!=temp2.val){
            return false;
        }
        return solve(temp1,temp2);
    }
}