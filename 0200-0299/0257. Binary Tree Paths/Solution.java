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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, "");
        return list;
    }

    public void dfs(TreeNode root, String s){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            s = s + root.val;
            list.add(s);
            return;
        }
        s = s + root.val + "->";
        dfs(root.left, s);
        dfs(root.right, s);
    }
}