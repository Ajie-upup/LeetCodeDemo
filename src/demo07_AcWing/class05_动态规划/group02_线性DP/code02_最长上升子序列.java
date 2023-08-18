package demo07_AcWing.class05_动态规划.group02_线性DP;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/17
 * @description:
 */
public class code02_最长上升子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        // dp[i] 表示以 i 为结尾的最长上升子序列的长度的最大值
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 以 i 为结尾的子序列长度最小值为 1
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 最长上升子序列不一定是最后一个数结尾的上升子序列
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
