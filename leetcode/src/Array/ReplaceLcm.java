package Array;

import java.util.ArrayList;
import java.util.List;

public class ReplaceLcm {
    // https://leetcode.cn/problems/replace-non-coprime-numbers-in-array/description/
    public List<Integer> replaceNonCoprimess(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int idx = 1, n = nums.length;
        while (idx < n) {
            int num = nums[idx];
            while (!list.isEmpty()) {
                Integer e = list.getLast();
                int gcd = gcd(num, e);
                if (gcd > 1) {
                    list.removeLast();
                    num = lcm(num, e);
                } else {
                    break;
                }
            }
            list.add(num);
            idx++;
        }
        return list;
    }

    // 求最大公因数 x, y => y ！= 0 , x = y, y = x % y;
    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        while (y != 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x;
    }

    // 求最小公倍数 x / gcd * y
    public int lcm(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
        int gcd = gcd(x, y);
        return x / gcd * y;
    }
}
