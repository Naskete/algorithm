package Array;

import java.util.Arrays;

public class MissingObservations {
    // 2028. find miss observations
    // https://leetcode.com/problems/find-missing-observations/description/?envType=daily-question&envId=2024-09-05
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int len = rolls.length;
        int sum = (len + n) * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum >= n * 6) {
            return new int[]{};
        }
        int base = sum / n;
        int mod = sum % n;
        int[] res = new int[n];
        Arrays.fill(res, base);
        for (int i = 0; i < mod; i++) {
            res[i]++;
        }
        return res;
    }
}
