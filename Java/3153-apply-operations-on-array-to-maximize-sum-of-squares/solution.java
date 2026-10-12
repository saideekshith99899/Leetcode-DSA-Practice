class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[31];
        int MOD = 1000000007;
        for(int num : nums) {
            for(int bit = 0; bit < 31; bit++) {
                if(((num >> bit) & 1) == 1) {
                    count[bit]++;
                }
            }
        }
        long answer = 0;
        for(int i=0; i<k; i++) {
            long current = 0;
            for(int bit = 0; bit < 31; bit++) {
                if(count[bit] > i) {
                    current |=  (1L << bit);
                }
            }
            answer = (answer + current * current % MOD) % MOD;
        }
        return (int) answer;
    }
}
