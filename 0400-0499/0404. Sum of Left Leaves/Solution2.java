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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, null);
        return sum;
    }

    public void helper(TreeNode root, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && parent != null && parent.left == root){
            sum += root.val;
        }
        helper(root.left, root);
        helper(root.right, root);
    }
}