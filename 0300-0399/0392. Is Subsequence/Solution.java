class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] x = s.toCharArray();
        char[] y = t.toCharArray();
        int i=0,j=0;

        while(i<x.length && j<y.length){
            if(x[i] == y[j]){
                i++;

            }
            j++;
        }

        return i==x.length;
    }
}