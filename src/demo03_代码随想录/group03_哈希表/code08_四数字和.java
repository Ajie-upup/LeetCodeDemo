package demo03_代码随想录.group03_哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ajie
 * @date 2023/7/31
 * @description:
 */
public class code08_四数字和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length - 3; first++) {
            // nums[first] > target 直接返回, 剪枝操作
            if (nums[first] > target && nums[first] > 0) {
                return res;
            }
            // 去重
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length - 2; second++) {
                int twoSum = nums[first] + nums[second];
                if (twoSum > target && twoSum > 0) {
                    break;
                }
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int left = second + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = twoSum + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[first], nums[second], nums[left], nums[right]));
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
