class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, wordDict, 0, memo);
    }

    public boolean helper(String s, List<String> wordDict, int index, Boolean[] memo){
        // Base Case
        if(index > s.length()) return false;
        if(index == s.length()) return true;
        if(memo[index] != null) return memo[index];

        // Execution
        boolean wb = false;
        for(int i = index;i<=s.length();i++){
            if(wordDict.contains(s.substring(index, i))){
                wb = wb || helper(s, wordDict, i, memo);
            }
        }
        // Return
        return memo[index] = wb;
    }
}