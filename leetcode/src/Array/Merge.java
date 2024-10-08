package Array;

public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            if (n >= 0)
                System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return ;
        }
        int[] array = new int[m + n];
        int p = 0, q = 0;
        int idx = 0;
        while (p < m && q < n) {
            array[idx++] = nums1[p] >= nums2[q] ? nums2[q++] : nums1[p++];
        }
        while (p < m) {
            array[idx++] = nums1[p++];
        }
        while (q < n) {
            array[idx++] = nums2[q++];
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = array[i];
        }
    }
}
