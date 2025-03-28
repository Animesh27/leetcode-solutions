/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        return inorderToBST(list, 0, list.size() - 1);
    }

    public TreeNode inorderToBST(List<Integer> list, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = inorderToBST(list, start, mid - 1);
        node.right = inorderToBST(list, mid + 1, end);
        return node;
    }
}