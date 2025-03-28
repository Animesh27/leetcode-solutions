class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> output = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return output;
        }
        helper("", digits);
        return output;
    }

    public void helper(String s, String digits){
        if(digits.length() == 0){
            output.add(s);
            return;
        }
        String letters = phone.get(digits.substring(0, 1));
        for(int i = 0;i<letters.length();i++){
            helper(s + letters.substring(i,i+1), digits.substring(1));
        }

    }
}