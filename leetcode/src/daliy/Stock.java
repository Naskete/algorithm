package daliy;

public class Stock {
    public long getDescentPeriods(int[] prices) {
        int l = 0, r = 0;
        int n = prices.length;
        long ans = 0L;
        while (r < n) {
            while (r + 1 < n && prices[r + 1] == prices[r] - 1) {
                r++;
            }
            long len = r - l + 1;
            ans += len * (len + 1) / 2;
            r++;
            l = r;
        }
        return ans;
    }
}
