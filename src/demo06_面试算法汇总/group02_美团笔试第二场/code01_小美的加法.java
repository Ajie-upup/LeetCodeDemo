package demo06_面试算法汇总.group02_美团笔试第二场;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/23
 * @description:
 */
public class code01_小美的加法 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            sum[i] = nums[i];
            if (i - 1 >= 0) {
                sum[i] += sum[i - 1];
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i < n; i++) {
            dp[i] = sum[n - 1] - nums[i] - nums[i - 1] + (nums[i] * nums[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(Math.max(max, sum[n - 1]));
    }
}
