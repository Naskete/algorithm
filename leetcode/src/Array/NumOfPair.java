package Array;

public class NumOfPair {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] pointA = points[i];
            for (int j = 0; j < n; j++) {
                int[] pointB = points[j];
                if (i == j || !(pointA[0] <=  pointB[0] && pointA[1] >= pointB[1])) {
                    continue;
                }
                if (n == 2) {
                    ans++;
                    continue;
                }
                boolean valid = false;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int[] pointK = points[k];
                    boolean validX = pointK[0] >= pointA[0] && pointK[0] <= pointB[0];
                    boolean validY = pointK[1] <= pointA[1] && pointK[1] >= pointB[1];
                    if (validX && validY) {
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
