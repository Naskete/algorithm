package expore.struct.array;

public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int p = 0, q = n;
        int[] ans = new int[n * 2];
        int idx = 0;
        while (p < n) {
            ans[idx++] = nums[p++];
            ans[idx++] = nums[q++];
        }
        return ans;
    }
}
