class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visited = new boolean[n];
        pq.add(new int[]{0, 0});

        int edgesUsed = 0;
        int minCost = 0;
        while(!pq.isEmpty() && edgesUsed < n){
            int[] curr = pq.poll();
            int u = curr[0], cost = curr[1];
            if(visited[u]){
                continue;
            }
            visited[u] = true;
            minCost += cost;
            edgesUsed++;
            for(int i = 0;i<n;i++){
                int distance = Math.abs(points[u][0] - points[i][0]) + Math.abs(points[u][1] - points[i][1]);
                pq.add(new int[]{i, distance});
            }
        }
        return minCost;
    }
}