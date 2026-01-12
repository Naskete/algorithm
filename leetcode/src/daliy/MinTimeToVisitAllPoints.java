package daliy;

public class MinTimeToVisitAllPoints {
    //切比雪夫距离:
    //对于平面上的两个点 x = (x0, x1) 和 y = (y0, y1)，设它们横坐标距离之差为 dx = |x0 - y0|，纵坐标距离之差为 dy = |x1 - y1|，对于以下三种情况，我们可以分别计算出从 x 移动到 y 的最少次数：
    // * dx < dy：沿对角线移动 dx 次，再竖直移动 dy - dx 次，总计 dx + (dy - dx) = dy 次；
    // * dx == dy：沿对角线移动 dx 次；
    // * dx > dy：沿对角线移动 dy 次，再水平移动 dx - dy 次，总计 dy + (dx - dy) = dx 次
    public int minTimeToVisitAllPoints(int[][] points) {
        int x0 = points[0][0], y0 = points[0][1];
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            ans += Math.max(Math.abs(x0 - x1), Math.abs(y0 - y1));
            x0 = x1;
            y0 = y1;
        }
        return ans;
    }
}
