class Solution {
    public int minMovesToMakePalindrome(String s) {
        char[] str = s.toCharArray();
        int minSwaps = 0;
        int i = 0, j = str.length-1;
        while(i < j){
            int k = j;
            while(i < k){
                if(str[i] == str[k]){
                    while(j != k){
                        char temp = str[k];
                        str[k] = str[k+1];
                        str[k+1] = temp;
                        k++;
                        minSwaps++;
                    }
                    j--;
                    break;
                }
                k--;
            }
            if(i == k){
                minSwaps += (str.length / 2 - i);
            }
            i++;
        }
        // Replace this placeholder return statement with your code
        return minSwaps;
    }
}