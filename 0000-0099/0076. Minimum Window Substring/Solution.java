class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> freq = new HashMap<>();
        for(char c: t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int start = 0, matched = 0;
        Map<Character, Integer> window = new HashMap<>();
        while(right < s.length()){
            char rChar = s.charAt(right);
            window.put(rChar, window.getOrDefault(rChar, 0) + 1);
            if(freq.containsKey(rChar) && window.get(rChar).equals(freq.get(rChar))) matched++;
            while (matched == freq.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lChar = s.charAt(left);
                window.put(lChar, window.get(lChar) - 1);
                if (freq.containsKey(lChar) && window.get(lChar) < freq.get(lChar)) {
                    matched--;
                }
                left++;  // Shrink the window
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}