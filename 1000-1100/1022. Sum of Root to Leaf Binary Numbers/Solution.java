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
    List<String> list;
    public int sumRootToLeaf(TreeNode root) {
        list = new ArrayList<>();
        rootToLeafPath(root, "");
        int sum = 0;
        for(String s: list){
            sum += Integer.parseInt(s,2);
        }
        return sum;
    }

    public void rootToLeafPath(TreeNode root, String s){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            s = s + root.val;
            list.add(s);
        }
        s = s + root.val;
        rootToLeafPath(root.left, s);
        rootToLeafPath(root.right, s);
    }
}