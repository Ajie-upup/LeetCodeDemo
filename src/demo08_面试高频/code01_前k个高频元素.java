package demo08_面试高频;

import java.util.*;

/**
 * @author ajie
 * @date 2023/9/8
 * @description:
 */
public class code01_前k个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
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

    public static List<String> findStrArray(String [] strArr, int k){
        Map<String, Integer> strMap = new HashMap<>();
        for(String str : strArr){
            strMap.put(str,strMap.getOrDefault(str,0) + 1);
        }
        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(strMap.entrySet());

        Collections
                .sort(entryList,
                        (e1,e2) -> e2.getValue().compareTo(e1.getValue()));
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < k && i < entryList.size(); i++){
            res.add(entryList.get(i).getKey());
        }
        return res;
    }

}
