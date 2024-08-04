package Array;

// 1460. Make Two Arrays Equal by Reversing SubArrays
public class CanBeEquals {
    public boolean canBeEqual(int[] target, int[] arr) {
        int[] count = new int[1001];
        for (int num : target) {
            count[num]++;
        }
        for (int num : arr) {
            count[num]--;
        }
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
