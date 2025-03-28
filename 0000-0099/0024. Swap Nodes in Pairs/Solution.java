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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode curr = head, prev = null;
        head = curr.next;
        while(curr != null && curr.next != null){
            ListNode temp = curr.next;
            curr.next = curr.next.next;
            temp.next = curr;
            if(prev != null){
                prev.next = temp;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}