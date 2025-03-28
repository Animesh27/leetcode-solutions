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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Math.abs(a - target) > Math.abs(b - target) ? -1 : 1);
        helper(root, heap, k);
        return new ArrayList<>(heap);
    }

    public void helper(TreeNode root, PriorityQueue<Integer> heap, int k){
        if(root == null){
            return;
        }
        heap.add(root.val);
        if(heap.size() > k){
            heap.remove();
        }
        helper(root.left, heap, k);
        helper(root.right, heap, k);
    }
}