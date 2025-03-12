class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managerGraph = new HashMap<>();
        for(int i = 0;i<n;i++){
            managerGraph.putIfAbsent(manager[i], new ArrayList<>());
            managerGraph.get(manager[i]).add(i);
        }
        return dfs(managerGraph, informTime, headID);
    }

    public int dfs(Map<Integer, List<Integer>> managerGraph, int[] informTime, int src){
        if(!managerGraph.containsKey(src)){
            return 0;
        }
        int max = 0;
        for(int adj: managerGraph.get(src)){
            max = Math.max(max, dfs(managerGraph, informTime, adj));
        }
        return max + informTime[src];
    }
}