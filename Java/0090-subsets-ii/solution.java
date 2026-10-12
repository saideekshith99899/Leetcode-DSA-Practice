class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int mask = 0; mask <(1 << n); mask++) {
            List<Integer> temp =  new ArrayList<>();
            boolean valid = true;
            for(int i=0; i<n; i++) {
                if(((mask >> i) & 1) == 1) {
                    // check already duplicate present or not
                    if(i> 0 && nums[i] == nums[i-1]  && 
                            (mask >> (i-1) & 1) == 0)
                        {
                                valid = false;
                                break;
                        }
                    temp.add(nums[i]);        
                }
            }
            if(valid) list.add(temp);
        }
        return list;
    }
}
