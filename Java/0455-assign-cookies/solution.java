class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;   // children
        int right = 0;  // cookies

        while (left < g.length && right < s.length) {

            if (s[right] >= g[left]) {
                left++;
                right++;
            } else {
                right++;
            }
        }

        return left;
    }
}
