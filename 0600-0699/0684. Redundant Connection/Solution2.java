class Solution {
    int cycleStart = -1;
    public void dfs(Map<Integer, List<Integer>> graph, int src, boolean[] visited, int[] parent){
        visited[src] = true;
        for(int adj: graph.get(src)){
            if(!visited[adj]){
                parent[adj] = src;
                dfs(graph, adj, visited, parent);
            } else if(adj != parent[src] && cycleStart == -1){
                cycleStart = adj;
                parent[adj] = src;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        for(int[] edge: edges){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(graph, 1, visited, parent);
        Set<Integer> cycleNodes = new HashSet<>();
        int node = cycleStart;
        do {
            cycleNodes.add(node);
            node = parent[node];
        } while(node != cycleStart);

        for(int i = edges.length - 1;i >= 0;i--){
            if(cycleNodes.contains(edges[i][0]) && cycleNodes.contains(edges[i][1])){
                return edges[i];
            }
        }
        return new int[]{};
    }
}