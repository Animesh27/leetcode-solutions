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
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return ans;
    }

    public boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        // Check if both left and right are unival and match the current node
        if (left && right) {
            if ((root.left != null && root.left.val != root.val) ||
                    (root.right != null && root.right.val != root.val)) {
                return false;
            }
            ans++;
            return true;
        }
        return false;
    }
}