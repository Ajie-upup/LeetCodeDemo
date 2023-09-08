package demo07_AcWing.class05_动态规划.group03_区间DP;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/18
 * @description:
 */
public class code01_合并石子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();
            // 前缀和
            stones[i] += stones[i - 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + stones[i] - stones[i - 1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
