class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> cs = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        find(candidates,target,cs,current,0);
        return cs;
    }

    public void find(int[] candidates, int target, List<List<Integer>> cs, List<Integer> current, int start) {
        if(target == 0) {
            cs.add(new ArrayList<>(current));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = start; i<candidates.length; i++) {
            // include
            current.add(candidates[i]);
            
            find(candidates,target-candidates[i],cs,current,i);
            current.remove(current.size()-1);
        }
    }
}
