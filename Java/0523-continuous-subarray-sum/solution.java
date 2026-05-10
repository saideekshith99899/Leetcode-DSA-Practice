class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i< nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        for(int i=0; i<prefix.length; i++) {
            if(map.containsKey(prefix[i] % k)) {
                if(i - map.get(prefix[i]%k) >=2) {
                return true;
            }
        }
            else{
                map.put(prefix[i]%k , i);
            }
        }

      return false;  
    }
}
