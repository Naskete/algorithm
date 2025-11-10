package dp;

public class RobI {
    // https://leetcode.cn/problems/PzWKhm/description/
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robI(nums, 0, n - 2), robI(nums, 1, n - 1));
    }

    public int robI(int[] nums, int i, int j) {
        int first = nums[i], second = Math.max(nums[i], nums[i + 1]);
        for (int k = i + 2; k <= j; k++) {
            int tmp = second;
            second = Math.max(first + nums[k], second);
            first = tmp;
        }
        return second;
    }
}
