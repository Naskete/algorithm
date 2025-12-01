package expore.struct.array;

public class FindNum {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] flags = new boolean[n + 1];
        int repeat = 0;
        for (int num : nums) {
            if (flags[num]) {
                repeat = num;
            }
            flags[num] = true;
        }
        int lose = 0;
        for (int i =1; i <= n; i++) {
            if (!flags[i]) {
                lose = i;
                break;
            }
        }
        return new int[]{repeat, lose};
    }
}
