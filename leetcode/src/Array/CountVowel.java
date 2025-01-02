package Array;


public class CountVowel {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = vowelWord(words[i]) ? 1 : 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String word = words[j];
                if (vowelWord(word)) {
                   dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = dp[queries[i][0]][queries[i][1]];
        }
        return res;
    }

    private boolean vowelWord(String word) {
        if (word.startsWith("a") || word.startsWith("e") || word.startsWith("u") || word.startsWith("i") || word.startsWith("o")) {
            return word.endsWith("a") || word.endsWith("i") || word.endsWith("u") || word.endsWith("e") || word.endsWith("o");
        }
        return false;
    }
}
