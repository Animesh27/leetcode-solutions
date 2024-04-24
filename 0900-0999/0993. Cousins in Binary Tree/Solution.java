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
        Deque<TreeNode[]> q = new ArrayDeque<>();
        q.add(new TreeNode[]{root, null});
        int depth = 0, d1 = 0, d2 = 0;
        TreeNode p1 = null, p2 = null;
        while(!q.isEmpty()){
            depth++;
            int count = q.size();
            while(count-- > 0){
                TreeNode[] arr = q.poll();
                TreeNode node = arr[0], parent = arr[1];
                if(node.val == x){
                    d1 = depth;
                    p1 = parent;
                }
                if(node.val == y){
                    d2 = depth;
                    p2 = parent;
                }
                if(node.left != null){
                    q.add(new TreeNode[]{node.left, node});
                }
                if(node.right != null){
                    q.add(new TreeNode[]{node.right, node});
                }
            }
        }
        return d1 == d2 && p1 != p2;
    }
}