package Array;

public class Area {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int len = dimensions.length;
        int maxSqrt = -1, maxLen = 0;
        for (int i = 0; i < len; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            int sqrt = l * w;
            int dimension = l * l + w * w;
            if (dimension > maxLen) {
                maxLen = dimension;
                maxSqrt = sqrt;
            } else if (dimension == maxLen) {
                maxSqrt = Math.max(sqrt, maxSqrt);
            }
        }
        return maxSqrt;
    }
}
