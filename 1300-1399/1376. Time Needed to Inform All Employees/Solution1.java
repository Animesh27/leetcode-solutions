class Solution {
    int maxTime = Integer.MIN_VALUE;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> managerGraph = new HashMap<>();
        for(int i = 0;i<n;i++){
            managerGraph.put(i, new ArrayList<>());
        }
        // Graph of manager -> employees
        for(int i = 0;i<manager.length;i++){
            if(manager[i] != -1){
                managerGraph.get(manager[i]).add(i);
            }
        }
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(headID, 0));
        while(!q.isEmpty()){
            Pair<Integer, Integer> empPair = q.poll();
            int parent = empPair.getKey();
            int time = empPair.getValue();
            maxTime = Math.max(maxTime, time);
            for(int adj: managerGraph.get(parent)){
                q.add(new Pair<>(adj, time + informTime[parent]));
            }
        }
        return maxTime;
    }
}