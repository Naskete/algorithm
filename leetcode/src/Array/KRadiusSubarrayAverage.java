package Array;

public class KRadiusSubarrayAverage {
    // https://leetcode.cn/problems/k-radius-subarray-averages/description/
    public int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        long sum = 0;
        int[] avgArr = new int[length];

        for(int i= 0; i< length;i++){
            sum += nums[i];
            avgArr[i] = -1;
            if(i < 2 * k){
                continue;
            }
            avgArr[i - k] = (int)(sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }
        return avgArr;
    }
}
