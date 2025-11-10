package interview;

public class WVBag {
    public int maxValue(int[] w, int[] v, int[] p, int W, int V) {
        int n = w.length;
        // dp[i][j] 表示重量限制i、体积限制j时的最大价值
        int[][] dp = new int[W + 1][V + 1];

        // 初始化：dp[0][0] = 0，其他默认0

        // 遍历每个物品
        for (int k = 0; k < n; k++) {
            // 倒序遍历重量，避免重复选择
            for (int i = W; i >= w[k]; i--) {
                // 倒序遍历体积
                for (int j = V; j >= v[k]; j--) {
                    // 选择当前物品或不选择当前物品
                    dp[i][j] = Math.max(dp[i][j], dp[i - w[k]][j - v[k]] + p[k]);
                }
            }
        }

        return dp[W][V];
    }

    // 测试用例
//    public static void main(String[] args) {
//        WVBag solution = new WVBag();
//
//        // 示例
//        int[] w = {2, 3, 4};  // 重量
//        int[] v = {3, 2, 1};  // 体积
//        int[] p = {4, 5, 6};  // 价值
//        int W = 5;  // 最大重量
//        int V = 4;  // 最大体积
//
//        int result = solution.maxValue(w, v, p, W, V);
//        System.out.println("最大价值: " + result); // 输出: 11
//    }
}
