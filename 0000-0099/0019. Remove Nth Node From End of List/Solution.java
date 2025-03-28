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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, prev = null, fast = head;
        while(n-- > 0 && fast != null){
            fast = fast.next;
        }
        while(fast != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(prev != null){
            prev.next = slow.next;
        } else {
            head = slow.next;
        }
        return head;
    }
}