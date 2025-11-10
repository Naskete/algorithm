package String;

public class CountOfConsistent {
    // 1684. count the number of consistent strings
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = words.length;
        boolean[] allowFlag = new boolean[26];
        for (int idx = 0; idx < allowed.length(); idx++) {
            allowFlag[allowed.charAt(idx) - 'a'] = true;
        }
        for (String word : words) {
            for (int i = 0; i < word.length();i++) {
                if (! allowFlag[word.charAt(i) - 'a']) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}
