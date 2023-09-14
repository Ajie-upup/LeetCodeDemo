package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code08_盛水最多的容器 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            // 只判断中间状态
            if (height[left] < height[right]) {
                res = Math.max(res, (right - left) * height[left++]);
            } else {
                res = Math.max(res, (right - left) * height[right--]);
            }
        }
        return res;
    }
}
