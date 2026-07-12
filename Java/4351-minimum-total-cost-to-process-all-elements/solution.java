class Solution {
    public int minimumCost(int[] nums, int k) {
    long operations = 0;
    long cost = 0;
    long mod = 1000000007;
    long res = k;
    for(int i=0; i<nums.length; i++) {
        if(nums[i] <= res) {
            res = res - nums[i];
        }
        else{
           long need = nums[i] - res;
            long count = (need + (long)k -1)/(long)k;
            res = res + count * (long)k;
             long opsMod = operations % mod;
                long countMod = count % mod;
                long term1 = (opsMod * countMod) % mod;
                long term2 = (count * (count + 1) / 2) % mod;
                cost = (cost + term1 + term2) % mod;
                
                operations += count;
                res -= nums[i];
        }        
    }
        return (int)cost;
    }
}
