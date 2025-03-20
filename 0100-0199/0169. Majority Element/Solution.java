class Solution {
    public int majorityElement(int[] nums) {
        int cand = 0, count = 0;
        for(int num: nums){
            if(count == 0){
                cand = num;
                count = 1;
            } else if(cand == num){
                count++;
            } else {
                count--;
            }
        }
        return cand;
    }
}