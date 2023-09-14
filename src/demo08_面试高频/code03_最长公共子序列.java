package demo08_面试高频;

/**
 * @author ajie
 * @date 2023/9/11
 * @description:
 */
public class code03_最长公共子序列 {

    /**
     * 二维 DP
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 一维 DP
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[] dp = new int[chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            int pre = 0;
            for (int j = 1; j <= chars2.length; j++) {
                int cur = dp[j];
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = cur;
            }
        }
        return dp[chars2.length];
    }

}
