class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 1;
        for(int i=1; i<= n; i++) {
            winner = (winner + k) % i;
        } 
        return winner + 1;       
    }
}
