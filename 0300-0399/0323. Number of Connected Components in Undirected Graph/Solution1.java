class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(visited, i, graph);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(boolean[] visited, int s, Map<Integer, List<Integer>> graph){
        visited[s] = true;
        for(int u: graph.get(s)){
            if(!visited[u]){
                dfs(visited, u, graph);
            }
        }
    }
}