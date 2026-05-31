class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    // map.put(element, nextgreaterelement);
    for(int i=0; i<nums2.length; i++) {
        while(!stack.empty() && nums2[stack.peek()] < nums2[i]) {
            int index = stack.pop();
            map.put(nums2[index], nums2[i]);
        }
        stack.push(i); // always push index
    }
    while(!stack.empty()) {
        map.put(nums2[stack.pop()], -1); // rem elements in the stack
    }
    int[] result = new int[nums1.length];
    for(int i=0; i<nums1.length; i++) {
        result[i] = map.get(nums1[i]);
    }
    return result;
    }
}
