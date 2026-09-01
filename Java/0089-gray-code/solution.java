class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] used = new boolean[1<<n]; //2^n
        result.add(0);
        used[0] = true;
        helper(n,result,used);
        return result;
    }

    public boolean helper(int n , List<Integer> result, boolean[] used) {
        // base case
        if(result.size() == (1<<n)) {
            return true;
        }
        int last = result.get(result.size()-1);
        int total = 1<<n;
        for(int bit=0; bit<total;bit++) {
            int next = last ^ (1 << bit);
            if(!used[next]) {
                result.add(next);
                used[next] = true;

                if(helper(n,result,used)){
                    return true;
                }
                result.remove(result.size()-1);
                used[next] = false;
            }
        }
        return false;
    }   
}
