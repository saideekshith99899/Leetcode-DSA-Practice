class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> allper = new ArrayList<>();
       find(nums,allper,0); //start = 0
       return allper;
    }

    public void find(int[] nums, List<List<Integer>> allper, int start) {
        if(start == nums.length) {
            List<Integer> current = new ArrayList<>();
            for(int num:nums) {
                current.add(num);
            }
            allper.add(current);
            return;
        }
        for(int i = start; i<nums.length; i++) {

              if (isDuplicate(nums, start, i)) {
        continue;
    }
            swap(nums,start,i);
            find(nums,allper,start+1);
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean isDuplicate(int[] nums, int start, int i) {
    for (int j = start; j < i; j++) {
        if (nums[j] == nums[i]) {
            return true;
        }
    }
    return false;
}
}
