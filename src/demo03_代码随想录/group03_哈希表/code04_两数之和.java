package demo03_代码随想录.group03_哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/two-sum/
 */
public class code04_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        // 创建一个初始化容量的 map 集合
        Map<Integer, Integer> numMap = new HashMap<>(nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            } else {
                numMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
