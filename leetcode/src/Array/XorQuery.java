package Array;

public class XorQuery {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int m = arr.length;
        int[] xor = new int[m];
        xor[0] = arr[0];
        for (int i = 1; i < m; i++) {
            xor[i] = arr[i] ^ xor[i - 1];
        }
        int n = queries.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xor[queries[i][0]] ^ xor[queries[i][1]];
        }
        return ans;
    }
}
