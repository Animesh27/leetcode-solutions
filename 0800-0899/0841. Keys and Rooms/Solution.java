class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(rooms, visited, i);
                count++;
            }
        }
        return count == 1;
    }

    public void dfs(List<List<Integer>> rooms, boolean[] visited, int i){
        visited[i] = true;
        for(int u: rooms.get(i)){
            if(!visited[u]){
                dfs(rooms, visited, u);
            }
        }
    }

}