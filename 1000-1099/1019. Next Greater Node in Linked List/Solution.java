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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int count = 0;
        while(head != null){
            ans.add(0);
            while(!stack.isEmpty() && head.val > stack.peek()[1]){
                int[] curr = stack.pop();
                ans.set(curr[0], head.val);
            }
            stack.add(new int[]{count++, head.val});
            head = head.next;
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}