package daliy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> times = map.values().stream().sorted((x,y) -> y - x).toList();
        int maxFre = times.getFirst();
        int ans = 0;
        for (Integer time : times) {
            System.out.println(time);
            if (time == maxFre) {
                ans+= time;
            }
        }
        return ans;
    }
}
