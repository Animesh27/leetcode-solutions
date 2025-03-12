class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(isConnected, i, visited, n);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited, int n){
        visited[i] = true;
        for(int j = 0;j<n;j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected, j, visited, n);
            }
        }
    }
}