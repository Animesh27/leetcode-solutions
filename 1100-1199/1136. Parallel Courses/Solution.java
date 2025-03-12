class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n+1];
        for(int i = 1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] rel: relations){
            graph.get(rel[0]).add(rel[1]);
            indegree[rel[1]]++;
        }

        Deque<Integer> q = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int ans = 0;
        int num = 0;
        while(!q.isEmpty()){
            int count = q.size();
            ans++;
            while(count-- > 0){
                int u = q.poll();
                num++;
                for(int adj: graph.get(u)){
                    indegree[adj]--;
                    if(indegree[adj] == 0){
                        q.add(adj);
                    }
                }
            }
        }
        return num == n ? ans : -1;
    }
}