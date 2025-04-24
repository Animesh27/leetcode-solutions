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
    Set<TreeNode> covered;
    int ans;
    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        ans = 0;
        covered.add(null);
        dfs(root, null);
        return ans;
    }
    public void dfs(TreeNode node, TreeNode par){
        if(node != null){
            dfs(node.left, node);
            dfs(node.right, node);
            if((par == null && !covered.contains(node)) ||
                    (!covered.contains(node.left) || !covered.contains(node.right))){
                ans++;
                covered.add(par);
                covered.add(node);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
}