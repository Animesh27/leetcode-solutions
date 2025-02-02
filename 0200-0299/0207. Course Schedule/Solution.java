class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i < numCourses; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0;i< numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v: graph.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
            count++;
        }
        return count == numCourses;
    }
}