class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> allcombi = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        find(k,n,allcombi,current,1); // start =1 
        return allcombi;
    }

    public void find(int k, int n, List<List<Integer>> allcombi, List<Integer> current, int start) {
        if( current.size() == k && n == 0 ) {
            allcombi.add(new ArrayList<>(current));
            return;
        }
        //if(n < 0) return;
        for(int i=start; i<=9;i++) {
            // include
            current.add(i);
            find(k,n-i,allcombi,current,i+1);
            //exclude-backtrack
            current.remove(current.size()-1);

        }
    }
}
