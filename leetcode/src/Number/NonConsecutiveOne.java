package Number;

public class NonConsecutiveOne {
    // 600. Non-negative Integers without Consecutive Ones
    public int findIntegers(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += hasConsecutiveOne(i);
        }
        return res;
    }

    private int hasConsecutiveOne(int num) {
        int half = num >> 1;
        return (half ^ num) == 0 ? 1 : 0;
    }
}
