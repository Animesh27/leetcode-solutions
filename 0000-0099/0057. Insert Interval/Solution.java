class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int i = 0;
        int n = intervals.length;
        List<int[]> outputList = new ArrayList<>();
        while(i<n && intervals[i][0] < newStart){
            outputList.add(intervals[i]);
            i++;
        }
        if(outputList.isEmpty() || outputList.get(outputList.size() - 1)[1] < newStart){
            outputList.add(newInterval);
        } else {
            outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], newEnd);
        }
        while(i < n){
            int[] ei = intervals[i];
            int start = ei[0];
            int end = ei[1];
            if (outputList.get(outputList.size() - 1)[1] < start) {
                outputList.add(ei);
            } else {
                outputList.get(outputList.size() - 1)[1] = Math.max(outputList.get(outputList.size() - 1)[1], end);
            }
            i += 1;
        }
        return outputList.toArray(new int[0][]);
    }
}