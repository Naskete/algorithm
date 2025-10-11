package daliy;

import java.util.Arrays;
import java.util.List;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).toList();
        List<Integer> v2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).toList();
        int p = 0, q = 0;
        int m = v1.size(), n = v2.size();
        while (p < m && q < n) {
            Integer v1Ele = v1.get(p);
            Integer v2Ele = v2.get(q);
            if (v1Ele > v2Ele) {
                return 1;
            }
            if (v1Ele < v2Ele) {
                return -1;
            }
            p++;
            q++;
        }
        while (p < m) {
            if (v1.get(p++) > 0) {
                return 1;
            }
        }
        while (q < n) {
            if (v2.get(q++) > 0) {
                return -1;
            }
        }
        return 0;
    }
}
