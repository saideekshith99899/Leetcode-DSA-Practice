class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int mask = 0; mask < (1 << n); mask++) {    
            List<Integer> temp = new ArrayList<>();       
            for(int i=0; i<n; i++) {
                if(((mask >> i) & 1) == 1) {
                    temp.add(nums[i]);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
