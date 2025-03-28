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
        ListNode curr = head;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        while(curr != null){
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        int size = stack.size(), count = 1;
        while(count <= size / 2){
            ans = Math.max(ans, stack.peek() + curr.val);
            curr = curr.next;
            stack.pop();
            count++;
        }
        return ans;
    }
}