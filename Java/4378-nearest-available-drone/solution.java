class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int result = -1;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<drones.length; i++) {
            int len = (Math.abs((target[0] - drones[i][0])) + Math.abs((target[1]-drones[i][1])));
       if(len <= drones[i][2] ) {
           if(len < min) {
                min = len;
               result =  i;  
           }
       }            
    }
    return result;
    }
}
