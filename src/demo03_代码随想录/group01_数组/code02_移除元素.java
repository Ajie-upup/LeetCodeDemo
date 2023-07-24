package demo03_代码随想录.group01_数组;

/**
 * @author ajie
 * @date 2023/7/17
 * @description: https://leetcode.cn/problems/remove-element/
 */
public class code02_移除元素 {

    public int removeElement(int[] nums, int val) {
        // 快慢指针法
        int low = 0;
        int len = nums.length;
        for (int fast = 0; fast < nums.length - 1; fast++) {
            if (nums[fast] != val) {
                nums[low] = nums[fast];
                low++;
            } else {
                if (fast + 1 < nums.length) {
                    nums[low] = nums[fast + 1];
                }
                len--;
            }
        }
        return len;
    }

}
