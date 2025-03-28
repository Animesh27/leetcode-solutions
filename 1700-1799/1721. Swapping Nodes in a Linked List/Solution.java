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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = null, fast = head, kthNode = null;
        int length = 0;
        while(fast != null){
            length++;
            if(slow != null){
                slow = slow.next;
            }
            if(length == k){
                kthNode = fast;
                slow = head;
            }
            fast = fast.next;
        }

        int temp = slow.val;
        slow.val = kthNode.val;
        kthNode.val = temp;
        return head;
    }
}