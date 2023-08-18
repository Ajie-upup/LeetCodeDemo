package demo07_AcWing.class05_动态规划.group02_线性DP;

import java.util.Scanner;

/**
 * @author ajie
 * @date 2023/8/17
 * @description:
 */
public class code06_编辑距离 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countString = sc.nextInt();
        int countTest = sc.nextInt();
        String[] strings = new String[countString];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = sc.next();
        }
        for (int i = 0; i < countTest; i++) {
            String testString = sc.next();
            int limit = sc.nextInt();
            int res = 0;
            for (int j = 0; j < strings.length; j++) {
                if (getMinFixCount(strings[j], testString) <= limit) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }

    public static int getMinFixCount(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        int[][] dp = new int[aLen + 1][bLen + 1];
        // 初始化 dp 方程
        for (int i = 0; i <= aLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= bLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1));
            }
        }
        return dp[aLen][bLen];
    }

}
