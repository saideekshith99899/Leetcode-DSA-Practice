class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for(int num = left; num <= right; num++) {
            int count_ones = Integer.bitCount(num);
            if(isPrime(count_ones)){
            count++;
            }
        }
    return count;
    }
    public boolean isPrime(int n) {
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int i = 3; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
