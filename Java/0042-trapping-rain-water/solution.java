class Solution {
    public int trap(int[] height) {

        int n =height.length;
        int trapp =0;

        for(int i=0;i<n;i++){
            int j=i;
            int lm=0;
            int rm=0;
            while(j>=0){
                lm=Math.max(lm,height[j]);
                j--;
            }
            j=i;
            while(j<n){
                rm=Math.max(rm,height[j]);
                j++;
            }
            trapp += Math.min(lm,rm) - height[i];
        }
        

        return trapp;
    }
}
