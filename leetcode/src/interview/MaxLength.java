package interview;

public class MaxLength {
    // 最长连续山脉 num[i] < num[i + 1] < ... < num[n], num[n] > num[n + 1] > num[n + 2] > .. >num[n+...]
    public int maxLength (int[] nums) {
        int res = 0;
        int len = 0;
        int n = nums.length;
        int start = 0, end = 0;
        int top = 0;
        while (end < n) {
            if (end == start) {
                len++;
                end++;
                continue;
            }
            while (end < n && nums[end] > nums[end - 1]) {
                top = nums[end];
                end++;
                len++;
            }
            while (end < n && nums[end] < top) {
                len++;
                end++;
                res = Math.max(res, len);
            }
            start = end;
            len = 0;
            top = 0;
        }
        return res < 3 ? 0 : res;
    }
}
