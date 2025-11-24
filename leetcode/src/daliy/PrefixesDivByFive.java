package daliy;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivByFive {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum <<= 1;
            sum += nums[i];
            ans.add(sum % 5 == 0);
            sum %= 5;
        }
        return ans;
    }
}
