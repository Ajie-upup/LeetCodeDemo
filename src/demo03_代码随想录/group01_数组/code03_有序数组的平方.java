package demo03_代码随想录.group01_数组;

/**
 * @author ajie
 * @date 2023/7/17
 * @description:
 */
public class code03_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;

        int[] res = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                res[index--] = nums[left] * nums[left];
                left++;
            } else {
                res[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
        // 无法原地修改，无法保证交换后的数组一定是绝对值最大的那个数
       /* while (left < right) {
            if (nums[left] * nums[left] >= nums[right] * nums[right]) {
                int temp = nums[right];
                nums[index--] = nums[left] * nums[left];
                nums[left] = temp;
                right--;
            } else {
                nums[index--] = nums[right] * nums[right];
                right--;
            }
        }*/
    }

}
