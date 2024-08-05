package Array;

import java.util.HashSet;
import java.util.Set;

public class KthDistinct {
    // 2053. Kth Distinct String in an Array
    public String kthDistinct(String[] arr, int k) {
        Set<String> distinct = new HashSet<>();
        Set<String> repeat = new HashSet<>();
        for (String word: arr) {
            if (distinct.contains(word)){
                repeat.add(word);
            }  else {
                distinct.add(word);
            }
        }
        int count = 0;
        for (String word : arr) {
            if (!repeat.contains(word)) {
                count++;
                if (count == k) {
                    return word;
                }
            }
        }
        return "";
    }
}
