package demo08_面试高频;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code10_数组中的重复数字 {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            if (numMap.get(num) == 2) {
                res.add(num);
            }
        }
        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        // 数组中的元素都是不大于 n 的元素
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            } else {
                res.add(index + 1);
            }
        }
        return res;
    }

}
