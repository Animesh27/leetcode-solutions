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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode nextNode, prev = null;
        while(slow != null){
            nextNode = slow.next;
            slow.next= prev;
            prev = slow;
            slow = nextNode;
        }
        ListNode start = head;
        int ans = 0;
        while(prev != null){
            ans = Math.max(ans, prev.val + start.val);
            prev = prev.next;
            start = start.next;
        }
        return ans;
    }
}