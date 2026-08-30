class Solution {
    public int sumDecoded(long[] nums) {
        long sum = 0;
        long mod = 1000000007;
        for(int i=0; i<nums.length; i++) {
            int width = (int)(nums[i] % 10);
            long di = nums[i]/10;
            String str = String.valueOf(di);
            int x = Integer.parseInt(str.substring(0,width));
            int y = Integer.parseInt(str.substring(width));

            long decode  = power(x,y,mod);
            sum = (sum + decode) % mod;
        }
        return (int) sum;
    }

    public long power(long x , long y, long mod) {
        long res = 1;
        while(y>0) {
            if(y % 2 == 1){
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            y = y/2;
        }
        return res;
    }
}
