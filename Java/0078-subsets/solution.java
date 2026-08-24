class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> allsubsets = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        printsubset(nums,allsubsets,current,0);
        return allsubsets;
    }
    public void printsubset(int[] nums,List<List<Integer>> allsubsets ,ArrayList<Integer> current , int i) {
        
        if(i == nums.length) {
            allsubsets.add(new ArrayList<>(current));
            return;
        }
        // include 
        current.add(nums[i]);
        printsubset(nums,allsubsets,current,i+1);
        //exclude
        current.remove(current.size()-1);  // backtracking - undo
        printsubset(nums,allsubsets,current,i+1);
    }
}
