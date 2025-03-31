class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        List<int[]> sortedFriends = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            sortedFriends.add(new int[]{i, times[i][0], times[i][1]});
        }
        sortedFriends.sort(Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int chairIndex = 0;
        for(int[] friend: sortedFriends){
            while(!occupiedChairs.isEmpty() && occupiedChairs.peek()[1] <= friend[1]){
                availableChairs.offer(occupiedChairs.poll()[0]);
            }
            int assignedChair = 0;
            if(!availableChairs.isEmpty()){
                assignedChair = availableChairs.poll();
            } else {
                assignedChair = chairIndex;
                chairIndex++;
            }
            occupiedChairs.offer(new int[]{assignedChair, friend[2]});
            if (friend[0] == targetFriend) {
                return assignedChair;
            }
        }
        return -1;
    }
}