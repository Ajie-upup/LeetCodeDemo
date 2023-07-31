package demo03_代码随想录.group03_哈希表;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author ajie
 * @date 2023/7/31
 * @description: https://leetcode.cn/problems/intersection-of-two-arrays/
 */
public class code02_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();
        // 将 nums1 数组中的元素加入到 temp Set中
        for (int i = 0; i < nums1.length; i++) {
            temp.add(nums1[i]);
        }
        // 如果在 temp Set 中出现了，同时也在 nums2 中也出现了，就添加到结果集中
        for (int i = 0; i < nums2.length; i++) {
            if (temp.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        // 遍历构造 int[]
        int[] res = new int[resSet.size()];
        Iterator<Integer> iterator = resSet.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        return res;
    }
}
