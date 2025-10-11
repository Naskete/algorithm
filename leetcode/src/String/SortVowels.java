package String;

import java.util.*;

public class SortVowels {
    // 模拟
    public String sortVowels(String s) {
        char[] charArray = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> list = new ArrayList<>();
        for (char c : charArray) {
            if (set.contains(c)) {
                list.add(c);
            }
        }
        Collections.sort(list);
        int idx = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (set.contains(charArray[i])) {
                charArray[i] = list.get(idx++);
            }
        }
        return String.valueOf(charArray);
    }
}
