class Solution {
    public int minimumCost(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n+1];
        pq.add(new int[]{1, 0});
        int minCost = 0;
        int edgesUsed = 0;
        while(!pq.isEmpty() && edgesUsed < n){
            int[] curr = pq.poll();
            int u = curr[0], cost = curr[1];
            if(visited[u]){
                continue;
            }

            visited[u] = true;
            minCost += cost;
            edgesUsed++;

            for(int i = 0;i<connections.length;i++){
                if(connections[i][0] == u && !visited[connections[i][1]]){
                    pq.add(new int[]{connections[i][1], connections[i][2]});
                }
                if(connections[i][1] == u && !visited[connections[i][0]]){
                    pq.add(new int[]{connections[i][0], connections[i][2]});
                }
            }
        }
        return edgesUsed < n ? -1 : minCost;
    }
}