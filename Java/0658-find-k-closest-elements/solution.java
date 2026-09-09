class pair implements Comparable<pair>{
    int dist;
    int val;
    pair(int dist, int val) {
        this.dist = dist;
        this.val = val;
    }
    public int compareTo(pair t) {
    if(this.dist != t.dist)
        return this.dist - t.dist;  // sort acc to distance 
    // same distance → max value should come first
    return this.val - t.val;
}
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
      PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
      for(int ele: arr){
        int dist = Math.abs(ele - x);
        pq.add(new pair(dist,ele));
        if(pq.size() > k) pq.remove();
      }

     List<Integer> result = new ArrayList<>();
      for(int i=0;i<k;i++) {
        pair top = pq.remove();
         result.add(top.val);
      }
      Collections.sort(result);
      return result;
    }
}
