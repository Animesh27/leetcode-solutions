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
    public ListNode partition(ListNode head, int x) {
        ListNode afterHead = new ListNode(0);
        ListNode beforeHead = new ListNode(0);
        ListNode curr = head, before = beforeHead, after = afterHead;
        while(curr != null){
            if(curr.val >= x){
                after.next = curr;
                after = after.next;
            } else {
                before.next = curr;
                before = before.next;
            }
            curr = curr.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;

    }
}