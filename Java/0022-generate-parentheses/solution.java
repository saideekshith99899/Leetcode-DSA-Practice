class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        find(n,current,result,0,0); //open,close = 0 intially;
        return result;
    }

    public void find(int n, StringBuilder current, List<String> result,int open, int close) {
        //base case
        if(open + close == 2 *n) {
            result.add(current.toString());
            return;
        }

        if(open  < n){ 
            current.append('(');
            find(n,current,result,open+1,close);
            current.deleteCharAt(current.length()-1);
        }

        if(close< open){
            current.append(')');
            find(n,current,result,open,close+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
