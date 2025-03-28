class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getDigitSquareSum(n);
        while(fast != 1 && slow != fast){
            slow = getDigitSquareSum(slow);
            fast = getDigitSquareSum(getDigitSquareSum(fast));
        }
        return fast == 1;
    }

    public int getDigitSquareSum(int number){
        int totalSum = 0;
        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digit, 2));
        }
        return totalSum;
    }
}