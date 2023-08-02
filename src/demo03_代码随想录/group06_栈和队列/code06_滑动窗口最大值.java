package demo03_代码随想录.group06_栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ajie
 * @date 2023/8/2
 * @description: https://leetcode.cn/problems/sliding-window-maximum/
 */
public class code06_滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(nums, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // 1. 队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 2. 队首始终存放区间最大值下标，需要将其余下标弹出
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            // 判断队列中的元素是否符合 k 范围
            if (i >= k - 1 && !deque.isEmpty()) {
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
