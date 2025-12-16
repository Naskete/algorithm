package binarySearch;

class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] arr = merge(nums1, m, nums2, n);
        int  mid = (m + n) / 2;
        return (m + n) % 2 == 0? 1.0 * (arr[mid - 1] + arr[mid]) / 2:  arr[mid] * 1.0;
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n == 0) {
            return new int[]{};
        }
        if (m == 0) {
            return nums2;
        }
        if (n == 0) {
            return nums1;
        }
        int idx = 0;
        int[] arr = new int[m + n];
        int p = 0,  q = 0;
        while (p < m && q < n) {
            arr[idx++] = nums1[p] <= nums2[q] ? nums1[p++] : nums2[q++];
        }
        while (p < m) {
            arr[idx++] = nums1[p++];
        }
        while (q < n) {
            arr[idx++] = nums2[q++];
        }
        return arr;
    }
}