class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums == null || nums.length == 0) {
            return result;
        }

        int left = bsl(nums, target);
        int right = bsr(nums, target);

        if (left <= right) {
            result[0] = left;
            result[1] = right;
        }

        return result;
    }

    public static int bsl(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (nums[left] == target) ? left : -1;
    }

    public static int bsr(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return (nums[right] == target) ? right : -1;
    }
}

