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
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        if(length == 0){
            return null;
        }
        ListNode node = lists[0];
        for(int i = 1;i<length;i++){
            node = merge(node, lists[i]);
        }
        return node;
    }


    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 ==  null){
            return null;
        } else if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}