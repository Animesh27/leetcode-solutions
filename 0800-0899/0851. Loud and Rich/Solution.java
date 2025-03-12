class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = quiet.length;
        int[] indegree = new int[n];
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            graph.put(i, new ArrayList<>());
            ans[i] = i;
        }
        for(int[] edge: richer){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int v = q.poll();
            for(int u: graph.get(v)){
                indegree[u]--;
                if(indegree[u] == 0){
                    q.add(u);
                }
                if(quiet[ans[u]] > quiet[ans[v]]){
                    ans[u] = ans[v];
                }
            }
        }
        return ans;
    }
}