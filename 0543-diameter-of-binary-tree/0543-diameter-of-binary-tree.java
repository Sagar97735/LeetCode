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
    public int solve(TreeNode root, int[] diameter){
        if(root==null){
            return 0;
        }
        int leftheight = solve(root.left,diameter);
        int rightheight = solve(root.right,diameter);
        diameter[0] = Math.max(diameter[0],leftheight+rightheight);
        return Math.max(leftheight,rightheight) +1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
         if(root==null){
            return 0;
        }
        int [] diameter = new int[1];
        solve(root,diameter);
        return diameter[0];
    }
}