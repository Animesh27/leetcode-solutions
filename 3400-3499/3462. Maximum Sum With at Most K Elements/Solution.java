class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<grid.length;i++){
            grid[i] = Arrays.stream(grid[i])
                    .boxed()
                    .sorted((a, b) -> b - a)
                    .mapToInt(p -> p)
                    .toArray();

            for(int j = 0;j<=limits[i]-1;j++){
                pq.add(grid[i][j]);
                if(pq.size() > k) pq.poll();
            }
        }
        long sum = 0;
        while(!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}