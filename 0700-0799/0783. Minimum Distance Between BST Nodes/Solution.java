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
    int ans;
    int prev;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        prev = Integer.MAX_VALUE;
        dfs(root);
        return ans;
    }

    /**
     * Note: we have to use inorder as the minimum difference can be the min node in the right subtree
     * or max node in the left subtree
     */
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        ans = Math.min(ans, Math.abs(root.val - prev));
        prev = root.val;
        dfs(root.right);
    }
}