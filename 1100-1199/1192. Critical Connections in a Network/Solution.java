class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // Create undirected graph
        for(List<Integer> edge: connections){
            int u = edge.get(0);
            int v = edge.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        Set<Integer> seen = new HashSet<>();
        dfs(0, graph, disc, low, parent, seen, 0);
        return ans;
    }

    public void dfs(int src, Map<Integer, List<Integer>> graph, int[] disc, int[] low, int[] parent, Set<Integer> seen, int time){
        seen.add(src);
        disc[src] = low[src] = ++time;
        for(int v: graph.get(src)){
            if(!seen.contains(v)){
                parent[v] = src;
                dfs(v, graph, disc, low, parent, seen, time);
                low[src] = Math.min(low[v], low[src]);
                if(low[v] > disc[src]) ans.add(new ArrayList<>(){{add(v);add(src);}});
            } else if (v != parent[src]){
                low[src] = Math.min(low[src], disc[v]);
            }
        }
    }
}