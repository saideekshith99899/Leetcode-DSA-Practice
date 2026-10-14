class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num)
            return "";
        int quotient = sum / 9;
        int remainder = sum % 9;
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < quotient; i++)
            sb.append('9');
        if (remainder > 0)
            sb.append((char) ('0' + remainder));
        while (sb.length() < num)
            sb.append('0');
        return sb.toString();
    }
}
