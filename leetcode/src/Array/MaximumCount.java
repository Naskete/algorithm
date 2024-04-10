package Array;

public class MaximumCount {
    // 2529. 正整数和负整数的最大计数
    public int maximumCount(int[] numbers) {
        int pos = 0, neg = 0;
        for (int num : numbers) {
            if (num < 0) neg++;
            if (num > 0) pos++;
        }
        return Math.max(pos, neg);
    }
}
