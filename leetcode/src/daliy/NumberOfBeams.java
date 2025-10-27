package daliy;

public class NumberOfBeams {
    public int numberOfBeams(String[] bank) {
        int res = 0, flag = 1;
        int pre = 0, next = 0;
        for (String palce : bank) {
            char[] charArray = palce.toCharArray();
            for (char c : charArray) {
                if (c == '1') {
                    if (flag == 1) {
                        pre++;
                    } else {
                        next++;
                    }
                }
            }
            if (flag == 1 && palce.contains("1")) {
                flag = 0;
            }
            if (next != 0) {
                res += next * pre;
                pre = next;
                next = 0;
            }
        }
        return res;
    }

    public int numberOfBeamsI(String[] bank) {
        int pre = 0;
        int ans = 0;
        for (String s : bank) {
            int count = count(s);
            if (count != 0) {
                ans += pre * count;
                pre = count;
            }
        }
        return ans;
    }

    public int count(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c - '0';
        }
        return count;
    }
}
