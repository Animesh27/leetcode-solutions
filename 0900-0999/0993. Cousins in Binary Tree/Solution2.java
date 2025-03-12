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
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean found_x=false;
            boolean found_y=false;
            while(size-- > 0){
                TreeNode curr=q.poll();
                if(curr.val==x){
                    found_x=true;
                }
                if(curr.val==y){
                    found_y=true;
                }
                if(curr.left != null && curr.right != null && ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))){
                    return false;
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            if(found_x && found_y)
                return true;
        }
        return false;
    }
}