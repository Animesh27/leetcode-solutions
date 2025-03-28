/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for(TreeNode node: nodes){
            set.add(node);
        }
        return lowestCommonAncestorUtil(root, set);
    }

    public TreeNode lowestCommonAncestorUtil(TreeNode root, Set<TreeNode> set){
        if(root == null || set.contains(root)){
            return root;
        }
        TreeNode left = lowestCommonAncestorUtil(root.left, set);
        TreeNode right = lowestCommonAncestorUtil(root.right, set);
        if(left == null){
            return right;
        } else if(right == null){
            return left;
        } else {
            return root;
        }
    }
}