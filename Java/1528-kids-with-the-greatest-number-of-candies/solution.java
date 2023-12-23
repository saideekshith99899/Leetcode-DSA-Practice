import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        List<Boolean> list = new ArrayList<>();

        int m;
        m = Arrays.stream(candies).max().orElse(0);

        for(int i=0;i<candies.length;i++){


            
                list.add(candies[i] + extraCandies >= m);
            
            
        }

    return list;

        
    }
}
