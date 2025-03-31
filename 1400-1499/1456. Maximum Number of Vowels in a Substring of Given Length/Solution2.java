class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i','o', 'u');
        int vowel = 0;
        for(int i = 0;i<k;i++){
            vowel += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int max = vowel;
        for(int i = k;i<s.length();i++){
            vowel += vowels.contains(s.charAt(i)) ? 1 : 0;
            vowel -= vowels.contains(s.charAt(i-k)) ? 1 : 0;
            max = Math.max(max, vowel);
        }
        return max;
    }
}