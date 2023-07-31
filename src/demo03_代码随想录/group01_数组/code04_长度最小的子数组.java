package demo03_代码随想录.group01_数组;

/**
 * @author ajie
 * @date 2023/7/17
 * @description:
 */
public class code04_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 当 sum 求和大于 target 时，滑动窗口向右移动
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
