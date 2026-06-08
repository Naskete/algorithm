package Array;

import java.util.ArrayList;
import java.util.List;

public class PivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        List<Integer> less = new ArrayList<Integer>();;
        List<Integer> equals = new  ArrayList<>();
        List<Integer> greater = new  ArrayList<>();
        for (int num :nums) {
            if (num == pivot) {
                equals.add(num);
            }
            if (num > pivot) {
                greater.add(num);
            }
            if (num < pivot) {
                less.add(num);
            }
        }
        int idx = 0;
        for (Integer n : less) {
            nums[idx++] = less.get(n);
        }
        for (Integer n : equals) {
            nums[idx++] = equals.get(n);
        }
        for (Integer n : greater) {
            nums[idx++] = greater.get(n);
        }
        return nums;
    }
    // 双指针，填充数组pivot然后按left right填入大于小于的值，最后翻转大于部分
}
