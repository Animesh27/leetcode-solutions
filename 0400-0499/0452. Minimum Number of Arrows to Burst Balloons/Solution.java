class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> {
            // We can't simply use the o1[1] - o2[1] trick, as this will cause an 
            // integer overflow for very large or small values.
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });
        int ans = 1;
        int iStart, iEnd, firstEnd = points[0][1];
        for(int[] interval: points){
            iStart = interval[0];
            iEnd = interval[1];
            if(iStart > firstEnd){
                ans++;
                firstEnd = iEnd;
            }
        }
        return ans;
    }
}