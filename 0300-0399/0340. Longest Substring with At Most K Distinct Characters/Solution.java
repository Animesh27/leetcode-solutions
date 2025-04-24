class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;
        for(int right = 0;right<s.length();right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > k){
                char lchar = s.charAt(left);
                map.put(lchar, map.get(lchar) - 1);
                if(map.get(lchar) == 0) map.remove(lchar);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}