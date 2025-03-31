class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> freqCount = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0, right = 0, max = 0;
        while(right < s.length()){
            charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);
            if (right - left + 1 > minSize) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++; // Shrink window from left
            }
            if(right - left + 1 == minSize && charCount.size() <= maxLetters){
                String subString = s.substring(left, right+1);
                freqCount.put(subString, freqCount.getOrDefault(subString, 0) + 1);
                max = Math.max(max, freqCount.get(subString));
            }
            right++;
        }
        return max;
    }
}