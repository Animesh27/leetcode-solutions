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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if(root.left != null && root.val == root.left.val){
            arrowLeft += left + 1;
        }
        if(root.right != null && root.val == root.right.val){
            arrowRight += right + 1;
        }
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}