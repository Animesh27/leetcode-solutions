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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int critical = 0;
        ListNode curr = head, prev = null, firstCritical = null;
        int max = 0, min = 0, maxAns = Integer.MIN_VALUE, minAns = Integer.MAX_VALUE;
        while(curr != null){
            if(prev == null){
                prev = curr;
                curr = curr.next;
                continue;
            }
            if(curr.next == null){
                curr = curr.next;
                continue;
            }
            if((curr.val > prev.val && curr.val > curr.next.val)
                    ||
                    (curr.val < prev.val && curr.val < curr.next.val)){
                if(firstCritical == null){
                    firstCritical = curr;
                    max = 0;
                    min = 0;
                } else {
                    maxAns = Math.max(maxAns, max);
                    minAns = Math.min(minAns, min);
                    min = 0;
                }
                critical++;
            }
            prev = curr;
            curr = curr.next;
            max++;
            min++;
        }
        return critical < 2 ? new int[]{-1, -1} : new int[]{minAns, maxAns};
    }
}