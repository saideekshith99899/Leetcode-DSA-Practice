class Solution {
    public double myPow(double x, int n) {
        long N = Math.abs((long) n);
        double result = rec(x,N);
        return n < 0 ? 1/ result : result;
}
    public double rec(double x, long n) {
        if(n == 0) return 1;

        double half = rec(x,n/2);
        if(n % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
}
