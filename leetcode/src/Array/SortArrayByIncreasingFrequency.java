package Array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) +  1);
        }
        Map<Integer, Integer> collect = countMap.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (Objects.equals(o1.getValue(), o2.getValue())) {
                    return o2.getKey() - o1.getKey();
                }
                return o1.getValue() - o2.getValue();
            }
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        int idx = 0;
        int[] result = new int[nums.length];
        for (Map.Entry<Integer, Integer> pair : collect.entrySet()) {
            int count = pair.getValue();
            while (count-- > 0) {
                result[idx++] = pair.getKey();
            }
        }
        return result;
    }
}
