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
    List<TreeNode> pathRootToA = new ArrayList<>();
    List<TreeNode> pathRootToB = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findPath(root, p, pathRootToA);
        findPath(root, q, pathRootToB);
        int i = 0;
        while(i < pathRootToA.size() && i < pathRootToB.size() && pathRootToA.get(i) == pathRootToB.get(i)){
            i++;
        }
        return pathRootToA.get(i-1);
    }

    public boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path){
        if(root == null) return false;
        path.add(root);
        if (root == target) return true;
        if(findPath(root.left, target, path) || findPath(root.right, target, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}