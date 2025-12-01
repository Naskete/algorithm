package daliy;

public class OneBitAndTwoBit {
    // https://leetcode.cn/problems/1-bit-and-2-bit-characters/description/?envType=daily-question&envId=2025-11-18
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (bits[n - 1] == 1) {
            return false;
        }
        int idx = 0;
        while (idx < n) {
            if (idx == n- 1 && bits[n - 1] == 0) {
                return true;
            }
            if (bits[idx] == 0) {
                idx++;
            } else {
                idx+=2;
            }
        }
        return false;
    }
}
