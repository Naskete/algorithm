package Array;

import java.util.Stack;

public class Ramp {
    public static void main(String[] args) {
        System.out.println(maximumWidthRamp(new int[]{6,0,8,2,1,5}));
        System.out.println(maximumWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1}));
    }
    public static int maximumWidthRamp(int[] nums) {
        int n = nums.length;
        int[][] ramp = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    ramp[i][j] = j - i;
                }
                max = Math.max(max, ramp[i][j]);
            }
        }
        return max;
    }
}
