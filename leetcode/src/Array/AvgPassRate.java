package Array;

import java.util.PriorityQueue;

public class AvgPassRate {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            long val1 = (long) (a[1] + 1) * a[1]  * (b[1] - b[0]);
            long val2 = (long) (b[1] + 1) * b[1]  * (a[1] - a[0]);
            if (val1 ==  val2) {
                return 0;
            }
            return val1 > val2 ? 1 : -1;
        });
        for (int[] clazz : classes) {
            queue.add(new int[]{clazz[0], clazz[1]});
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] clazz = queue.poll();
            int pass = clazz[0], total = clazz[1];
            queue.add(new int[]{pass + 1, total + 1});
        }
        double sum = 0.0;
        while (!queue.isEmpty()) {
            int[] clazz = queue.poll();
            int pass = clazz[0], total = clazz[1];
            double passRate = 1.0 * pass / total;
            sum += passRate;
        }
        int classCount = classes.length;
        return sum / classCount;
    }
}
