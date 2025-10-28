package Hot150and100;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num :nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int curLen = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    curLen++;
                }
                ans = Math.max(ans, curLen);
            }
        }
        return ans;
    }
}
