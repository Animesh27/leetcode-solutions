/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(k == 0){
            ans.add(target.val);
            return ans;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        getParents(root, -1, map);
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(target.val);
        visited.add(target.val);
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            while(size-- > 0){
                int cur = q.poll();
                for(int num: map.get(cur)){
                    if(!visited.contains(num)){
                        q.add(num);
                        visited.add(num);
                    }
                }
            }
            if(dist == k){
                while(!q.isEmpty()){
                    ans.add(q.poll());
                }
                break;
            }
        }
        return ans;
    }


    private void getParents(TreeNode root, int parent, Map<Integer, Set<Integer>> map){
        if(root == null){
            return;
        }
        if(!map.containsKey(root.val)){
            map.put(root.val, new HashSet<>());
        }
        Set<Integer> adj = map.get(root.val);
        if(parent != -1){
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
