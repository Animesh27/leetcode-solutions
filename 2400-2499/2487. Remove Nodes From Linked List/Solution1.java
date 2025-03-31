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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while(curr != null){
            st.push(curr);
            curr = curr.next;
        }
        curr = st.pop();
        int max = curr.val;
        ListNode res = new ListNode(max);
        while(!st.isEmpty()){
            curr = st.pop();
            if(curr.val < max){
                continue;
            } else {
                ListNode newNode = new ListNode(curr.val);
                newNode.next = res;
                res = newNode;
                max = curr.val;
            }
        }
        return res;
    }
}