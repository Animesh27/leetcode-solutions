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
    int ans = 0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        ans++;
        dfs(root.left);
        dfs(root.right);
    }
}