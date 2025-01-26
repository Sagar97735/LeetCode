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
    public void solve(TreeNode root,String str, List<String> arr ){
        if(root==null){
            return;
        }
        if(root!=null && root.left==null && root.right==null){
            str+=root.val;
            arr.add(str);
            return;
        }
        str+=root.val;
        str+="->";
        solve(root.left,str,arr);
        solve(root.right,str,arr);
       return;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arr = new ArrayList<>();
        solve(root,"",arr);
        return arr;
    }
}