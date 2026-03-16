class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        int max_freq = 0;
        int result = -1;

        for(int i=0;i<nums.length;i++) {

            if(nums[i] % 2 == 0) {

                int freq = map.get(nums[i]); 

                if(freq > max_freq) {
                    max_freq = freq;
                    result = nums[i];
                }
                else if(freq == max_freq){
                    if(nums[i] < result)
                    {
                        result = nums[i];
                    }
                }
            }
        }

        return result;       
        
    }
}
