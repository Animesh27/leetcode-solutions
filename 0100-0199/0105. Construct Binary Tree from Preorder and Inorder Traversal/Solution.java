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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }
        int val = preorder[preIndex];
        TreeNode node = new TreeNode(val);
        preIndex++;
        if(start == end){
            return node;
        }
        int inIndex = getInorderIndex(inorder, val);
        node.left = buildTreeUtil(preorder, inorder, start, inIndex - 1);
        node.right = buildTreeUtil(preorder, inorder, inIndex + 1, end);
        return node;
    }

    public int getInorderIndex(int[] inorder, int val){
        return IntStream.range(0, inorder.length).filter(i -> val == inorder[i]).findFirst().orElse(-1);
    }
}