package Number;

import java.util.HashSet;
import java.util.Set;

public class CheckDoubleN {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        for (int num : arr) {
            if (set.contains(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfExistI(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
