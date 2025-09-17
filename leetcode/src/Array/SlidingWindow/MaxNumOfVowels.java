package Array.SlidingWindow;

public class MaxNumOfVowels {
    // https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
    public int maxVowels(String s, int k) {
        int n = s.length();
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                vowel++;
            }
            int left = i - k + 1;
            if (left < 0) {
                continue;
            }
            ans = Math.max(ans, vowel);
            if (ans == k) {
                break;
            }
            char out = s.charAt(left);
            if (isVowel(out)) {
                vowel--;
            }
        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowelsI(String s, int k) {
        char[] arr = s.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(arr[i])) {
                vowel++;
            }
        }
        ans = Math.max(ans, vowel);
        if (ans == k) {
            return ans;
        }
        for (int i = k; i < arr.length; i++) {
            if (isVowel(arr[i])) {
                vowel++;
            }
            if (isVowel(arr[i - k])) {
                vowel--;
            }
            ans = Math.max(ans, vowel);
        }
        return ans;
    }
}
