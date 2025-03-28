class Solution {
    public int minSwaps(int[] data) {
        int ones = Arrays.stream(data).sum();
        int left = 0, right = 0;
        int countOne = 0, maxOne = 0;
        while(right < data.length){
            countOne += data[right++];
            if(right - left > ones){
                countOne -= data[left++];
            }
            maxOne = Math.max(maxOne, countOne);
        }
        return ones - maxOne;
    }
}