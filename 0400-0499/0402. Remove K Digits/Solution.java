class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(char c: num.toCharArray()){
            while(st.size() > 0 && k > 0 && st.peek() > c){
                st.pop();
                k -= 1;
            }
            st.push(c);
        }
        for(int i=0; i<k; ++i) {
            st.pop();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: st){
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}