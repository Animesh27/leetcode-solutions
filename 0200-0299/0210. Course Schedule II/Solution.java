class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0;i<numCourses;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] p: prerequisites){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0)
                q.add(i);
        }
        int[] ans = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            ans[count++] = u;
            for(int v: graph.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        return count == numCourses ? ans : new int[0];
    }
}