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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(root);
        q1.add(null);
        int cnt = 0;
        int ans = 0;
        int level = 1;
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        int cnt1 =0;
        while(!q1.isEmpty()){
          TreeNode curr = q1.poll();
          if(cnt1>2){
            break;
          }
          if(curr==null){
            q1.add(null);
            if(temp>sum && cnt>0){
                sum = Math.max(sum,temp);
                ans = level;
            }
            cnt1++;
            level += 1;
            temp = 0;
            cnt = 0;
          }
          else{
            cnt1 = 0;
            cnt+=1;
           temp+=curr.val;
        if(curr.left!=null){
            q1.add(curr.left);
           }
        if(curr.right!=null){
             q1.add(curr.right);
          }
          } 
        }
        return ans;
    }
}