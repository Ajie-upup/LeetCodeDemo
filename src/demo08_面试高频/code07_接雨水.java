package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code07_接雨水 {
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right){
            if (height[left] < height[right]){
                if (height[left] > leftMax){
                    leftMax = height[left];
                }else {
                    res += leftMax - height[left];
                }
                left++;
            }else {
                if (height[right] > rightMax){
                    rightMax = height[right];
                }else {
                    res += rightMax-height[right];
                }
                right--;
            }
        }
        return res;
    }
}
