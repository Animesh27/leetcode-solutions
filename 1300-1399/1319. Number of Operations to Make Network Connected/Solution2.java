class Solution {
    public void dfs(int src, boolean[] visited, Map<Integer, List<Integer>> graph){
        visited[src] = true;
        if (!graph.containsKey(src)) {
            return;
        }
        for(int u: graph.get(src)){
            if(!visited[u]){
                dfs(u, visited, graph);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] connection: connections){
            graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited, graph);
                connectedComponents++;
            }
        }
        return connectedComponents -1;
    }
}