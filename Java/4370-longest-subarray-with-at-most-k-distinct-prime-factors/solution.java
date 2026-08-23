class Solution {
    public int longestSubarray(int[] nums, int k) {
        int left = 0;
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int right=0;right<nums.length;right++) {
            ArrayList<Integer> fac = primefac(nums[right]);
            for(int p : fac){
                map.put(p,map.getOrDefault(p,0)+1);
            }
        while(map.size() > k) {
            ArrayList<Integer> leftfac = primefac(nums[left]);
            for(int p: leftfac) {
                map.put(p,map.get(p)-1);
                if(map.get(p) == 0){
                    map.remove(p);
                }
            }
            left++;
        }
         result = Math.max(result,right-left+1);
    }
      return result;
    }


    public ArrayList<Integer> primefac(int num) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i= 2; i*i <=num; i++) {
            if(num % i == 0) {
                factors.add(i);
                while(num % i == 0) {
                    num/=i;
                }
            }
        }
        if(num > 1){
            factors.add(num);
        }
        return factors;
    }
}
