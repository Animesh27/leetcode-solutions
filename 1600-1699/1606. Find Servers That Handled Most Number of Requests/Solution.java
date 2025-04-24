class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> ans = new ArrayList<>();
        int[] busyness = new int[k];
        PriorityQueue<Server> pq = new PriorityQueue<>();
        TreeSet<Integer> availableServers = new TreeSet<>();
        int maxBusyness = 0;
        for(int i = 0;i<k;i++) availableServers.add(i);
        for(int i = 0;i<arrival.length;i++){
            long arrivalTimeOfRequest = arrival[i];
            long loadTimeOfRequest = load[i];
            while(!pq.isEmpty() && pq.peek().time <= arrivalTimeOfRequest){
                Server p = pq.poll();
                availableServers.add(p.server);
            }
            if(!availableServers.isEmpty()){
                Integer serverToBeAssigned = availableServers.ceiling(i%k);
                if(serverToBeAssigned == null) serverToBeAssigned = availableServers.first();
                pq.add(new Server(serverToBeAssigned, arrivalTimeOfRequest + loadTimeOfRequest));
                availableServers.remove(serverToBeAssigned);
                busyness[serverToBeAssigned]++;
                maxBusyness = Math.max(maxBusyness, busyness[serverToBeAssigned]);
            }
        }
        for(int i = 0;i<k;i++){
            if(busyness[i] == maxBusyness) ans.add(i);
        }
        return ans;
    }
}

class Server implements Comparable<Server> {
    int server;
    long time;
    Server(int server, long time){
        this.server = server;
        this.time = time;
    }
    public int compareTo(Server that){
        return Long.compare(this.time, that.time);
    }
}