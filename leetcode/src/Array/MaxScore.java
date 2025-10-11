package Array;

import java.util.PriorityQueue;

public class MaxScore {
    public long maxKElements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.add(num);
        }
        long ans = 0L;
        for (int i =0; i < k; i++) {
            Integer maxValue = queue.poll();
            ans += maxValue;
            int mod = maxValue % 3;
            queue.add(mod == 0 ? maxValue / 3 : maxValue / 3 + 1);
        }
        return ans;
    }
}
