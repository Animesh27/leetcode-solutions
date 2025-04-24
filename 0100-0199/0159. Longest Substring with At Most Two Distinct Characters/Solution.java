class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while(map.size() > 2){
                char lchar = s.charAt(left);
                map.put(lchar, map.get(lchar) - 1);
                if(map.get(lchar) == 0) map.remove(lchar);
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}