package Number;

public class FlipsNum {
    // 2220. minimum bit flips to convert number
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int res = 0;
        while (xor > 0) {
            int add = xor & 1;
            res += add;
            xor >>= 1;
        }
        return res;
    }
}
