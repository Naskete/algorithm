package daliy;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivByFive {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum = ((sum << 1) + num) % 5;
            ans.add(sum == 0);
        }
        return ans;
    }
}
