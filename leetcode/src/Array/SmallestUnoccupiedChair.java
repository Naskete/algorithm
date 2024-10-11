package Array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        PriorityQueue<Friend> queue = new PriorityQueue<>(Comparator.comparingInt(friend -> friend.arrivalTime));
        PriorityQueue<Friend> occupyQueue = new PriorityQueue<>(Comparator.comparing(friend -> friend.leaveTime));
        PriorityQueue<Integer> chairQueue = new PriorityQueue<>();
        // 找出所有比他早到的
        int arrivalTime = times[targetFriend][0];
        Friend target = new Friend(targetFriend, arrivalTime, times[targetFriend][1]);
        queue.add(target);
        chairQueue.add(0);
        int chair = 1;
        for (int i = 0; i < n; i++) {
            Friend friend = new Friend(i, times[i][0], times[i][1]);
            if (friend.arrivalTime < arrivalTime) {
                queue.add(friend);
                chairQueue.add(chair++);
            }
        }

        while (!queue.isEmpty()) {
            Friend friend = queue.poll();
            while (!occupyQueue.isEmpty() && occupyQueue.peek().leaveTime <= friend.arrivalTime) {
                Friend leave = occupyQueue.poll();
                chairQueue.add(leave.chair);
            }
            friend.chair = chairQueue.poll();
            occupyQueue.add(friend);
            if (friend.num == targetFriend) {
                return friend.chair;
            }
        }
        return 0;
    }

    class Friend {
        int num;
        int arrivalTime;
        int leaveTime;
        Integer chair;

        public Friend(int num, int arrivalTime, int leaveTime) {
            this.num = num;
            this.arrivalTime = arrivalTime;
            this.leaveTime = leaveTime;
        }
    }
}
