package Hot150and100;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int left = 0, right = 1;
        int remain = 1;
        while (right < n) {
            if (nums[left] == nums[right]) {
                if (remain == 0) {
                    right++;
                } else {
                    remain--;
                    left++;
                    swap(nums, left, right);
                    right++;
                }
            } else {
                remain = 1;
                left++;
                swap(nums, left, right);
                right++;
            }
        }
        return left + 1;
    }

    public void swap (int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }
}
