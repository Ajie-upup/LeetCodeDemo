package demo03_代码随想录.group06_栈和队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ajie
 * @date 2023/8/2
 * @description: https://leetcode.cn/problems/top-k-frequent-elements/
 */
public class code07_前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        topKFrequent(nums, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 维护一个小顶堆，方便弹出不符合前 K 个高频元素
        PriorityQueue<int[]> queue = new PriorityQueue<>((nums1, nums2) -> nums1[1] - nums2[1]);
        // (nums1, nums2) -> nums1[1] - nums2[1] 根据数组的第二个值进行比较
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                // 堆中的元素小于 k 个，直接将 entry 加入到队列中
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                // 堆中的元素大于 k 个
                // 当 entry 中的元素大于小顶堆的堆顶元素，进行poll操作
                if (entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    // 将新元素加入堆中，由堆自动维护
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        // 将元素导出到数组中，堆是小顶堆，从数组末尾填充
        int[] res = new int[k];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = queue.poll()[0];
        }
        return res;
    }
}
