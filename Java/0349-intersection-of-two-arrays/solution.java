class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      
        HashSet<Integer> set = new HashSet<>();
        int[] result = new int[nums1.length];
        int k = 0;
        for(int i=0 ;i<nums1.length;i++) {
            set.add(nums1[i]);
        }
        for(int i=0 ;i<nums2.length;i++) {
        if(set.contains(nums2[i])) {
            result[k] = nums2[i];
            k++;
            set.remove(nums2[i]);
        }
        }
        return Arrays.copyOf(result,k);          
        
    }
}


