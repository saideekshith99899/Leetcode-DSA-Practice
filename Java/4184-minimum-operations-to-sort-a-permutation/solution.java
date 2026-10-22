class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int asc_count = 0;
        int desc_count = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] == (nums[i - 1] + 1) % n) {
                asc_count++;
            }

            if (nums[i - 1] == (nums[i] + 1) % n) {
                desc_count++;
            }
        }

        if (asc_count == n - 1) {
            if (nums[0] == 0) {
                return 0;
            }

            int leftRot = (n - nums[0]) % n;
            int rightRot = nums[0] + 2;

            return Math.min(leftRot, rightRot);
        }

        if (desc_count == n - 1) {
            int leftRot = nums[n - 1] + 1;
            int rightRot = (n - nums[n - 1]) % n + 1;

            return Math.min(leftRot, rightRot);
        }

        return -1;
    }
}
