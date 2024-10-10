package Array;

import java.util.Stack;

public class Ramp {
    public static void main(String[] args) {
        System.out.println(maximumWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(maximumWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
    public static int maximumWidthRamp(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1;
            while (j > i && nums[j] < nums[i]) {
                j--;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
