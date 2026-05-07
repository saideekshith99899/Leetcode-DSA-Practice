class Solution {
    public int findMaxLength(int[] nums) {

        for(int i=0; i<nums.length;i++) {
            if(nums[i] == 0){
                nums[i] = -1;
            }
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i =1; i< prefix.length;i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        int length, maxlength = 0;
        HashMap<Integer,Integer> map = new HashMap<>(); // map(sum,index)
        map.put(0,-1);
        for(int i=0; i< prefix.length;i++) {
            if(map.containsKey(prefix[i])) {
                length = i - map.get(prefix[i]);
                maxlength = Math.max(maxlength, length);
            }
            else{
                map.put(prefix[i],i);
            }
        }




return maxlength;
        
    }
}
