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
    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        while(head != null){
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ListNode node = new ListNode(entry.getValue());
            curr.next = node;
            curr = node;
        }
        return dummyHead.next;
    }
}