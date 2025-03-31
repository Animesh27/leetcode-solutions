class Solution {
    public int maxVowels(String s, int k) {
        int start = 0, end = 0;
        int max = 0, vowel = 0;
        while(end < s.length()){
            if(end - start + 1 < k){
                if("aeiou".indexOf(s.charAt(end)) != -1){
                    vowel++;
                }
                end++;
            } else {
                if("aeiou".indexOf(s.charAt(end)) != -1){
                    vowel++;
                }
                max = Math.max(max, vowel);
                if("aeiou".indexOf(s.charAt(start)) != -1 && vowel != 0){
                    vowel--;
                }
                start++;
                end++;
            }
        }
        return max;
    }
}