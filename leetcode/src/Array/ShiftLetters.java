package Array;

public class ShiftLetters {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] operate = new int[len];
        for (int[] shift : shifts) {
            int offset = shift[2] == 1 ? 1 : -1;
            change(operate, shift[0], shift[1], offset);
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            char c = charArray[i];
            charArray[i] = offsetChar(c, operate[i]);
        }
        return String.valueOf(charArray);
    }

    public void change(int[] arr, int i, int j, int offset) {
        for (int idx = i; idx <= j; idx++) {
            arr[idx] += offset;
        }
    }

    public char offsetChar(char c, int offset) {
        if (offset == 0) {
            return c;
        }
        int letter = c + offset;
        if (letter < 'a') {
            letter += 26;
        }
        if (letter > 'z') {
            letter -= 26;
        }
        return (char)letter;
    }
}
