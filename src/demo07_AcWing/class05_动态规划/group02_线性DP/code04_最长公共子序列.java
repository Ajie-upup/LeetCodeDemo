package demo07_AcWing.class05_动态规划.group02_线性DP;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/17
 * @description:
 */
public class code04_最长公共子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aLen = sc.nextInt();
        int bLen = sc.nextInt();
        String aString = sc.next();
        String bString = sc.next();

        // dp[i][j] 表示最长子序列集合中长度最大的子序列长度
        int[][] dp = new int[aLen + 1][bLen + 1];

        /*
            1. 不包含 a[i] 和 b[i]          --- 》  dp[i-1][j-1]
            2. 包含 a[i] 和 不包含 b[i]      --- 》  dp[i-1][j]    (包含情况一)
            3. 不包含 a[i] 和 包含 b[i]      --- 》  dp[i][j-1]
            4. 包含 a[i] 和 b[i]            --- 》  dp[i-1][j-1] + 1
         */
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (aString.charAt(i - 1) == bString.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[aLen][bLen]);
    }
}
