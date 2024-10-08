package Matrix;

import LinkedList.ListNode;

import java.util.Arrays;

public class SpiralIV {
    // 2326. Spiral Matrix IV
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        fillMatrix(0, 0, 0, 0, m - 1, n - 1, head, res);
        return res;
    }

    private void fillMatrix(int x, int y, int startX, int startY, int endX, int endY, ListNode head, int[][] res) {
        if (x > endX || y > endY || head == null) {
            return;
        }
        while (y <= endY && head != null) {
            res[x][y] = head.val;
            y++;
            head = head.next;
        }
        x = startX + 1;
        y = endY;
        while (x <= endX && head != null) {
            res[x][y] = head.val;
            head = head.next;
            x++;
        }
        y = endY - 1;
        x = endX;
        while (y >= startX && head != null) {
            res[x][y] = head.val;
            head = head.next;
            y--;
        }
        x = endX - 1;
        y = startY;
        while (x > startY && head != null) {
            res[x][y] = head.val;
            head = head.next;
            x--;
        }
        fillMatrix(x + 1, y + 1, startX + 1, startY + 1, endX - 1, endY - 1, head, res);
    }
}
