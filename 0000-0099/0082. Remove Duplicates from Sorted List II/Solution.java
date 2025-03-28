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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head, prev = null;
        while(curr != null && curr.next != null){
            if(curr.val != curr.next.val){
                prev = curr;
                curr = curr.next;
            } else {
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }
                if(prev != null){
                    prev.next = curr.next;
                } else {
                    head = curr.next;
                }
                curr = curr.next;
            }
        }
        return head;
    }
}