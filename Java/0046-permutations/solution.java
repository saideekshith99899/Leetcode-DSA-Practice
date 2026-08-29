class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> allper = new ArrayList<>();
       List<Integer> current = new ArrayList<>();
       boolean visited[] = new boolean[nums.length];
       find(nums,current,allper,visited);
       return allper;
    }

    public void find(int[] nums, List<Integer> current, List<List<Integer>> allper, boolean[] visited) {
        if(current.size() == nums.length) {
            allper.add(new ArrayList<>(current));
        }

        for(int i=0;i<nums.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                current.add(nums[i]);
                find(nums,current,allper,visited);
                current.remove(current.size()-1);
                visited[i] = false;
            }
        }
    }
}
