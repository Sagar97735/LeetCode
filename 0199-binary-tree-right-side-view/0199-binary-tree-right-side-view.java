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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList <Integer> arr = new ArrayList<>();
         if(root==null){
            return arr;
        }
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
         int count = q1.size();
         for(int i = 0; i<count;i++){
            TreeNode curr = q1.poll();
             if(curr.left!=null){
                q1.add(curr.left);
             } 
             if(curr.right!=null){
                q1.add(curr.right);
             }
             if(i==count-1){
             arr.add(curr.val); 
             }
        }
    }
    return arr;
    }
}