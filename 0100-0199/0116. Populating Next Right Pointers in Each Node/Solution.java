/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    public void dfs(Node root, Node next){
        if(root != null){
            root.next = next;
            dfs(root.left, root.right);
            dfs(root.right, root.next == null? null : root.next.left);
        }
    }
}