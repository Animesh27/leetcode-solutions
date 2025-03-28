class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            int curr = map.get(s.substring(i,i+1));
            int next = i + 1 < s.length() ? map.get(s.substring(i+1, i+2)) : 0;
            if(next > curr){
                ans += (next-curr);
                i++;
            } else {
                ans += curr;
            }
        }
        return ans;
    }
}