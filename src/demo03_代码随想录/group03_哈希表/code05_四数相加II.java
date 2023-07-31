package demo03_代码随想录.group03_哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/4sum-ii/
 */
public class code05_四数相加II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 第一个数表示求和值，第二个数字表示有多少组搭配
        Map<Integer, Integer> sumMap = new HashMap<>();
        // 求前两个数组和的集合
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        // 如果 0 - (c + d) 在数组中则证明符合要求
        int count = 0;
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = -(nums3[i] + nums4[j]);
                if (sumMap.containsKey(sum)) {
                    count += sumMap.get(sum);
                }
            }
        }
        return count;
    }
}
