class Solution {
    public boolean threeFibonacciSum(int n) {
        int first = 0;
        int second = 1;
        int third = 1;
        while(first + second + third <= n) {
            if(first + second + third == n) {
                return true;
            }
            int next_term = second + third;
            first= second;
            second= third;
            third = next_term;
        }
        return false;
    }
}
