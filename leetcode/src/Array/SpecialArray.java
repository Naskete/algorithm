package Array;

public class SpecialArray {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int m = nums.length;
        int n = queries.length;
        boolean[] res = new boolean[n];
        boolean[][] dp = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (!dp[i][j - 1]) {
                    dp[i][j] = dp[i][j-1];
                } else {
                    dp[i][j] = ((nums[j-1] % 2) != (nums[j] % 2));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = dp[queries[i][0]][queries[i][1]];
        }
        return res;
    }
}
