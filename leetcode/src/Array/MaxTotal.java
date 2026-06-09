package Array;

public class MaxTotal {
    public long maxTotalValue(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[l]) {
                l = i;
            }
            if (nums[i] < nums[r]) {
                r = i;
            }
        }
        int less = Math.min(l, r);
        int great =  Math.max(l, r);
        long val = nums[great] - nums[less];
        return val * k;
    }

    public long maxTotalValueI(int[] nums, int k) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MIN_VALUE;
        for (int x : nums) {
            m1 = Math.min(m1, x);
            m2 = Math.max(m2, x);
        }
        return (long)(m2 - m1) * k;
    }
}
