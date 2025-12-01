package daliy;

public class MaxSumDivThree {
    public int maxSumDivThree(int[] nums) {
        return getMaxSum(nums, 0, nums.length, 0, 0);
    }

    public int getMaxSum(int[] nums, int cur, int len, int add, int max) {
        if (cur == len) {
            if (add % 3 == 0) {
                return Math.max(max, add);
            }
            return max;
        }
        if (cur > 0 && add % 3 == 0) {
            max = Math.max(add, max);
        }
        int added = getMaxSum(nums, cur + 1, len, add + nums[cur], max);
        int noAdd = getMaxSum(nums, cur + 1, len, add, max);
        return Math.max(added, noAdd);
    }
}
