class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int prev = lower - 1;
        for(int num : nums){
            if(num <lower || num > upper) continue;
            if(num > prev + 1){
                result.add(Arrays.asList(prev+1,num-1));
            }
            prev = num;
        }
        if(prev < upper){
            result.add(Arrays.asList(prev+1,upper));
        }
        return result;
    }
}
