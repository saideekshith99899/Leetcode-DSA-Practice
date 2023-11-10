class Solution {
    public int countHomogenous(String s) {
        int MOD = 1000000007;
        int ans = (int) s.length();
        int count=1;
        for(int i=1;i<(int) s.length();i++){
            if(s.charAt(i)== s.charAt(i-1)){

                ans = (ans+count)%MOD;
                count++;
            }
            else{
                count=1;
            }
        }
        

        return ans;
    }
}
