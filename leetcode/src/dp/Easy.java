package dp;

public class Easy {
    // https://leetcode.cn/problems/climbing-stairs/?envType=study-plan-v2&envId=dynamic-programming
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1]= 1;
        for (int i = 2 ; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // https://leetcode.cn/problems/fibonacci-number/?envType=study-plan-v2&envId=dynamic-programming
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n+1; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
