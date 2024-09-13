package Array;

public class XorQuery {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = arr.length;
        int[][] xor = new int[m][m];
        for (int i = 0; i < m; i++) {
            xor[i][i] = arr[i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                xor[i][j] = xor[i][j - 1] ^ arr[j];
            }
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xor[queries[i][0]][queries[i][1]];
        }
        return ans;
    }
}
