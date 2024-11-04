package String;

public class CompressedString {
    public String compressedString(String word) {
        if(word.isEmpty()) {
            return word;
        }
        char[] charArray = word.toCharArray();
        int n = charArray.length, p = 0, q = 0;
        StringBuilder builder = new StringBuilder();
        int num = 0;
        while (p < n) {
            if (q < n && charArray[q] == charArray[p]) {
                num++;
                if (num == 9) {
                    builder.append(num).append(charArray[p]);
                    p = q;
                    num = 0;
                }
                q++;
            } else {
                builder.append(num).append(charArray[p]);
                p = q;
                num = 0;
            }
        }
        return builder.toString();
    }
}
