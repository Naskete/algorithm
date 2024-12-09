package Array;

import java.util.PriorityQueue;

public class MinCost {
    public Integer minCost(int[] nums, int maxOperations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        while (maxOperations > 0 && !queue.isEmpty()) {
            Integer maxCost = queue.poll();
            int half = maxCost / 2;
            int mod = maxCost % 2;
            queue.add(half);
            if (mod == 0) {
                queue.add(half);
            } else {
                queue.add(half+1);
            }
            maxOperations--;
        }
        return queue.poll();
    }
}
