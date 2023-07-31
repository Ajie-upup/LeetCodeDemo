package demo03_代码随想录.group03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/3sum/
 */
public class code07_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int start = 0; start < nums.length - 2; start++) {
            if (nums[start] > 0) {
                // 排序后的三个数字相加，如果第一个数字大于0，则结果一定大于0
                break;
            }
            if (start > 0 && nums[start] == nums[start - 1]) {
                // 去重
                continue;
            }
            int left = start + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[start], nums[left], nums[right]));
                    // 去重操作
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
