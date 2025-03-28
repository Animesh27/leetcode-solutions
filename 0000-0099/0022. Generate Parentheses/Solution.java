class Solution {
    List<String> output = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backTrack(new StringBuilder(), n, 0, 0);
        return output;
    }
    public void backTrack(StringBuilder sb, int n, int openingBracketCount, int closingBracketCount){
        if(sb.length() == n*2){
            output.add(new String(sb));
            return;
        }
        if(openingBracketCount < n){
            sb.append("(");
            backTrack(sb, n, openingBracketCount + 1, closingBracketCount);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closingBracketCount < openingBracketCount){
            sb.append(")");
            backTrack(sb, n, openingBracketCount, closingBracketCount + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}