class Solution {
    public boolean feasible(int[] grades, int groups){
        int groupCount = 1;
        int prevSum = grades[0], prevCount = 1, currCount = 0, sum = 0;
        for(int i = 1;i<grades.length;i++){
            sum += grades[i];
            currCount++;
            if(sum > prevSum && currCount > prevCount){
                prevSum = sum;
                prevCount = currCount;
                sum = 0;
                currCount = 0;
                groupCount++;
            }
        }
        return groupCount >= groups;
    }

    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int low = 1, high = grades.length, ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(feasible(grades, mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}