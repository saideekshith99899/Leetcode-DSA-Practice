class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] answer = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> treeset = new TreeSet<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num,0)+1);
            treeset.add(num);
        }
        int i = 0;
        while(i < nums.length) {
            for(int num: treeset) {
                if(map.get(num) > 0) {
                    answer[i] = num;
                    i++;
                    map.put(num,map.get(num)-1);
                }
            }
        }
        return answer;
    }
}
