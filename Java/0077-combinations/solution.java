class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allcombi = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        findcombinations(n,k,allcombi,current,1); // index i  = 0
        return allcombi;
    }

    public void findcombinations(int n, int k,List<List<Integer>> allcombi, List<Integer> current, int start){
        if(current.size() == k) {
            allcombi.add(new ArrayList<>(current));
            return;
        }
        //include
        for(int i = start; i <= n; i++) {
        current.add(i);
        findcombinations(n, k, allcombi, current, i + 1);
        //exclude
        current.remove(current.size()-1); // backtrack
        }
    }
}
