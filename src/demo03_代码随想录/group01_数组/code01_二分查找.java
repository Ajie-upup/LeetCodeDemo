package demo03_代码随想录.group01_数组;

/**
 * @author ajie
 * @date 2023/7/17
 * @description: https://leetcode.cn/problems/binary-search/
 */
public class code01_二分查找 {
    public int search(int[] nums, int target) {
        int left = 0;
        // 当数组中只有一个元素时，会返回 -1
//        int right = nums.length - 1;
        int right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
//                right = mid - 1;
                right = mid;
            }
        }
        return -1;
    }

}
