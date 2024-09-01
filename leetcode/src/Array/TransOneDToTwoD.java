package Array;

public class TransOneDToTwoD {
    // 2022. Convert 1D Array Into 2D Array
    // https://leetcode.com/problems/convert-1d-array-into-2d-array/description/?envType=daily-question&envId=2024-09-01
    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;
        if (len != m * n) {
            return new int[][]{};
        }
        int idx = 0;
        int[][] trans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[i][j] = original[idx++];
            }
        }
        return trans;
    }
}
