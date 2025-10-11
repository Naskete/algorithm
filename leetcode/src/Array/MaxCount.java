package Array;

import java.util.*;

public class MaxCount {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedNum = new HashSet<>();
        for (Integer num : banned) {
            bannedNum.add(num);
        }
        int sum = 0;
        int count = 0;
        for (int num = 1;  num <= n; num++) {
            if (sum + num <= maxSum && !bannedNum.contains(num)) {
                sum += num;
                count++;
            }
            if (sum + num > maxSum) {
                break;
            }
        }
        return count;
    }
}
