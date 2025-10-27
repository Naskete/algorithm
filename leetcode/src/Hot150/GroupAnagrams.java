package Hot150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        int[] arr = new int[26];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            arr[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int n : arr) {
            builder.append(n).append(".");
        }
        return builder.toString();
    }
}
