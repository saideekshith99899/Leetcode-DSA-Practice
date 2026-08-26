class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> allcombi = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        find(candidates,target,allcombi,current,0);
        return allcombi;
    }
    public void find(int[] candidates, int target, List<List<Integer>> allcombi, List<Integer> current, int start){
        if(target == 0) {
            allcombi.add(new ArrayList<>(current));
            return;
        }
        if(target < 0) return;        
        for(int i= start; i < candidates.length; i++) {
            // remove duplicates occurs twice means
            if (i > start && candidates[i] == candidates[i-1]) continue;
            // include
            current.add(candidates[i]);           
            find(candidates,target-candidates[i],allcombi,current,i+1);
            //exclude
            current.remove(current.size()-1);
        }        
    }
}
