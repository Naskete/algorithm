package String;

public class BlackAndWhiteBall {

    public long minimumSteps(String s) {
        long ans = 0L;
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] arr = new int[n];
        arr[0] = charArray[0] - '0';
        for (int i = 1; i < n; i++) {
            if (charArray[i] == '0') {
                arr[i] = arr[i - 1];
            }
            if (charArray[i] == '1') {
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (charArray[i] == '0') {
                ans += arr[i];
            }
        }
        return ans;
    }
}
