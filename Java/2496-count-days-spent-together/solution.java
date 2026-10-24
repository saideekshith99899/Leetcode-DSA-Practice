class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int alice_start = today(arriveAlice,days);
        int alice_end = today(leaveAlice,days);
        int bob_start = today(arriveBob,days);
        int bob_end = today(leaveBob,days);
        int start = Math.max(alice_start, bob_start);
        int end = Math.min(alice_end, bob_end);
        return start <= end ? end - start + 1: 0;
    }
    public int today(String s, int[] days){
        int month = (s.charAt(0)-'0') * 10 + (s.charAt(1)-'0');
        int day = (s.charAt(3)-'0') * 10 + (s.charAt(4)-'0');
        int res = day;
        for(int i=0; i<month-1; i++) {
            res += days[i];
        }
        return res;
    }
}
