package Array;

public class WalkRobot {
    // 874. walking robot simulation
    // https://leetcode.com/problems/walking-robot-simulation/description/?envType=daily-question&envId=2024-09-04
    public int robotSim(int[] commands, int[][] obstacles) {
        int distance = 0;
        int face = 1;
        int x = 0, y = 0;
        for (int command : commands) {
            if (command > 0) {
                int originX= x, originY = y;
                if (face == 0) {
                    // E
                    x += command;
                    for (int[] obstacle : obstacles) {
                        if (obstacle[1] == y && obstacle[0] > originX) {
                            x = Math.min(obstacle[0] - 1, x);
                        }
                    }
                } else if (face == 1) {
                    // N
                    y += command;
                    for (int[] obstacle : obstacles) {
                        if (obstacle[0] == x && obstacle[1] > originY) {
                            y = Math.min(obstacle[1] - 1, y);
                        }
                    }
                } else if (face == 2) {
                    // W
                    x -= command;
                    for (int[] obstacle : obstacles) {
                        if (obstacle[1] == y && obstacle[0] < originX) {
                            x = Math.max(obstacle[0] + 1, x);
                        }
                    }
                } else if (face == 3) {
                    // S
                    y -= command;
                    for (int[] obstacle : obstacles) {
                        if (obstacle[0] == x && obstacle[1] < originY) {
                            y = Math.max(obstacle[1] + 1, y);
                        }
                    }
                }
                distance = Math.max(distance, x * x + y * y);
            } else {
                face = turn(face, command);
            }
        }
        return distance;
    }

    public  int turn(int face, int command) {
        if (command == -1) {
            return  (face + 3) % 4;
        }
        if (command == -2) {
            return  (face + 1) % 4;
        }
        return 0;
    }
}
