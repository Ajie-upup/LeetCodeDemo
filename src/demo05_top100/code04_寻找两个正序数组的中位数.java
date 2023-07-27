package demo05_top100;

/**
 * @author ajie
 * @date 2023/7/27
 * @description: https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class code04_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;
        int start1 = 0;
        int start2 = 0;
        int left = 0, right = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (start1 < len1 && (start2 >= len2 || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }
        if ((len & 1) == 0) {
            // 偶数
            return (left + right) / 2.0;
        } else {
            // 奇数
            return right;
        }
    }

}
