class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for(int[] redEdge: redEdges){
            graph.computeIfAbsent(redEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(redEdge[1], 0));
        }
        for(int[] blueEdge: blueEdges){
            graph.computeIfAbsent(blueEdge[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(blueEdge[1], 1));
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        boolean[][] visited = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, -1});
        ans[0] = 0;
        visited[0][1] = visited[0][0] = true;
        while(!q.isEmpty()){
            int[] element = q.poll();
            int node = element[0], steps = element[1], prevColor = element[2];
            if(!graph.containsKey(node)) continue;
            for(List<Integer> nei: graph.get(node)){
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if(!visited[neighbor][color] && color != prevColor){
                    if(ans[neighbor] == -1){
                        ans[neighbor] = 1 + steps;
                    }
                    visited[neighbor][color] = true;
                    q.add(new int[]{neighbor, steps+1,color});
                }
            }
        }
        return ans;
    }
}