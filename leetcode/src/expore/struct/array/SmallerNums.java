package expore.struct.array;

public class SmallerNums {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int ans = 0;
            int cur = nums[i];
            for (int num : nums) {
                if (cur > num) {
                    ans++;
                }
            }
            res[i]  = ans;
        }
        return res;
    }
}
