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
    List<Integer> ans;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        if(root.left != null || root.right != null){
            ans.add(root.val);
        }
        printLeftBoundary(root.left);
        printLeaves(root);
        printRightBoundary(root.right);
        return ans;
    }

    private void printLeftBoundary(TreeNode root){
        if(root != null){
            if(root.left != null){
                ans.add(root.val);
                printLeftBoundary(root.left);
            } else if(root.right != null){
                ans.add(root.val);
                printLeftBoundary(root.right);
            }
        }
    }

    private void printLeaves(TreeNode root){
        if(root != null){
            printLeaves(root.left);
            if(root.right == null && root.left == null){
                ans.add(root.val);
            }
            printLeaves(root.right);
        }
    }

    private void printRightBoundary(TreeNode root){
        if(root != null){
            if(root.right != null){
                printRightBoundary(root.right);
                ans.add(root.val);
            } else if(root.left != null){
                printRightBoundary(root.left);
                ans.add(root.val);
            }
        }
    }
}