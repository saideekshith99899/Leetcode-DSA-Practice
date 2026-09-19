class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
      Arrays.sort(boxTypes,(a,b) -> b[1] -a[1]);
      int i = 0;
      int n = boxTypes.length;
      int totalUnits = 0;

      while(i < n && truckSize > 0) {
        int box = boxTypes[i][0];
        int units = boxTypes[i][1];

        int take = Math.min(box,truckSize);
        totalUnits += units * take;
        truckSize = truckSize - take;
        i++;

      }  
      return totalUnits;
    }
}
