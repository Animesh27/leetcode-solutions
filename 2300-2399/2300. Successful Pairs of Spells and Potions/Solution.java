class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0;i<spells.length;i++){
            int minIndex = findIndex(spells[i], potions, success);
            ans[i] = potions.length - minIndex;
        }
        return ans;
    }

    public int findIndex(int spell, int[] potions, long success){
        int low = 0, high = potions.length;
        while(low < high){
            int mid = low + (high - low)/2;
            if((long)potions[mid] * spell >= success){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}