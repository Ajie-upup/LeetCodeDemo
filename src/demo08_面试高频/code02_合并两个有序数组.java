package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code02_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int left = m - 1, right = n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] <= nums2[right]) {
                nums1[index--] = nums2[right--];
            } else {
                nums1[index--] = nums1[left--];
            }
        }
        while (left >= 0) {
            nums1[index--] = nums1[left--];
        }
        while (right >= 0) {
            nums1[index--] = nums2[right--];
        }
    }

}
