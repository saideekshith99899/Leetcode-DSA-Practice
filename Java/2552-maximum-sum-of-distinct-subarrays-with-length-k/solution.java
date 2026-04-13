class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>(); 

        for(int right=0; right<nums.length; right++) {
            // count element hashmap
            if(map.containsKey(nums[right])) {
                map.put(nums[right],map.get(nums[right])+1);
            }
            else{
                map.put(nums[right],1);
            }

            sum = sum + nums[right];

            while(right - left + 1 > k){

                // remove count from hashmap 
                // we use map.size() == k must contain only 3 element counts
                // 1 time count remove , 2 times count reduce one time
                if(map.get(nums[left]) == 1) {
                    map.remove(nums[left]);
                }
                else{
                    map.put(nums[left], map.get(nums[left]) - 1);
                }   

                sum = sum - nums[left];
                left++;
            }

            if(map.size() == k && right -left + 1 == k) {
                max = Math.max(sum,max);
            }
        }
        return max;      
    }
}
