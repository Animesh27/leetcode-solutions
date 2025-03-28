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
    public ListNode reverse(ListNode head, int k){
        ListNode curr = head, prev = null;
        while(k-- > 0){
            ListNode next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(count < k && cur != null){
            cur = cur.next;
            count++;
        }

        if(count == k){
            ListNode reversedHead = reverse(head, k);
            head.next = reverseKGroup(cur, k);
            return reversedHead;
        }
        return head;
    }
}