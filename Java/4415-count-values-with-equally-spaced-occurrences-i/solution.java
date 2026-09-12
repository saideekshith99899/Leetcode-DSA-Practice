class pair{
    int count;
    int firstIndex;
    int secondIndex;
    int thirdIndex;

    pair(int count, int firstIndex, int secondIndex, int thirdIndex) {
        this.count = count;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.thirdIndex = thirdIndex;
    }
}

class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,pair> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            pair p = map.getOrDefault(nums[i],new pair(0,-1,-1,-1));
            p.count++;
            if(p.count == 1) p.firstIndex = i;
            else if(p.count == 2) p.secondIndex = i;
            else if(p.count == 3) p.thirdIndex = i;
            map.put(nums[i],p);
        }
        int result = 0;
        for(pair p: map.values()) {
            if(p.count == 3 && p.secondIndex - p.firstIndex == p.thirdIndex - p.secondIndex) {
                result++;
            }
        }
        return result;    
    }
}
