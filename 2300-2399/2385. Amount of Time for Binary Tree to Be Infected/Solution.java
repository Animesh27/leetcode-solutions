/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        getParents(root, 0, map);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(start);
        seen.add(start);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int cur = q.poll();
                for(int num : map.get(cur)){
                    if(!seen.contains(num)){
                        q.add(num);
                        seen.add(num);
                    }
                }
            }
            ans++;
        }
        return ans - 1;
    }

    private void getParents(TreeNode root, int parent, Map<Integer, Set<Integer>> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(root.val)){
            map.put(root.val, new HashSet<>());
        }
        Set<Integer> adj = map.get(root.val);
        if(parent != 0){
            adj.add(parent);
        }
        if(root.left != null){
            adj.add(root.left.val);
        }
        if(root.right != null){
            adj.add(root.right.val);
        }
        getParents(root.left, root.val, map);
        getParents(root.right, root.val, map);
    }
}