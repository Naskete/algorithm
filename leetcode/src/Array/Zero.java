package Array;

public class Zero {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        long res = 0;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                long count = cnt * (cnt + 1) / 2;
                res = res + count;
                cnt = 0;
            }
        }
        res = res + cnt * (cnt + 1) / 2;
        return  res;
    }
}
