class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> allsubsets = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    printsubsets(nums,allsubsets,current,0);
    return allsubsets;
    }

    public void printsubsets(int[] nums, List<List<Integer>> allsubsets , List<Integer> current, int i) {
        if(i == nums.length) {
            allsubsets.add(new ArrayList<>(current));
            return;
        }
        // include
        current.add(nums[i]);
        printsubsets(nums,allsubsets,current,i+1);
        // exclude
        int next = i+1;
        while(next < nums.length  && nums[i] == nums[next]) {
            next++;
        }
        current.remove(current.size()-1);
        printsubsets(nums,allsubsets,current,next);
    }
}
