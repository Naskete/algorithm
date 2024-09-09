package Matrix;

import LinkedList.ListNode;

import java.util.Arrays;

public class SpiralIV {
    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(0);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next = new ListNode(1);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);
        System.out.println(Arrays.deepToString(spiralMatrix(3, 5, node)));
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        fillMatrix(0, 0, 0, 0, m - 1, n - 1, head, res);
        return res;
    }

    private static void fillMatrix(int x, int y, int startX, int startY, int endX, int endY, ListNode head, int[][] res) {
        if (startX > endX || startY > endY || head == null) {
            return;
        }
        while (y < endY && head.next != null) {
            res[x][y] = head.val;
            y++;
            head = head.next;
        }
        x = startX + 1;
        y = endY - 1;
        while (x < endX && head.next != null) {
            res[x][y] = head.val;
            head = head.next;
            x++;
        }
        y = endY - 2;
        x = endX - 1;
        while (y > startX && head.next != null) {
            res[x][y] = head.val;
            head = head.next;
            y--;
        }
        x = endX - 2;
        y = startY;
        while (x > startY && head.next != null) {
            res[x][y] = head.val;
            head = head.next;
            x--;
        }
        fillMatrix(x + 1, y + 1, startX + 1, startY + 1, endX - 1, endY - 1, head, res);
    }
}
