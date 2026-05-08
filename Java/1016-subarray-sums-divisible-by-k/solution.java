class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i<nums.length; i++){

            prefix[i] = prefix[i-1] + nums[i];
        }
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);                   // map(rem,count);
        for(int i=0; i< prefix.length; i++) {
            int rem = ((prefix[i] % k) + k ) % k;
            if(map.containsKey(rem)){
                count = count + map.get(rem);
                map.put(rem, map.get(rem) +1);
            }
            else{
                map.put(rem, 1);
            }            
        }
        return count;
    }
}
