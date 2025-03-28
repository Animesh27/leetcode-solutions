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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int numComponents = 0;
        while(head != null){
            if(set.contains(head.val) && (head.next == null || !set.contains(head.next.val))){
                numComponents++;
            }
            head = head.next;
        }
        return numComponents;
    }
}