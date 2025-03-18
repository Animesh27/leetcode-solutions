class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                bfs(isConnected, i, visited, n);
                ans++;
            }
        }
        return ans;
    }

    public void bfs(int[][] isConnected, int node, boolean[] visited, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;
        while(!q.isEmpty()){
            int i = q.poll();
            visited[i] = true;
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1 && !visited[j]){
                    q.add(j);
                }
            }
        }
    }
}