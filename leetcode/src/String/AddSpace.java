package String;

public class AddSpace {
    public String addSpace(String s, int[] spaces) {
        char[] charArray = s.toCharArray();
        int idx = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            int space = spaces[idx];
            if (i == space) {
                idx++;
                builder.append(' ');
            }
            builder.append(charArray[i]);
        }
        return builder.toString();
    }
}
