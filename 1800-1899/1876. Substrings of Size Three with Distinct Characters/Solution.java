class Solution {
    public int countGoodSubstrings(String s) {
        int k = 3;
        if (s.length() < k) return 0;
        int[] freq = new int[26]; // Frequency array for 'a' to 'z'
        int count = 0, unique = 0;
        for (int i = 0; i < s.length(); i++) {
            // Add new character in the window
            if (freq[s.charAt(i) - 'a']++ == 0) unique++;

            // Remove old character when window exceeds k
            if (i >= k) {
                if (--freq[s.charAt(i - k) - 'a'] == 0) unique--;
            }

            // Check if current window has all unique characters
            if (i >= k - 1 && unique == k) count++;
        }
        return count;
    }
}