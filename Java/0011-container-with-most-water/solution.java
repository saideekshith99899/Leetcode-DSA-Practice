class Solution {
    public int maxArea(int[] height) {
        
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while(left < right) {

            int area = Math.min(height[left] , height[right]) * (right - left);
            // area = height * width => height= min(left,right) - store water
            // width = base => right - left pointers.
            if(height[left] < height[right]){
                left++;    // moving ptr which is smaller height to get large area
            }
            else{
                right--;
            }
            max = Math.max(max,area);            // update area for find larger one
        }
    return max;
    }
}
