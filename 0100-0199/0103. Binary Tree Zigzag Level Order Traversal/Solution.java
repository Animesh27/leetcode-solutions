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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if(root == null){
            return ans;
        }
        boolean ltr = true;
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> list = new ArrayList<>();
            while(count-- > 0){

                if(ltr){
                    TreeNode node = q.pollFirst();
                    list.add(node.val);
                    if(node.left != null){
                        q.addLast(node.left);
                    }
                    if(node.right != null){
                        q.addLast(node.right);
                    }
                } else if(!ltr){
                    TreeNode node = q.pollLast();
                    list.add(node.val);
                    if(node.right != null){
                        q.addFirst(node.right);
                    }
                    if(node.left != null){
                        q.addFirst(node.left);
                    }
                }

            }
            ans.add(list);
            ltr = !ltr;
        }
        return ans;

    }
}