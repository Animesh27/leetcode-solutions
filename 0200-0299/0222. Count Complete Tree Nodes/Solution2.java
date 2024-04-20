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
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return 0;
        }
        int ans = 0;
        q.add(root);
        while(!q.isEmpty()){
            ans++;
            root = q.poll();
            if(root.left != null){
                q.add(root.left);
            }
            if(root.right != null){
                q.add(root.right);
            }
        }
        return ans;
    }
}