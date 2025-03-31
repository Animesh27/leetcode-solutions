class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) availableRooms.offer(i);

        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) ->
                a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));

        int[] roomUsage = new int[n];
        for(int[] meeting: meetings){
            int start = meeting[0], duration = meeting[1] - meeting[0];
            while(!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start){
                availableRooms.offer((int) occupiedRooms.poll()[1]);
            }
            if(!availableRooms.isEmpty()){
                int room = availableRooms.poll();
                occupiedRooms.offer(new long[]{start + duration, room});
                roomUsage[room]++;
            } else {
                long[] earliest = occupiedRooms.poll();
                occupiedRooms.offer(new long[]{earliest[0] + duration, earliest[1]});
                roomUsage[(int)earliest[1]]++;
            }
        }

        int maxUsage = 0, bestRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomUsage[i] > maxUsage) {
                maxUsage = roomUsage[i];
                bestRoom = i;
            }
        }
        return bestRoom;
    }
}