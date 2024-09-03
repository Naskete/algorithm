package String;

import java.util.HashMap;
import java.util.Map;

// 1945. Sum of Digits of String After Convert
// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/?envType=daily-question&envId=2024-09-03
public class SumOfConvertInteger {
    public Integer getLuck(String s, int k) {
        Map<Character, Integer> letter = new HashMap<>();
        int cost = 1;
        for (char i = 'a'; i <= 'z'; i = (char) (i + 1)) {
            letter.put(i, cost++);
        }
        String convert = convert(s, letter);
        for (int i = 0; i < k; i++) {
            int n = convert.length();
            int sum = 0;
            for (int idx = 0; idx < n; idx++) {
                int val = Integer.parseInt(String.valueOf(convert.charAt(idx)));
                sum += val;
            }
            convert = String.valueOf(sum);
        }
        return Integer.parseInt(convert);
    }

    private String convert(String s, Map<Character, Integer> letter) {
        if (s.isBlank()) {
            return s;
        }
        String word = "";
        for (int i = 0; i < s.length(); i++) {
            int cost = letter.get(s.charAt(i));
            word += String.valueOf(cost);
        }
        return word;
    }
}
