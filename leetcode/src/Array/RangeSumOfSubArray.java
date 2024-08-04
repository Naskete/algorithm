package Array;

import java.util.Arrays;

// 1508 range sum of Sorted SubArray sums
public class RangeSumOfSubArray {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[][] subSum = new int[n][n];
        int[] result = new int[(n * (n + 1)) / 2];
        int i = 0;
        for (int idx = 0; idx < n; idx++) {
            subSum[idx][idx] = nums[idx];
            result[i++] = subSum[idx][idx];
        }
        for (int row = n - 2; row >= 0; row--) {
            for (int col = row + 1; col < n; col++) {
                subSum[row][col] = subSum[row][col - 1] + nums[col];
                result[i++] = subSum[row][col];
            }
        }
        Arrays.sort(result);
        int sum = 0;
        for (int idx = left - 1; idx <= right - 1; idx++) {
            sum += result[idx];
            sum = sum % 1000000007;
        }
        return sum;
    }
}
