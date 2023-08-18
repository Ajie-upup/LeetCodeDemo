package demo07_AcWing.class05_动态规划.group02_线性DP;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/17
 * @description:
 */
public class code05_最短编辑距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aLen = sc.nextInt();
        String aString = sc.next();
        int bLen = sc.nextInt();
        String bString = sc.next();
        // dp[i][j] 表示 1 ~ i 与 1 ~ j 两个字符串在的最小修改次数
        int[][] dp = new int[aLen + 1][bLen + 1];

        // 初始化 dp 方程
        for (int i = 0; i <= aLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= bLen; i++) {
            dp[0][i] = i;
        }

        /*
            1. 删除 a 中最后一个字符变成 b  ----->  dp[i-1][j] + 1
            2. 添加 a 中最后一个字符变成 b  ----->  dp[i][j-1] + 1
            3. 修改 a 中最后一个字符变成 b  ----->  dp[i-1][j-1] + 1  or dp[i-1][j-1] + 0 (a 中最后一个字符与 b 中最后一个字符相等)
         */
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (aString.charAt(i - 1) == bString.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[aLen][bLen]);
    }
}
