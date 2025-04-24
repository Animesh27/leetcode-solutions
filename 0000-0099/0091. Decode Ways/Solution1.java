class Solution {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return helper(s, 0, memo);
    }

    public int helper(String s, int index, Integer[] memo){
        // Base Case
        if(index == s.length()) return 1;
        if(s.charAt(index) == '0') return 0;
        if(memo[index] != null) return memo[index];
        // Execution
        int count = helper(s, index+1, memo);
        if(index + 1 < s.length()){
            int val = Integer.parseInt(s.substring(index, index+2));
            if(val <= 26){
                count += helper(s, index+2, memo);
            }
        }
        return memo[index] = count;
    }
}