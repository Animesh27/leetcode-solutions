class Solution {
    Map<Integer, Integer> count = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();
    public int maxPoints(int num){
        if(num == 0) return 0;
        if(num == 1) return count.getOrDefault(num, 0);
        if(cache.containsKey(num)) return cache.get(num);
        int gain = count.getOrDefault(num,0);
        cache.put(num, Math.max(maxPoints(num-1), gain + maxPoints(num-2)));
        return cache.get(num);
    }
    public int deleteAndEarn(int[] nums) {
        int maxNumber = 0;
        for(int n: nums){
            count.put(n, count.getOrDefault(n,0) + n);
            maxNumber = Math.max(maxNumber, n);
        }
        return maxPoints(maxNumber);
    }
}