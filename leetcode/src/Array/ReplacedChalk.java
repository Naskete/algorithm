package Array;

public class ReplacedChalk {
    // 1894. find the student that will replace the chalk
    // https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/?envType=daily-question&envId=2024-09-02
    public int chalkReplacer(int[] chalk, int k) {
        int len = chalk.length;
        long[] costSum = new long[len];
        costSum[0] = chalk[0];
        for (int i = 1; i < len; i++) {
            costSum[i] = chalk[i] + costSum[i - 1];
        }
        long sum = costSum[len - 1];
        long mod = k % sum;
        for (int i = 0; i < len; i++) {
            if (mod < costSum[i]) {
                return i;
            }
        }
        return 0;
    }
}
