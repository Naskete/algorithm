package expore.struct.array;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int ans = 0;
        while (r < n) {
            while (r < n && nums[r] == 1) {
                r++;
            }
            ans = Math.max(ans, r - l);
            while (r < n && nums[r]  == 0) {
                r++;
                l = r;
            }
        }
        return Math.max(ans, r - l);
    }
}
