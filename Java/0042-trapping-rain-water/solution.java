class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int result = 0;

        while(left < right) {
            if(height[left] < height[right]) {                              
                maxL = Math.max(maxL, height[left]);
                 result +=  maxL - height[left];
                left++;              
        }
        else{                
                maxR = Math.max(maxR, height[right]);
                 result += maxR - height[right];
                right--;
        }                   
    }
        return result;        
    }
}
